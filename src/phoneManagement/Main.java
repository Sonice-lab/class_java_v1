package phoneManagement;

import phoneManagement.ver_1.Phone;

import java.util.Scanner;

public class Main {

    //전화번호관리 프로그램 만들기 - {연습문제}
    //**전화번호부에 저장된 연락처 정보 CRUD 기능 구현**
    //**요구 사항**
    //- **저장**: 사용자가 이름과 전화번호를 입력하여 전화번호부에 저장할 수 있어야 합니다.
    //- **조회**: 전체 연락처 목록을 조회하거나, 특정 이름으로 연락처를 검색하여 조회할 수 있어야 합니다.
    //- **수정**: 기존 연락처의 전화번호를 변경할 수 있어야 합니다.
    //- **삭제**: 전화번호부에서 연락처를 삭제할 수 있어야 합니다.
    //- **선택 조회** : 이름을 입력하면 해당 전화번호가 출력 되어야 합니다.
    //- **Scanner 활용, 입력 받는 데이터 타입은 전부 String 으로 처리**
    //- **전화번호 저장은 100까지 한정.**

    //실제값이 들어있는 인덱스를 관리하기 위한 변수를 먼저 선언한다.
    // 생각해보기: 이거 왜 굳이 static 변수로 지정해야할까?
    static int lastIndexNumber = 0;

    //- **저장**: 사용자가 이름과 전화번호를 입력하여 전화번호부에 저장할 수 있어야 합니다.
    public static void save(Scanner sc, Phone[] phones) {
        System.out.println("-------1. 저장을 선택하셨습니다.-------");
        //방어적 코드 작성
        //배열의 길이를 초과했을 경우 저장할 공간이 확보되지 않았으므로, 책을 더이상 저장할 수 없음
        if (lastIndexNumber >= phones.length) {
            System.out.println("데이터를 저장할 수 있는 공간이 없습니다.");
            return;
        }
        System.out.println("사용자 이름을 입력하세요.");
        String name = sc.nextLine();
        System.out.println("저장할 전화번호를 입력하세요.");
        String phoneNumber = sc.nextLine();
        System.out.println("성공적으로 저장 되었습니다.");
        //사용자에게 입력받는 변수들로 phone 이라는 객체 만들기
        Phone phone = new Phone(name, phoneNumber);
        //현재 객체를 생성했으니 값이 채워진 인덱스도 업데이트해야 함 lastIndexNumber 활용
        phones[lastIndexNumber] = phone;
        //만들어진 객체가 덮어쓰여지면 안되니까 증감 연산자를 활용해서 내용이 순차적으로 저장되도록 정리
        lastIndexNumber++;
    }


    //- **조회**: 특정 이름으로 연락처를 검색하여 조회할 수 있어야 합니다.
    //1. 이름으로 검색하기(생각해보기: 이건 왜 private일까?)
    private static void searchByName(Scanner sc, Phone[] phones) {
        System.out.println("'이름으로 조회'를 선택하셨습니다.");
        //이름을 입력하면 해당하는 정보 유무를 확인할 수 있는 기능
        System.out.println("조회할 이름을 입력해주세요.");
        String targetName = sc.nextLine();

        //100번 도는 도중 검색된다면 검색을 멈추기 위한 처리
        boolean isFine = false;
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null) {
                //문자열 비교는 반드시 equals를 사용!
                //.trim() <--문자열에 앞뒤 공백 자동 제거
                //예시) (공백)김 도 현(공백) > 중간 공백은 날리지 않음
                if (phones[i].getName().equals(targetName.trim())) {
                    System.out.println("[검색 결과 확인]");
                    phones[i].showInfo();
                    isFine = true;
                    break;
                }
            }
        }
        if (isFine == false) {
            System.out.println("조회된 사용자 정보가 없습니다.");
        }
    }

    /// /- **조회**: 특정 전화번호로 연락처를 검색하여 조회할 수 있어야 합니다.
    private static void searchByPhoneNumber(Scanner sc, Phone[] phones) {
        System.out.println("'전화번호로 조회'를 선택하셨습니다.");
        //이름을 입력하면 해당하는 정보 유무를 확인할 수 있는 기능
        System.out.println("조회할 전화번호를 입력해주세요.");
        String targetPhoneNumber = sc.nextLine();

        //100번 도는 도중 검색된다면 검색을 멈추기 위한 처리
        boolean isFine = false;
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null) {
                //문자열 비교는 반드시 equals를 사용!
                //.trim() <--문자열에 앞뒤 공백 자동 제거
                //예시) (공백)010 - 1234 - 5678(공백) > 중간 공백은 날리지 않음
                if (phones[i].getPhoneNumber().equals(targetPhoneNumber.trim())) {
                    System.out.println("[검색 결과 확인]");
                    phones[i].showInfo();
                    isFine = true;
                    break;
                }
            }
        }
        if (isFine == false) {
            System.out.println("조회된 사용자 정보가 없습니다.");
        }
    }


    //- **수정**: 기존 연락처의 전화번호를 변경할 수 있어야 합니다.
    private static void update(Scanner sc, Phone[] phones) {
        System.out.println("'전화번호 수정'을 선택하셨습니다.");
        //이름을 입력하면 해당하는 정보 유무를 확인할 수 있는 기능
        System.out.println("수정할 정보의 사용자 이름을 입력해주세요.");
        String targetName = sc.nextLine();

        //100번 도는 도중 검색된다면 검색을 멈추기 위한 처리
        boolean isFine = false;
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null) {
                //문자열 비교는 반드시 equals를 사용!
                //.trim() <--문자열에 앞뒤 공백 자동 제거
                //예시) (공백)김 도 현(공백) > 중간 공백은 날리지 않음
                if (phones[i].getName().equals(targetName.trim())) {
                    System.out.println("[검색 결과 확인]");
                    phones[i].showInfo();
                    System.out.println(targetName + "이 선택되었습니다. 새 전화번호를 입력해주세요.");
                    String phoneNumber = sc.nextLine();
                    phones[i].setPhoneNumber(phoneNumber);
                    System.out.println("수정이 완료되었습니다.");
                    isFine = true;
                    break;
                }
            }
        }
        if (isFine == false) {
            System.out.println("조회된 사용자 정보가 없습니다.");
        }
    }

    //- **삭제**: 전화번호부에서 연락처를 삭제할 수 있어야 합니다.
    private static void phoneNumberDelete(Scanner sc, Phone[] phones) {
        System.out.println("------전화번호 삭제를 선택하셨습니다.------");
        //만약, 검색했을 때 데이터가 없다면 > "삭제하고자하는 전화번호가 확인되지 않습니다."
        if (lastIndexNumber == 0) {
            System.out.println("삭제하고자하는 전화번호가 확인되지 않습니다.");
            return;
        }
        System.out.println("삭제할 전화번호를 입력해주세요.");
        String targetPhoneNumber = sc.nextLine().trim();
        //1단계: 삭제할 전화번호의 위치(인덱스)를 먼저 찾는다.
        int targetIndex = -1; //관용적인 표현, -1 "못 찾았다."는 뜻으로 약속한 값
        //만약, 검색을 했을 때 데이터가 있다면, "해당하는 전화번호가 확인되었습니다."
        for (int i = 0; i < lastIndexNumber; i++) {
            if (phones[i] != null && phones[i].getPhoneNumber().equals(targetPhoneNumber)) {
                System.out.println("전화번호가 검색되었습니다.");
                //시나리오 작성하기
                //[][][0][]
                targetIndex = i;
                break;
            }
        }
        //2단계: 못 찾았으면 여기서 동작 끝
        if (targetIndex == -1) {
            System.out.println("해당 전화번호를 찾을 수 없습니다.");
            return;
        }
        System.out.println("[삭제대상]");
        phones[targetIndex].showInfo();
        System.out.println("전화번호가 성공적으로 삭제되었습니다.");

        //3단계: 삭제할 자리 뒤에 요소들을 한 칸 씩 앞으로 당겨서 삭제할 대상 덮어쓰디
        //[A][B][C][D] ---> 1. 인덱스 삭제 ----> [A][C][D][D]
        //targetIndex == 2~4
        for (int i = targetIndex; i < lastIndexNumber - 1; i++) {
            //[][][C][][] = [][][][D][E]
            phones[i] = phones[i + 1];
            //[][][D][E][E]
            //[B] ---> 1번째 인덱스 = [C] ---> 2번째 인덱스 덮어쓰기
        }
        //4단계: 맨 뒷 칸을 비우고 실제 개수를 하나 줄인다.(라이스 인덱스 번호 재갱신)
        //[][][D][E][null]
        phones[lastIndexNumber - 1] = null;
        lastIndexNumber--;
    }


    //메인 함수
    public static void main(String[] args) {
        //1단계: 기본 코드 작성
        //- Scanner 활용, 입력 받는 데이터 타입은 전부 String 으로 처리
        Scanner sc = new Scanner(System.in);
        //- 전화번호 저장은 100까지 한정.
        Phone[] phones = new Phone[100];//배열안에 100칸짜리의 공간이 있다.

        //샘플데이터 만들기
        phones[0] = new Phone("김일남", "010-1234-5678");
        phones[1] = new Phone("김이남", "010-1234-1565");
        phones[2] = new Phone("김삼남", "010-1234-2454");
        phones[3] = new Phone("김사남", "010-1234-5464");
        phones[4] = new Phone("김오남", "010-1234-5843");

        //샘플데이터가 5개 이므로, 인덱스 관리 번호를 활용하여 이 샘플들을 관리해보자.
        lastIndexNumber = 5;

        //while문을 종료시키기 위한 선언
        boolean flag = true;

        final String SAVE = "1";
        final String SEARCH_BY_NAME = "2";
        final String SEARCH_BY_PHONENUMBER = "3";
        final String PHONENUMBERUPDATE = "4";
        final String PHONENUMBERDELETE = "5";
        final String END = "0";

        //2단계 실행의 흐름 만들어보기
        while (flag) {
            System.out.println("**메뉴를 선택하세요.**");
            System.out.print("1. 저장 2. 이름으로 조회 3. 전화번호로 조회 4. 전화번호 수정 5. 전화번호 삭제 0. 종료 ");

            //사용자에게 몇 번의 메뉴를 받을 것인가? > 스캐너 활용
            String selectedNumber = sc.nextLine();

            if (selectedNumber.equals(SAVE)) {
                //- **저장**: 사용자가 이름과 전화번호를 입력하여 전화번호부에 저장할 수 있어야 합니다.
                save(sc, phones);
            } else if (selectedNumber.equals(SEARCH_BY_NAME)) {
                //- **조회**: 특정 이름으로 연락처를 검색하여 조회할 수 있어야 합니다.
                searchByName(sc, phones);
            } else if (selectedNumber.equals(SEARCH_BY_PHONENUMBER)) {
                //- **조회**: 특정 전화번호로 연락처를 검색하여 조회할 수 있어야 합니다.
                searchByPhoneNumber(sc, phones);
            } else if (selectedNumber.equals(PHONENUMBERUPDATE)) {
                //- **수정**: 기존 연락처의 전화번호를 변경할 수 있어야 합니다.
                //1. 수정할 데이터를 선택하세요.
                //2. 새 전화번호를 입력하세요.
                update(sc, phones);
            } else if (selectedNumber.equals(PHONENUMBERDELETE)) {
                phoneNumberDelete(sc, phones);
            } else if (selectedNumber.equals(END)) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요");
            }
        }//enf of while
    }//end of main
}//end of class
