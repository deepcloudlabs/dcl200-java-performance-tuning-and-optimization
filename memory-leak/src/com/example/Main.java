package com.example;
import java.util.*;

import static java.util.Objects.hash;

public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> emps= new ArrayList<>(100_000);
        emps.ensureCapacity(300_000);
        HashSet<Employee> employees = new HashSet<>(100_000);
        employees.add(new Employee("1", 10000,"jack bauer"));
        employees.add(new Employee("2", 20000,"kate austen"));
        employees.add(new Employee("3", 30000,"james sawyer"));
        System.out.println(employees.size());
        System.out.println(employees.contains(new Employee("2", 20000,"kate austen")));
        // after some codes...
        System.out.println("After a long long long time...");
        employees.remove(new Employee("2", 20000,"kate austen"));
        System.out.println(employees.contains(new Employee("2", 20000,"kate austen")));
        System.out.println(employees.size());


    }
}

class Employee {
    private String identityNo;
    private double salary;
    private String fullName;

    public Employee(String identityNo, double salary, String fullName) {
        this.identityNo = identityNo;
        this.salary = salary;
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(identityNo, employee.identityNo);
    }

    @Override
    public int hashCode() {
        return hash(identityNo);
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}