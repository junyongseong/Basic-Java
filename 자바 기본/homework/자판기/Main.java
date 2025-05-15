package homework;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//자판기(Vending)객체 생성
		Vending v =new Vending();
		v.init();//각 음료들이 배열에 생성되어 저장된다.
		
		Scanner scan =new Scanner(System.in);
		System.out.println("insert coin : ");
		int coin=scan.nextInt();
		
		String msg=v.insertCoin(coin);
		System.out.println(msg);
		
		System.out.println("선택:");
		int num =scan.nextInt();//음료번호 선택
		//msg=v.charge(num,coin);
		//System.out.println(msg);
		
		Drink d=v.getDrink(num);
		System.out.printf("선택한 음료는 : %s\n잔돈은 : %d원입니다.",d.getName(),
				coin-d.getPrice());

		scan.close();
	}

}
