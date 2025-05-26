package pm;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;


public class Ex3_Frame extends JFrame {

	JPanel p;
	Image BackGround;//배경화면
	Image gunship;//비행선
	Image Missile;//미사일 날리기
	
	int bgy;//background y
	int bgHeight;
	int shipX=250;//건쉽 x의 좌표
	int shipY=600;//건쉽 y의 좌표
	ArrayList<Ex3_Missile> al =new ArrayList<Ex3_Missile>();//미사일 배열
	
	//배경을 움직이게 하는 스레드 
	Thread t =new Thread() {

		@Override
		public void run() {
			while(true) {
				//배경위치 업데이트
				bgy+=2;
				if(bgy>=bgHeight)//화면 아래에 도달한 경우		
					bgy=0;//다시 초기값 0을 넣어서 위로 올린다.
				p.repaint();//paintComponent가 호출되며,여기서 bgY가 증가한다.
				try {
					Thread.sleep(30);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}//무한반복
		}
	};
	public Ex3_Frame() {
		
		BackGround = new ImageIcon("src/images/space.jpg").getImage();
		gunship = new ImageIcon("src/images/gunship.png").getImage();
		Missile = new ImageIcon("src/images/missile.png").getImage();
		
		p=new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				Image buf = createImage(this.getWidth(),this.getHeight());
				
				Graphics buf_g=buf.getGraphics();
				bgHeight= BackGround.getHeight(this);
				//배경을 그리기
				buf_g.drawImage(BackGround, 0, bgy, getWidth(),bgHeight,null);
				//두번째 배경
				buf_g.drawImage(BackGround, 0, bgy-bgHeight, getWidth(),bgHeight,null);
				
				//비행선 그리기
				buf_g.drawImage(gunship, shipX, shipY, 60, 60, null);
				
				//미사일 그리는 반복문
				for(int i=0; i<al.size();i++) {
					Ex3_Missile m= al.get(i);
					buf_g.drawImage(Missile, m.m_x+1, m.m_y-70,m.m_w,m.m_h,this);
				}
				
				//화면에 나타내기 위해 이미지를 패널에 붙여넣는다.
				g.drawImage(buf, 0, 0, this);
			}
		};
		add(p);
		p.setFocusable(true);//패널을 활성화
		
		setBounds(300, 100, 600, 800);
		setVisible(true);
		
		t.start();//배경 움직이는 스레드 시작!
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//키보드감지
		p.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode =e.getKeyCode();
				int step=5;
					switch(keyCode) {
					case KeyEvent.VK_RIGHT://오른쪽
						shipX =Math.min(shipX+step,p.getWidth()-60 );
						break;
					case KeyEvent.VK_LEFT://왼쪽
						/*shipX -=step;
						if(shipX<0)
							shipX=0;*/
						shipX=Math.max(shipX-step, 0);//둘중 최대값을 달라는 뜻
						break;
					case KeyEvent.VK_UP://위로이동
						shipY =Math.max(shipY-step,0 );
						break;
					case KeyEvent.VK_DOWN://아래쪽으로 이동
						shipY =Math.min(shipY+step, p.getHeight()-60);
						break;
					case KeyEvent.VK_SPACE:
						//스페이스바를 누를때마다 미사일 객체 생성
						Ex3_Missile m =new Ex3_Missile(
								Ex3_Frame.this, shipX+(gunship.getWidth(p)/2-(19/2)), shipY);
						
						al.add(m);//생성된 미사일 객체를 ArrayList에 저장
						m.start();//스레드 구동
						break;
					}//switch문의 끝
				p.repaint();//비행선의 좌표가 변경되었으니 다시 그린다.
			}
		});//키보드 감지
	}//생성자의 끝
	
	public static void main(String[] args) {
		new Ex3_Frame();

	}

}
