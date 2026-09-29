package oop_test.ch08;

// 데이터 객체 역할을 한다. - 주문 클래스(비즈니스 로직)

public class Order {
    private String menuName;
    private int price;

    public Order(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }
}
