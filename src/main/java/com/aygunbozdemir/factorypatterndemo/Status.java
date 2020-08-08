package com.aygunbozdemir.factorypatterndemo;

public enum Status {

    ACCEPT("Accept Product to Service"),
    DONE("Technical Support finished");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
