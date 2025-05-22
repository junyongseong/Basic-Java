package homework.회사;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmpFrame extends JFrame implements ActionListener {

	JPanel west_p,south_p,p1,p2,p3,p4;//왼쪽(서쪽)에 패널 생성
	JTextField empno_tf,ename_tf,pos_tf,dept_tf;
	JButton total_bt,add_bt,search_bt,del_bt,cancle_bt;//버튼 5개는 south_p에 추가
	JTextArea ta;// 중앙에 생성
	
	final int TOTAL =1;
	final int ADD =2;
	final int SEARCH =3;
	final int DEL =4;
	final int CANCEL =0;
	
	int cmd;//현재 눌려진 버튼값을 저장
	
	public EmpFrame() {
        //FlowLayout f = new FlowLayout(FlowLayout.RIGHT);
		//south_p=new JPanel(f);
		south_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		south_p.add(total_bt=new JButton("전체"));
		south_p.add(add_bt=new JButton("추가"));
		south_p.add(search_bt=new JButton("검색"));
		south_p.add(del_bt=new JButton("삭제"));
		south_p.add(cancle_bt=new JButton("취소"));
		
		//현재창 south영역에 south_p를 추가
		this.add(south_p,BorderLayout.SOUTH);
		
		west_p =new JPanel(new GridLayout(6,1));
		west_p.add(new JLabel());//공백
		//두번째 셀에는 사번:______- 가 들어있는 p1을 만들어야 한다.
		p1=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(new JLabel("사번"));
		p1.add(empno_tf=new JTextField(8));
		west_p.add(p1);
		//세번째 셀에는 이름:______- 가 들어있는 p2을 만들어야 한다.
		p2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(new JLabel("이름"));
		p2.add(ename_tf=new JTextField(8));
		west_p.add(p2);
		
		//네번째 셀에는 직책:______- 가 들어있는 p3을 만들어야 한다.
		p3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(new JLabel("직책"));
		p3.add(pos_tf=new JTextField(8));
		west_p.add(p3);	
		
		//다섯번째 셀에는 직책:______- 가 들어있는 p4을 만들어야 한다.
		p4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4.add(new JLabel("부서임여"));
		p4.add(dept_tf=new JTextField(8));
		west_p.add(p4);		
		
		this.add(west_p,BorderLayout.WEST);
		this.add(new JScrollPane(ta= new JTextArea()));//가운데 추가
		
		setBounds(300, 100, 400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //이벤트 감지자 등록
        total_bt.addActionListener(this);
        add_bt.addActionListener(this);
        search_bt.addActionListener(this);
        del_bt.addActionListener(this);
        cancle_bt.addActionListener(this);
	}
	
	public void setButton() {
		total_bt.setEnabled(false);
		add_bt.setEnabled(false);
		search_bt.setEnabled(false);
		del_bt.setEnabled(false);
		
		switch(cmd) {
			case ADD://추가
				add_bt.setEnabled(true);
				break;
			case SEARCH://검색
				search_bt.setEnabled(true);
				break;
			case DEL://삭제
				del_bt.setEnabled(true);
				break;
			case CANCEL://취소
				total_bt.setEnabled(true);
				add_bt.setEnabled(true);
				search_bt.setEnabled(true);
				del_bt.setEnabled(true);
		}
	}
	public void viewData() {
		cmd=0;
		//데이터들 불러서 ta에 표현했다
		setButton();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 각 버튼을 클릭할 때 수행하는곳
		Object obj=e.getSource();
		if(obj==total_bt) {
			
		}//건들필요 없음
		else if(obj==add_bt) {
			if(cmd==ADD) 
				viewData();
			else {
				cmd=ADD;
				setButton();
				}
		}
		else if(obj==search_bt) {
			if(cmd==SEARCH) 
				viewData();
			else 
				{cmd=SEARCH;
				setButton();
				}
		}
		else if(obj==del_bt) {
			if(cmd==DEL) 
				viewData();
			else 
				{cmd=DEL;
				setButton();
				}
		}
		else {
			cmd=CANCEL;
			setButton();

		}

	}

	public static void main(String[] args) {

		new EmpFrame();
	}

}
