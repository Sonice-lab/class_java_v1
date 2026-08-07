package employeeSalary;

public class PayrollMain {
    public static void main(String[] args) {

        Employee e1 = new FullTimeEmployee("김정규", 1001, 3200000);
        Employee e2 = new PartTimeEmployee("이알바", 2001, 10030, 80);

        e1.printInfo();
        System.out.println("급여 : " + e1.calculatePay() + "원");

        System.out.println("-----");

        e2.printInfo();
        System.out.println("급여 : " + e2.calculatePay() + "원");
    }
}
