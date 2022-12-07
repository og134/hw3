package assignment3;

public class BitVector {
    private Bit[] bits;

    public BitVector(String s) {
        if (!NumericalString.legalNumericString(s, 2))
            throw new IllegalArgumentException("not in base 2");
        this.bits = new Bit[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                this.bits[i] = new Bit(true);
            else
                this.bits[i] = new Bit(false);
        }
    }

    //Task 4.5
    public String toString() {
        String ans = "";
        for (int i = 0; i<this.bits.length; i++)
            ans += this.bits[i].toString();
        ans =  NumericalString.flip(NumericalString.binary2Decimal(ans));
        return ans;
    }

}
