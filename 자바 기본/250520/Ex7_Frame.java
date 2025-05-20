package pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex7_Frame extends JFrame implements ActionListener{

	JPanel north_p,center_p;
	
	JButton bt1,bt2,bt3;
	//JTextArea ta;//중앙에
	
	public Ex7_Frame() {
		
		north_p =new JPanel();
		center_p =new JPanel();
		bt1=new JButton("Red");
		bt2=new JButton("Green");
		bt3=new JButton("Blue");
		
		//ta =new JTextArea();
		
		north_p.add(bt1);
		north_p.add(bt2);
		north_p.add(bt3);
		//버튼 3개를 모두 가지고 있는 north_p를 현재 창 north영역에 추가
		this.add(north_p,BorderLayout.NORTH);
		this.add(center_p);//가운데에 패널 추가
		
		/*JScrollPane jp = new JScrollPane(ta);
		this.add(jp,BorderLayout.CENTER);
		*/
		//setSize(500,400);
		//setLocation(300, 100);
		setBounds(300, 100, 500, 400);//위에 2개를 한번에
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//이벤트 감지자 등록
		bt1.addActionListener(this);//bt1이 이벤트 대상 
		bt2.addActionListener(this);//this가 해당 버튼에서 감지해서 수행하는 객체
		bt3.addActionListener(this);
		
	}
	public static void main(String[] args) {
		//Ex7_Frame f = new Ex7_Frame();
		new Ex7_Frame(); //한번이라도 쓰이면 이렇게 하면 안되지만
						//한번도 안쓰임 변수 쓸 이유가 없음
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 발생 할때마다 수행하는 곳
		//이벤트를 발생시킨 객체를 알아낸다.
		Object obj = e.getSource();
		if(obj==bt1) {
			center_p.setBackground(Color.RED);
		}
		else if(obj==bt2) {
			center_p.setBackground(Color.green);
		}
		else {
			center_p.setBackground(Color.BLUE);
		}
	}

}
