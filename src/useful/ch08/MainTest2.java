package useful.ch08;

public class MainTest2 {

    public static void main(String[] args) {

        // 외부에서 들어오는 값들은 보통 문자열로 취급되는 경우가 많다.(스캐너, 통신 등...)
        String str1 = "10A"; // 숫자가 아닌 문자 포함 NumberFormatException --> 이거 숫자로 못바꿔!
        String str2 = "20.5";//실수형태의 문자열
        String str3 = "true";//Boolean 형태의 문자열

        //System.out.println("10" + 100); //10100 --> 문자열로 출력
        //외부에서 들어온 문자라도 연산을 하고 싶음!
        int n1;
        try {
            n1 = Integer.parseInt(str1);//문자열을 int형으로 바꾼다.
            System.out.println(n1 + 100); //110 --> 덧셈 연산되어 출력, 10A일 경우 NumberFormatException 발생! --> 이거 숫자로 못바꿔!
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값입니다!");
        }
        //문자열 > 실수로 변환
        double d = Double.parseDouble(str2);
        System.out.println(d + 0.5);

        //문자열 > 논리값으로 변환
        boolean b = Boolean.parseBoolean(str3);
        System.out.println(!b);

    }//end of main
}//end of class
