package oop_test.ch10;

// DI 주입은 어떻게 조합해야하는가?

import oop_test.ch10.OrderService;
import oop_test.ch10.RateDiscountPolicy;

public class Main {
    public static void main(String[] args) {
        // DiscountPolicy discountPolicy = new FixDiscountPolicy();
        MemoryOrderDao memoryOrderDao = new MemoryOrderDao();
        RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

        OrderService orderService = new OrderService(memoryOrderDao, discountPolicy );

        orderService.takeOrder("아메리카노", 4500);
        orderService.takeOrder("카페라떼", 5000);
        orderService.takeOrder("바닐라라떼", 5500);

        orderService.printAllOrders();

    }
}
