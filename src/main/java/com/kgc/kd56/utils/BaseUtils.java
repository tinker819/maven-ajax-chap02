package com.kgc.kd56.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseUtils {
	protected static final String DRIVER = "com.mysql.jdbc.Driver";
	protected static final String URL = "jdbc:mysql://localhost:3306/610test";
	protected static final String USERNAME = "root";
	protected static final String PASSWORD = "";
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;
    
    
    static{
    	try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public Connection getConn(){
    	try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return conn;
    }
    
    public ResultSet executeQuery(String sql, Object...param){
    	conn = this.getConn();
    	try {
			pstmt = conn.prepareStatement(sql);
			for(int i = 0;i<param.length;i++){
				pstmt.setObject(i+1, param[i]);
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return rs;
    }
    
    public int executeUpdate(String sql, Object...param){
    	int result = 0;
    	conn = this.getConn();
    	try {
			pstmt = conn.prepareStatement(sql);
			for(int i = 0;i<param.length;i++){
				pstmt.setObject(i+1, param[i]);
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(rs, pstmt, conn);
		}
    	
    	return result;
    }
    
    public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn){
    	if(rs!=null){
    		try {
    			rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	if(pstmt!=null){
    		try {
    			pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	if(conn!=null){
    		try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
}









