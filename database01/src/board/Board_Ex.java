package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Board_Ex {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		
		Subject b = new Subject();
		conn = b.getConnection();
		
		
		//등록 목록 삭제 수정 종료
		Scanner sc = new Scanner(System.in);
		boolean isFlag = true;
		while(isFlag) {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("1.게시물 등록   2.게시물목록   3.게시물삭제   4.게시물수정   5.종료 ");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			
			System.out.print("선택 > ");
			int menu = Integer.parseInt(sc.nextLine()); //띄어쓰기 글자 입력 가능하게
			System.out.println();
			
			switch(menu) {
			case 1:
				System.out.println();
				System.out.println("#############################################");
				System.out.println("               게시물을 등록합니다.               ");
				System.out.println("#############################################");
				System.out.println();
				
				System.out.print("제목 > ");
				String sub = sc.nextLine();
				
				System.out.print("작성자 > ");
				String wri = sc.nextLine();
				
				System.out.print("내용 > ");
				String con = sc.nextLine();
				
				/*-----------------------------------------*/
				/* Scanner 정보를 객체로 받아서 저장하기(setter) */
				/*-----------------------------------------*/
				
				b.setTitle(sub);
				b.setName(wri);
				b.setContent(con);
				
				String query = "INSERT INTO board(title, name, content, regdate) VALUES(?, ?, ?, now())";
				
				try {
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, b.getTitle());
					pstmt.setString(2, b.getName());
					pstmt.setString(3, b.getContent());
					int result = pstmt.executeUpdate();
					
					if(result > 0) {
						System.out.println("게시물이 등록되었습니다.");
					}else {
						System.out.println("게시물을 등록할 수 없습니다.\n관리자에게 문의하세요.");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("데이터베이스를 사용할 수 없습니다.");
				}
				
				System.out.println();
				
				break;
				
			case 2:
				System.out.println();
				System.out.println("#############################################");
				System.out.println("             게시물 목록을 보여줍니다.             ");
				System.out.println("#############################################");
				System.out.println();
				String sql = "SELECT * FROM board ORDER BY bid desc";
				
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
						while(rs.next()) {
							System.out.println("번호 : " + rs.getInt(1) + "\t제목 : " + rs.getString(2) + "\t이름 : " + rs.getString(3) + "\t게시물 : " + rs.getString(4) + "\t등록일자 : " + rs.getDate(5));
							System.out.println();
						}
						
					}
					
				 catch (SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println();
				System.out.println("#############################################");
				System.out.println("               게시물을 삭제합니다.               ");
				System.out.println("#############################################");
				
				System.out.print("삭제할 번호 선택 > ");
				int delID = Integer.parseInt(sc.nextLine()); //띄어쓰기 글자 입력 가능하게
				pstmt = conn.prepareStatement("DELETE FROM board where bid = " + delID);
				int res = pstmt.executeUpdate();
				
				if(res > 0) {
					System.out.println("선택한 번호를 삭제합니다.");
				}else {
					System.out.println("삭제할 수 없습니다.");
				}
				
				System.out.println();
				System.out.println();
				break;
				
			case 4:
				System.out.println();
				System.out.println("#############################################");
				System.out.println("               게시물을 수정합니다.               ");
				System.out.println("#############################################");
				System.out.println();
				break;
				
			case 5:
				System.out.println();
				System.out.println("#############################################");
				System.out.println("              프로그램을 종료합니다.              ");
				System.out.println("#############################################");
				System.out.println();
				System.exit(0);
				break;
			
			default:
				System.out.println();
				System.out.println("#############################################");
				System.out.println("                다시 입력해주세요.                ");
				System.out.println("#############################################");
				System.out.println();
				break;
			
			}
	
			
		}
		
		
		sc.close();

	}

}
