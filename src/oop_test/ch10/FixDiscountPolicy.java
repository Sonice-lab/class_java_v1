package oop_test.ch10;

import oop_test.ch10.DiscountPolicy;

// 구현체 1
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountAmount = 1000;

    @Override
    public int discount(int price) {
        return discountAmount;
    }


}
