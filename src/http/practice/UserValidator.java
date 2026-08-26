package http.practice;

//요청 데이터를 담을 DTO 클래스
class UserSignUpRequest {
    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}

public class UserValidator {
    //1. 검증 결과 코드 상수 정의 (static final)
    public static final int SUCCESS = 0;
    public static final int ERROR_LENGTH = 1;
    public static final int ERROR_FORMAT = 2;
    public static final int ERROR_EMPTY = 3;

    /**
     * // 2. 아이디 검증 로직
     * //조건: 5자 이상 15자 이하, 영문 소문자와 숫자만 허용
     * // @param id 검증할 사용자 아이디
     * // @return 검증 결과 코드
     */

    public int validateId(String id) {
        //입력값 존재 여부 확인
        if (id == null || id.trim().isEmpty()) {
            return ERROR_EMPTY;
        }
        // 길이 검증 (5자~15자)
        if (id.length() < 5 || id.length() > 15) {
            return ERROR_LENGTH;
        }

        //정규식을 통한 형식 검증(영문 소문자 및 숫자로만 구성)
        /**
         * 1. ^: 문자열의 시작
         * 2. [a-z0-9]: 허용하는 문자들을 괄호 안에 모음
         *             영어 소문자 a부터 z와, 숫자 0부터 9 중 하나를 의미
         * 3. +: 바로 앞에 있는 패턴(여기서는 소문자나 숫자)이 1번 이상 반복되어야 함을 의미
         * 4. $: 문자열의 끝을 의미
         * 종합: "문자열의 처음부터 끝까지 오직 영문 소문자와 숫자로만 이루어져야 한다."라는 의미
         */
        if (!id.matches("^[a-z0-9]+$")) {
            return ERROR_FORMAT;
        }
        return SUCCESS;
    }

    /**
     * // 3. 비밀번호 검증 로직
     * // 조건: 8자 이상 20자 이하, 영문/숫자/특수문자 최소 1개 이상 포함
     * // @param password 검증할 사용자 비밀번호
     * // @return 검증 결과 코드
     */
    public int validatePassword(String password) {
        //입력값 존재 여부 확인
        if (password == null || password.trim().isEmpty()) {
            return ERROR_EMPTY;
        }

        //길이 검증(8자~20자)
        if (password.length() < 8 || password.length() > 20) {
            return ERROR_LENGTH;
        }
        //정규식을 통한 형식 검증(영문, 숫자, 특수문자 포함)
        /**
         * 1. ^: 문자열의 시작
         * 2. (?=.*[A-Za-z]): 긍정형 전방 탐색(Lookahead)기법
         *                  : 문자열 어딘가에 영문자(대소문자 또는 소문자)가 최소 1개 이상 포함되어 있는지 확인
         * 3. (?=.*\\d): 문자열 어딘가에 숫자(0~9)가 최소 1개 이상 포함되어 있는지 확인
         *               \d는 숫자를 의미하며 자바 문자열 안에서는 \\d로 작성
         * 4. (?=.*[@$!%*#?&]): 문자열 어딘가에 괄호 안의 특수문자(@$!%*#?&) 중 하나가 최소 1개 이상 포함되어있는지 확인
         * 5. [A-Za-z\\d@$!%*#?&]+: 비밀번호 전체가 영문 대소문자, 숫자, 그리고 허용된 특수문자로만 1개 이상 구성되어야 함을 의미
         *                          즉, 허용되지 않은 다른 문자나 공백이 들어가면 검사 실패!
         * 6. $: 문자열의 끝을 의미
         */
        if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]+$")) {
            return ERROR_FORMAT;
        }
        return SUCCESS;
    }
}
