package employeeSalary;

public class PartTimeEmployee extends Employee {

    private int hourlywage;
    private int workHours;

    public PartTimeEmployee(String name, int id, int hourlywage, int workHours) {
        super(name, id);
        this.hourlywage = hourlywage;
        this.workHours = workHours;
    }

    @Override
    public int calculatePay() {
        return hourlywage * workHours;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        // name 은 private 이므로 자식에서는 getName() 으로 읽는다
        System.out.println(getName() + " 님의 이번 달 근무 시간 : " + workHours + "시간");
    }
}

