package useful.ch04;

//사용자 정의 예외 클래스 만들기
//상속을 통해 만들 수 있음 unchecked의 상위 클래스 > RuntimeException으로 처리
public class DivideByZeroException extends RuntimeException  {

    private String msg;

    public DivideByZeroException(String msg) {
        super(msg); //RuntimeException 생성자에 우리가 작성한 메세지를 넣을 수 있도록 설계 e.getMessage() <---
        this.msg = msg;
    }
}
