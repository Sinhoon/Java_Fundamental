package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDemo {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("load success");
			
			con= DriverManager.getConnection("jdbc:mysql://localhost/acorn?",
					"root",
					"root1234");
			System.out.println("connect success");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select * from dept  WHERE deptno = ?");
			psmt = con.prepareStatement(sql.toString());
			
			psmt.setInt(1, 10);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()){
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				System.out.printf("%d %.5s %.10s \n",deptno,dname,loc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
