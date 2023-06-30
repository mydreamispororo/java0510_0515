package employee2.model;

public class Employee {
	//아이디, 비번, 이름, 시간, 주소
	private String userid;
	private String passwd;
	private String username;
	private String regdate;
	private String addr;
	
	public Employee() {	}

	public Employee(String userid, String passwd, String username, String regdate, String addr) {
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.regdate = regdate;
		this.addr = addr;
	}
	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	//public void disp() {아이디 : 000 \t비밀번호 : 0000}
	//public String showMember() {}
	@Override
	public String toString() {
		return "Employee [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", regdate=" + regdate
				+ ", addr=" + addr + "]";
	}
	
	
	
	
	
	
	
	
}







