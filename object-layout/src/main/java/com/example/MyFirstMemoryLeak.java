package com.example;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MyFirstMemoryLeak {

	public static void main(String[] args) throws InterruptedException {
		Set<Customer> customers = new HashSet<>();
		var i = 0;
		while (true) {
			customers.add(new Customer("11111111110", "jack shephard"));
			customers.remove(new Customer("11111111110", "jack shephard"));
			if (i % 10_000 == 0)
				TimeUnit.MICROSECONDS.sleep(100);
			++i;
		}
//		System.err.println(customers.size());
//		System.err.println(customers.size());
	}

}

class Customer {
	private String identity;
	private String fullname;

	public Customer(String identity, String fullname) {
		this.identity = identity;
		this.fullname = fullname;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullname=" + fullname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
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
		Customer other = (Customer) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

}
