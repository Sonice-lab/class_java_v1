package io.ch03;


import java.io.FileInputStream;

public class FileInputTest2 {
    public static void main(String[] args) {
        //파일을 열면 반드시 닫아 주는 것이 좋다.
        //다만, 반복적 코드가 매번 발생해서 불편함이 있다.
        //8버전 이후 이러한 불편함을 해결하기 위해 새로운 문법 try-with-resources 을 제공하고 있음

//        try{
//
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }finally {
//
//        }

        //      try(스트림을 생성 ... 자동으로 close() 호출됨){
//
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }finally {
//
//        }


        try (FileInputStream in = new FileInputStream("assets/a.txt")) {

            int readData;
            while ((readData = in.read()) != -1) {
                System.out.println((char) readData);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //.close 자동 호출됨 -> 메모리 누수 방지

    }//end of main
}
