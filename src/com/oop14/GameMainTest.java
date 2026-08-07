package com.oop14;

public class GameMainTest {
    public static void main(String[] args) {
    Warrior warrior = new Warrior("하나", 1);
    Archer archer = new Archer("둘", 2);
    Wizard wizard = new Wizard("셋", 3);
    warrior.comboAttack();
    archer.fireArrow();
    wizard.freezing();
    }//end of main
}//end of class
