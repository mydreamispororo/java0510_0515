package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect_Ex02 {

	public static void main(String[] args) throws SQLException {
		Connection conn = null; //연결객체
		PreparedStatement pstmt = null; //쿼리 실행 객체
		ResultSet rs = null; //쿼리 결과를 담는 객체
		
		String DB_URL = "jdbc:mysql://localhost:3306/grp?charsetEncoding=UTF-8&serverTimeZone=UTC";
		String DB_USER = "yeonkyeong";
		String DB_PASSWD = "1234";
		
		try {
			//select * from register;
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
			//mysql 만들어 놓은 명령어는 대문자
			String query = "select * from board order by id desc"; //ASC : 오름차순, DESC : 내림차순
			
//			String query = "select * from register order by userid desc"; //ASC : 오름차순, DESC : 내림차순
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery(); //객체(배열)로 저장
			
			while(rs.next()) { //객체 안에 들어 있는 데이터 만큼 반복
				System.out.println("번호 : " + rs.getInt(1) + "\t제목 : " + rs.getString(2) + "\t작성자 : " + rs.getString(3) + "\t내용 : " + rs.getString(4) + "\t등록일 : " + rs.getDate(5));
			}
			
		}catch(SQLException sqle) {
			//SQL 구문
			sqle.getStackTrace();
			
		}finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		

	}

}
