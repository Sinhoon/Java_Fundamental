package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcDemo {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//org.mariadb.jdbc,driver
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이브 클래스 로드 성공");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/acorn?autoReconnect=true"
					,"root","root1234");
			System.out.println("DB connection 성공");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dept VALUES(?,?,?)");
			// 3. SQL문을 전송할 수 있는 PreparedStatement 객체 생성
			pstmt = con.prepareStatement(sql.toString());
			
			// 4. binding 변수 설정
			pstmt.setInt(1, 60);
			pstmt.setString(2, "ANAYLSIS");
			pstmt.setString(3, "LA");
			
			// 5. SQL문 전송
			int result = pstmt.executeUpdate(); // DML insert,update,delete
			System.out.println("갱신된 행의 수:"+result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
