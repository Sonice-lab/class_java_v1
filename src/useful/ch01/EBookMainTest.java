package useful.ch01;

public class EBookMainTest {

    public static void main(String[] args) {

        EBook eBook1 = new EBook(1, "홍길동전", "허균");
        EBook eBook2 = new EBook(1, "홍길동전", "허균");
        EBook eBook3 = new EBook(2, "춘향전", "작자미상");

        System.out.println("eBook1: " + eBook1);
        System.out.println("eBook2: " + eBook2);
        System.out.println("eBook3: " + eBook3);//toString을 재정의 했기 때문에 바로 이렇게 출력 eBook3: EBook[2,춘향전,작자미상]
        System.out.println("----------------------------------------------");
        System.out.println("eBook1 == eBook2: " + (eBook1 ==eBook2)); //false(참조 비교)
        System.out.println("eBook1.equals(eBook2) : " + (eBook1.equals(eBook2))); //true(논리적 동등 비교)
        System.out.println("eBook1.equals.(eBook3): " + (eBook1.equals(eBook3))); //false(논리적 동등 비교)

        System.out.println("eBook1.hashcode(): " + eBook1.hashCode()); //501961186
        System.out.println("eBook2.hashcode(): " + eBook2.hashCode()); //501961186
        System.out.println("eBook3.hashcode(): " + eBook3.hashCode()); //-1100199342

    }//end of main
}//end of class


