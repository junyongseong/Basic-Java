package pm;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Map;

public class Ex8_File_info {

	public static void main(String[] args) {
		// 폴더의 경로
		String path= "c:/my_study/test/util";
		
		File f= new File(path);
		
		if(f.isDirectory()) {
			//디렉토리일 경우에만 수행하도록 한다.
			
			File[] sub=f.listFiles();
			String [] c_name = {"파일명","수정일","용량"};
			String[][] ar= new String[sub.length][c_name.length];
			//1차원 배열의길이는 sub의 길이 열은 c_name임
			
			for(int i=0;i<sub.length;i++) {
				//파일 하나 얻기
				File sub_file = sub[i];
				try {
					//얻어낸 파일의 정보를 얻어내기 위해 Map구조 생성
					Map<String,Object> att = Files.readAttributes(
							Paths.get(sub_file.getAbsolutePath()),"*");
					
					ar[i][0] =sub_file.getName();//파일명 0행 0열
					FileTime ft= ((FileTime)att.get("lastModifiedTime"));//최종 수정일
					ar[i][1]=ft.toString();//1행 1열
					
					ar[i][2]= String.valueOf(sub_file.length());
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				}//for의 끝
			for(int i=0;i<ar.length;i++) {
				for(int j=0;j<ar[i].length;j++) {
					System.out.printf("%s",ar[i][j]);
				}
				System.out.println();
				}
			}

	}

}
