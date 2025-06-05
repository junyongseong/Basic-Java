package pm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatJFrame extends javax.swing.JFrame {
   
    CardLayout card;
    
    Socket s;
    ObjectInputStream in;
    ObjectOutputStream out;
    
    // 서버쪽에서 데이터가 넘어오는지 항상 감시하는 스레드
    Thread t = new Thread() {

      @Override
      public void run() {
         bk: while(true) {
            try {
               Object obj = in.readObject();
               if (obj != null) {
                  Protocol p = (Protocol) obj;
                  switch(p.cmd) {
                  case 1: // 어떤 누군가가 접속했을 때 수행
                        // 명단을 받아서 user_list라는 Jlist에 넣어준다
                     user_list.setListData(p.getUser_names());
                     room_list.setListData(p.getRoom_names());
                     break;
                  case 3://접속 종료
                     break bk;
                  case 4:
                     // 내가 방을 만들고 다시 4번 프로토콜을 받는 경우
                     // 명단과 입장 메세지도 같이 받아 화면에 표현한다
                      join_list.setListData(p.getUser_names());
                     card.show(getContentPane(), "chatRoom");

                     ta.append(p.getMsg());
                     break;
                  case 5:
                      user_list.setListData(p.getUser_names());
                      room_list.setListData(p.getRoom_names());

                	  card.show(getContentPane(), "roomList");
                  }
               }
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         try {
            if(in != null)
               in.close();
            if(out != null)
               out.close();
            if(s != null)
               s.close();
            System.exit(0); // 프로그램 종료
         } catch (Exception e) {}
      }
       
    };
    
    // 채팅화면에 필요한 객체
    JPanel card3, card3_e, card3_s;
    JButton out_bt, send_bt;
    JTextArea ta;
    JTextField input_tf;
    JList<String> join_list; // 참여자 명단
    
    public ChatJFrame() {
        initComponents(); // 화면 구성
        setVisible(true);
        
        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() { // 창을 닫을때

         @Override
         public void windowClosing(WindowEvent e) {
            if(s == null) {
            System.exit(0);
            } else {
               Protocol p = new Protocol();
               p.cmd = 3;
               try {
                  out.writeObject(p);
               } catch (IOException e1) {
                  e1.printStackTrace();
               }
            }
         }
      });
        
        jButton5.addActionListener(new ActionListener() { // 종료 버튼을 누를때
           
           @Override
           public void actionPerformed(ActionEvent e) {
              
            Protocol p = new Protocol();
            p.cmd = 3;
            try {
               out.writeObject(p);
               out.flush();
            } catch (IOException e1) {
               e1.printStackTrace();
            }
            
           }
        });
        
        jButton2.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // 방 만들기
            String str = JOptionPane.showInputDialog(ChatJFrame.this, "방 제목을 입력하세요");
            
            if(str != null && str.trim().length() > 0) {
               // 방제목을 1자라도 입력한 경우
               // 방을 만들 수 있는 프로토콜 생성
               Protocol p = new Protocol();
               p.setCmd(4);
               p.setMsg(str); // 방 제목 담기
               
               try {
                  out.writeObject(p);
                  out.flush();
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }
            
         }
      });
        
        jButton3.addActionListener(new ActionListener() {//방참여버튼
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // 먼저 방이름을 가져와야함
        	 
        	 String roomName =room_list.getName();
        	////1: 접속 2: 채팅, 3: 종료 4: 방만들기 5: 방 나가기 6: 방참여
        	 Protocol p= new Protocol();
        	 p.setCmd(6);
        	 p.setMsg(roomName);
        	 
        	 try {
				out.writeObject(p);
				out.flush();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
            
         }
      });
        send_bt.addActionListener(new ActionListener() {//보내기 버튼
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg= input_tf.getText().trim();
				
				if(msg.length()==0)
					JOptionPane.showMessageDialog(ChatJFrame.this,"보낼 메세지를 입력하시오");
				else {
					Protocol p= new Protocol();
					p.setCmd(2);
					p.setMsg(msg);
					
					try {
						out.writeObject(p);
						out.flush();
						input_tf.setText("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
        room_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //room_list에서 더블클릭을 했는지
                //선택된 index값을 얻어내자
                int cnt=e.getClickCount();
                if(cnt==2){
                   join();
                }
            }
        });

        out_bt.addActionListener(new ActionListener() {//방 나가기 버튼
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Protocol p = new Protocol();
				p.setCmd(5);//방나기 5번
				
				try {
                    //서버로 전송--나하고만 연결된
					out.writeObject(p);
					out.flush();
					card.show(getContentPane(), "roomList");//화면 전환
					ta.setText("");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
        
        
        jButton1.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // 로그인 버튼 클릭했을 때 수행하는 곳
            
            // 사용자가 입력한 대화명 가져오기
            String n = jTextField1.getText().trim();
            
            if(n.length() < 1) {
               JOptionPane.showMessageDialog(ChatJFrame.this, "대화명을 입력하세요");
               jTextField1.setText("");
               jTextField1.requestFocus(); // 커서 가져다놓기
               return;
            } else {
               // 서버 접속
               try {
                  s = new Socket("192.168.10.114", 5555);
                  
                  // 소켓으로 연결된 서버와 스트림 연결
                  out = new ObjectOutputStream(s.getOutputStream());
                  in = new ObjectInputStream(s.getInputStream());
                  
                  t.start(); // 입력받을 기능을 하는 스레드 구동
                  
                  card.show(getContentPane(), "roomList");
                  
                  // 접속했다는 사실을 알리는 프로토콜 전송
                  Protocol p = new Protocol();
                  p.setCmd(1);
                  p.setMsg(n);
                  
                  // 서버로 보낸다
                  out.writeObject(p);
                  out.flush();
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }
            
         }
      });
    }
    public void join(){

        int idx= room_list.getSelectedIndex();

        //방 참여를 위한 프로토콜
        Protocol p = new Protocol();
        p.setCmd(6);
        p.index=idx;
        try {
            out.writeObject(p);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        card1 = new JPanel();
        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jPanel3 = new JPanel();
        jButton1 = new JButton();

        card2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        room_list = new JList<>();
        jPanel4 = new JPanel();
        jLabel3 = new JLabel();
        jPanel5 = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jScrollPane2 = new JScrollPane();
        user_list = new JList<>();

        setPreferredSize(new Dimension(390, 490));
        getContentPane().setLayout(card = new CardLayout());
        
        card1.setPreferredSize(new Dimension(390, 490));
        card1.setLayout(new BorderLayout());

        jLabel1.setMaximumSize(new Dimension(390, 490));
        jLabel1.setMinimumSize(new Dimension(390, 490));
        jLabel1.setName(" "); // NOI18N
        ImageIcon icon = new ImageIcon("src/images/chat.png");
       // ImageIcon icon = new ImageIcon("c/my_study/java_study/work/Ex0604/src/images/chat.png");

        Image img = icon.getImage().getScaledInstance(390, 400, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(img);
        jLabel1.setIcon(icon2);
                  

        jLabel1.setPreferredSize(new Dimension(390, 400));
        card1.add(jLabel1, BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(2);
        flowLayout1.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout1);

        jLabel2.setText("대화명 :");
        jPanel2.add(jLabel2);

        jTextField1.setColumns(10);
        jPanel2.add(jTextField1);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(2));

        jButton1.setText("로그인");
        jPanel3.add(jButton1);

        jPanel1.add(jPanel3);

        card1.add(jPanel1, BorderLayout.PAGE_END);

        getContentPane().add(card1, "first");

        //////////////////////////////////////////        
        
        card2.setPreferredSize(new Dimension(423, 100));
        card2.setLayout(new BorderLayout());

        jScrollPane1.setViewportView(room_list);

        card2.add(jScrollPane1, BorderLayout.CENTER);

        jPanel4.setPreferredSize(new Dimension(100, 490));
        jPanel4.setLayout(new BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("[대기실]");
        jPanel4.add(jLabel3, BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.GridLayout(4, 1));

        jButton2.setText("방 만들기");
        jPanel5.add(jButton2);

        jButton3.setText("방 참여");
        jPanel5.add(jButton3);

        jButton4.setText("쪽지 보내기");
        jPanel5.add(jButton4);

        jButton5.setText("종료");
        jPanel5.add(jButton5);

        jPanel4.add(jPanel5, BorderLayout.SOUTH);

        jScrollPane2.setViewportView(user_list);

        jPanel4.add(jScrollPane2, BorderLayout.CENTER);

        card2.add(jPanel4, BorderLayout.EAST);

        getContentPane().add(card2, "roomList");
        
//      card.show(getContentPane(), "roomList");
        
        // 채팅 화면 구성하기----------------------------------------------
        
        card3 = new JPanel(new BorderLayout());
        card3_e = new JPanel(new BorderLayout());
        card3_s = new JPanel(new BorderLayout());
        
        card3.add(new JScrollPane(ta = new JTextArea()));
        ta.setEditable(false);// ta의 영역에 직접 편집 불가능하게 만듬
        
        card3_e.add(new JLabel("[참여자]"), BorderLayout.NORTH);
        card3_e.add(new JScrollPane(join_list = new JList<String>()), BorderLayout.CENTER);
        card3_e.add(out_bt = new JButton("방 나가기"), BorderLayout.SOUTH);
        card3.add(card3_e, BorderLayout.EAST);
        
        card3_s.add(new JScrollPane(input_tf = new JTextField()), BorderLayout.CENTER);
        card3_s.add(send_bt = new JButton("보내기"), BorderLayout.EAST);
        card3.add(card3_s, BorderLayout.SOUTH);
        
        // card3를 현재창에 "chatRoom"이라는 이름으로 추가
        getContentPane().add(card3, "chatRoom");
        
        //-----------------------------------------------------------------
        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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

        new ChatJFrame();
    }

    private JPanel card1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel card2;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField jTextField1;
    private JList<String> room_list;
    private JList<String> user_list;
    // End of variables declaration//GEN-END:variables
}
