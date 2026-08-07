package com.oop6;

public class AccountMainTest {

    //코드의 시작점
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(10_000); //<-- 10_000 == 10,000
        account.withdraw(6_000);
        account.showInfo();

        // 접근 제어 지시자가 필요한 이유
        // 가상 시나리오
        // 나는 객체의 행동이 입금하는 기능을 만들어두었는데,
        // 신입 개발자가 실수로 입금하는 기능이 아닌, 직접 변수에 접근해서 값을 수정한다면,
        // 의도하지 않은 결과를 발생시킬 수 있다.
        // account.balance = 10_000; --> private로 변경하여 실수를 예방한다.
        // 변수에 직접 접근해서 값을 수정할 경우, 실수할 가능성이 높다.
        // 따라서, 나는 변수에 private를 사용해서 외부에서는 필드가 안보이게 설정하는 것이 좋다.

        System.out.println("-------------------------");
        account.showInfo();

    }//end of main
}//end of class
