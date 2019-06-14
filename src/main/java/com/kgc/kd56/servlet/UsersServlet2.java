package com.kgc.kd56.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.kgc.kd56.entity.Users;

@WebServlet("/UsersServlet2")
public class UsersServlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ģ��
		//�����ַ������ʽ,��ֹ��������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//����out�������
		PrintWriter out = response.getWriter();
		
		//����һ���û�����
		String uid = UUID.randomUUID().toString().replace("-", "");
		Users u = new Users(uid, "����", "1999-10-10 12:12:12", 0, 0);
		
		
		//��������û�����
		List<Users> lUsers = new ArrayList<Users>();
		for(int i = 0;i<5; i++){
			Random r = new Random();
			int ranNum = r.nextInt(2);
			Users user = new Users(UUID.randomUUID().toString().replace("-", ""),
									"����"+i, "199"+i+"-10-10 12:12:12", ranNum, ranNum);
			lUsers.add(user);
		}
		
		//����ȡ�ĵ����û�����ͻ�ȡ�Ķ���û�����ͨ��ʹ��ajax��ǰ̨���л�ȡ
		/**
		 * ǿ��:��Ϊǰ̨ҳ�治�ô�����ַ���������,����,��̨��������ַ���������ת���������ַ��������ݴ�����ʽ
		 * 
		 * 
		 */
		//����JSONObject����,����ת��json��ʽ����
		JSONObject jsonObject = new JSONObject();
		//����Ҫת����json��ʽ�����ݣ�ֱ��put�ŵ�JSONObject������
		jsonObject.put("u", u);
		jsonObject.put("lUsers", lUsers);
	
		//ͨ��out�������,��jsonObjectд��ǰ̨��
		out.println(jsonObject);
		
	}

}







