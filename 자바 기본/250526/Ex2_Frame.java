package pm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2_Frame extends JFrame {

	JPanel p;
	int w=80; //상자의 넓이
	int h=30; // 상자의 높이
	int x,y; //상자의 위치
	
	//스페이스바를 누를 때 마다 생성되는 총알 객체(Thread)를 저장할 ArrayList!
	ArrayList<Ex2_Bullet> al =new ArrayList<Ex2_Bullet>();
	
	public Ex2_Frame() {
		this.add(p=new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// 더블 버퍼링 기법-현 Jpanel과 같은 크기의 Image 객체를 준비하자
				Image buf=createImage(this.getWidth(), this.getHeight());
				
				//준비된 이미지 객체에만 그림을 그릴 수 있는 붓 객체
				
				Graphics buf_g = buf.getGraphics();
				
				buf_g.fillRect(x, y, w, h);
				
				//총알들 그리기 위해 필요한 반복문
				
				for(int i=0;i<al.size();i++) {
					//총알 객체를 ArrayList로부터 하나씩 얻어내어 b라는 변수에 저장하자
					Ex2_Bullet b=al.get(i);
					
					//얻어낸 총알을 그린다
					buf_g.fillRect(b.x, b.y, b.w, b.h);
				}
				
				//이렇게 그려진 Image를 다시 현 JPanel에 이미지를 놓는다.
				g.drawImage(buf, 0, 0, this);
			}
			
			
		});
		
		setBounds(300, 100,600, 500);
		p.setFocusable(true);//p가 활성화
		
		this.setVisible(true);
		//상자의 위치를 잡아주기 위해 setVisible 이후에 x,y좌표를 지정한다.
		
		x=p.getWidth()/2-(w/2);
		y=p.getHeight()-(h+15);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		p.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				//먼저 사용자가 얻은 키의 코드값을 얻기
				int keyCode =e.getKeyCode();
				while(true) {
					switch(keyCode) {
					case KeyEvent.VK_SPACE:
						//스페이스바를 누를때마다 총알 객체 생성
						Ex2_Bullet b =new Ex2_Bullet(Ex2_Frame.this, x+35, y);
						
						//생성된 총알 객체를 ArrayList에 저장
						al.add(b);
						
						//총알은 스스로 올라가기 위해 Thrad로 부터 상속받음
						b.start();//스레드 구동
						break;
					case KeyEvent.VK_RIGHT:
						x+=5;
						if(x>p.getWidth()-w);
						x=p.getWidth()-w;
						break;
					case KeyEvent.VK_LEFT:
						x-=5;
						if(x<=0);
						x=0;
						break;					
						}//switch의 끝
					p.repaint();
				}
			}
		
		});
	}
	public static void main(String[] args) {
		new Ex2_Frame();

	}

}
