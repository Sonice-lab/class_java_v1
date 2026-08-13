package io.ch07;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//속도가 굉장히 빠름
public class BufferedFileReader {

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            //파일에다가 데이터를 읽을거야 > 기반스트림 대상은 파일이다.
            fr = new FileReader("assets/a.txt");
            //보조스트림 - 기반스트림을 감싸야 한다!
            //참고) BufferedInputStream - 바이트 기반일 때
            br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){ //역슬래시 기준으로 하나씩 빠르게 읽는 명령어
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //순서 중요! 역순으로 닫기!
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }//end of main
}//end of class
