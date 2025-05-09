package pm;

import java.util.*;

public class Ex6_Array {

	public static void main(String[] args) {
		//배열의 정렬
		
		//정수 5개를 저장하는 배열을 만들자.
		int[] ar= new int[5];
		
		//외부로부터 배열의 값을 받았다고 가정하자
		ar[0]=27;
		ar[1]=15;
		ar[2]=22;
		ar[3]=9;
		ar[4]=4;
		
		//정렬을 시키기 위해 java.util.Arrays객체가 필요함
		Arrays.sort(ar);//오름차순 정렬 1만건 이하면 이게 나쁘지 않다
		Arrays.parallelSort(ar);//배열의 크고 10만건 이상
		//그 안에 있는 값들이 들쑥날쑥일 경우 parallelSort가 빠르고
		//배열의 크기가 작고 정렬이 된 경우 sort가 빠르다.
		for(int i=0;i<ar.length;i++)
		{
			System.out.printf("ar[%d] = %d\n",i,ar[i]);
		}
		
		//내림차순을 정렬 시키기 위해서는 java.util.Collections가 필요함
		//Collections는 기본자료형 배열로 하지 말고 객체 자료형 배열로 해야함
		// int[] --->Integer[] 객체 자료형은 앞에 숫자가 대문자
		
		System.out.println("---내림차순---");
		Integer[] ar1=new Integer[5];
		
		ar1[0]=27;
		ar1[1]=15;
		ar1[2]=22;
		ar1[3]=9;
		ar1[4]=4;
		
		Arrays.parallelSort(ar1,Collections.reverseOrder());
		for(int i=0;i<ar1.length;i++)
		{
			//ar1[i]=ar[i]; 이건 이미 정렬이 되어있는것
			System.out.printf("ar1[%d] = %d\n",i,ar1[i]);
		}
		//실수형(float,double) 5개를 저장하는 배열
		double[] ar2=new double[5];
		Double[] ar3=new Double[5];
		
		char c ='A';//기본자료형
		Character c2 = c;
		
		boolean b=true;
		Boolean b2=true;
		
	}
}
