package com.mac286.postfix;

public class PostFixTester {
    public static void main(String[] args) {
        Postfix P = new Postfix("( 29.2 + 31.3 / 4.3 - 4) * (3.2 / (34.5 - 5.2) - 3.2 * 5.6)");
        System.out.println("Infix: " + P.getInFix()); //successful
        System.out.println("PostFix: " + P.getPostFix());

        System.out.println("The resl: " + P.evaluate());
    }
}
