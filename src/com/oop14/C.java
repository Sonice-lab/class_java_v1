package com.oop14;


//extends - 상속을 사용할 때 사용.
public class C extends A {

    // 여기 코드에는 보이지는 않지만 자동으로 A에 선언된 필드들을 물려 받는다.
    //단, 접근 제어 지시자는 그대로 동작한다.
    //여기서 부모클래스는 C

    int level;
    String nickName;
}
