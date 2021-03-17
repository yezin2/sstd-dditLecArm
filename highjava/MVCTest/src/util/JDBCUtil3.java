package util;
/*
 * db.properties파일의 내용으로 db정보를 설정하는 방법
 * 방법2) ResourceBundle객체 이용하기
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil3 {
	static ResourceBundle bundle; //ResourceBundle객체변수 선언
	
	static {
		bundle = ResourceBundle.getBundle("db");// 객체 생성
		
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
	      
		try {
			return DriverManager.getConnection(
					bundle.getString("url"), 
					bundle.getString("user"),
					bundle.getString("pass"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void disConnect(Connection conn, 
			Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) try {rs.close();} catch(SQLException ex) {}
		if(stmt != null) try {stmt.close();} catch(SQLException ex) {}
		if(conn != null) try {conn.close();} catch(SQLException ex) {}
		if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
	}
}
