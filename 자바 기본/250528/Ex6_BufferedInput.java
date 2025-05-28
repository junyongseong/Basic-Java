package pm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Ex6_BufferedInput {

	public static void main(String[] args) {
		String path ="C:/My_Study/java_study/work/Ex_0528/src/pm/Ex5_FileInput.java";
		//FileInputStream을 활용하여 읽은후 화면에 출력하시오

		File f = new File(path);//경로로 파일객체 생성
		FileInputStream fis=null;
		BufferedInputStream bis= null;
		
		try {			
			fis = new FileInputStream(f);
			bis = new BufferedInputStream(fis);//부모
			int size=-1;
			byte[] buf = new byte[2048];//*****//2kb임
			
			while((size=bis.read(buf))!= -1) {//배열 2048이 차던가 -1이면
											//while을 벗어남
				String str =new String(buf, 0, size);//buf의 0번지부터 size가 기억하고
				//있는것까지
				//위는 배열 buf의 0번지부터 size가 기억하고 있는 번지까지 
				//가져와서 문자열로 만든다.(0~1047)
				
				//한번에 읽어버림
				System.out.println(str);
			}//while의 끝
		} catch (Exception e) {
			//예외가 발생할 경우 오류난 Stack구조로 표현한다.
			e.printStackTrace();
		}finally {try {
			fis.close();
			bis.close();//닫는 순서도 안쪽에 있는 fis먼저 닫기
		} catch (Exception e2) {
			}
		}

	}

}
