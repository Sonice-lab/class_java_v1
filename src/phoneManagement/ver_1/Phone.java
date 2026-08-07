package phoneManagement.ver_1;

public class Phone {
    //1. 속성 정의
    private String name;
    private  String phoneNumber;

    //1. 생성자 만들기
    public Phone(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //2. get메서드 만들기
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    //3. set 메서드 만들기
    public void setName(String name){
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void showInfo(){
        System.out.println("-----사용자 정보-----");
        System.out.println("사용자 이름: " + name);
        System.out.println("전화번호: " + phoneNumber);
    }
}//end of class


