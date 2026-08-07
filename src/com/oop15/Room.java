package com.oop15;

public class Room {
    private String type;

    public Room(String type) {
        this.type = type;
    }

    public void use() {
        System.out.println(type + "사용합니다.");
    }
}
