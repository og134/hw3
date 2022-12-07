package assignment3;

import java.math.BigInteger;
import java.util.Random;
class Assignment3BigInteger{

    //Task 1.1
    public static BigInteger sumSmaller(BigInteger n){
        BigInteger sum =  new BigInteger("0");
        BigInteger stop = new BigInteger("0");
        BigInteger dec = new BigInteger("1");
        n = n.subtract(dec);
        while(n.compareTo(stop) !=0) {
            System.out.println(n.toString());
            sum =sum.add(n);
            n = n.subtract(dec);

        }
        return sum;
    }
    //Task 1.2
    public static void printRandoms(int n){
        for(int i = 0; i<n;i++){
            Random rnd = new Random();
            System.out.println(rnd.nextInt());
        }
    }
    //Task 1.3
    public static   boolean isPrime(BigInteger n){
        boolean ans= true;
        boolean isPrime = true;
        BigInteger check = new BigInteger("1");
        BigInteger update = new BigInteger("1");
        BigInteger mulVal;
        BigInteger mod_res = new BigInteger("0");
        //number is 1 or 0
        if(n.compareTo(check)<1)
            return false;

        check = check.add(update); // update to 2
        mulVal = check.multiply(check);
        // <1 means mulVal is smaller then n
        while (ans & mulVal.compareTo(n) < 1) {
            if(mod_res.compareTo(n.mod(check)) == 0) {
                ans = false;
                }
            mulVal = check.multiply(check);
            check = check.add(update);

        }

        return ans;
    }
    //Task 1.4
    public static BigInteger randomPrime(int n){
        BigInteger randBig;
        BigInteger downLimit = new BigInteger("1");
        Random rnd = new Random();
        BigInteger result;
        do {
            randBig = new BigInteger(n, rnd);
            System.out.println(randBig);
            System.out.println(isPrime(randBig));
        } while ((randBig.compareTo(downLimit) > 0) & (!isPrime(randBig)));

        //Task 1.4
        return randBig;
    }

}