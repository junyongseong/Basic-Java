package pm;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Ex6_Frame extends JFrame {

	JTable table;//1차원 배열 2차원 배열 필요
	//JTable에 필요한 컬럼명
	String[] c_name= {"사번","이름","직책","입사일","부서코드"};
	
	Object[][] data;//선언
	
	ArrayList<Ex6_Emp> e_list = new ArrayList<Ex6_Emp>();//add를 누를때 
	
	JMenuBar bar;
	JMenu file_menu;
	JMenuItem new_item,add_item,open_item,save_item,exit_item;
	
	//파일로부터 자원을 읽기하기 위한 스트림
	ObjectInputStream ois;//br
	ObjectOutputStream oos;//pw
	File selectedFile;
	
	String path;
	File f;
	
	public Ex6_Frame() {
		path="c:/my_study/test/abc.txt";//일단 경로지정
		f= new File(path);
		//화면 가운데에 ta를 생성하여 스크롤바에 추가하여 넣는다.
		this.add(new JScrollPane(table=new JTable(new DefaultTableModel(null,c_name))));
		
		//메뉴 작업
		new_item = new JMenuItem("새파일");
		add_item = new JMenuItem("추가");
		open_item = new JMenuItem("열기",new ImageIcon("src/images/folder.png"));
		save_item = new JMenuItem("저장",new ImageIcon("src/images/save.png"));
		exit_item = new JMenuItem("종료");
		
		file_menu = new JMenu("파일");
		//생성된 파일메뉴에 메뉴아이템들 추가
		file_menu.add(new_item);
		file_menu.add(add_item);
		file_menu.add(open_item);
		file_menu.add(save_item);
		file_menu.addSeparator();
		file_menu.add(exit_item);
		
		
		path="c:/my_study/test/abc.txt";
		//메뉴바 생성
		bar= new JMenuBar();
		
		//메뉴바에 메뉴 추가
		bar.add(file_menu);
		
		//현재 창에 메뉴바 설정
		this.setJMenuBar(bar);
		
		setBounds(300, 100, 500, 400);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				closed();//닫는 함수
			}
			
		});
		//종료버튼 누를때
		exit_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		add_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 
				Ex6_AddDialog add= new Ex6_AddDialog(Ex6_Frame.this);
				
			}
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 열기라는 메뉴아이템을 선택했을 때만 수행
				selectedFile = new File("c:/my_study/test/abc.txt");
				//JFileChooser jfc = new JFileChooser("c:/my_study/test");
				//int cmd = jfc.showOpenDialog(Ex6_Frame.this);//파일 선택기
				//사용자가 열기를 선택했다면 cmd에는 JFileChooser.APPROVE_OPTION인
				//0값이 저장된다.
				//if(cmd==JFileChooser.APPROVE_OPTION) {
					//선택된 파일을 얻어내어 멤버변수인 selectedFile에 저장
					//selectedFile = jfc.getSelectedFile();
					
					//readFile();
				//}
				if(selectedFile.exists()) {
					readFile();
				}
			}
		});
		
		save_item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedFile ==null) {
					JFileChooser jfc= new JFileChooser("c:/my_study/test");
					int cmd= jfc.showSaveDialog(Ex6_Frame.this);
					
					if(cmd==JFileChooser.APPROVE_OPTION) {
						//선택된 파일에 넣어야함
						selectedFile = jfc.getSelectedFile();
						
						//저장하겠다고 선택한 파일이 이미 존재한다면...
						if(selectedFile.exists()) {
							int select = JOptionPane.showConfirmDialog(
									Ex6_Frame.this, "덮어 쓰시겠습니까?","Warning",
									JOptionPane.YES_NO_OPTION);
							if(select !=JOptionPane.YES_OPTION) {
								selectedFile =null;//이걸 안해버리면 저장해버림
											//파일이 이미선택되었기때문임 그러니 초기화해줘야함
								return;
							}
						}
					}else {
						selectedFile =null;
						return;
					}
				}//제일 바깥쪽 if문
				//파일을 열었거나 저장을 한번이라도 한 경우 또는
				//저장하라고 파일이 존재하지 않거나,
				//존재해도 파일을 덮어쓰기에 승인한 경우
				saveFile();
			}
		});
		
	}//생성자의 끝
	
	//저장을 누르면 abc.txt에 저장 경로 c:/my_study/abc.txt
	private void saveFile() {
		
		String path="c:/my_study/test/abc.txt";
		File f= new File(path);
		ObjectOutputStream oos= null;
		try {
			oos= new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(e_list);//리스트에 넣어주고
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();// 오류 발생시 나오게
		}finally {
			try {
				if(oos!=null)
					oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		//clsoed()

	}
	//파일을 열면
	private void readFile() {
		ois= null;
		//String path="c:/my_study/test/abc.txt";//경로 지정
		//File f= new File(path);
		try {
			ois = new ObjectInputStream(new FileInputStream(selectedFile));
			e_list= (ArrayList<Ex6_Emp>) ois.readObject();
			viewTable();
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "오류가남");
		}finally {
			try {
				if(ois!=null)
					ois.close();//닫기
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	private void closed() {
		//사용되는 스트림이 있다면 먼저 닫아야한다.
		
		try {
			if(ois != null)
				ois.close();//스트림 닫기
			if(oos!=null)
				oos.close();//oos도 닫아줘야함
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.exit(0);
	}
	
	public void addData(String empno,String ename,//Ex6_addDialog에서 호출
			String pos,String hdate,String deprno) {
		Ex6_Emp emp= new Ex6_Emp(empno, ename, pos, hdate, deprno);
		e_list.add(emp);//멤버 변수인 e_list라는 Arraylist에 저장
		viewTable();
	}
	public void viewTable() {//위 addData에서 호출
		//멤버변수인 e_list를 가지고 2차원 배열을 만든다. 
		data=new Object[e_list.size()][c_name.length];//행 열
		
		for(int i=0; i<e_list.size();i++) {
			//ArrayList에서 저장된 요소 가져오기
			Ex6_Emp emp= e_list.get(i);
			data[i][0]=emp.getEmpno();//사번
			data[i][1]=emp.getEname();//이름
			data[i][2]=emp.getPos();//직책
			data[i][3]=emp.getHire_date();//입사일
			data[i][4]=emp.getDeptno();//부서코드
		}
		//위에 반복문으로 테이블에 사용할 모델자원이 준비 됐음
		//모델 객체 생성한 후 그것을 테이블에 적용하면 된다.
		table.setModel(new DefaultTableModel(data, c_name));
	}
	public static void main(String[] args) {
		// 프로그램 시작
		
		new Ex6_Frame();

	}

}
