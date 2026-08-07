package inheritance;

/**
 * 고객의 속성 : 고객 아이디, 고객 이름, 고객 등급, 보너스 포인트, 보너스 포인트 적립비율
 * 일반 고객의 경우 물품 구매시 1%의 보너스 포인트 적립
 */
public class Customer {
    private int customerID;
    private String customerName;
    private String customerGrade;
    private int bonusPoint;
    private double bonusRatio;

    //기본 생성자
    public Customer(){}

    //메서드 1.
    public void calcPrice(int price){
        System.out.println("price: ");
    }

    //메서드 2.
    public void showCustomerInfo(String customerName){
        System.out.println("customerName: ");
    }

}
