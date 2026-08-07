package useful.ch02;

public class ReplaceMain {
        //API를 활용하면 시간을 절약라며 완성도가 높은 코드를 작성할 수 있다.
    public static void main(String[] args) {
        //개념 정리: replace는 문자열 안에서 특정 문자나 또는 문자열을 찾아 다른 값으로 바꾼 새로운 문자열을 반환하는 메서드
        //1. 원본은 절대 바뀌지 않는다.(불변객체)
        //2. 일치하는 부분을 전부 바꾼다.
        //3. 두가지 메서드 오버로딩이 존재한다.

        //🌟 테스트 코드 짜보기
        //1. char 하나를 다른 char로 바꾸기
        String fruit = "banana";
        String result1 = fruit.replace('a', 'o');
        System.out.println("reault1: " + result1 + ", 원본: " + fruit);

        //2. 문자열 단위로 바꾸기 --> 하이픈 제거하기
        String phone = "010-1234-1234";
        String result2 = phone.replace("-", "");
        System.out.println("result2: " + result2);

        //3. 활용
        String sentence = "자바는 재미있다. 다만, 자바는 어렵기도 하다.";
        String result3 = sentence.replace("자바", "JAVA");
        System.out.println("result3: " + result3);


//        String result1 = "mesquite in your cellar".replace('e', 'o');
//        System.out.println(result1);
    }//end of main
}//end of class
