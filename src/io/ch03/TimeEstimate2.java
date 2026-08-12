package io.ch03;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

public class TimeEstimate2 {
    public static void main(String[] args) {
        //시간을 측정하는 코드 작성하기
        //2.1. 배열 코드로 작업하기
        //2.2. 소요시간 측정하기 end - start

        LocalTime start2 = LocalTime.now();

        try (FileInputStream in = new FileInputStream("assets/b.txt")) {
            byte[] buffer = new byte[255];
            int readCount;
            while ((readCount = in.read(buffer)) != -1) {
                for (int i = 0; i < readCount; i++) {
                    System.out.print((char) buffer[i]);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        LocalTime end2 = LocalTime.now();
        Duration result2 = Duration.between(start2, end2);

        System.out.println("작업 2. 시작 시간 : " + start2);
        System.out.println("작업 2. 종료 시간 : " + end2);
        System.out.println("작업 2. 소요 시간 : " + result2.toMillis() + "ms");


        //3. jave.time을 활용하여 시간을 측정하기

        //4. 작업 1과 작업 2 중 어떤 작업이 더 빠른지 출력하기 > 작업 1.44ms, 작업 2.25ms
        //결과: 작업 1이 더 빠름!
    }
}


