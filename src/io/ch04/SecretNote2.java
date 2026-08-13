package io.ch04;

import java.io.FileInputStream;
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

public class SecretNote2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== 비밀 메모장 ===");
        System.out.println("1. 메모 암호화 저장");
        System.out.println("2. 메모 복호화 읽기");
        System.out.print("선택 : ");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveEncrypted(sc);
        } else if (choice.equals("2")) {
            readDecrypted();
        }

        sc.close();
    }

    static void saveEncrypted(Scanner sc) {
        System.out.print("저장할 메모를 입력하세요 : ");
        String input = sc.nextLine();

        try (FileOutputStream fos = new FileOutputStream("assets/secretNote.txt")) {
            byte[] original  = input.getBytes();
            byte[] encrypted = new byte[original.length];

            for (int i = 0; i < original.length; i++) {
                encrypted[i] = (byte) (original[i] + 3);
            }

            fos.write(encrypted);
            System.out.println("암호화 저장 완료!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void readDecrypted() {
        System.out.println("\n=== 복호화된 메모 ===");

        try (FileInputStream fis = new FileInputStream("assets/secretNote.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) (data - 3));
            }
            System.out.println();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

