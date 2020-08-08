package com.aygunbozdemir.factorypatterndemo;

public enum PhoneBrand {
    APPLE("apple"),
    SAMSUNG("samsung");

    private final String model;

    PhoneBrand(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model;
    }
}
