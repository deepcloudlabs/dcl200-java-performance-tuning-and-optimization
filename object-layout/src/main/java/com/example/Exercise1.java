package com.example;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class Exercise1 {
	public static void main(String[] args) {
		System.out.println(VM.current().details());
		System.out.println(ClassLayout.parseClass(A.class).toPrintable());
		System.out.println(ClassLayout.parseClass(Integer[].class).toPrintable());
		System.out.println(ClassLayout.parseClass(int[].class).toPrintable());
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
	int x;
	short s1;
	short s2;
	byte b1;
	byte b2;
	byte b3;
	byte b4;
	byte b5;
	byte b6;
}