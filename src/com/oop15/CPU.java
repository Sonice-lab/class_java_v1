package com.oop15;

public class CPU {
    private String brain;

    public CPU(String brain) {
        this.brain = brain;
    }

    public void use() {
        System.out.println(brain + "을 사용합니다.");
    }
}
