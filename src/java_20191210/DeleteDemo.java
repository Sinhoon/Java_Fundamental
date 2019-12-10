package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDemo {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		PreparedStatement psmt2 = null;
		
		try {
			//1. driver load
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("load success");
			
			//2. connection db
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?",
					"root",
					"root1234");
			System.out.println("connect success");
			
			//3. preparestatement 생성
			StringBuffer sql = new StringBuffer();
			sql.append("delete from dept ");
			sql.append("where deptno=?");			
			psmt = con.prepareStatement(sql.toString());
			
			//4. BINDING VAR 
			psmt.setInt(1, 60);
			
			//4 .sql 전송
			int result = psmt.executeUpdate();
			System.out.printf("제거된 행의 수  %d",result);
			
			StringBuffer sql2 = new StringBuffer();
			sql2.append("select * from dept");
			psmt2 = con.prepareStatement(sql2.toString());
			
			ResultSet rs = psmt2.executeQuery();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(psmt != null)
					psmt.close();
					
					if(con != null)
					con.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
