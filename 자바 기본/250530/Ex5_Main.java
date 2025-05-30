package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex5_Main {

	public static void main(String[] args) {

		String path= "c:/my_study/test/abc.txt";
		File f= new File(path);
		
		ObjectInputStream ois= null;
		
		try {
			ois= new ObjectInputStream(new FileInputStream(f));
			
			Object obj = ois.readObject();//객체 읽기
			ArrayList<Ex4_Data> al = (ArrayList<Ex4_Data>) obj;//저장 당시의 자료형으로
															//형변환
			for(int i=0;i<al.size();i++) {
				Ex4_Data data= al.get(i);
				System.out.printf("이름 : %s , 나이 : %d \r\n",data.getName(),data.getAge());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois!=null)
					ois.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
