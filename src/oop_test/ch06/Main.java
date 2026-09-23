package oop_test.ch06;

public class Main {

    public static void main(String[] args) {
        // 1. 사용할 부품(Dao)을 먼저 생성
        OrderDao orderDao = new OrderDao();

        // 2. 서비스 객체를 생성할 때 부분(Dao)를 주입받도록 설계되어있음
         OrderService service = new OrderService(orderDao); //DI(생성자 의존성 주입)

        // 3. 동작 확인
        service.takeOrder("아메리카노", 4500);
        service.takeOrder("카페라떼", 5000);
        service.takeOrder("바닐라라떼", 5500);

        service.printAllOrders();
    }// end of main
}
