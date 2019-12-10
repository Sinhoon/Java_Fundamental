package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcSelect {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?",
					"root","root1234");
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("from emp ");
			sql.append("where deptno = ? ");
			sql.append("order by empno");
			psmt = con.prepareStatement(sql.toString());
			psmt.setInt(1, 10);
			ResultSet res = psmt.executeQuery();
			
			while(res.next()){
				int empno =res.getInt(1);
				String ename = res.getString(2);
				System.out.printf("%d %s %n",empno,ename);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
