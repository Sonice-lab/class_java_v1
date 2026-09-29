package oop_test.ch10;

import java.util.List;


// 인터페이스 (설계도)
public interface OrderDao {
    //저장 메서드 구현
    void insert(Order order);
    List<Order> findAll();
}
