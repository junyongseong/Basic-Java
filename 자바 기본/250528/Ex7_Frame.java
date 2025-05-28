package pm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex7_Frame extends JFrame {

	JTextArea ta;
	JMenuBar bar;//메뉴바
	JMenu f_menu;//메뉴
	JMenuItem new_item,open_item,save_item,exit_item;//메뉴 아이템
	
	//파일 처리를 위한 객체들
	File f;
	BufferedInputStream bis;
	FileInputStream fis;
	
	public Ex7_Frame() {
		
		this.add(new JScrollPane(ta=new JTextArea()));//jscroolpane안에 ta선언후 생성
		
		//메뉴 작업 -JMenuItem -->JMenu-->JMenuBar
		new_item = new JMenuItem("새파일");
		open_item = new JMenuItem("열기...");
		save_item = new JMenuItem("저장...");
		exit_item = new JMenuItem("종료");
		
		f_menu = new JMenu("파일");
		//앞서 생성된 JMenuItem들을 Jmenu에 추가한다.
		f_menu.add(new_item);
		f_menu.add(open_item);
		f_menu.add(save_item);
		f_menu.addSeparator();//구분선
		f_menu.add(exit_item);
		
		bar = new JMenuBar();
		bar.add(f_menu);//JMenuBer에 파일메뉴를 추가
		
		
		
		//JmenuBar를 현재 창에 추가해야한다.
		
		this.add(bar,BorderLayout.NORTH);
		
		setBounds(300, 200, 600, 550);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				
				//종료하기전에 해야할 일이 있으면 이 쯤에서 해야함
				System.exit(0);
			}
			
		});
		exit_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//종료하기 전에 해야 할 일이 있다면 이쯤에서 해야한다.
				System.exit(0);//프로그램 종료
			}
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//파일 선택기를 만든다.
				JFileChooser jfc= new JFileChooser("c:/my_study/java_study");
				int cmd = jfc.showOpenDialog(Ex7_Frame.this);
				if(cmd==JFileChooser.APPROVE_OPTION) {
					//사용자가 긍정적인 승인을 했을때만 수행
					//APPROVE_OPTION 이면 사용자가 파일을 선택한 경우
					
					f = jfc.getSelectedFile();
					//위에서 받은 파일을 가지고 존재여부 확인
					if(f.exists()) {
						//스트림과 f를 연동
						try {
							fis = new FileInputStream(f);
							bis = new BufferedInputStream(fis);//부모
							
							int size=-1;
							
							//size와 byte배열 선언
							byte[] buf= new byte[1024*4];//4kb
							//반복문 처리하면서 byte 배열에 있는 자원을 가지고 문자열생성
							while((size=bis.read(buf))!=-1) {
								String str =new String(buf, 0, size);
								
								//System.out.println(str); //출력 확인용
								//ta.add(str); //add가 아니라 append사용
								
								//생성된 문자열을 ta에 추가.
								ta.append(str);
							}
						} catch (Exception e2) {
							e2.printStackTrace();
						}finally {
							try {
								fis.close();
								bis.close();
							} catch (Exception e3) {
								
							}
						}
					}
				}
			}
		});
	}
	
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex7_Frame();

	}

}
