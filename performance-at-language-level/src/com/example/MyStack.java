package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyStack<T> {
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    private List<T> list = new ArrayList<>();
    private int top = 0;

    public T pop() {
        Lock lock = rwl.writeLock();
        lock.lock();
        try {
            if (top == 0) throw new IllegalArgumentException("Stack is empty!");
            --top;
            T e = list.get(top);
            list.remove(top);
            return e;
        } finally {
            lock.unlock();
        }
    }

    public void push(T e) {
        Lock lock = rwl.writeLock();
        lock.lock();
        try {
            list.add(e);
            top++;
        } finally {
            lock.unlock();
        }
    }

    public T peek() {
        Lock lock = rwl.readLock();
        lock.lock();
        try {
            if (top == 0) throw new IllegalArgumentException("Stack is empty!");
            return list.get(top - 1);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        Lock lock = rwl.readLock();
        lock.lock();
        try {
            return top;
        } finally {
            lock.unlock();
        }
    }
}
