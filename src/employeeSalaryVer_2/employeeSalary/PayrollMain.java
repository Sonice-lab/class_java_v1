package employeeSalaryVer_2.employeeSalary;

public class PayrollMain {
    public static void main(String[] args) {

        Employee e1 = new FullTimeEmployee("김정규", 1001, 3200000);
        Employee e2 = new PartTimeEmployee("이알바", 2001, 10030, 80);

        e1.printInfo();
        System.out.println("급여 : " + e1.calculatePay() + "원");

        System.out.println("-----");

        e2.printInfo();
        System.out.println("급여 : " + e2.calculatePay() + "원");

        System.out.println("-----");

// Employee 타입으로 받으면 calculateBonus() 를 호출할 수 없다
        FullTimeEmployee e3 = new Manager("박팀장", 1002, 4000000, 500000);

        e3.printInfo();
        System.out.println("급여 : " + e3.calculatePay() + "원");
        System.out.println("보너스 : " + e3.calculateBonus() + "원");
    }

}
