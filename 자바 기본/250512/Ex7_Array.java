package pm;

import java.util.Random;

public class Ex7_Array {

	public static void main(String[] args) {
		
		/*
		String[] a1= {"다이아","금두꺼비","꽝","로또1등"};
		String[] a2= {"꽝","황금알","비누","아파트"};
		String[] a3= {"꽝","천원","꽝","거품"};
		
		String[][] ar= new String[3][4];
		ar[0]=a1;
		ar[1]=a2;
		ar[2]=a3;
		*/
		
		String[][] ar= {
				{"다이아","금두꺼비","꽝","로또1등"},
				{"꽝","황금알","비누","아파트"},
				{"꽝","천원","꽝","거품"}
		};
		
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar[i].length;j++)
			{
				System.out.printf("%-1s\t",ar[i][j]);
			}
			System.out.println();
		}
		/*
		 Random rand = new Random();//랜덤 객체생성
		 
	     int row = rand.nextInt(ar.length);
	     int col = rand.nextInt(ar[0].length);
		 */
	     	int row = (int)(Math.random()*ar.length);//0~2
	     	int col = (int)(Math.random()*ar[0].length);//0~3

	     String msg = ar[row][col];
	     System.out.println("==============================");
	     System.out.println("랜덤으로 선택된 항목 : " + msg);
	}
}
