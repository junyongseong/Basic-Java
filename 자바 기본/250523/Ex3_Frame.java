package am;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex3_Frame extends JFrame {

	private String msg ="쌍용교육센터";
	JPanel p;
	
	public Ex3_Frame() {
		p = new JPanel() {

			
			@Override
			protected void paintComponent(Graphics g) {
				g.drawString(msg, 10, 50);//x좌표 y좌표
			}
			
		};
		this.add(p);
		
		this.setBounds(300, 100, 400, 400);
		this.setVisible(true);
		
		//이벤트감지자 등록
		this.addWindowListener(new WindowAdapter() {

			//현재 영역은 WindowAdapter를 상속받는 이름없는 내부클래스
			//class ? extends WindowAdapter{}
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); //프로그램 종료
			}
		});
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex3_Frame();

	}

}
