package assignment3;

public class Bit {

    private boolean value;

    public Bit(boolean value){
        this.value = value;
    }

    public int toInt(){ 
        int ans = 0;
        if(this.value)
            ans = 1;
        return ans;

    }

    public String toString(){
        String ans = "0";
        if(this.value)
            ans = "1";
        return ans;
    }
}

