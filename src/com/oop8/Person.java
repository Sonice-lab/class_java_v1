package com.oop8;

public class Person {//멤버 변수 선언 시 private로 선언하고, 필요하면 private를 제거한다.

    //this의 3가지 사용 방법
    //1. 자기 자신의 주소를 가리킨다.
    //2. 생성자에서 다른 생성자를 호출할 수 있다.
    //3. 자기자신의 주소값을 리턴값으로 반환시킬 수 있다.
    //똑같은 위치에는 같은 변수를 선언할 수 없다. > 다른 위치에서는 이름이 같은 변수를 선언할 수 있다.

    private String name;
    private int age;
    private String phone;
    private String gender; //F, M

    //컴파일러는 생성자를 구분할 때 우선 매개 변수 숫자를 확인하고, 갯수가 같다면 데이터 타입으로 생성자를 구분한다.
    //생성자 - 객체로 태어나게 하는 것
    //생성자 - 1. this 사용 방법 첫번째!
    public Person(String name, int age) {
        //생성자는 객체를 생성할 때 가장 먼저 수행되는 코드
        //멤버 변수를 초기화할 때 사용
        //name = name; //컴파일러는 가까운 변수를 먼저 찾음, 동시에 매개 변수로 보기때문에  변수에 this.을 붙여 자기자신을 나타낸다
        //this를 쓰는 이유: 변수명을 만들어야하는 경우가 많기 때문에 가리키는 단어를 같이쓰고 this.으로 구분해준다.
        this.name = name;
        this.age = age;
    }

    //생성자 - 2 this 사용 방법 2번째
    // 자기 자신의 생성자 호출, 생성자가 미리 만들어져 있어야 호출 가능, 모양 맞춰서 넣어주기
    public Person(String name, int age, String phone) {
        //this.name = name;
        //this.age = age;

        this(name, age); //★★★앞에 생성된 생성자 호출
        this.phone = phone;
    }

    //생성자 - 3. this 사용방법 복습

    public Person(String name, int age, String phone, String gender) {
        //this.name = name;
        //this.age = age;
        //this.phone = phone;

        this(name, age, phone);//★★★앞에 생성한 생성자 호출
        this.gender = gender;
    }

    // this의 메서드 - this의 사용 방법 3번째
    // 메서드를 통해서 자기 자신의 주소값을 반환 시켜야하는 경우 this를 사용할 수 있다.
    public Person getPerson() {
        return this;
    }
}//end of class