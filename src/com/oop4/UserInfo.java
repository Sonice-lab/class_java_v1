package com.oop4;

public class UserInfo {
    String userId;
    String userPassword;
    String userName;
    String userAddress;
    String phoneNumber;

    //tip: 객체 생성될 때 가장 먼저 실행되는 부분은 생성자이다.
    //컴퓨터는 데이터의 갯수와 데이터 타입으로만 다른 점을 판단할 수 있기 때문에 생성자 마다 변수 숫자를 다르게 설계해주어야 함
    //아래의 구현 내용 참고하기!
    public UserInfo(String id) { //생성자
        userId = id;
    }
    public UserInfo(String u, String password) {
        userId = u;
        userPassword = password;
    }
    //생성자 직접 만들어보기
    public UserInfo(String id, String password, String name) {
        userId = id;
        userPassword = password;
        userName = name;
    }
    public UserInfo(String id, String password, String name, String address){
        userId = id;
        userPassword = password;
        userName = name;
        userAddress = address;
    }
    public UserInfo(String id, String password, String name, String address, String number){
        userId = id;
        userPassword = password;
        userName = name;
        userAddress = address;
        phoneNumber = number;
    }
}
