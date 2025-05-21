package am;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex4_CardLayout extends JFrame implements ActionListener {

	//화면에 쓰일 카드 ,멤버변수들
	JPanel card1,card2;
	ImageIcon icon1,icon2;
	JButton bt1,bt2;
	CardLayout cl;
	
	public Ex4_CardLayout() {
		//첫번째 화면 
		card1=new JPanel();
		JLabel lb =new JLabel("첫번째 화면");
		//레이블을 카드 1에 추가
		card1.add(lb);
		icon1 =new ImageIcon("src/images/1.gif");
		JLabel lb2=new JLabel(icon1);
		card1.add(lb2);
		bt1 =new JButton("다음");
		card1.add(bt1);
		
		//두번째 화면 
		card2=new JPanel();
		JLabel lb3 =new JLabel("두번째 화면");
		//레이블을 카드 2에 추가
		card2.add(lb3);		
		icon2 =new ImageIcon("src/images/2.gif");
		JLabel lb4=new JLabel(icon2);
		card2.add(lb4);	
		bt2 =new JButton("이전");
		card2.add(bt2);
		
		//현재 창의 레이아웃을 카드 레이아웃으로 변경한다.
		cl = new CardLayout();
		//현재 레이아웃을 카드 레이아웃으로 바꿈
		this.getContentPane().setLayout(cl);
		
		//현재 창 안에 각 카드를 등록한다.
		this.getContentPane().add("card1", card1);//카드 1이라는 이름으로 card1추가
		this.getContentPane().add("card2", card2);//카드 2이라는 이름으로 card2추가
		
		cl.show(this.getContentPane(),"card1");//카드 1화면
		
		setTitle("로또 생성기");
		setBounds(300,100,500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}
	
	public static void main(String[] args) {
		//프로그램 시작
		new Ex4_CardLayout();
	}

	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//마우스 버튼을 누를때마다 수행하는곳!
		Object obj=e.getSource();//이벤트를 발생시킨 버튼 객체를 가져온다.
			
		if(obj==bt1) {
			//카드를 두번째 카드로 변경한다.
			cl.show(this.getContentPane(), "card2");
		}
		else if(obj==bt2) {
			//카드를 첫번째로 변경한다.
			cl.show(this.getContentPane(), "card1");
		}
	}

}
