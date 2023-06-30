package employee2.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	//데이터베이스 연결 객체를 하나만 만들어서 공유해서 사용
	//static => 클래스명.메소드명() - new 사용 x
	static Connection conn = null;
	
	
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/emp";
			String userID = "yeonkyeong";
			String userPWD = "1234";
			
			conn = DriverManager.getConnection(url, userID, userPWD);
			System.out.println("연결 성공~!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
	
	
	
}

