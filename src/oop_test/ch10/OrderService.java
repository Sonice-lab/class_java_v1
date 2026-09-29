package oop_test.ch10;


import oop_test.ch10.DiscountPolicy;
import oop_test.ch10.Order;

import java.util.List;

//비즈니스 로직 객체(주입 대상)
public class OrderService {
    private OrderDao dao;
    // 인터페이스로 참여
    private DiscountPolicy discountPolicy;

    // 생성자 - DI의 역할
    public OrderService(OrderDao dao, DiscountPolicy discountPolicy) {
        this.dao = dao;
        this.discountPolicy = discountPolicy;
    }

    public void takeOrder(String menuName, int price) {
        Order newOrder = new Order(menuName, price);
        dao.insert(newOrder);

    }

    public void printAllOrders() {
        List<Order> orders = dao.findAll();
        System.out.println("--- 전체 주문 내역 ---");
        for (Order order : orders) {
            int discountAmount = discountPolicy.discount(order.getPrice());
            // 모든 계산은 서비스 객체에서 한다.
            int finalPrice = order.getPrice() - discountAmount;
            System.out.println( "메뉴: " + order.getMenuName() + "| 결제금액: " + finalPrice + "원");
        }
    }
}
