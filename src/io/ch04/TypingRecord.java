package io.ch04;
//도전과제 1 - 입력받은 문자열을 assets/typing.txt 파일에 바로 기록해주세요.
//도전과제 2 - 파일에 한 단어를 입력할 때 소요시간도 함께 표기해주세요. 소요시간:

import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class TypingRecord {
    public static void main(String[] args) {
        //키보드에서 값을 입력 받아서 내가 정의한 파일에 그대로 저장시키는 기능을 구현
        //1. 표준 입력 스트림
        Scanner sc = new Scanner(System.in);//스트림 체이닝


        System.out.println("==================타자 연습 기록기===================");
        System.out.print("연습한 문장을 입력하세요.: ");


        //도전과제 1 - 입력받은 문자열을 assets/typing.txt 파일에 바로 기록해주세요.

        //입력이 시작 직후의 시각을 기록
        LocalTime start = LocalTime.now();
        String input = sc.nextLine();
        //입력이 끝난 직후의 시각을 기록
        LocalTime end = LocalTime.now();
        Duration result = Duration.between(start, end);
        long ms = result.toMillis();
        double sec = ms/1000.0;

        //파일에 남길 내용을 미리 설계
        String record = input + " | 소요시간: " + sec + "초" + ms + "(ms)";

        try {
            FileOutputStream fos = new FileOutputStream("assets/typing.txt", true);
            fos.write(record.getBytes());
            fos.write("\n".getBytes());

            //변기에 물을 내리다.
            fos.flush();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//end of main
}
