package useful.ch04;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileExceptionHandling2 {

    public static void main(String[] args) {

        FileInputStream fis = null; //해당하는 파일에 빨대를 열어 읽어내는 기능

        try {
            fis = new FileInputStream("test1.txt");
            byte[] data = fis.readAllBytes(); //파일 전체를 읽어온다. checked 예외 -> FileNotFoundException로 catch 처리를 해버리면 하위 개념이라 잡히지 않음,
            String content = new String(data, StandardCharsets.UTF_8); //읽은 값을 문자열로 변환

            System.out.println("----------------파일 내용 시작------------------");
            System.out.println(content);
            System.out.println("----------------파일 내용 끝------------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    System.out.println("파일을 닫는 도중 문제가 발생되었습니다!");
                }
            }
        }
    }//end of main
}//end of class
