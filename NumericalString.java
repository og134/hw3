package assignment3;

public class NumericalString {
    //Task 3.1
    public static boolean legalNumericString(String s, int b) {
        if (b > 10 | b < 2)
            throw new IllegalArgumentException("b not in range");
        boolean ans = true;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) - '0' > b)
                ans = false;
        return ans;
    }

    public static String flip(String s) {
        String ans = "";
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            ans = ch + ans;
        }
        return ans;
    }

    //Task 3.2
    public static String decimalIncrement(String s) {
        String ans = "";
        if (!legalNumericString(s, 10))
            throw new IllegalArgumentException("s not in base 10");
        int sum = recString2Decimal(s, 0) + 1;
        ans = flip(String.valueOf(sum));


        return ans;
    }

    public static int recString2Decimal(String s, int place) {
        if (s.length() == 0)
            return 0;
        int sum = 0;
        int lsb = 1;
        for (int i = 0; i < place; i++)
            lsb *= 10;
        sum += lsb * ((s.charAt(0) - '0')) + recString2Decimal(s.substring(1), place + 1);
        return sum;
    }

    //Task 3.3
    public static String decimalDouble(String s) {
        if (!legalNumericString(s, 10))
            throw new IllegalArgumentException("string no in base 10");
        String ans = "";
        int temp = 2 * recString2Decimal(s, 0);
        ans = Integer.toString(temp);
        return ans;
    }

    public static int recbinary2Decimal(String s, int place) {
        if (s.length() == 0)
            return 0;

        int sum = 0;
        int lsb = 1;
        for (int i = 0; i < place; i++)
            lsb *= 2;
        // calculation for the current lsb
        String temp = String.valueOf(lsb * ((s.charAt(0) - '0')));

        for (int i = 0; i < temp.length(); i++) {
            int val = temp.charAt(i) + temp.charAt(i);
        }
        recbinary2Decimal(s.substring(1), place + 1);
        return sum;
    }

    //Task 3.4
    public static String binary2Decimal(String s) {
        String ans = "";
        if (!legalNumericString(s, 2))
            throw new IllegalArgumentException("s not in base 2");
        int sum = recbinary2Decimal(s, 0);
        ans = flip(String.valueOf(sum));
        return ans;
    }

    public static int recOctal2Decimal(String s, int place) {
        if (s.length() == 0)
            return 0;
        int sum = 0;
        int lsb = 1;
        for (int i = 0; i < place; i++)
            lsb *= 8;
        sum += lsb * ((s.charAt(0) - '0')) + recOctal2Decimal(s.substring(1), place + 1);
        return sum;
    }

    //Task 3.5
    public static String octal2Decimal(String s) {
        String ans = "";
        if (!legalNumericString(s, 8))
            throw new IllegalArgumentException("s not in base 8");
        int sum = recOctal2Decimal(s, 0);
        ans = flip(String.valueOf(sum));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Good Luck! :)");
    }
}
