package useful.ch02;

public class SubStringMain {

    public static void main(String[] args) {
        //개념 정리 - substring은 문자열의 일부 구간을 잘라내어 새로운 문자열로 반환하는 메서드
        //H e l l o W o r l d
        //0 1 2 3 4 5 6 7 8 9
        String text = "HelloWorld";

        //1. 시작 위치부터 끝까지 자르기
        System.out.println("substring(5): " + text.substring(5));
        //2. 시작 위치부터 끝 위치 '앞'까지 , 시작점이 0인 경우 앞 글자는 잘리지 않는다.
        System.out.println("substring(0,5)" + text.substring(0,5));

        //3. 만들어져 있는 모양 맞추기 개념 확인

        //시작인덱스는 포함, 끝 인덱스는 포함하지 않음
        //공식: end - start =
        //      6   -   2   =   4
        System.out.println("substring(2,6)" + text.substring(2,6));

        //주의할점: 범위를 벗어났을 경우, 컴파일 시점에서는 오류가 나지 않으나 런타임 시점에서는 오류가 발생한다.
        System.out.println("substring(0,20)" + text.substring(0,20)); //StringIndexOutOfBoundsException

//        String result2 = "unhappy".substring(2);
//        System.out.println(result2);
    }//end of main
}//end of class
