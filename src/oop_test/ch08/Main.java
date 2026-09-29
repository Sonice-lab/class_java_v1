package oop_test.ch08;

public class Main {
    public static void main(String[] args) {
        // 회사마다 다른 부분(오라클, MySQL 등..)을 쓴다면 따로 프로그램을 만드는 것이 아닌
        // 의존성 주입으로 해결한다.
        // 이 한 줄만 바꾸면 저장 방식이 바뀝니다. OrderService는 그대로입니다.
        OrderDao orderDao = new MemoryOrderDao();
        // OrderDao orderDao = new LogOrderDao();

        // 생성자에 필요한 객페를 외부에서 주입하고 있다. > 의존성 주입(DI)
        OrderService service = new OrderService(orderDao);

        service.takeOrder("아메리카노", 4500);
        service.takeOrder("카페라떼", 5000);
        service.takeOrder("바닐라라떼", 5500);

        service.printAllOrders();
    }
}
