package employeeSalary;

public class FullTimeEmployee extends Employee  {

    private int monthlySalary;

    public FullTimeEmployee(String name, int id, int monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public int calculatePay() {

        return monthlySalary;
    }
}

