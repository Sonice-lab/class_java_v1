package employeeSalary;

// Payable 에게 받은 calculatePay() 를 구현하지 않았으므로 추상 클래스가 된다
//Employee는 Payable을 바라보고 있다.
public abstract class Employee implements Payable {

    private String name;
    private int id;

    //1. 생성자
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    //2. get 메서드
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void printInfo() {
        System.out.println("---사원 정보---");
        System.out.println("이름: " + getName());
        System.out.println("사번: " + getId());
    }
}
