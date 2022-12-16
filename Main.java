package assignment3;

import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
        int[] coins = {5, 10, 20, 50, 100};
        int n = 100;
        int numOfCoinsToUse = 5;

        int[] S = { 1, 2, 3 };

        // total change required
        int target = 4;

        BigInteger test = new BigInteger("11");
        String a = "111110110101100110011001110101011011111011010011011011110010111100101101100110111100010111";
        System.out.println(NumericalString.binary2Decimal(a));
       // System.out.println(NumericalString.binary2Decimal(b));
    }
}
