package oop_test.ch09;


//비즈니스 로직 객체(주입 대상)
public class OrderService {
    // 인터페이스로 참여
    private DiscountPolicy discountPolicy;

    // 생성자 - DI의 역할
    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public void takeOrder(String menuName, int price) {
        Order newOrder = new Order(menuName, price);
        int discountAmount = discountPolicy.discount(newOrder.getPrice());
        // 모든 계산은 서비스 객체에서 한다.
        int finalPrice = newOrder.getPrice() - discountAmount;
        System.out.println(newOrder.getMenuName() + "| 정가: " +
                newOrder.getPrice() + "원| 할인: " + discountAmount + "원 | 결제금액: " + finalPrice + "원");

    }
}
