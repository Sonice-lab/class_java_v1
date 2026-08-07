package useful.ch01;

import java.util.Objects;

//Object 클래스를 자동으로 상속받고 있다.
public class EBook {

    private int bookTypeId;
    private String title;
    private String author;

    public EBook(int bookTypeId, String title, String author) {
        this.bookTypeId = bookTypeId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "EBook[" + bookTypeId + "," + title + "," + author + "]";
    }

    //equals() 메서드의 재정의의 목적은 필요하다면 논리적으로 같은 객체라고 판별하고 싶을 때 사용

    @Override
    public boolean equals(Object obj) {//Object로 선언되었을 경우 모든 클래스가 괄호안에 들어올 수 있다.
        //1. 동일 참조 체크
        if (this == obj) {//자기 자신을 비교하는 것
            return true;
        }
        //2. 타입 체크(EBook인지 여부)
        if (!(obj instanceof EBook)) {
            return false;
        }
        //3. 필드 비교(논리적 기준)
        //만약, 책제목과 저자가 같다면, 논리적으로 같은 책이라고 판별하겠다.
        EBook other = (EBook) obj; //다운캐스팅
        return this.bookTypeId == other.bookTypeId &&
                Objects.equals(this.title, other.title) &&
                Objects.equals(this.author, other.author);
    } //여기까지만해도 웬만한 부분들을 모두 확인 가능! 다만, 오류를 예방하기 위해 아래의 코드도 추가로 작성

    @Override
    public int hashCode() {
        return Objects.hash(bookTypeId, title, author); //필드 기반으로 해시 코드 생성
    }//여기까지 작성(재정의)해야 의도한 대로 잘 동작함
}
