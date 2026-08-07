package com.oop11;

public class ArrayTest4 {
    public static void main(String[] args) {

        //문자열로 배열을 사용해보자.
        String[] names = new String[10]; //값을 초기화하지 않았기 때문에 각 칸에는 null이 들어간다.

        //인덱스 연산자를 활용하여 값을 초기화
        names[0] = "김씨";
        names[1] = "나씨";
        names[2] = "박씨";
        names[9] = "최씨";

        // 배열의 길이와 요소의 갯수는 동일하지 않다는 것을 알고 있음
        // 여기서, null값이 아닌 요소만 출력할 수 있도록 코드를 생성해보기
        for(int i = 0;i<names.length;i++){
            //만약 null이 아니라면 출력해!
            if(names[i] != null){
                System.out.println(names[i]); //값이 없는 인덱스는 null로 출력된다.
            }
        }
    }//end of main
}//end of class
