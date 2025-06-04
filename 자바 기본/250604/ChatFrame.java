package pm;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ChatFrame extends javax.swing.JFrame {

    CardLayout card;
    Socket s;
    ObjectInputStream in;//객체를 주고받기위해 선언
    ObjectOutputStream out;
    
    //서버쪽에서 데이터가 넘어오는지 항상 감시하는 스레드
    Thread t= new Thread() {

		@Override
		public void run() {
			
			bk:while(true) {
				try {
					Object obj= in.readObject();//서버로부터 데이터가 올 때까지 
												//대기한다.
					Protocol p= (Protocol) obj;
					
					switch(p.getCmd()) {
						case 1://어떤 누군가가 접속했을 때 수행
							//명단을 받아서 user_list라는 JList에 넣어준다.
							user_list.setListData(p.getUser_names());
							break;
						
					}//Switch의 끝
				} catch (Exception e) {
					
				}
			}//무한반복문 While의 끝
		}
    };
    
    public ChatFrame() {
        initComponents(); //화면 구성
        setVisible(true); // 화면 보여주기 
        //t.start();//스레드 시작여기서 하면 안됨 로그인 버튼 눌렀을때
        this.addWindowListener(new WindowAdapter() {

         @Override
         public void windowClosing(WindowEvent e) {
        	 Protocol p = new Protocol();
        	 try {
        	        p.setCmd(3);
        	        out.writeObject(p);//다시씀
        	        out.flush();
        	    } catch (Exception ex) {
        	        ex.printStackTrace();
        	    } finally {
        	        System.exit(0);
        	    }
         }
        }); 
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인 버튼을 눌렀을때 수행하는 곳!
				//사용자가 입력한 대화명 가져오기
				String n = jTextField1.getText().trim();
				
				if(n.length()<1) {
					JOptionPane.showMessageDialog(ChatFrame.this, "대화명을 입력하세요");
					jTextField1.setText("");//청소
					jTextField1.requestFocus();//커서 가져다 놓기
					
					return;
				}else {//입력을 제대로 했을때 서버 접속
					try {
						s= new Socket("192.168.10.114",5555);
						out = new ObjectOutputStream(s.getOutputStream());
						in = new ObjectInputStream(s.getInputStream());
						t.start();//스레드 시작
						
						card.show(getContentPane(), "roomList");
						
						//처음 접속했다는 의미로 프로토콜 데이터를 보내야함
						Protocol p= new Protocol();
						p.setCmd(1);
						p.setMsg(n);//대화명
						
						//서버로 보낸다.
						out.writeObject(p);
						out.flush();
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
			
		});
        //종료버튼을 눌렀을때
        jButton5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Protocol p = new Protocol();
				try {
        	        p.setCmd(3);
        	        out.writeObject(p);
        	        out.flush();
        	    } catch (Exception ex) {
        	        ex.printStackTrace();
        	    } finally {
        	        System.exit(0);
        	    }
				
			}
		});
    }//생성자의 끝
    
    @SuppressWarnings("unchecked")

    private void initComponents() {

        card1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        card2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        room_list = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        user_list = new javax.swing.JList<>();

        setPreferredSize(new java.awt.Dimension(390, 490));
        getContentPane().setLayout(card = new java.awt.CardLayout());

        card1.setPreferredSize(new java.awt.Dimension(390, 490));
        card1.setLayout(new java.awt.BorderLayout());

        jLabel1.setMaximumSize(new java.awt.Dimension(390, 490));
        jLabel1.setMinimumSize(new java.awt.Dimension(390, 490));
        jLabel1.setName(" "); // NOI18N
        ImageIcon icon = new ImageIcon("src/images/chat.png");
        Image img = icon.getImage().getScaledInstance(390, 400, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(img);
        jLabel1.setIcon(icon2);
        jLabel1.setIcon(icon2);
        jLabel1.setPreferredSize(new java.awt.Dimension(390, 490));
        card1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel2.setLayout(new java.awt.FlowLayout(2));

        jLabel2.setText("대화명:");
        jPanel2.add(jLabel2);

        jTextField1.setColumns(10);
        jPanel2.add(jTextField1);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(2));

        jButton1.setText("로그인");
        jPanel3.add(jButton1);

        jPanel1.add(jPanel3);

        card1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(card1, "first");

        card2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(room_list);

        card2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(100, 490));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("[대기실]");
        jLabel3.setToolTipText("");
        jPanel4.add(jLabel3, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.GridLayout(4, 1));

        jButton2.setText("방만들기");
        jPanel5.add(jButton2);

        jButton3.setText("방 참여");
        jPanel5.add(jButton3);

        jButton4.setText("쪽지보내기");
        jPanel5.add(jButton4);

        jButton5.setText("종료");
        jPanel5.add(jButton5);

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jScrollPane2.setViewportView(user_list);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        card2.add(jPanel4, java.awt.BorderLayout.LINE_END);

        getContentPane().add(card2, "roomList");
        
        //card.show(getContentPane(), "roomList");//2번째 화면
        pack();
    }

   
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
        
       new ChatFrame();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<String> room_list;
    private javax.swing.JList<String> user_list;
    // End of variables declaration//GEN-END:variables
}
