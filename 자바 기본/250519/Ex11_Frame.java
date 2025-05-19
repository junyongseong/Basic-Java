package pm;

import javax.swing.JFrame;

public class Ex11_Frame extends JFrame {

	public Ex11_Frame() {//기본 생성자
		this.setTitle("내가 그린 기린 그림은 목이 긴 기린 그린 그림이고"
				+ ", 네가 그린 기린 그림은 목이 안 긴 기린 그린 그림이다. ");
		
		//현재 객체(this)가 상속 받아서 가지고 있는 setSize호출
		this.setSize(1600, 1000);
		this.setLocation(0, 0);//창 위치설정
		this.setVisible(true);//창 보여주기
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//닫으면 자동으로 창 종료
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		Ex11_Frame f= new Ex11_Frame();

	}

}
