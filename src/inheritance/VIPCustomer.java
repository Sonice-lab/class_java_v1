package inheritance;

public class VIPCustomer extends Customer {

    public VIPCustomer(int customerID, String customerName, String customerGrade, int bonusPoint, double bonusRatio) {
        super();
    }

    //1. 자식 클래스 고유의 속성 설정
    private int agentID;
    private double salesRatio;

    //2. 생성자
    public VIPCustomer() {
    }

    //3. 메서드 1.
    public void getAgentID(int agentID) {
        System.out.println("agentID: ");
    }
}
