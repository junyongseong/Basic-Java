package pm;

import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//Ex6_URL
public class Ex6_URL extends JFrame {

	JPanel center_p;//가운데 패널 선언
	JTextField url_tf;//텍스트 필드 선언
	JButton down_bt;//다운로드 버튼 선언
	
	//파일 처리를 위한 스트림 객체들
	BufferedInputStream bis;//인풋
	BufferedOutputStream bos;//아웃풋
	public Ex6_URL() {
		
		center_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		center_p.add(new JLabel("URL : "));
		center_p.add (url_tf=(new JTextField(50)));
		center_p.add(down_bt= new JButton("다운로드"));
		
		this.add(center_p);
		
		this.setBounds(300, 100, 800, 250);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//지금 바로 프로그램 종료
				//나중에 함수로 만들어서 처리할 수 도 있
			}
		
		});
		down_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//다운로드 버튼을 클릭할때만 수행하는곳
				JFileChooser jfc = new JFileChooser("c:/my_study");
				
				//파일명만 얻어내기 위해 url_tf에 있는 문자열을 가져온다.
				String url_path= url_tf.getText().trim();
				
				//가장 뒤에 있는 "/"의 위치값을 알아낸다./
				int idx =url_path.lastIndexOf("/");
				//위에서 얻어낸 마지막 "/"위치값을가지고 파일명만 얻어낸다.
				
				String fnmae= url_path.substring(idx+1);
				
				//추출한 파일명을 파일 선택기에 지정한다.
				jfc.setSelectedFile(new File(fnmae));//인자가 파일
				
				int cmd = jfc.showSaveDialog(Ex6_URL.this);
				if(cmd==JFileChooser.APPROVE_OPTION) {
					//저장버튼을 클릭한 경우에
					//이런 경우에는 사용자가 반드시 파일을 선택한 경우임
					//선택된 파일을 얻어내자.
					File f = jfc.getSelectedFile();
					
					try {
						URL url = new URL(url_path);//웹상의 경로
						//읽기 bis
						// 웹 상에 존재하는 이미지 경로와 연결된 스트림 생성
						bis = new BufferedInputStream(url.openStream());
						
						//쓰기 bos
						//웹상의 이미지를 저장할 파일과 연결하는 스트림 생성
						bos = new BufferedOutputStream(new FileOutputStream(f));
						int size=-1;//읽을게 없을때까지를 의미
						byte[] buf= new byte[4096];
						StringBuffer sb = new StringBuffer();
						
						while((size=bis.read(buf))!=-1) {
							//읽은 자원들은 모두 buf라는 배열에 저장된 상태다.
							//읽기한 수는 size가 기억하므로 buf의 0번지부터 사이즈수만큼
							//쓰기하면 된다.
							bos.write(buf, 0, size);
							bos.flush();
							
						}//while의 끝
						//파일의 끝을 만났을때 여기를 수행함
						JOptionPane.showMessageDialog(Ex6_URL.this, "저장완료");
						
					} catch (Exception e2) {
					}
					
				}
				
			}
		});
	}//생성자의 끝
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex6_URL();

	}

}
