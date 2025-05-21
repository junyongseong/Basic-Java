package am;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2_FlowLayout extends JFrame implements ActionListener {

	JPanel north_p;
	JButton bt1,bt2,bt3;
	FlowLayout fl;
	
	public Ex2_FlowLayout() {//이와 같은 생성자는 객체가 생성될 때 단 한번 호출되면서
							//멤버 변수들에 대한 초기화를 목적으로 한다.
		
		// create(); 아래처럼 create 함수를 만들고 하면 됨
		
		north_p = new JPanel();
		bt1 = new JButton("Left");
		bt2 = new JButton("Center");
		bt3 = new JButton("Right");
		
		north_p.add(bt1);
		north_p.add(bt2);
		north_p.add(bt3);
		
		//버튼 3개를 가지는 north_p를 현재 창의 North 영역에 추가
		this.add(north_p,BorderLayout.NORTH);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료
		
		//이벤트 감지자 등록
		
		bt1.addActionListener(this);//인자는 ActionLisner를 구현한 객체의 주소
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}//생성자의 끝
	
	/*
	public void create() {//이렇게도 가능
		north_p = new JPanel();
		bt1 = new JButton("Left");
		bt2 = new JButton("Center");
		bt3 = new JButton("Right");
		
		north_p.add(bt1);
		north_p.add(bt2);
		north_p.add(bt3);
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 각 버튼을 클릭할 때 마다 수행 하는 곳
		String str= e.getActionCommand();//클릭한 버튼의 문자열을 얻어냄(Left,Center,Light)

		if(str.equalsIgnoreCase("left")) {
			//버튼들을 왼쪽 맞춤 수행
			FlowLayout fl = new FlowLayout(FlowLayout.LEFT);//이렇게하거나 멤버변수로 선언
			//위에서 만든 레이아웃을 다시 north_p에 적용시켜야 함
			north_p.setLayout(fl);
			north_p.updateUI();
		}
		else if(str.equalsIgnoreCase("center")) {
			fl=new FlowLayout(FlowLayout.CENTER);
			//위에서 만든 레이아웃을 다시 north_p에 적용시켜야 함

			north_p.setLayout(fl);
			north_p.updateUI();
		}
		else {
			fl=new FlowLayout(FlowLayout.RIGHT);
			//위에서 만든 레이아웃을 다시 north_p에 적용시켜야 함
			north_p.setLayout(fl);
			north_p.updateUI();
		}
	}

	public static void main(String[] args) {
		// 프로그램 시작
		new Ex2_FlowLayout();

	}

}
