package com.example;
import java.math.BigDecimal;
import java.math.BigInteger;

public class PrimitiveTypes {
    public static void main(String[] args) {
        byte b=1; // [-128..127]
        b= 127;
        b = (byte) (b + 1);
        System.out.println(b);
        Byte bb= 127;
        bb = Byte.valueOf((byte) (bb + 1));
        System.out.println(bb);
        long l= Long.MAX_VALUE;
        System.out.println("l="+l);
        l++;
        System.out.println("l="+l);
        BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(bi);
        bi = bi.add(BigInteger.ONE);
        System.out.println(bi);
        float f = 3.1415161718F; // 4-byte
        double d = 2.0;
        d = d - 1.1;
        System.out.println(String.format("%16.16f",d));
        f = 1_000_000_000;
        f = f + 50;
        System.out.println(String.format("%16f",f));
        BigDecimal bd= BigDecimal.valueOf(2);
        bd = bd.subtract(BigDecimal.valueOf(1.1));
        System.out.println(bd);
    }
}
