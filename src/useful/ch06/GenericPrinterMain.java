package useful.ch06;

import java.util.ArrayList;

public class GenericPrinterMain {
    public static void main(String[] args) {
        //제네릭 프로그래밍을 활용하면 타입의 안정성을 주어 컴파일 시 명확하게 타입을 지정할 수 있다.
        Plastic plastic1 = new Plastic();
        Powder powder1 = new Powder();
        //코드를 사용하는 시점에 대체 문자열에 명확한 타입을 지정할 수 있다.
        GenericPrinter<Plastic> printer1 = new GenericPrinter();
        printer1.setMaterial(plastic1);
        System.out.println(printer1.getMaterial());
        //다운캐스팅 필요 없음! --> 즉 타입에 안정성을 줄 수 있음
        Plastic tempPlastic = printer1.getMaterial();

        //핵심 - 변수명을 똑같이 사용해야하는데 데이터 타입이 다양하게 처리되어야하는 경우
        //       제네릭 프로그래밍을 사용하면 아주 많은 이점이 있다.
        //사례 1) 배열 - 컬렉션 프레임워크(자료 구조) --> 객체 배열을 ArrayList 데이터 타입이 있음(제네릭 활용)
        //정수값만 넣고 싶을 때
        ArrayList<Integer> list = new ArrayList(); //[1][2][2][3][4] --> [4.0] x
        list.add(10);
        list.add(11);
        //list.add(10.0); > 실수 입력! 오류 발생!

    }//end of main
}//end of class
