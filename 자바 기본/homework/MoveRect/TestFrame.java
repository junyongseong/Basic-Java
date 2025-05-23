package homework.회사;

import javax.swing.JFrame;


public class TestFrame extends JFrame {

	TestPanel p;
	public TestFrame() {
		
		//p=new TestPanel();
		//this.add(p);
		this.add(p=new TestPanel());
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		//이벤트 감지자 등록
		this.addWindowListener(new TestWindowAdap());
		this.addKeyListener(new TestKeyAdap(this));
	}
	
	public static void main(String[] args) {
		//프로그램 시작
		new TestFrame();
	}

}
