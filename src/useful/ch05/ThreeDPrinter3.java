package useful.ch05;

public class ThreeDPrinter3 {

    //재료
    Object material;

    //재료를 꺼냄
    public Object getMaterial() {
        return material;
    }

    //재료를 넣음
    public void setMaterial(Object material) {
        this.material = material;//필드에 보관하므로 의존 관계는 아님
    }

    //테스트코드 작성
    public static void main(String[] args) {
        Plastic plastic1 = new Plastic();
        Powder powder1 = new Powder();
        ThreeDPrinter3 threeDPrinter3 = new ThreeDPrinter3();
        threeDPrinter3.setMaterial(plastic1);
        System.out.println(threeDPrinter3.getMaterial());
        System.out.println("----------------------------");
        threeDPrinter3.setMaterial(powder1);
        System.out.println(threeDPrinter3.getMaterial());

        //타입을 선언해서 저장시켜보자.
        Powder tempPowder = (Powder) threeDPrinter3.getMaterial(); //다운캐스팅  --> 문제! 매번 해야하기 때문에 매우 불편

    }
}
