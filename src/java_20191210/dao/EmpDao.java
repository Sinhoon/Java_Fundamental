package java_20191210.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import java_20191210.dto.EmpDto;

public class EmpDao {
	private static EmpDao single;
	private static String url;
	private static String user;
	private static String pwd;

	static {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\acorn\\git\\Homework\\src\\jdbc.properties");
			Properties prop = new Properties();
			prop.load(fis);

			String driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			pwd = prop.getProperty("pwd");

			Class.forName(driver);
			System.out.println("드라이브 성공");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private EmpDao() {

	}

	public static EmpDao getInstance() {
		if (single == null) {
			single = new EmpDao();
		}
		return single;
	}

	public boolean insert(EmpDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			StringBuffer sql = new StringBuffer();
			sql.append("insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) ");
			sql.append("VALUES(?,?,?,?,curdate(),?,?,?)");
			psmt = con.prepareStatement(sql.toString());
			int index = 0;
			psmt.setInt(++index, dto.getNo());
			psmt.setString(++index, dto.getName());
			psmt.setString(++index, dto.getJob());
			psmt.setInt(++index, dto.getMgr());
			psmt.setInt(++index, dto.getSal());
			psmt.setInt(++index, dto.getComm());
			psmt.setInt(++index, dto.getDeptno());
			psmt.executeUpdate();
			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;
	}

	public boolean update(EmpDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			StringBuffer sql = new StringBuffer();
			sql.append("update emp set ename = ?,job = ?,mgr = ?,hiredate = curdate(),sal = ?,comm = ?,deptno = ? ");
			sql.append("where empno = ?");
			psmt = con.prepareStatement(sql.toString());
			int index = 0;
			psmt.setString(++index, dto.getName());
			psmt.setString(++index, dto.getJob());
			psmt.setInt(++index, dto.getMgr());
			psmt.setInt(++index, dto.getSal());
			psmt.setInt(++index, dto.getComm());
			psmt.setInt(++index, dto.getDeptno());
			psmt.setInt(++index, dto.getNo());
			psmt.executeUpdate();
			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;
	}

	public boolean delete(int empno) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			StringBuffer sql = new StringBuffer();
			sql.append("delete from emp ");
			sql.append("where empno = ?");
			psmt = con.prepareStatement(sql.toString());
			int index = 0;
			psmt.setInt(++index, empno);
			psmt.executeUpdate();
			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;
	}

	public ArrayList<EmpDto> select(int start, int len) {
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			StringBuffer sql = new StringBuffer();
			sql.append("select * from emp ");
			sql.append("order by hiredate desc ");
			sql.append("limit ?,? ");
			psmt = con.prepareStatement(sql.toString());
			int index = 0;
			psmt.setInt(++index, start);
			psmt.setInt(++index, len);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				index = 0;
				int no = rs.getInt(++index);
				String name = rs.getString(++index);
				String job = rs.getString(++index);
				int mgr = rs.getInt(++index);
				String hiredate = rs.getString(++index);
				int sal = rs.getInt(++index);
				int comm = rs.getInt(++index);
				int deptno = rs.getInt(++index);
				list.add(new EmpDto(no,name,job,mgr,hiredate,sal,comm,deptno));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public EmpDto select(int empno){
		EmpDto dto = null;
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			StringBuffer sql = new StringBuffer();
			sql.append("select * from emp where empno = ? ");
			psmt = con.prepareStatement(sql.toString());
			psmt.setInt(1, empno);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				int index = 0;
				int no = rs.getInt(++index);
				String name = rs.getString(++index);
				String job = rs.getString(++index);
				int mgr = rs.getInt(++index);
				String hiredate = rs.getString(++index);
				int sal = rs.getInt(++index);
				int comm = rs.getInt(++index);
				int deptno = rs.getInt(++index);
				dto = new EmpDto(no,name,job,mgr,hiredate,sal,comm,deptno);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
}
