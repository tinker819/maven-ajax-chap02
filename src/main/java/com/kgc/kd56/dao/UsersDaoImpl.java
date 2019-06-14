package com.kgc.kd56.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kgc.kd56.entity.Users;
import com.kgc.kd56.utils.BaseUtils;

public class UsersDaoImpl extends BaseUtils implements UsersDao {

	public List<Users> queryAllUsers() {
		List<Users> users = new ArrayList<Users>();
		String sql = "SELECT uid,uname,borndate,sex,status FROM users";
		rs = super.executeQuery(sql);
		try {
			while(rs.next()){
				Users u = new Users(rs.getString("uid"), rs.getString("uname"),
							rs.getString("borndate"), rs.getInt("sex"), rs.getInt("status"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(rs, pstmt, conn);
		}
		return users;
	}

	public Users queryOneUser(String uid) {
		Users u = null;
		String sql = "SELECT uid,uname,borndate,sex,status FROM users where uid = ? ";
		rs = super.executeQuery(sql, new Object[]{uid});
		try {
			if(rs.next()){
				u = new Users(rs.getString("uid"), rs.getString("uname"),
							rs.getString("borndate"), rs.getInt("sex"), rs.getInt("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(rs, pstmt, conn);
		}
		return u;
	}

	public int updateUsers(Users u) {
		String sql = "update users set uname=?,borndate=?,sex=?,status=? where uid = ? ";
		return super.executeUpdate(sql, new Object[]{u.getUname(),u.getBorndate(),u.getSex(),u.getStatus(),u.getUid()});
	}

	public int delUsersById(String uid) {
		String sql = "delete from users where uid = ? ";
		return super.executeUpdate(sql, new Object[]{uid});
	}

	public int addUsers(Users u) {
		String sql = "insert into users values(?,?,?,?,?)";
		return super.executeUpdate(sql, new Object[]{u.getUid(),u.getUname(),u.getBorndate(),u.getSex(),u.getStatus()});
	}

}
