package oop_test.ch06;

import java.util.List;

public class OrderService {
    // 1. 직접 생성하지 않고 선언만 함
    private OrderDao dao;

    // 2. 외부에서 생성된 개체를 파라미터로 주입받도록 설계 (DI)
    public OrderService (OrderDao dao) {
        this.dao = dao;
        // 여기서 객체를 생성하게 될 경우 마름모는 채워진다.
    }

    public void takeOrder (String menuName, int price) {
        Order order = new Order(menuName, price);
        dao.insert(order);
    }
    public void printAllOrders() {
        // 자기가 주문받은 전체 목록 출력
        List<Order> orders = dao.findAll();
        System.out.println("----전체 주문 목록----");
        for(Order order : orders) {
            System.out.println("메뉴: " + order.getMenuName() + "| 가격: " + order.getPrice() + "원");

        }
    }
}
