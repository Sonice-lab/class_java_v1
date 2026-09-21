package oop_test.ch05;

import java.util.List;

public class ItemService {
    private ItemDao dao = new MemoryItemDao();

    // 메서드 1
    public void obtainItem (String name, String grade) {
        Item item = new Item(name, grade);
        dao.insert(inventory);
    }

    //메서드 2
    public void printInventory () {
        List<Item> item = dao.findAll();
        System.out.println("--- 전체 아이템 목록 ---");
        for(Item item : items) {
            System.out.println("item: " + item.getName() + ", 등급: " + item.getGrade());
        }
    }
}//end of class
