package com.oop15;
//연관관계에서의 각 객체는 독립적으로 존재한다.
public class UserMainTest {
    public static void main(String[] args) {

        //1. Todo 객체와 User 객체는 서로 몰라도 각자 생성이 된다.
        Todo todo1 = new Todo("자바복습");
        User user1 = new User(1,"홍길동");

        //2. 아직 두 객체는 연결되지 않은 상태 - todo1필드는 null 상태임
        user1.displayMyTask();
        System.out.println("------------------------");

        //3. 연관관계 형성 - user1이  todo1의 주소값을 갖게된다.
        //메서드 의존 주입
        user1.setTodo(todo1);//연관관계 형성
        user1.displayMyTask();

        System.out.println("------------------------------");

        //4. todo1 참조 변수를 통해서 상태를 바꿔본다.(중요)
        todo1.setCompleted(true);//

        //5. 연관관계이기 때문에 user1을 통해서 조회해봐도 바뀐상태가 보인다.
        //즉, 복사본이 아니라 같은 객체 하나를 가리키고 있다.
        user1.displayMyTask();//todo1과 user1은 같은 객체를 바라본다는 것이 중요한 핵심

    }//end of main
}//end of class
