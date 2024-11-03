package com.example.demo;

import java.util.LinkedList;

public class MyHashSetV2 {

    static final int DEFAULT_INITIAL_CAPACITY = 16;

    private LinkedList<Object>[] buckets;

    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV2() {
        init();
    }

    public MyHashSetV2(int capacity) {
        this.capacity = capacity;
        init();
    }

    private void init() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(Object value) {
        int hashIndex = hash(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        if (bucket.contains(value)) {
            return false;
        }
        bucket.add(value);
        size++;
        return true;
    }

    public boolean contains(Object value) {
        int hashIndex = hash(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        return bucket.contains(value);
    }

    public boolean remove(Object value) {
        int hashIndex = hash(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        boolean result = bucket.remove(value);
        if (result) {
            size--;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    private int hash(Object value) {
        return Math.abs(value.hashCode()) % capacity;
    }

}