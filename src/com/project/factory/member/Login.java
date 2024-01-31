package com.project.factory.member;

import java.io.BufferedReader;
import java.io.FileReader;

import com.project.factory.resource.Path;

public class Login {

	public static boolean login(String id, String pw) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBER));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");

				if (temp[0].equals(id) && temp[1].equals(pw)) {
					// 로그인 성공 > 계속 유지
					Identify.auth = id;
					Identify.level = temp[5];
					Identify.dept = temp[6];
					
				}
				reader.close();
			}
		} catch (Exception e) {
			
		}
		//로그인 성공시 true, 실패시 false
		if(Identify.auth != null) {
			return true;
		}else {
			return false;
		}

	}

}
