package learning;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any String to check: ");
        String str = sc.nextLine();
        if (isCheck(str))
            if (str.contains("'"))
                str = str.replace("'", "\\'");
        System.out.println(str);
    }

    private static boolean isCheck(String str) {
        final Pattern checkPattern = Pattern.compile("[^a-zA-Z0-9]");
        final Matcher match = checkPattern.matcher(str);
        return match.find();
    }
}
