package useful.ch04;

public class ArrayExceptionHandling {

    public static void main(String[] args) {

        //Runtime 오류 발생! -> 반복문을 try-catch 처리하여 해결!
        //1. 배열 선언과 동시에 초기화
        int[] arr = {1, 2, 3, 4, 5};
        //3. try - catch로 예외처리 해주기
        try {
            //2. 반복문 돌리기
            for (int i = 0; i < 10; i++) {
                System.out.println("arr[" + i + "] = " + arr[i]); //ArrayIndexOutOfBoundsException
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //System.out.println("catch 블록으로 넘어왔음");
            //System.out.println(e.getMessage()); //String 값을 리턴 - Index 5 out of bounds for length 5
            e.printStackTrace();// 추적할 수 있는 오류에 대한 내역을 출력
        }

        System.out.println("프로그램이 비정상 종료되지 않았음");

    }//end of main
}// end of class




