package am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex4_Frame extends JFrame {

	JPanel p;
	int x=210;
	
	public Ex4_Frame() {
		
		p=new JPanel() {

			//현재 영역은 jpanel 상속받는 익명의 내부클래스 영역이다.
			@Override
			protected void paintComponent(Graphics g) {
				Image buf =createImage(this.getWidth(),this.getHeight());
				
				Graphics buf_g =buf.getGraphics();
				int red =(int)(Math.random()*256);
				int green =(int)(Math.random()*256);
				int blue =(int)(Math.random()*256);
				
				Color c= new Color(red,green,blue);
				buf_g.setColor(c);
				
				buf_g.fillRect(x, 235, 80, 30);
				
				//사각형이 그려진 이미지 객체를 현재 JPanel에 넣는다.
				g.drawImage(buf, 0, 0, this);
			}
			
		};
		this.add(p);//화면 가운데에 패널 객체 넣기
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		//windowadaoter를 상속받는 익명의 내부 클래스 영역이다.
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		addKeyListener(new KeyAdapter() {
			//현재 영역은 KeyAdapter을 상속받는 익명의 내부 클래스
			@Override
			public void keyPressed(KeyEvent e) {
				// 누른키의 코드값을 받기
				int keyCOde =e.getKeyCode();
				
				//좌측,우측 방향키만 선별하는 비교문 만들기
				switch(keyCOde) {
				case KeyEvent.VK_LEFT:
					x-=5;
					if(x<0)
						x=0;
					p.repaint();

					break;
				case KeyEvent.VK_RIGHT:
					x+=5;
					if(x>p.getWidth()-80)
						x=p.getWidth()-80;
					p.repaint();

					break;
				
				}//switch 의 끝
				//p.repaint();
			}	
		});
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex4_Frame();
	}
}
