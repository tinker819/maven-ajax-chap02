package com.kgc.kd56.service;

import java.util.List;

import com.kgc.kd56.entity.Users;

public interface UsersService {
	// 查询所有
	List<Users> queryAllUsers();

	// 根据uid查询用户信息
	Users queryOneUser(String uid);

	// 根据uid修改用户信息
	int updateUsers(Users u);

	// 根据uid删除用户信息
	int delUsersById(String uid);

	// 新增用户信息
	int addUsers(Users u);
}
