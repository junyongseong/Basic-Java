package pm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex5_Chat extends JFrame implements ActionListener{
	
	ImageIcon icon;
	JLabel icon_lb;
	JPanel chat1_p1,chat2_p2;//p1처음 화면p2 두번째 화면
	JPanel p1_south_p,s_p1,s_p2,p2_south_p;
	JTextField name_tf,input_tf;
	JButton login_bt,send_bt;
	JTextArea ta;
	
	CardLayout card;
	
	//서버 접속에 필요한 객체들
	Socket s;
	ObjectInputStream in;
	ObjectOutputStream out;
	
	//서버로부터 전달되어오는 프로토콜을 받는 스레드
	Thread t= new Thread() {

		@Override
		public void run() {
			// 항상 in.readObject를 수행해야한다.
			bk:while(true) {
				try {
					Object obj= in.readObject();
					if(obj!=null) {
						Ex3_Protocol protocol= (Ex3_Protocol) obj;
						switch(protocol.cmd) {
						case 2:
							ta.append(protocol.getMsg());
							ta.append("\r\n");
							break;
						case 3://종료
							break bk;
							
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//무한반복
			try {
				if(in!=null)
					in.close();
				if(out!=null)
					out.close();
				if(s!=null)
					s.close();
				
				System.exit(0);//프로그램 종료
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	};
	
	public Ex5_Chat() {
		//현재 창의 레이아웃을 cardLayout으로 지정
		card = new CardLayout();
		this.getContentPane().setLayout(card);
		
		//첫번째 화면작업
		chat1_p1 =new JPanel(new BorderLayout());
		//icon =new ImageIcon("src/images/2.png");
		ImageIcon originalIcon = new ImageIcon("src/images/2.png");
		Image scaledImage = originalIcon.getImage().getScaledInstance(
				300, 300, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		icon_lb= new JLabel(icon);
		chat1_p1.add(icon_lb);//첫번째 화면 가운데에 이미지 표현
		
		
		s_p1=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		s_p2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		s_p1.add(new JLabel("대화명 : "));
		s_p1.add(name_tf = new JTextField(10));
		s_p2.add(login_bt=new JButton("   로그인   "));
		
		p1_south_p = new JPanel(new GridLayout(2,1));
		p1_south_p.add(s_p1);
		p1_south_p.add(s_p2);
		
		chat1_p1.add(p1_south_p,BorderLayout.SOUTH);
		
		this.getContentPane().add("chat1",chat1_p1);
		
		//두번째 화면작업
		chat2_p2 =new JPanel(new BorderLayout());
		chat2_p2.add(new JScrollPane(ta= new JTextArea()));
		p2_south_p = new JPanel(new BorderLayout());
		p2_south_p.add(input_tf = new JTextField());
		p2_south_p.add(send_bt = new JButton("보내기"),BorderLayout.EAST);
		chat2_p2.add(p2_south_p,BorderLayout.SOUTH);
			
		this.getContentPane().add("chat2",chat2_p2);

		//card.show(this.getContentPane(), "chat1");
				
				
		setBounds(300,100,400,500);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				//접속이 안되었다면 프로그램 종료
				if(s==null)
					System.exit(0);
				else {
					//프로토콜 생성 cmd에 3저장 후 서버로 프로토콜 전송
					Ex3_Protocol p= new Ex3_Protocol();
					p.cmd=3;
					try {
						out.writeObject(p);//접속해제를 위한 프로토콜 보내기
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		login_bt.addActionListener(this);
		send_bt.addActionListener(this);//보내기 버튼
	}

	public static void main(String[] args) {
		new Ex5_Chat();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==login_bt) {
			//로그인 버튼을 클릭했을 때
			
			//사용자가 입력한 대화명 가져오기
			String n= name_tf.getText().trim();
			if(n.length()>0) {
				try {
					//접속!!!
					s= new Socket("192.168.10.107",5555);
					
					//나의 복사본이 server에 숨어 들었다.
					//복사본과 통신하기 위해 스트림 생성
					out = new ObjectOutputStream(s.getOutputStream());
					in = new ObjectInputStream(s.getInputStream());
					
					//in을 계속 계속 read하는 스레드 구동시켜야 한다.
					Ex3_Protocol p = new Ex3_Protocol();
					p.cmd= 1;
					p.msg= n;//대화명
					out.writeObject(p);//서버로 보내기
					//대화명을 1자라도 입력한 경우 화면 변경
					card.show(this.getContentPane(), "chat2");
					t.start();//스레드 시작
				}catch(Exception ex) {
					ex.getStackTrace();
				}
			}
			else
				JOptionPane.showMessageDialog(this, "대화명을 입력하세요");
		}
		else if(obj == send_bt) {//보내기 버튼을 눌렀을때
		    String chatmsg = input_tf.getText().trim();
		    if(chatmsg.length() > 0) {
		    	
		        Ex3_Protocol p = new Ex3_Protocol();
		        
		        p.cmd=2;
		        p.msg=chatmsg;
		        try {
		            out.writeObject(p);
		            out.flush();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        input_tf.setText(""); // 입력창 지우기
		    }
		}
	}
}