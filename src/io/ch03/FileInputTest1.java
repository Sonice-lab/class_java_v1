package io.ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputTest1 {
    public static void main(String[] args) {
        //추상화(I/O 스트림의 끝판왕)을 이용하면 파일을 쉽게 읽어들일 수 있다.
        //파일을 한 바이트씩 읽어들이는 스트림
        FileInputStream in = null;

        //메모리 공간 상자 선언
        int readData;

        //Heap 메모리에 띄우기
        try {
            in = new FileInputStream("assets/a.txt");
//            //파일의 첫번째 데이터를 한 바이트로 읽기
//            readData = in.read(); //catch 절 추가하기
//            System.out.println("1: " + readData);
//            System.out.println("1: " + (char) readData);
//
//            //파일의 두번째 데이터를 한 바이트로 읽기
//            readData = in.read();
//            System.out.println("2: " + readData);
//            System.out.println("2: " + (char) readData);

            //도전 과제 - 반복적인 부분을 확인하고 끝까지 파일에서 데이터를 읽는 코드를 작성해주세요.
            int i;
            while ((i = in.read()) != -1) {
                System.out.print((char) i);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                //방어적 코드 - NullPointerException 예방
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //in.close(); //예상 문제 - catch에서 잡히면 실행되지 않음 -> finally 안에 넣어 예외처리 해주기
    }//end of main
}
