package com.example;
public class ImmutableString {
    public static void main(String[] args) {
        String s1= "Jack"; // Immutable
        String s2= new String("Jack"); // Immutable
        String s3= "Jack"; // Immutable
        s2 = s2.intern();
        System.out.println("s1==s2: "+(s1==s2));
        System.out.println("s1==s3: "+(s1==s3));

    }
}
