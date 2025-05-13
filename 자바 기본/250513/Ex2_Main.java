package am;

import java.util.Scanner;

public class Ex2_Main {

	public static void main(String[] args) {
		//Ex2_Pet 객체 생성
		Ex2_Pet a1= new Ex2_Pet();

		
		String a1_name = a1.getName();
		int a1_age=a1.getAge();
		System.out.printf("Name : %s, Age : %d\n",a1_name,a1_age);
		
		System.out.println("=======================");
		a1.setName("포동이");
		a1.setAge(2);
		
		a1_name =a1.getName();
		a1_age =a1.getAge();
		
		System.out.printf("Name : %s, Age : %d\n",a1_name,a1_age);

		System.out.println("=======================");
		
		
		Ex2_Pet a2 =new Ex2_Pet();
		
		
		a2.setName("바둑이");
		a2.setAge(5);
		String name =a2.getName();
		int age =a2.getAge();
		
		System.out.printf("Name : %s, Age : %d\n",name,age);
		
		
		/*
		String s1 = a1.getName();
		int s2=a1.getAge();


		System.out.println("이름을 입력 : ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		System.out.print("나이를 입력: ");
		int age = scan.nextInt();
		
		a1.setName(str);
		System.out.println("이름 : "+str);
		a1.setAge(age);
		System.out.println("나이 : "+age);
		*/
		
	}
}