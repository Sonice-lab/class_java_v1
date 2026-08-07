package com.oop15;

//연관관계의 예시
//체크리스트에 있는 목록 하나하나가 객체가 됨
public class Todo {

    private String content;
    //참고 - boolean 필드명에 관례상 is를 붙이지 않는다. --> 프로그램이 꼬일 수 있음
    private boolean completed;

    public Todo(String content) {
        this.content = content;
    }

    //getter
    public String getContent() {
        return content;
    }

    //getter - boolean 타입은 관례상 is로 만들어준다.
    public boolean getCompleted() {
        return completed;
    }

    //setter - 단순히 상태값만 변경하는 메서드를 set으로 만들어준다.
    //set에서는 is를 사용하지 않고 set으로 이름을 만들어준다.
    public void setCompleted(boolean completed) {
        this.completed = completed; //외부에서 불러오도록 처리
    }

    public void ShowInfo() {
        String status;//지역변수 생성
        if (completed) {
            status = "완료";
        } else {
            status = "미완료";
        }
        System.out.println("할 일 내용: " + content + ", " + status);
    }

}//end of class
