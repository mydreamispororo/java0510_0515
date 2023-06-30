package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect_Ex01 {

	public static void main(String[] args) throws SQLException {
		//java < jdbc > mysql 연결을 해서 연결이 되면 "연결이 되었습니다."
		Connection conn = null;

		String DB_URL = "jdbc:mysql://localhost:3306/grp?charsetEncoding=UTF-8&serverTimeZone=UTC";
		String DB_USER = "yeonkyeong";
		String DB_PASSWD = "1234";

		//드라이버 매니저에 등록
		try {
			//정상적으로 연결 된다면
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
			System.out.println("Mysql Database에 연결되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Mysql Database에 연결할 수 없습니다.\n관리자에게 문의하세요.");
		} finally {
			conn.close();
		}

	}

}
