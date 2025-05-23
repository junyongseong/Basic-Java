package am;

import javax.swing.JFrame;

public class Ex1_Frame extends JFrame {

	Ex1_Panel p;
	
	public Ex1_Frame() {
		add(p=new Ex1_Panel());//화면 가운데에 p객체 생성 후 추가
		//p.setFocusable(true);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		this.addWindowListener(new Ex1_WinAdap());
		//p.addKeyListener(new Ex1_KeyAdap(this));
		addKeyListener(new Ex1_KeyAdap(this));
	}
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex1_Frame();
	}

}
