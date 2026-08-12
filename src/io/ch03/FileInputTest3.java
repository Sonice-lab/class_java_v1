package io.ch03;


import java.io.FileInputStream;

public class FileInputTest3 {
    public static void main(String[] args) {

        //도전과제
        //in.read(byte[] b)를 사용해서 코드를 완성해보세요.
        //in.read보다 훨씬 빠름

        //1. 데이터를 담아 둘 그릇(바구니)가 먼저 필요! 미리 만들어두기
        //크기 10 = 한번에 최대 10바이트까지 읽어오겠다고 설정
        byte[] buffer = new byte[255];

        //몇개를 읽었는지를 반환한다. -> read(byte[] b)는 읽은 바이트 수를 반환한다.
        //read()가 바이트 값 자체를 돌려주는 것과는 다름
        int readCount; //얼마나 읽었는지에 대한 변수 선언

        try (FileInputStream in = new FileInputStream("assets/a.txt")) {
            //[a][b][c][d][e][]
            //[a][b][c] <---
            //[d][e][c]
            while ((readCount = in.read(buffer)) != -1) {
                //buffer.length....
                for (int i = 0; i < readCount; i++) {
                    System.out.print((char) buffer[i]);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //.close 자동 호출됨 -> 메모리 누수 방지

    }//end of main
}

