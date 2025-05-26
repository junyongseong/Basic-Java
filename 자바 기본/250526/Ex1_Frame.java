package am;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1_Frame extends JFrame {

	JPanel p;//패널 생성
	ArrayList<Ex1_Mythread> al= new ArrayList<>();
	
	public Ex1_Frame() {
		p= new JPanel() {
			//JPanel을 상속받는 익명의 내부 클래스
			@Override
			protected void paintComponent(Graphics g) {
				// ArrayList에 있는 Ex1_Mythread들을 하나씩 가져와서
				//그림을 그려야 한다.
				//먼저 더블 버퍼링을 위한 Image객체 준비
				
				Image buf = createImage(this.getWidth(), this.getHeight());
				//현재 영역에서 This는 Jpanel을 상속받는 이름없는 내부 객체를 의미함
			
				//buf에만 그림을 그릴 수 있는 전용 붓을 만들자
				Graphics buf_g= buf.getGraphics();
				
				for(int i=0;i<al.size();i++) {
					Ex1_Mythread mt = al.get(i);//ArrayList에서 요소를 하나씩 가져옴
					
					//붓 색상을 변경
					buf_g.setColor(mt.bg);
					buf_g.fillOval(mt.x, mt.y, mt.width, mt.height);
				}
				
				//임시 이미지 객체에 타원을 모두 그린상태다. 이제 이미지 객체를
				//현재 JPanel에 넣어야한다.
				g.drawImage(buf, 0, 0, this);
			}
			
		};
		this.add(p);
		
		
		this.setBounds(300, 100, 800, 500);
		setVisible(true);
		
		//종료이벤트
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		//p에서 클릭할 때 마다 이벤트 감지자 등록
		p.addMouseListener(new MouseAdapter() {

			//현재 영역은 MouseAdapter를 상속받는 익명내부 클래스
			@Override
			public void mousePressed(MouseEvent e) {
				// p에서 클릭 할 때 마다 호출되는 곳
				int x=e.getX();
				int y=e.getY();
				
				Ex1_Mythread m= new Ex1_Mythread(x, y, Ex1_Frame.this);
				//내부 클래스에서 바깥쪽 클래스를 지칭 할 때는
				//바깥쪽 클래스명. this라고 하면된다.
				
				//이렇게 생성된 타원 스레드 객체인 Ex1_Mythread를
				//ArrayList에 저장해야한다.
				al.add(m);
				
				//이제 m이라는 스레드를 시작시켜야함
				m.start();
			}	
		});;	
	}//생성자의 끝
	
	
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex1_Frame();

	}

}
