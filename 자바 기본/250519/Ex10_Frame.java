package pm;

import javax.swing.JFrame;//module.info.java 때문에 오류 삭제

public class Ex10_Frame extends JFrame {

	public static void main(String[] args) {
		// 프로그램 시작
		
		//현재 객체 생성
		Ex10_Frame frame = new Ex10_Frame();//생성자 Ex10_Frame 으로 상속받은것들 다 사용
		//조상중에 컴포넌트 프레임 컨테이너 등 다 있음
		frame.setSize(1000, 800);//창크기
		frame.setLocation(500, 150);//창 위치설정
		frame.setVisible(true);//창 보여주기
	}
}