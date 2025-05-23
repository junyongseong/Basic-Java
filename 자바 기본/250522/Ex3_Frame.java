package pm;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex3_Frame extends JFrame {

	//JPanel p;//먼저 패널 생성
	Ex3_Panel p;
	public Ex3_Frame() {
		//p=new JPanel();
		//this.add(p);
		
		p= new Ex3_Panel();
		this.add(p);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		//종료
		//이벤트 감지자 등록
		this.addWindowListener(new Ex2_MyAdap());//addWindowListener를 구현한 객체가 오른쪽 괄호
		p.addMouseMotionListener(new Ex3_MouseMotion(this));//addMouseMotionListener를 구현한 객체가 오른쪽 괄호
														//Ex3_MouseMotion객체를 생성할 때 인자가 this가 되어
														 //현재 객체(Ex3_Frame)의 주소를 전달했다.
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex3_Frame();

	}

}
