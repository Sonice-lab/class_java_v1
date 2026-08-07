package useful.ch11;

public class Main1 {
    public static void main(String[] args) {
        //객체에 10만원 있음
        BankAccount bankAccount = new BankAccount(); //객체 생성
        //아버지(입금 일을 위임받은 자)는 1만원 입금
        Father father = new Father(bankAccount); //하나의 자원을 동시에 공유하는 Shared resource 상태
        father.start();
        //어머니(출금 일을 위임받은 자는 5천원 입금
        Mother mother = new Mother(bankAccount);//하나의 자원을 동시에 공유하는 Shared resource 상태
        mother.start();
        //기대값: 10만 5천원 ... 정상동작
        //실제로 찍어낸 값 11만원 --> 의도하지 않은 동작이 발생됨 --> 디버깅 실시
        //multi Thread를 사용하면 발생하는 문제! 시점에 따른 정보 업데이트 지연이 원인! --> 해결방법: BankAccount(공유하는 자원)에서 동기화 실시
        //동기화 후 의도한 대로 정상동작!
        // 위 해결 방안은 자바에서 동기화 처리로 해결할 수 있다.
        //키워드 'synchronized' 사용하여 synchronized 메서드로 만들 수 있다.

    }//end of main
}//end of class
