package am;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex1_GuguDan extends JFrame implements ActionListener{

	//현재창에서 필요한 객체들을 모두 멤버로 선언
	JPanel north_p;
	JButton[] bt_ar;
	JTextArea ta;
	
	public Ex1_GuguDan() {
		//화면 모양-- 창틀(JFrame)은 기본 레이아웃이 borderLayout이다.
		north_p = new JPanel();//패널의 기본레이아웃이 flowLyout(추가하는 순서대로)이다. 
		bt_ar=new JButton[8];
		for(int i=0; i<bt_ar.length;i++) {
			//bt_ar[i] = new JButton(i+2)//오류나는 이유는 i+2는 숫자 즉 문자열이 아니라서 오류
			String v1 =String.valueOf(i+2);// 이렇게 stringvalueOf사용
			bt_ar[i] = new JButton(v1);// 이렇게 stringvalueOf사용
			
			north_p.add(bt_ar[i]);
			
			//생성된 버튼객체 각각에 이벤트 감지자 등록
			bt_ar[i].addActionListener(this);
			//현재 객체가 ActionListner를 구현하고 있기 때문에 this 로 넣어줌
			
			
		}//for 의 끝
		//현재창 north 영역에 north_p
		this.add(north_p,BorderLayout.NORTH);
		
		//현재창 가운데에 ta를 추가한다. 이때 스크롤도 적용
		//this.add(ta)가 아니라 스크롤 적용하면서 넣어버림
		JScrollPane jp= new JScrollPane(ta=new JTextArea());
		this.add(jp);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex1_GuguDan();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// 각 버튼을 클릭할때 마다 수행하는 곳
		//현재 이벤트를 발생시킨 객체의 문자열을 얻어낸다.
		String str= e.getActionCommand();
		int dan =Integer.parseInt(str);//정수형으로 바꾸는거
		
		StringBuffer sb=new StringBuffer(str);
		sb.append("단\r\n");
		sb.append("===============\r\n");
		
		Formatter fm=new Formatter(sb);
		for(int i=1;i<10;i++) {
			fm.format("%d X %d = %d\r\n",dan,i,dan*i);
		}
		ta.setText(sb.toString());
		
		/*
		for(int i=1;i<10;i++) {
			sb.append(str);//dan
			sb.append("X");
			sb.append(i);//문자열로 변환
			sb.append("=");
			sb.append(dan*i);
			sb.append("\r\n");
		}*/
		/*
		ta.setText(str);//삭제
		ta.append("단\r\n");
		ta.append("====================\r\n");
		for(int i=1;i<10;i++ ) {
			ta.append(str);//dan
			ta.append("X");
			ta.append(String.valueOf(i));//문자열로 변환
			ta.append("=");
			ta.append(String.valueOf(dan*i));
			ta.append("\r\n");
			
			
		}*/
		
	}

}
