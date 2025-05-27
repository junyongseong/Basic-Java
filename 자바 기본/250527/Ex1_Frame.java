package am;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1_Frame extends JFrame {

	Dimension d=new Dimension(390, 590);//너비 390 높이 590 크기 객체
	
	//필요한 이미지를 선언한다.
	Image back_img,me_img;//배경과 주인공 이미지
	
	JPanel p;
	Me me =new Me();
	public Ex1_Frame() {
		back_img = new ImageIcon("src/images/back.jpg").getImage();
		me_img = new ImageIcon("src/images/me.png").getImage();
		
		p= new JPanel() {//익명 내부 클래스

			@Override
			protected void paintComponent(Graphics g) {
				//배경 그리기
				g.drawImage(back_img, 0, 0, this);
				//주인공 그리기
				g.drawImage(me_img,me.rect.x, me.rect.y, this);//지금 x, y=0
			}
			
		};
		
		init_game();//게임 초기화 함수 호출
		init_me_pos();//me 캐릭터의 위치 초기화 함수
		
		this.setLocation(300, 50);//위치잡기
		this.pack();//창 내부에 들어온 컴포넌트들의 크기에 맞도록
			//현재창의 사이즈를 설정 우린 창에 JPanel만 추가하므로
			//JPanel의 크기(Dimension)에 맞춘다.
		this.setResizable(false);//창 크기 조정 불가
		this.setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});	
	}//생성자
	
	private void init_game() {
		//크기 객체(Dimension)을 가지고 JPanel의 크기로 예약하자
		p.setPreferredSize(d);
		
		//크기가 지정된 JPanel을 현재창 가운데에 추가!
		this.add(p);
	}
	
	private void init_me_pos() {
		//주인공 이미지의 초기 위치를 지정하는 함수
		
		//주인공 이미지의 너비와 높이를 지정
		int imgWidth = me_img.getWidth(this);
		int imgHeight = me_img.getHeight(this);
		
		//이미지의 너비 높이 확인
		//System.out.printf("w : %d, h : %d\r\n",imgWidth,imgHeight);
		//Me객체 안에 Rectangle의 x,y,width,height를 지정하자
		me.rect.x=(d.width-imgWidth)/2;
		me.rect.y=d.height-imgHeight-10;
		
		me.rect.width= imgWidth;//여기에 있는 너비와 높이가 없어도 이미지는 표현된다.
		me.rect.height= imgHeight;//rect의 너비와 높이가 필요한 이유는
								//운석객체와 주인공 객체가 충돌하는지 알아낼 때 필요함
	}
	
	public static void main(String[] args) {
		new Ex1_Frame();

	}

}
