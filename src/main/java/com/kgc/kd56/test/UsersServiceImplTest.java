package com.kgc.kd56.test;

import java.util.Random;
import java.util.UUID;

import com.kgc.kd56.entity.Users;
import com.kgc.kd56.service.UsersServiceImpl;

public class UsersServiceImplTest {

	public static void main(String[] args) {
		UsersServiceImpl uImpl = new UsersServiceImpl();
		
		/*for(int i = 0;i<9; i++){
			Random r = new Random();
			int ranNum = r.nextInt(2);
			Users user = new Users(UUID.randomUUID().toString().replace("-", ""),
									"ÀîËÄ"+i, "199"+i+"-10-10 12:12:12", ranNum, ranNum);
			uImpl.addUsers(user);
		}*/
		
		
		Users u = new Users("10f75e56af1b4dbbad5b192c37f495fe",
				"ÍúÍú", "2000-10-10 12:12:12", 1, 0);
		System.out.println(uImpl.updateUsers(u));
		
		System.out.println(uImpl.queryOneUser("10f75e56af1b4dbbad5b192c37f495fe"));
		
	}

}
