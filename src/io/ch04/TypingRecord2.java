package io.ch04;
//도전과제 1 - 입력받은 문자열을 assets/typing.txt 파일에 바로 기록해주세요.
//도전과제 2 - 파일에 한 단어를 입력할 때 소요시간도 함께 표기해주세요. 소요시간:

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class TypingRecord2 {
    public static void main(String[] args) {
        // 키보드에서 값을 입력 받아서 내가 정의한 파일에 그대로 저장 시키는 기능을 구현해 보자.
        Scanner sc = new Scanner(System.in);
        System.out.println("=========타자 연습 기록기 ==========");
        System.out.println("1. 문장 저장");
        System.out.println("2. 기록 보기");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveRecord(sc);
        } else if(choice.equals("2")) {
            printRecord();
        }
        sc.close();
    } // end of main

    public static void printRecord() {
        System.out.println("\n 저장된 기록 ");
        try (FileInputStream fis = new FileInputStream("assets/typing.txt")) {
            int data;
            while ( (data = fis.read()) != -1 ) {
                System.out.print((char)data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void saveRecord(Scanner sc) {
        System.out.print("연습한 문장을 입력하세요 :  ");
        LocalDateTime start = LocalDateTime.now();
        String input = sc.nextLine();
        LocalDateTime end = LocalDateTime.now();

        Duration result = Duration.between(start, end);
        long ms = result.toMillis();
        double sec = ms / 1000.0;

        String record = input + " | 소요시간 : " + sec + "초 " + ms + "(ms)";

        try (FileOutputStream fos = new FileOutputStream("assets/typing.txt", true)) {
            fos.write(record.getBytes());
            fos.write("\n".getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // end of saveRecord
}



