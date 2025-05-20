package pm;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex6_Frame extends JFrame implements MouseListener {

	//현재 창에 들어가는 모든것들을 멤버로 선언
	JPanel north_p;//북쪽에 나무판자
	
	JButton bt1,bt2,bt3;
	JTextArea ta;//중앙에
	
	public Ex6_Frame() {//멤버변수들 초기화는 생성자에서
		north_p =new JPanel();
		bt1 =new JButton("Red");
		bt2 =new JButton("Green");
		bt3 =new JButton("Blue");
		ta= new JTextArea();
		
		
		
		//위에서 생성한 객체들을 배치시켜야 한다.
		//먼저 north영역에 들어갈 버튼들을 north_p에 추가
		//this.add 현재창에 추가한다는 소리니
		
		north_p.add(bt1); //north_p에 버튼들 추가
		north_p.add(bt2);
		north_p.add(bt3);
		
		this.add(north_p,BorderLayout.NORTH);//north_p를 북쪽에 추가
		setTitle("내가 그린 기린 그림은 목이 긴 기림 그림이고,"
				+ "네가 그린 기린그림은 목이 안 긴 기린 그림이다.");
		
		//스코롤바의 역활을 하는 객체 생성
		//현재창 가운데에 ta 추가
		//this.add(ta); 
		JScrollPane jp =new JScrollPane(ta);
		this.add(jp,BorderLayout.CENTER);
		//이벤트 감지자 등록
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
		bt3.addMouseListener(this);
		
		setSize(500, 400);
		setLocation(300, 100);
		setVisible(true);//이게 위에 있으면 이미 보여진 상태에서 추가하기 때문에 
		//스크롤 추가가 안됨
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		
		Ex6_Frame f= new Ex6_Frame();

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		//마우스 버튼을 누를 때마다 호출하여 수행하는 곳
		
		//이벤트를 발생 시킨 객체를 얻어낸다. 즉 여기서 버튼을 알 수 있음
		Object obj = e.getSource();
		if(obj==bt1) {
			//이벤트를 발생 시킨 객체가 bt1일 때 수행한다.
			ta.append("Red\r\n");
		}
		else if(obj==bt2) {
			ta.append("Green\r\n");			
		}
		else {
			ta.append("Blue\r\n");			
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
