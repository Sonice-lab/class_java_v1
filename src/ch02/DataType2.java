package ch02;


/**
 * 문자 데이터 타입
 * char 자료형의 크기는 2바이트입니다.
 */
public class DataType2 {

    //메인 함수의 시작점
    public static void main(String[] args) {

        // 기본자료형: 문자 타입(사실 내부적으로는 정수형으로 저장되어 있음)
        // 문자를 저장할 때 사용함.
        // 단 하나의 문자를 저장할 수 있음.
        char charBox = '가';
        // char charBox2 = '가나';  <- [][][][][][][][] [][][][][][][][]
        System.out.println(charBox);

        System.out.println('A');
        System.out.println('B');
        System.out.println('C');

        System.out.println("---------------------------------------");

        char alphabetA = 'A'; //[][][][] <-- 97 저장됨
        System.out.println((int)alphabetA);
        System.out.println((int)'K');
        // char alphabetB = "B"; ""(쌍따옴표)는 문자가 아닌 문자열을 표현할 때 사용한다.(JAVA 문법)

        // 고민! - 문자도 사실 정수형이라고 했으나 왜 화면에는 문자 형태로 출력이 되는걸까?-?
        // 이유: 문자표가 이미 컴퓨터 내부에 저장되어있기 때문!(아스키코드표)



    } //end of main
} // end of class
