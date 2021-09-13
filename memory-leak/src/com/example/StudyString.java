package com.example;
public class StudyString {
    public static void main(String[] args) {
        StringBuffer s= new StringBuffer(10_000_000);
        long start= System.currentTimeMillis();
        for (int i=0;i<10_000_000;++i){
            s.append(1);
        }
        long stop= System.currentTimeMillis();
        System.out.println("Duration: "+(stop-start));
    }
}
