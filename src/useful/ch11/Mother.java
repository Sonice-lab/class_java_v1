package useful.ch11;

public class Mother extends Thread {
    //공유하는 자원
    BankAccount bankAccount;
    public Mother(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        //가정. 어머니께서는 5천원을 출금
        bankAccount.withdraw(5_000);
    }
}
