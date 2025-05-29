package am;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex2_FileOutput {

   public static void main(String[] args) {
      // 프로그램 시작 
      // 저장할 파일의 경로를 준비 
         String path = "c:/my_study/test/abc.txt";

         // 위의 존재하지 않는 경로로 file객체 생성 
         File f = new File(path);

         try {
            if(!f.exists()) { // 파일이 존재하지 않다면
            FileOutputStream fos = new FileOutputStream(f);
            // 위 스트림을 생성하면 파일이 무조건 만들어진다.
            // 만약!
            // 같은 파일이 있다면 덮어쓰기가 된다. 
            }else {
               int cmd = JOptionPane.showConfirmDialog(new JFrame(), "덮어쓰기 하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION);
               System.out.println(cmd + ":" + JOptionPane.YES_OPTION + ":" + JOptionPane.CANCEL_OPTION);

               if(cmd == JOptionPane.YES_OPTION) { // 경고창에서 예를 눌렀을 경우 
                  System.out.println("덮어쓰기 하러 감");
               }
            }
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         }
   }

}