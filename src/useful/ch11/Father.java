package useful.ch11;

public class Father extends Thread {
    //공유하는 자원 - BankAccount
    BankAccount bankAccount;

    public Father(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

    //별도로 일을 시키고 싶어! run()
    @Override
    public void run() {
        //가정. 아버지께서 1만원 입금하고 싶어함
        bankAccount.saveMoney(10_000);
    }
}
