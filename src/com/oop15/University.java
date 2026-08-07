package com.oop15;

/**
 * 대학교와 교수 예시 코드대학교 객체가 여러 교수 객체를 리스트로 가집니다.
 * 대학교가 문을 닫아(객체가 사라져)도 교수들은 다른 대학으로 갈 수 있으므로 생명주기가 독립적입니다.
 */

public class University {

    private Professor[] professors;
    private int count;

    public University(int size){
        this.professors = new Professor[size];
        this.count = 0;
    }
    //집합 관계의 핵심: 밖에서 생성된 객체의 주소값을 받아온다.
    public void addProfessor(Professor professor){
        if(count >= professors.length){
            System.out.println("더 이상 교수 정보를 넣을 공간이 없습니다.");

        }
        professors[count] = professor;
        count++;
    }
    public void showInfo(){
        //배열의 길이가 아니라 실제 담긴 개수까지만 순회한다.
        for(int i = 0;i<count;i++){
            professors[i].display();
        }
    }
}//end of class
