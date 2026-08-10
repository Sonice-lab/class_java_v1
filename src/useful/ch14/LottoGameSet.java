package useful.ch14;

import java.util.*;

public class LottoGameSet {
    public static void main(String[] args) {

        Set<Integer> lotto = new HashSet<>();
        Random random = new Random();
        int count = 0;

        //횟수가 명확하게 지정되어있지 않을 때? -> while //lotto.size() < 6 --> false
        while(lotto.size() < 6){//6이되면 멈추는 코드 -> (5)(12)(15)(18)(22)(45)
            int number = random.nextInt(45)+1;
            lotto.add(number);
            count++;
        }
        System.out.println("이번 주 로또 번호: " + lotto);
        System.out.println("while문 반복 횟수: " + count);

        System.out.println("----------------------------------------------");
        //순서 정렬하고 싶음
        //ArrayList의 기능 - ArrayList 생성자 안에 Set 계열을 넣어서 List 계열에 객체를 생성할 수 있다.
        //객체를 하나 더 생성
        //형변환의 개념
        List<Integer> sortedLotto = new ArrayList<>(lotto);
        System.out.println(sortedLotto);
        System.out.println("----------------------------------------------------------");
        //오름차순 정렬(ArrayList)
        Collections.sort(sortedLotto);
        System.out.println("오름차순된 로또 번호: " + sortedLotto);

        //도전 과제 - 내림차순으로 정렬하는 코드를 작성하세요.
        Collections.sort(sortedLotto.reversed());
        System.out.println("내림차순된 로또 번호: " + sortedLotto);

    }//end of main
}// end of class
