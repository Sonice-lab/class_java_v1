package io.ch07;

import java.io.*;

public class BufferedKeyboard {

    public static void main(String[] args) {

        // 도전 과제 1 - 바이트 기반
        //키보드에서 데이터를 보조 기반 스트림을 활용해서 받아내고
        //콘솔(화면)에 출력하세요.

        try (BufferedInputStream bis = new BufferedInputStream(System.in);
             BufferedOutputStream bos = new BufferedOutputStream(System.out)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);//읽은만큼만 씀
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // 코드 직접 구현하기


    }//end of main
}//end of class


