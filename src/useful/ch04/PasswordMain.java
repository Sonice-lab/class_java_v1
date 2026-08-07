package useful.ch04;

public class PasswordMain {
    public static void main(String[] args) {
        //String password = "123123";
        Password password = new Password();
        try {
            password.setPassword(null);
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("비정상종료 안됨");

    }//end of main
}//end of class
