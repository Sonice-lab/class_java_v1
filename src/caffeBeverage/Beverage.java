package caffeBeverage;

public abstract class Beverage {
    private String name;
    private int price;

    //1. 생성자
    public Beverage(String name, int price){
        this.name = name;
        this.price = price;
    }

    //2. get 메서드
    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
    public abstract void prepare();
    public void serve(){
        System.out.println("주문하신 : " + this.name + "(이)가 준비되었습니다. 가격은 " + price +"원 입니다." );
    }

}
