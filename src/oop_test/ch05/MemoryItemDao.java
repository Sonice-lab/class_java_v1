//package oop_test.ch05;
//
//import javax.naming.CompositeName;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MemoryItemDao implements ItemDao {
//
//    private List<Item> inventory = new ArrayList<>();
//
//    public void insert (Item item) {
//
//        inventory.add(item);
//        System.out.println("[" + item.getName() + "] 아이템을 인벤토리에 넣었습니다.");
//
//    }
//
//    public List<Item> findAll () {
//        return inventory;
//    }
//
//}
