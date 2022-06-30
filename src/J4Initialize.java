public class J4Initialize {
    public static void main(String[] args) {
        //Primitive Datatypes
        //Size: 1 byte, Range: Stores whole numbers from -128 to 127
        byte myByte;
        //Size: 2 bytes, Range: Stores whole numbers from -32,768 to 32,767
        short myShort;
        //Size: 4 bytes, Range: Stores whole numbers from -2,147,483,648 to 2,147,483,647
        int myInt;
        //Size: 8 bytes, Range: Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        long myLong;
        //Size: 4 bytes, Range: Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
        float myFloat;
        //Size: 8 bytes, Range: Stores fractional numbers. Sufficient for storing 15 decimal digits
        double myDouble;
        //Size: 1 bit, Range: Stores true or false values
        boolean myBoolean;
        //Size: 2 bytes, Range: Stores a single character/letter or ASCII values
        char myChar;

        //Initializing
        myByte = 21;
        myShort = 22;
        myChar = 'A';
        myInt = 232;
        myLong = 2121314311;
        myFloat = 23.54f;
        myDouble = 12441124124.4343;

        //Wrapper Data-types
        Byte myObjectByte;
        Short myObjectShort;
        Integer myObjectInt;
        Long myObjectLong;
        Float myObjectFloat;
        Double myObjectDouble;
        Boolean myObjectBoolean;
        Character myObjectChar;
        String myObjectString;


        //Initializing together
        int i = 1, j = 11, k = 11;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}
