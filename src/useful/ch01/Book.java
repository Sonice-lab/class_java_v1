package useful.ch01;

//import java.lang.String;
//import java.lang.*; //모든 클래스 파일 가지고 오기 <--자동으로 가지도 오는 녀석이라 직접 명시할 필요가 없음

//Object 클래스는 모든 클래스의 최상위 클래스이다.
//extends를 선언하지 않아도 자동 생성됨
public class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    //부모 클래스(toString) 재정의
    @Override
    public String toString() {
        return "[" + title + "," + author + "]";
    }

    //showInfo() <-- 대신 toStirng을 재정의해서 많이 활용하기도 함

    //메인 함수
    public static void main(String[] args) {
        Book book = new Book("데미안", "헤르만 헤세"); //Heap메모리 영역에 객체를 띄움
        Book book2 = book; //book과 같은 주소값을 가리킴, 그렇게 때문에 아래와 같이 결과는 true로 나온다.
        Book book3 = new Book("데미안", "헤르만헤세");

        System.out.println(book == book2); //true
        System.out.println(book.equals(book2));//equals의 기본 동작은 == 이다. true

         System.out.println(book); //주소값 출력: useful.ch01.Book@b4c966a --> toString을 재정의하면 재정의한 대로 출력됨 -> 데미안,헤르만 헤세
        System.out.println(book.toString()); //주소값 출력: useful.ch01.Book@b4c966a 기본이 toString이기 때문에 위와 같이 생략 가능

        System.out.println("----------------------------------");
        System.out.println("로깅 1 - 책의 제목 : " + book.title);

        //논리적으로 같은 객체라도 판별하고 싶을 때, equals() 메서드를 재정의해서 활용할 수 있다.
        //단, equals()를 재정의할 때, 반드시 해시코드도 함께 재정의해야 한다. --> 의도치 않은 오류를 막을 수 있다.
        System.out.println(book.hashCode());
    }//end of main
}
