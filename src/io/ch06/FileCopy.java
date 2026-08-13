package io.ch06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        zipInputStream();

    }//end of main

    //파일 복사 기능을 만들어주세요.
    //단, 파일은 zip 파일로 한다.
    //1. 바이트 단위로 읽어야 함- inputStream 필요
    // 2. 출력하는 Stream이 필요하다. - outputStream 필요
    //소요 시간 체크

    //1. 파일에서 zip을 읽는 메서드(바이트기반 스트림 사용)
    public static void zipInputStream(){
        System.out.println("zip 파일을 확인합니다.");
        try (FileInputStream fis = new FileInputStream("assets/img1.zip")) {
            int data;
            while((data = fis.read()) != -1){
                System.out.println(data);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //2. 파일을 출력하기
    public static void saveZipFile(){
        System.out.println("zip 파일을 확인합니다.");
        try (FileOutputStream fos = new FileOutputStream("assets/img1.zip", true)) {
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//end of saveZipFile
}//end of class
