package com.kgc.kd56.dao;

import java.util.List;

import com.kgc.kd56.entity.Users;

public interface UsersDao {
	//��ѯ����
	List<Users> queryAllUsers();
	
	//����uid��ѯ�û���Ϣ
	Users queryOneUser(String uid);
	
	//����uid�޸��û���Ϣ
	int updateUsers(Users u);
	
	//����uidɾ���û���Ϣ
	int delUsersById(String uid);
	
	//�����û���Ϣ
	int addUsers(Users u);

}
