package useful.ch04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyHandling {

    //1. 메인 함수
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);//키보드에서 데이터를 입력받는 녀석!

        try {
            System.out.println("숫자를 입력하시오.");  //문자를 입력할 경우 오류 발생! - InputMismatchException
            int result1 = scanner.nextInt();

        } catch (InputMismatchException  e1) { //최상위 클래스 > 순서를 맨 마지막에 처리해야함
            System.out.println("숫자를 입력하지 않았습니다. 숫자를 입력하세요.");
        } catch (Exception e2){
            System.out.println("알 수 없는 오류 발생!");
        }
        //못잡은 catch 부분을 놓치지 않기 위해 finally 처리!
        finally {
            //반드시 수행되어야 할 코드 영역
            // 심지어 return 키워드를 만나더라도 여기는 수행이 됩니다.
            scanner.close();//메모리 누수 방지 처리
        }
        System.out.println("-------------------------------------");
        System.out.println("프로그램이 비정상적으로 종료되지 않았습니다.");
    }//end of main
}//end of class
