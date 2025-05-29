package am;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.ClosedByInterruptException;
import java.nio.file.ReadOnlyFileSystemException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.*;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex5_Output extends JFrame {

	JTextArea ta;
	
	//메뉴 관련객체들
	JMenuBar bar;
	JMenu file_menu,color_menu;
	JMenuItem new_item,open_item,save_item,exit_item;
	JMenuItem red_item,green_item,blue_item,orangr_item;
	
	//스트림 객체들
	BufferedInputStream bis;//읽기
	BufferedOutputStream bos;//쓰기
	File selectedFile;//선택된 파일
	
	public Ex5_Output() {
		ta = new JTextArea();
		//this.add(ta);//스크롤바가 없음
		this.add(new JScrollPane(ta));//스크롤바 생성 ta
		
		//메뉴 작업
		new_item = new JMenuItem("새파일");
		open_item = new JMenuItem("열기...");
		save_item = new JMenuItem("저장");
		exit_item = new JMenuItem("종료");
		
		
		//서브 메뉴 작업------------------
		red_item = new JMenuItem("빨강");
		green_item = new JMenuItem("초록");
		blue_item = new JMenuItem("파랑");
		
		color_menu = new JMenu("색상");
		color_menu.add(red_item);
		color_menu.add(green_item);
		color_menu.add(blue_item);
	
		//-----------------------------
		file_menu = new JMenu("파일");
		file_menu.add(new_item);
		file_menu.add(open_item);
		file_menu.add(color_menu);//서브메뉴
		
		file_menu.add(save_item);
		file_menu.addSeparator();
		file_menu.add(exit_item);
		
		
		bar= new JMenuBar();
		bar.add(file_menu);
				
		this.setJMenuBar(bar);
		
		this.setBounds(300, 100, 600, 600);
		this.setVisible(true);
		
		//이벤트 감지자
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				//닫기를 위한 메서드 호출
				closed();
			}
		
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 열기를 눌렀을때만 수행하는곳!
				JFileChooser jfc= new JFileChooser("c:/my_study");
				//위아같이 파일 선택기가 생성되어도 화면에는 나타나지 않는다.
				int cmd=jfc.showOpenDialog(Ex5_Output.this);
				
				if(cmd== JFileChooser.APPROVE_OPTION) {
					//사용자가 입력했던.. 선택한 파일을 받아낸다.
					selectedFile =jfc.getSelectedFile();
					
					readFile();//함수화
				}
			}
		});
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//[저장]을 클릭할 때만 수행하는 곳
				//선택된 파일이 null이 아니고 파일이 존재해야 한다.
				if(selectedFile !=null) {
					saveFile();
				}else {
					//선택된 파일이 없는 상황이기 때문에
					//어디에 저장할건지 파일선택기를 보여주면서 사용자로 하여금
					//저장 위치를 지정하도록 해야한다.
					JFileChooser jfc= new JFileChooser("C:/my_study");
					int cmd=jfc.showSaveDialog(Ex5_Output.this);
					
					if(cmd==JFileChooser.APPROVE_OPTION) {
						//[저장]버튼을 클릭했을때
						//사용자가 선택한 파일정보를 얻어내어 selectedFile에 저장
						selectedFile = jfc.getSelectedFile();
						
						//파일이 이미 존재할 경우엔 덮어 쓸건지? 물어본다.
						if(selectedFile.exists()) {
							int select =JOptionPane.showConfirmDialog
							(Ex5_Output.this, "덮어쓰기 하시겠습니까?", "Warning", JOptionPane.YES_NO_OPTION);
							
							if(select == JOptionPane.YES_OPTION)
								System.out.println("덮어쓰기 하자");//확인용
							else {
								selectedFile =null;
								return;
							}
							
						}
						saveFile();
						//selectedFile =null; 원래의 메모장은 다시저장 X
					}
				}
				
			}
		});
	}//생성자의 끝
	public void readFile() {
		//먼저 선택된 파일이 있어야 하고, 파일이 존재해야 한다.
		if(selectedFile !=null&&selectedFile.exists()) {
			//읽기할 스트림 생성
			try {
				bis= new BufferedInputStream(new FileInputStream(selectedFile));
				
				int size=-1;//읽은수를 저장할 변수
				byte[] buf= new byte[4096];
				StringBuffer sb = new StringBuffer();
				
				while((size=bis.read(buf))!=-1) {
					String str = new String(buf,0,size);//배열에 있는 자원들을
					//가져와서 문자열 객체로 생성
					sb.append(str);
				}
				//모든 데이터는 sb에 적재되어있다.
				ta.setText(sb.toString());
				this.setTitle(selectedFile.getAbsolutePath());//제목 설정
				ta.setCaretPosition(0);//화면을 맨 위로 이동!
				//바구니 역활을 해 주는 배열이 필요
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	//파일에 저장하는 함수
	private void saveFile() {
		if(selectedFile !=null) {
		try {
			bos= new BufferedOutputStream(new FileOutputStream(selectedFile));
			//쓰기할 데이터는 JTextArea에 있다. 모두 가져온다.
			String str =ta.getText();
			
			byte[] buf = str.getBytes();//문자열이 바이트타입으로 변환되고 가져옴
			bos.write(buf, 0, buf.length);//buf의 0번지부터 buf의 길이만큼
			bos.flush();
			
			this.setTitle(selectedFile.getAbsolutePath());
			JOptionPane.showMessageDialog(this, "저장완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
	}
	
	public void closed() {
		//각 스트림들 생성여부 확인 후 닫기한다.
		try {
			if(bis !=null)
				bis.close();
			if(bos !=null)
				bos.close();
		} catch (Exception e) {
			
		}
		System.exit(0);//지금 프로그램 종료
	}
	
	public static void main(String[] args) {
		//프로그램 시작
		new Ex5_Output();
	}

}
