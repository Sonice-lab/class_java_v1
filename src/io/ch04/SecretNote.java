package io.ch04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * ### 간단한 암호화 저장소
 * <p>
 * 중요한 메모를 파일에 저장할 때, 내용을 살짝 변환해서 저장합니다.
 * 저장할 때는 각 문자의 ASCII 코드에 3을 더하고, 읽을 때는 3을 빼서 원래 문자로 복원합니다.
 * <p>
 * 원본 텍스트 : Hello
 * 암호화 후   : Khoor  (H+3=K, e+3=h, l+3=o, l+3=o, o+3=r)
 * 복호화 후   : Hello  (K-3=H, h-3=e, o-3=l, o-3=l, r-3=o)
 * 이 방식을 카이사르 암호(Caesar Cipher) 라고 합니다.
 * 고대 로마의 율리우스 카이사르가 군사 통신에 사용했던 방식입니다.
 */

public class SecretNote {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("-----비밀 메모장-----");
        System.out.println("저장할 메모를 입력하세요.: ");
        String input = sc.nextLine();

        //비밀 메모장 기능을 구현해주세요.
        //1. 입력받은 문자열을 assets/secretNote.txt 파일에 남기고자 하는 내용을 작성한다.
        //2. 암호화해서 파일에 쓰는 기능 구현


        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("assets/secretNote.txt", true);
            //배열로 변환
            byte[] original = input.getBytes();
            byte[] encrypted = new byte[original.length];

            //반복문 돌려서 +3하기
            for (int i = 0; i < original.length; i++) {
                encrypted[i] = (byte)(original[i] + 3);
            }
            fos.write(encrypted);
            fos.flush();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sc.close();

    }//end of main
}// end of class
