package com.example.demo.Model;

public class InnodbFtDefaultStopword {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}