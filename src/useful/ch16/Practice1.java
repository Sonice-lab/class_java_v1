package useful.ch16;

public class Practice1 {
    /**
     * 도전과제
     * <p>
     * 두 수를 입력 받아 큰 값을 출력하는 기능을 만들어 보세요 단, 람다 표현식을 사용하세요
     * <p>
     * 1. 함수형 인터페이스 선언
     * 2. 람다 표현식 설계
     * 3. 데이터 입력후 결과 확인
     */

    public static void main(String[] args) {
        Output output1 = new Output() {
            @Override
            public int output(int x, int y) {
                if (x > y) {
                    return x;
                } else {
                    return y;
                }
            }
        };

        //람다식 - 삼항 연산자 활용
        Output output2 = (x, y) -> x > y ? x : y;

        //출력
        System.out.println("익명클래스: " + output1.output(50, 100));
        System.out.println("람다표현식: " + output2.output(50, 100));

    }//end of main
}
