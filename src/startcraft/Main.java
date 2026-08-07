package startcraft;

import startcraft.ver_1.Marine;
import startcraft.ver_1.Zealot;
import startcraft.ver_1.Zergling;

public class Main {
    public static void main(String[] args) {

        Zealot z1 = new Zealot("질럿1"); //2에서 사망
        Zealot z2 = new Zealot("질럿2"); //6에서 사망
        Zergling ze1 = new Zergling("저글링1"); //1에서 사망
        Zergling ze2 = new Zergling("저글링2"); //5에서 사망
        Marine ma1 = new Marine("마린1"); //3에서 사망
        Marine ma2 = new Marine("마린2"); //4에서 사망
        Marine ma3 = new Marine("마린3");

        //1. 질럿이 저글링을 공격하는 시나리오
        for (int i = 0; i < 10; i++) {
            z1.attack(ze1);
        }
        ze1.showInfo();//죽어버린 ze1 😢

        System.out.println("-------------------");

        //2. 저글링이 질럿을 공격하는 시나리오
        for (int i = 0; i < 100; i++) {
            ze2.attack(z1);
        }
        z1.showInfo();//죽어버린 z1 😢

        System.out.println("---------------------------");

        //3. 질럿이 특정 마린을 공격하는 시나리오
        for (int i = 0; i < 15; i++) {
            z2.attack(ma1);
        }
        ma1.showInfo();//죽어버린 ma1 😢

        System.out.println("---------------------------");
        //4. 저글링이 특정 마린을 공격하는 시나리오
        for (int i = 0; i < 100; i++) {
            ze2.attack(ma2);
        }
        ma2.showInfo();

        System.out.println("--------------------------");
        //5. 마린이 저글링을 공격하는 시나리오
        for (int i = 0; i < 100; i++) {
            ma3.attack(ze2);
        }
        ze2.showInfo();//죽어버린 ze2 😢

        System.out.println("----------------------------");
        //6. 마린이 질럿을 공격하는 시나리오
        for (int i = 0; i < 100; i++) {
            ma3.attack(z2);
        }
        z2.showInfo();//죽어버린 z2 😢
    }//end of main
}//end of class
