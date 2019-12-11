package java_20191210.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_20191210.dto.SalgradeDto;

public class SalgradeDao {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	private static SalgradeDao single;

	private SalgradeDao() {
		super();
	}

	public static SalgradeDao getInstance() {
		if (single == null) {
			single = new SalgradeDao();
		}
		return single;
	}

	public boolean insert(SalgradeDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/acorn?", "root", "root1234");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into salgrade(grade,losal,hisal)");
			sql.append("values(?,?,?)");
			psmt = con.prepareStatement(sql.toString());

			int index = 0;
			psmt.setInt(++index, dto.getGrade());
			psmt.setInt(++index, dto.getLosal());
			psmt.setInt(++index, dto.getHisal());

			psmt.executeUpdate();

			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;
	}

	public boolean update(SalgradeDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn?", "root", "root1234");
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE SALGRADE ");
			sql.append("SET LOSAL = ? , HISAL = ? ");
			sql.append("WHERE GRADE = ?");
			psmt = con.prepareStatement(sql.toString());

			int index = 0;
			psmt.setInt(++index, dto.getGrade());
			psmt.setInt(++index, dto.getLosal());
			psmt.setInt(++index, dto.getHisal());
			psmt.executeUpdate();
			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	public boolean delete(int grade) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn?", "root", "root1234");
			StringBuffer sql = new StringBuffer();
			sql.append("delete from salgrade ");
			sql.append("where grade = ? ");
			psmt = con.prepareStatement(sql.toString());

			int index = 0;
			psmt.setInt(++index, grade);
			psmt.executeUpdate();
			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;
	}

	public ArrayList<SalgradeDto> select() {
		ArrayList<SalgradeDto> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn?", "root", "root1234");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM salgrade");
			psmt = con.prepareStatement(sql.toString());
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				int index = 0;
				int grade = rs.getInt(++index);
				int losal = rs.getInt(++index);
				int hisal = rs.getInt(++index);
				list.add(new SalgradeDto(grade, losal, hisal));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public SalgradeDto select(int setgrade){
		SalgradeDto dto = null;
		Connection con = null; 
		PreparedStatement psmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn?", "root", "root1234");
			StringBuffer sql = new StringBuffer();
			sql.append("select * from salgrade where grade = ?");
			psmt = con.prepareStatement(sql.toString());
			int index = 0;
			psmt.setInt(++index, setgrade);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				int grade = rs.getInt(1);
				int losal = rs.getInt(2);
				int hisal = rs.getInt(3);
				dto = new SalgradeDto(grade,losal,hisal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return dto;
	}

}
