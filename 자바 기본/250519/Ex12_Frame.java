package pm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//현재 객체는 JFrame으로 부터 상속을 받았으므로
//현재 객체를 생성하는 순간 생성하는 것이 바로 창틀을 만드는 것과 같다.
public class Ex12_Frame extends JFrame {

	//현재 창 객체가 가지는 모든것들은 멤버 변수로 선언한다.
	private JButton bt1,bt2,bt3;
	
	public Ex12_Frame() {//this붙여도 되고 안붙여도 됨
		this.setTitle("내가 그린 기린 그림은 버튼을 가진 창 기린 그린 그림이고"
				+ ", 네가 그린 기린 그림은 목이 안 긴 기린 그린 그림이다. ");
		//버튼 객체들 생성
		bt1 = new JButton("버튼 1");//버튼1이라는 문자열이 써진 버튼 객체 생성
		bt2 = new JButton("버튼 2");
		bt3 = new JButton("버튼 3");
		//현재 창(this)에 추가(add)해야 한다.
		this.add(bt1,BorderLayout.NORTH);//north영역에 bt1 추가
		this.add(bt2,BorderLayout.CENTER);//생력하면 center이다
		add(bt3,BorderLayout.EAST);
		
		
		
		setSize(500, 400);
		setLocation(300, 100);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);//종료버튼을 누를때 프로그램 종료
		
	}//생성자의 끝
	
	public static void main(String[] args) {
		// 프로그램 시작
		Ex12_Frame f = new Ex12_Frame();

	}

}
