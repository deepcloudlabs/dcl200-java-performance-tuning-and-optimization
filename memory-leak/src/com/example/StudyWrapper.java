package com.example;
import java.util.IdentityHashMap;

public class StudyWrapper {
    public static void main(String[] args) {
        IdentityHashMap<Integer,String> map= new IdentityHashMap<>();
        map.put(Integer.valueOf(108),"test1");
        map.put(Integer.valueOf(108),"test2");
        Integer key = Integer.valueOf(549);
        map.put(key,"test3");
        map.put(Integer.valueOf(549),"test4");
        System.out.println(map.get(108));
        System.out.println(map.get(key));
        System.out.println(map.size());
    }
}
