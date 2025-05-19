package pm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex13_Frame extends JFrame {
	
	private JButton bt1,bt2,bt3,bt4,bt5;
	public Ex13_Frame() {
	setTitle("내가 그린 기린 그림은 목이 긴 기림그림이고,"
			+ "네가 그린기린그림은 동서남북 창이있는 버튼그림이다.");
	
	bt1 =new JButton("버튼 1");
	bt2 =new JButton("버튼 2");
	bt3 =new JButton("버튼 3");
	bt4 =new JButton("버튼 4");
	bt5 =new JButton("버튼 5");
	
	add(bt1,BorderLayout.EAST);//동
	add(bt2,BorderLayout.WEST);//서
	add(bt3,BorderLayout.SOUTH);//남
	add(bt4,BorderLayout.NORTH);//북
	add(bt5);//아무것도 없으면 가운데
		
	setSize(1000, 600);
	setLocation(100, 200);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		
		Ex13_Frame fr =new Ex13_Frame();
	}
	
}
