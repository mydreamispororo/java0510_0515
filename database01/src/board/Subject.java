package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Subject {
	//필드
	private int bid;
	private String title;
	private String name;
	private String content;
	private String regdate;
	
	
	//캡슐화
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	

	//Connection 연결 객체를 메소드화
	
	public Connection getConnection() {
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/groupware?characterEncoding=UTF-8&ServerTimezone=UTC";
		String uid = "yeonkyeong";
		String upwd = "1234";
		
		try {
			conn = DriverManager.getConnection(url, uid, upwd);
			System.out.println("연결");
			
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("연결 실패");
			
		}
		

		
		return conn;
	}
	
	

}














