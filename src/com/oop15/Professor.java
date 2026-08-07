package com.oop15;

public class Professor {

    private  String professorName;

    public Professor(String professorName){
        this.professorName = professorName;
    }
    public void display(){
        System.out.println("교수명: " + professorName);
    }
}
