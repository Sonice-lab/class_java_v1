package useful.ch16;

@FunctionalInterface //함수형 인터페이스 -> 함수형 언어를 지원하기 위한 자바의 새로운 문법
public interface MathOperation {
    int operate(int x, int y);
    //void run();
}
