package com.kgc.kd56.service;

import java.util.List;

import com.kgc.kd56.dao.UsersDao;
import com.kgc.kd56.dao.UsersDaoImpl;
import com.kgc.kd56.entity.Users;

public class UsersServiceImpl implements UsersService {
	//调用数据访问层对象
	private UsersDao uDao = new UsersDaoImpl();

	public List<Users> queryAllUsers() {
		return uDao.queryAllUsers();
	}

	public Users queryOneUser(String uid) {
		return uDao.queryOneUser(uid);
	}

	public int updateUsers(Users u) {
		return uDao.updateUsers(u);
	}

	public int delUsersById(String uid) {
		return uDao.delUsersById(uid);
	}

	public int addUsers(Users u) {
		return uDao.addUsers(u);
	}

}
