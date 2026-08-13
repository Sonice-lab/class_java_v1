package io.ch03;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

public class TimeEstimate1 {
    public static void main(String[] args) {
        //시간을 측정하는 코드 작성하기
        //1.1. 일반 코드로 작업하기
        //1.2. 소요시간 측정하기 end - start

        LocalTime start1 = LocalTime.now();

        try (FileInputStream in = new FileInputStream("assets/b.txt")) {
            int readData;
            while ((readData = in.read()) != -1) {
                System.out.println((char)readData);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LocalTime end1 = LocalTime.now();
        Duration result1 = Duration.between(start1, end1);

        System.out.println("작업 1. 시작 시간 : " + start1);
        System.out.println("작업 1. 종료 시간 : " + end1);
        System.out.println("작업 1. 소요 시간 : " + result1.toMillis() + "ms");


        //3. jave.time을 활용하여 두 작업 간의 시간을 측정하기

        //4. 어떤 작업이 더 빠른지 출력하기 > 작업1. 44ms
    }
}
