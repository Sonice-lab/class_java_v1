package employeeSalaryVer_2.employeeSalary;

public class Manager extends FullTimeEmployee {

    private int allowance;

    public Manager(String name, int id, int monthlySalary, int allowance) {
        super(name, id, monthlySalary);
        this.allowance = allowance;
    }

    @Override
    public int calculatePay() {
        // 부모가 계산한 월급에 수당만 더한다
        return super.calculatePay() + allowance;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("직책 수당 : " + allowance + "원");
    }
}
