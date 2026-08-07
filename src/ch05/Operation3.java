package ch05;

/**
 * 복합 대입 연산자
 * 대입 연산자와 다른 연산자가 함께 쓰이는 것
 */

public class Operation3 {

    //코드의 시작점
    public static void main(String[] args) {
        int n1 = 100;
        n1 = n1 + 1;
        n1 = n1 + 1; // 원래 값에서 +1씩 해주고 있음
        n1 = n1 + 1; // 귀찮음...... 이를 간소화 하기 위해 복합 대입 연산자를 활용할 수 있음

        System.out.println("------------------------");

        //시작값 설정
        int score = 7;

        // score = score + 3;
        //1. 점수 추가
        score += 3; //복합 대입 연산자, 축약해서 쓰는 것
        System.out.println("농구 점수 3점 추가 " + score);
        //2. 점수 감점
        // score = score - 3;
        score -= 3;
        System.out.println("농구 점수 3점 감점 " + score);

        //3. 점수 2배 증가
        score *= 2;
        System.out.println("농구 점수 2배 증가 " + score);

        //4. 점수 반으로 감소
        score /= 2;
        System.out.println("농구 점수 반으로 감소 " + score);

        //5. 점수에 대한 나머지 연산
        score %= 2;
        System.out.println("농구 점수에 대한 나머지 " + score);


    } //end of main
}//end of class
