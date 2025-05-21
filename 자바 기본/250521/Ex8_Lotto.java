package pm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex8_Lotto extends JFrame implements ActionListener{

	JPanel north_p;//북쪽에 생성
	JPanel card1;//카드 1개
	ImageIcon icon1;
	JButton bt_start;//로또 번호 생성버튼
	CardLayout cl;
	FlowLayout flow;//flow 만들어놓고

	public Ex8_Lotto() {
		flow =new FlowLayout(FlowLayout.RIGHT);//오른쪽에
		north_p = new JPanel(flow);//패널 만들기
		bt_start = new JButton("번호 생성");//번호 생성 버튼 만들기
		north_p.add(bt_start);//north_p에 버튼 생성
		
		this.add(north_p,BorderLayout.NORTH);//north_p 패널을 북쪽에 생성
		
		//처음 화면
		card1=new JPanel();
		JLabel lb =new JLabel("로또 자동 생성");
		card1.add(lb);
		//icon1 =new ImageIcon("src/images/1.gif");
		bt_start =new JButton("번호 생성");
		card1.add(bt_start);
		
		//일단 하나 출력해보기
		cl = new CardLayout();
		this.getContentPane().setLayout(cl);
		this.getContentPane().add("card1", card1);
		cl.show(this.getContentPane(),"card1");//카드 1화면
		
		setTitle("로또 생성");
		setBounds(300,100,1000,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    bt_start.addActionListener(this);//감지자

	}
	
	
	public static void main(String[] args) {
		new Ex8_Lotto();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 로또 생성을 클릭했을때 사진 6개가 나오게 만들어야함
		Object obj=e.getSource();
		Random r= new Random();//랜덤 객체 r생성
		int[] lotto =new int[6];
		//int random =(int)(Math.random()*45+1);//랜덤 변수 생성 이걸 6개?
		int num;
		
		
		if(obj==bt_start) {//만약 로또생성 버튼을 눌렀을때
			for(int i=0;i<6;i++) {
				lotto[i]=r.nextInt(45)+1;
				num=lotto[i];
				icon1 = new ImageIcon("src/images/"+num+".gif");
				//icon1 = new ImageIcon("src/images/num.gif");
			}
			cl.show(this.getContentPane(),"card1");
		}
	}
}
