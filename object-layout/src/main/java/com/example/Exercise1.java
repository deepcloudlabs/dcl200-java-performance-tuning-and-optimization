package com.example;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
// -XX:-UseCompressedOops
public class Exercise1 {
	public static void main(String[] args) {
		System.out.println(VM.current().details());
		System.out.println(ClassLayout.parseClass(A.class).toPrintable());
		System.out.println(ClassLayout.parseClass(B.class).toPrintable());
		System.out.println(ClassLayout.parseClass(Integer[].class).toPrintable());
		System.out.println(ClassLayout.parseClass(int[].class).toPrintable());
		System.out.println(ClassLayout.parseClass(int.class).toPrintable());
		// Distributed Cache -> Hazelcast, Coherence, ... (Java)
		// Java Object -> Size? -> JVM Heap Size
		// 100_000 Object -> (1k) -> 100GB x2 -> 200GB
		// 16GB RAM Node ? -Xms14g -Xmx14g 14GB E(512M)-S0(256M)-S1(256M)-T(13GB) (Cached Objects)
		// # of nodes = 200GB / 13GB = 16 Nodes
		// -XX:NewRatio=2 -XX:SurvivorRatio=8
		// New Generation/Old Generation = 1/2
		// Survivor/New Generation=1/8
		// -Xms14g -Xmx14g -XX:-NewRatio=13 -XX:SurvivorRatio=2
	}

}

class A {
	byte b;
	short s;
	int i;
	long l;
	char c;
	boolean x;
	float f;
	double d;
	B r;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (i != other.i)
			return false;
		return true;
	}

}

class B {
	// 12B
	int x; // 1
	short s1; // 2
	short s2; // 3
	byte b1;
	byte b2;
	byte b3;
	byte b4; 
	byte b5;
	byte b6;
}