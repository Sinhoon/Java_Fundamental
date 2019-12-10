package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		
		try {
			// 1. driver class load
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("load success");
			
			// 2. db connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn?autoReconnect=true"
					,"root","root1234");
			System.out.println("connect success");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
		
			//3. prepareStatememt 생성
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?");
			psmt = con.prepareStatement(sql.toString());
			
			//4. binding variable set
			psmt.setString(1, "MINING");
			psmt.setString(2, "SILICON VELLY");
			psmt.setInt(3, 50);
			
			//5. sql transfer
			int result = psmt.executeUpdate();
			System.out.println("변형된 행의수"+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
	}
}
