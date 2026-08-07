package exercise;

public class Exercise0 {
    public static void main(String[] args) {
        //문제 이중 for문을 활용하여 012 012 012 3행으로 출력하기
        System.out.print(0);
        System.out.print(1);
        System.out.print(2);
        System.out.println();
        System.out.print(0);
        System.out.print(1);
        System.out.print(2);
        System.out.println();
        System.out.print(0);
        System.out.print(1);
        System.out.print(2);
        System.out.println();
        System.out.println("-----------------------------");
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println("---------------------------------");

        //문제 1, 3, 5, 7 별찍기
        for (int i = 1; i <= 4; i++) {
            System.out.println("*");
        }


        //문제 7, 5, 3, 1 별찍기
//            }
//        }
    }
}
