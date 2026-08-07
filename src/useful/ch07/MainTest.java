package useful.ch07;

public class MainTest {
    public static void main(String[] args) {

        Water water = new Water();
        Plastic plastic = new Plastic();
        GenericPrinter printer = new GenericPrinter();
        //printer.setMaterial(water);//오류 발생!
        printer.setMaterial(plastic);
        System.out.println(printer.getMaterial());

    }//end of main
}//end of class


