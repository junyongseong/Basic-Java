package pm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ex4_Main {

	public static void main(String[] args) {
		// 프로그램 시작
		//객체들을 저장할 파일의 경로
		
		String path= "c:/my_study/test/abc.txt";
		File f= new File(path);
		
		//저장할 객체
		Ex4_Data data = new Ex4_Data();
		data.setName("홍길동");
		data.setAge(27);
		
		Ex4_Data data2 = new Ex4_Data();
		data2.setName("아무동");
		data2.setAge(17);
		
		Ex4_Data data3 = new Ex4_Data();
		data3.setName("기린동");
		data3.setAge(233);
		
		ArrayList<Ex4_Data> list = new ArrayList<Ex4_Data>();
		list.add(data);
		list.add(data2);
		list.add(data3);
		
		//객체를 저장하기 위해 필요한 스트림
		ObjectOutputStream oos= null;
		try {
			oos= new ObjectOutputStream(new FileOutputStream(f));
			//oos.writeObject(data);//객체 쓰기(저장)
			oos.writeObject(list);//직렬화를 한 list를 넣어줘야함
			
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();//오류나면 보여줘
		}finally {
			try {
				if(oos !=null)
					oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	

	}

}
