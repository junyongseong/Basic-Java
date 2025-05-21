package am;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex3_GridLayout extends JFrame {

	JButton[] ar =new JButton[5];
	GridLayout gl;
	JPanel center_p;
	
	public Ex3_GridLayout() {
		center_p =new JPanel();//지금상태는 flowlayout임
		gl = new GridLayout(3, 3,10,20);//3행 3열 즉 9개의 셀이 생김 수평간격 수직간격
		center_p.setLayout(gl);//기본 레이아웃인 FLowLayout을 GridLayout으로 변경
		
		for(int i=0;i<ar.length;i++) {
			ar[i]= new JButton(String.valueOf(i+1));
			center_p.add(ar[i]);//center_p에 버튼객체 추가
		}
		
		for(int i=0;i<3;i++)//3행 3열의 모양을 유지하기 위해 공백을 JLable로 
			center_p.add(new JLabel());//만들어서 추가하는 반복문
		
		
		this.add(center_p);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Ex3_GridLayout();
	}
}
