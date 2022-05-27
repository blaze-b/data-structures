package learning;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.US_ASCII;

public class Encryption {

    public static final String SECRET_KEY =
            "fuoEXZjHFfgT7jByO5fGD/uLp3mkbwj0vPxbvLXUnXwwnHFZFI2FXuygW22o0aO/O2OIMe1OIBiva9e9y6FO" +
                    "+ExZVXilhhVJUIS7MsmUjDo=";
    private static final String SALTED_STR = "Salted__";
    private static final byte[] SALTED_MAGIC = SALTED_STR.getBytes(US_ASCII);

    public static String encrypt(String toEncrypt) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException,
            UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        final byte[] salt = (new SecureRandom()).generateSeed(8);
        final byte[][] keyAndIV = generateKeyAndIV(32, 16, 100, salt, SECRET_KEY.getBytes(US_ASCII), md5);
        final SecretKeySpec secretKey = new SecretKeySpec(keyAndIV[0], "AES");
        IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] cipherText = cipher.doFinal(toEncrypt.getBytes(StandardCharsets.UTF_8));
        byte[] data = array_concat(array_concat(SALTED_MAGIC, salt), cipherText);
        String encrypted = Base64.getEncoder().encodeToString(data);
        return URLEncoder.encode(encrypted, StandardCharsets.UTF_8.name());
    }

    /**
     * Generates a key and an initialization vector (IV) with the given salt and password.
     *
     * @param keyLength
     *         the length of the generated key (in bytes)
     * @param ivLength
     *         the length of the generated IV (in bytes)
     * @param iterations
     *         the number of digestion rounds
     * @param salt
     *         the salt data (8 bytes of data or <code>null</code>)
     * @param password
     *         the password data (optional)
     * @param md
     *         the message digest algorithm to use
     * @return an two-element array with the generated key and IV
     */
    public static byte[][] generateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password,
                                            MessageDigest md) {

        int digestLength = md.getDigestLength();
        int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
        byte[] generatedData = new byte[requiredLength];
        int generatedLength = 0;
        try {
            md.reset();
            while (generatedLength < keyLength + ivLength) {
                if (generatedLength > 0)
                    md.update(generatedData, generatedLength - digestLength, digestLength);
                md.update(password);
                if (salt != null)
                    md.update(salt, 0, 8);
                md.digest(generatedData, generatedLength, digestLength);
                for (int i = 1; i < iterations; i++) {
                    md.update(generatedData, generatedLength, digestLength);
                    md.digest(generatedData, generatedLength, digestLength);
                }
                generatedLength += digestLength;
            }
            byte[][] result = new byte[2][];
            result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
            if (ivLength > 0)
                result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);
            return result;
        } catch (DigestException e) {
            throw new RuntimeException(e);
        } finally {
            Arrays.fill(generatedData, (byte) 0);
        }
    }

    private static byte[] array_concat(final byte[] a, final byte[] b) {
        final byte[] c = new byte[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    public static String encrypt1(String data) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException,
            InvalidKeySpecException, InvalidParameterSpecException, UnsupportedEncodingException {
        String salt = "15charRandomSalt";
        int iterations = 100;
        /* Derive the key, given password and salt. */
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray());
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
        /* Encrypt the message. */
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        AlgorithmParameters params = cipher.getParameters();
        byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
        byte[] cipherText = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        byte[] message = new byte[iv.length + cipherText.length];
        System.arraycopy(iv, 0, message, 0, iv.length);
        System.arraycopy(cipherText, 0, message, iv.length, cipherText.length);
        return Base64.getEncoder().encodeToString(message);
    }

    public static String decrypt(String cipherText) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] cipherData = Base64.getDecoder().decode(cipherText);
        byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);
        byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        final byte[][] keyAndIV = generateKeyAndIV(32, 16, 1, saltData, SECRET_KEY.getBytes(StandardCharsets.UTF_8),
                md5);
        SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
        IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);
        Cipher aesCBC = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decryptedData = aesCBC.doFinal(encrypted);
        return new String(decryptedData, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws IOException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException,
            BadPaddingException, InvalidKeyException, InvalidKeySpecException, InvalidParameterSpecException {
        String encrypted = OpenSSL.encrypt(SECRET_KEY, "dlkhdshjdhjhd");
        System.out.println(encrypted);
        String decrypted = Encryption.decrypt(encrypted);
        System.out.println(decrypted);
    }
}
