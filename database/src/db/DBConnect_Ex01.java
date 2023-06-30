package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect_Ex01 {

	public static void main(String[] args) throws SQLException {
		//연결 Connection
		//쿼리 PreparedStatement
		Connection conn = null;
		PreparedStatement pstmt = null;

		
		String url = "localhost";
		String port = "3306";
		String dbName = "grp";
		String enc = "charsetEncodeing=UTF-8";
		String timezone = "ServerTimezone=UTC";
		
		String dbURL = "jdbc:mysql://localhost:3306/grp?charsetEncoding=UTF-8&serverTimeZone=UTC";
		String dbUser = "yeonkyeong";
		String dbPwd = "1234";
		
		String delDB = "grp";
		
		try {
			//성공
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
			
			String query = "DROP DATABASE " + delDB;
			
			pstmt = conn.prepareStatement(query);
			//정삭동작을 하면 1 실패 0
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("데이터베이스가 삭제되었습니다.\n확인하세요.");
			}else {
				System.out.println("데이터베이스를 삭제할 수 없습니다.\n관리자에게 문의하세요.");
			}
			
			
			/*
			 * 입력
			
			String query = "INSERT INTO board(subject, writer, content, upload, visit, regdate) VALUES(?, ?, ?, ?, ?, now())";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "공지사항입니다.");
			pstmt.setString(2, "관리자");
			pstmt.setString(3, "내용입니다.");
			pstmt.setString(4, "korea.hwp");
			pstmt.setInt(5, 999);
			pstmt.executeUpdate();
			System.out.println("게시물이 등록되었습니다.");
			
			System.out.println("연결");
			
			*/
			
			//pstmt.executeQuery() : 검색
			//pstmt.executeUpdate() : 저장/수정
			
		}catch(SQLException sqle) {
			//실패
			sqle.printStackTrace();
			System.out.println("Insert 실패");
				
			
		}finally {
			//마지막에 무조건 실행
//			pstmt.close();
			conn.close();
			
		}
				
		

	}

}
