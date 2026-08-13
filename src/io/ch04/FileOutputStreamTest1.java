package io.ch04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest1 {

    public static void main(String[] args)  {
        String data = "Hello, Java FileOutputStream...";
//        new FileOutputStream("assets/c.txt");
//        //기존 파일에 있는 데이터에 덮어쓰지말고 추가하라 - true
//        new FileOutputStream("assets/c.txt", true);//append
        FileOutputStream fos = null;
        //파일 참조 - fos
        try {
            fos = new FileOutputStream("assets/c.txt", true);
            fos.write("97".getBytes());
            fos.write(98);
            fos.write(99);

            fos.write(data.getBytes());

            //변기에 물을 내리다.
            fos.flush();
            //단, fos.close() 메서드를 호출하면 자동으로 flush() --> close()가 된다.

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }//end of main
}
