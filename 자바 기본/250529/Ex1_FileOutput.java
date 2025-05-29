package am;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ex1_FileOutput {

   public static void main(String[] args) {
      // 저장할 파일의 경로를 준비 
      String path = "c:/my_study/test/abc.txt";

      // 위의 존재하지 않는 경로로 file객체 생성 
      File f = new File(path);

      try {
         FileOutputStream fos = new FileOutputStream(f);
         // 위 스트림을 생성하면 파일이 무조건 만들어진다.
         // 만약!
         // 같은 파일이 있다면 덮어쓰기가 된다. 
      } catch (FileNotFoundException e) {
         // File이 실존하지 않을 경우~ 
         e.printStackTrace();
      }

   }

}