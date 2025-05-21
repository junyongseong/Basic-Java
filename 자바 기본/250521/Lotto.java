package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lotto extends JFrame implements ActionListener{

	JPanel north_p,center_p;
	JLabel[] ar = new JLabel[6];
	TreeSet<Integer> ts;
	JButton num_bt;
	FlowLayout flow;
	GridLayout grid;
	
	public Lotto() {
		ts = new TreeSet<>();//treeset 초기화
		
		
		flow = new FlowLayout(FlowLayout.RIGHT);
		north_p =new JPanel(flow);
		north_p.add(num_bt=new JButton("번호 생성"));
		this.add(north_p,BorderLayout.NORTH);
		
		grid = new GridLayout(1,6);//1행 6열
		center_p = new JPanel(grid);
		this.add(center_p);
		
		setBounds(300,100,750,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//이벤트 감지자 등록
		num_bt.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 번호 생성 버튼을 클릭할때마다 수행하는 곳
		//set구조 생성해서 난수 6개를 가져야 한다.
		
		center_p.removeAll();//JPanel청소
		ts.clear();//삭제
		
		while(true) {
			int su=(int)(Math.random()*45+1);
			ts.add(su);
			if(ts.size()==6)//사이즈가 6 무한반복 탈출
				break;
		}//무한반복의 끝
		
		//ts에 이있는 요소들을 하나씩 얻어내어 imageicon으로 만들어내야함
		Iterator<Integer> it =ts.iterator();//6개
		int i=0;
		while(it.hasNext()) {
			int n=it.next();//숫자 하나 얻기
			StringBuffer sb= new StringBuffer("src/images/");
			sb.append(n);
			sb.append(".gif");
			//ImageIcon icon = new ImageIcon("src/images/"+n+".gif");
			ImageIcon icon = new ImageIcon(sb.toString());
			
			//JLabel배열에 icon을 넣어서 Jlabel을 생성한다.
			ar[i] = new JLabel(icon);
			//System.out.println(n);
			//center_p에 JLabel을 추가
			center_p.add(ar[i]);
			i++;
		}
		center_p.updateUI();//새로고침
	}
	
	public static void main(String[] args) {
		new Lotto();

	}
}


