package assignment3;

public final class IntegrityStatement {
    public static String signature() {
        String signature = "omer gonen"; // <- Fill in your name and ID here! For example: "Israel Israeli (123456789)"
        
        if (signature.length() == 0) {
            throw new UnsupportedOperationException("You should sign here");
        }
        
        return signature;
    }
}
