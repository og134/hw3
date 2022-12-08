package assignment3;

public class NumericalString {

    public static int toInt(char c) {
        return "0123456789".indexOf(c);
    }

    //Task 3.1
    public static boolean legalNumericString(String s, int b) {
        //check if b in range
        if (b > 10 | b < 2)
            throw new IllegalArgumentException("b not in range");
        boolean ans = true;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) - '0' > b)
                ans = false;
        return ans;
    }

    public static String flip(String s) {
        //flip string
        String ans = "";
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            ans = ch + ans;
        }
        return ans;
    }

    public static String compareSizes(String A, String B) {
        //will compare size B to A
        while (A.length() != B.length())
            B += "0";
        return B;
    }

    public static String reccombine(String A, String B, int carry) {
        //combine two strings using sum and carry method
        //string must be in the same size
        String res = "";
        if (A.length() == 0) {
            // in case the msb gave more than 10
            if (carry == 1)
                res += "1";
            return res;
        }
        int sum;
        sum = ((toInt(A.charAt(0)) + toInt(B.charAt(0))) + carry) % 10;
        carry = ((toInt(A.charAt(0)) + toInt(B.charAt(0))) + carry) / 10;

        res += String.valueOf(sum) + reccombine(A.substring(1), B.substring(1), carry);
        return res;
    }

    //Task 3.2
    public static String decimalIncrement(String s) {
        String ans = "";
        if (!legalNumericString(s, 10))
            throw new IllegalArgumentException("s not in base 10");

        String add = "1";
        add = compareSizes(s, add);
        ans = reccombine(s, add, 0);
        return (ans);
    }


    //Task 3.3
    public static String decimalDouble(String s) {
        //will use the combine method to combine the same string
        //aka double it by 2
        if (!legalNumericString(s, 10))
            throw new IllegalArgumentException("string no in base 10");
        String ans = "";
        ans = reccombine(s, s, 0);
        return ans;
    }

    public static String recbinary2Decimal(String s, int bit) {
        //bit is 2^x according to the place we at
        if (s.length() == 1)
            return String.valueOf(bit * toInt(s.charAt(0)));


        // calculation for the current lsb
        String current = flip(String.valueOf(bit * ((s.charAt(0) - '0'))));
        String tempSum = flip(recbinary2Decimal(s.substring(1), bit * 2));

        if (current.length() > tempSum.length())
            tempSum = compareSizes(current, tempSum);
        else
            current = compareSizes(tempSum, current);
        String sum = reccombine(current, tempSum, 0);
        //flip again to handle the slip of the recursion
        return flip(sum);
    }

    //Task 3.4
    public static String binary2Decimal(String s) {
        String ans = "";
        if (!legalNumericString(s, 2))
            throw new IllegalArgumentException("s not in base 2");
        ans = recbinary2Decimal(s, 1);
        ans = flip(ans);
        return ans;
    }

    public static String recOctal2Decimal(String s, int bit) {
        //bit is 2^x according to the place we at
        if (s.length() == 1)
            return String.valueOf(bit * toInt(s.charAt(0)));


        // calculation for the current lsb
        String current = flip(String.valueOf(bit * ((s.charAt(0) - '0'))));
        String tempSum = flip(recOctal2Decimal(s.substring(1), bit * 8));

        if (current.length() > tempSum.length())
            tempSum = compareSizes(current, tempSum);
        else
            current = compareSizes(tempSum, current);
        String sum = reccombine(current, tempSum, 0);
        //flip again to handle the slip of the recursion
        return flip(sum);
    }

    //Task 3.5
    public static String octal2Decimal(String s) {
        String ans = "";
        if (!legalNumericString(s, 8))
            throw new IllegalArgumentException("s not in base 8");
        ans = recOctal2Decimal(s, 1);
        ans = flip(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Good Luck! :)");
    }
}
