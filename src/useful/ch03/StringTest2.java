package useful.ch03;

public class StringTest2 {
    public static void main(String[] args) {

        String str1 = new String("Hello");
        String str2 = new String("World");
        Dog dog = new Dog();
        System.out.println(dog);
        System.out.println(str1);//참조 변수를 넣으면? --> 주소값이 나옴
                                 //String을 넣으면? --> 문자열 --> toString을 재정의 해두었기 때문

        //String 실제 주소값을 확인해보자.
        System.out.println(System.identityHashCode(str1));//해시코드(예시: 도서관의 청구번호)값 확인 가능

        //문자열은 불변이다.(한번 생성된 문자열은 불변이고, 변경이 발생되면 새로 문자열이 생성되는 구조)
        //str1 = str1 + "World";//문자열 추가 변환 -> 주소값 변경됨
        System.out.println("-----------------");
        str1 = str1.concat("world");
        System.out.println("str1 + world: " + str1);
        System.out.println(System.identityHashCode(str1));

    }//end of main
}//end of class

class Dog{}