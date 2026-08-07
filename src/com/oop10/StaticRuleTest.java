package com.oop10;

public class StaticRuleTest {

    private String version = "1.0.0"; //인스턴스변수(멤버 변수이기도 함)
    private static String appName = "로또 번호 생성기"; //static 변수

    //인스턴스 메서드 > 객체의 행위를 담당
    public String getVersion(){
        System.out.println(appName);
        System.out.println(version);
        System.out.println(makeMessage()); //static 메서드는 태양이기 때문에 이미 생성되어 있는 것으로 간주됨 그래서 인스턴스 메서드에서도 실행 가능
        return version;
    }

    //static 메소드
    public static String makeMessage(){
        System.out.println(appName);//여기서 appName은 static 변수
            //아직 객체가 생성되지 않은 상태일 수 있기 때문에 사용 못하게 막음

//        System.out.println(version); //여기서 version은 인스턴스 변수 > 실행 안됨 불가능
//        System.out.println(getVersion()); //여기서 version은 인스턴스 변수 > 실행 안됨 불가능
//        System.out.println(this); //여기서 version은 인스턴스 변수 > 실행 안됨 불가능

        return appName +  " 입니다.";

    }
}



