package useful.ch04;

public class ThrowsHandling {

    public static void main(String[] args) {

        Calc calc = new Calc();
        //사용하는 시점에서 예외처리
        try {
            calc.divide(100, 0); //ArithmeticException
        } catch (Exception e) {
            System.out.println("어떤 수를 0으로 나눌 수 없습니다.");
        }
    }//end of main
}//end of class

//Calc 클래스 설계
class Calc {
    //예외처리를 사용하는 사람이 직접 던질 수 있다. throws(메서드 선언부에서 사용)
    //강제성이 발생됨(사용하는 측에서 반드시 처리해야되는 강제성 생성)
    public int divide(int n1, int n2) throws DivideByZeroException {
        System.out.println("나누기 동작");
        return n1 / n2;
    }
}