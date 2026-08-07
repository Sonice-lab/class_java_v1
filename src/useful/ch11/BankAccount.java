package useful.ch11;

public class BankAccount {

    private int money = 100_000;

    //get 메서드
    public int getMoney() {
        return money;
    }

    //set 메서드
    public void setMoney(int money) {
        this.money = money;
    }

    //입금 기능
    public synchronized void saveMoney(int money) {
        int currentMoney = getMoney(); //현재금액이 얼마인지 money를 주입받을 수 있도록 한다.
        //은행에서 입금하는 상황, 3초 정도 걸림
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setMoney(currentMoney + money);
        System.out.println("입금 후 계좌잔액: " + getMoney());
    }

    //synchronized <-- 동기화 처리(순차적으로 코드를 수행해도록 보장)
    //출금 기능
    public synchronized int withdraw(int money){
        int currentMoney = getMoney();
        try {
            Thread.sleep(1000);//1초 걸림!
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //방어적 코드
        if(currentMoney >= money){
            setMoney(currentMoney - money);
            System.out.println("출금 후 계좌 잔액: " + getMoney());
            return money;

        }else{
            System.out.println("잔액 부족");
        }

        return 0;
    }

}
