package useful.ch15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordBook {
    public static void main(String[] args) {
        //apple -> 사과
        Map<String, String> words = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        //샘플값
        words.put("apple", "사과");
        words.put("banana", "바나나");
        words.put("cherry", "체리");


        while (true) {
            System.out.println("\n=== 영한 단어장 ===");
            System.out.println("1.단어 추가 2.단어 검색 3. 전체 출력 4. 종료");
            System.out.println("선택: ");
            //int choice = sc.nextInt();
            String choice = sc.nextLine();

            //아래 기능을 구현해주세요.(if, Switch)
            // 1. 단어 추가
            if (choice.equals("1")) {
                System.out.print("추가할 단어: ");
                String word = sc.nextLine();

                System.out.print("단어의 뜻: ");
                String meaning = sc.nextLine();

                words.put(word, meaning);
                System.out.println("성공적으로 저장되었습니다!");
            }
            //2. 단어 검색
            if (choice.equals("2")) {
                System.out.println("검색할 단어를 입력하세요.: ");
                String word = sc.nextLine();

                if (words.containsKey(word)) {
                    System.out.println(word + ":" + words.get(word));
                }
            }

            //3. 전체 출력
            //키워드: KeySet, for 반복문
            if (choice.equals("3")) {
                System.out.println("===단어장 전체 출력===");
                for (String k : words.keySet()) {
                    System.out.println(k + ":" + words.get(k));
                }
            }

            //4. 종료
            if (choice.equals("4")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            //자원 닫기
            //sc.close();
        }
    }//end of main
}//end of class
