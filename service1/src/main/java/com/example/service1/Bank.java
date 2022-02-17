package com.example.service1;
public class Bank {
    private final int id;
    private final String name;

    public Bank(final int id,  final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
