package useful.ch16;

class Calculator {
    public int add(int x, int y) {
        return x + y;
    }

    public int subsract(int x, int y) {
        return x - y;
    }
}
// 원래방식: 두수를 더하거나 빼는 기능을 만들려면 클래스를 설계하고, 객체를 만들고, 메서드를 호출하는 기본적인 3단계를 거쳐야 함.

public class Demo2 {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("10 + 5 = " + calculator.add(10,5));
        System.out.println("10 - 5 = " + calculator.subsract(10,5));
    }//end of main
}//end of class




