package pm;

import java.io.Serializable;

public class Ex3_Protocol implements Serializable {

	int cmd;//1: 접속, 2: 채팅 3:종료
	String msg;//채팅 메세지
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
