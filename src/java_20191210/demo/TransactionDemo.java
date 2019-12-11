package java_20191210.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement psmt = null;
		PreparedStatement psmt2 = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn?");
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dept(deptno,dname,loc) VALUES(50,'aa','aaa')");
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql.toString());
			psmt.executeUpdate();
			sql.setLength(0);
			sql.append("INSERT INTO dept(deptno,dname,loc) VALUES(60,'bb','bbb)");
			psmt2 = con.prepareStatement(sql.toString());
			psmt2.executeUpdate();
			
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try{
				if (isSuccess == true){
					con.commit();
				}else {
					con.rollback();
				}
				con.setAutoCommit(true); // connection pool 사용경우에는 반드시 작성해야되는 코드
				if(psmt != null) psmt.close(); 
				if(psmt2 != null) psmt2.close();
				if(con != null) con.close();
			
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}

}
