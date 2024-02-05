package com.project.factory.resource.sub;

import java.io.BufferedReader;
import java.io.FileReader;

import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
import com.project.factory.resource.Path;

public class AgencyData {
	
	public static void load() {
		try {

			Data.memberList.clear(); // 기존 데이터 초기화

			BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBER));

			String line = null;
			while ((line = reader.readLine()) != null) {
				// 사원번호■비밀번호■이름■생년월일■전화번호■주소■직급■부서■이메일
				// 대리점ID■비밀번호■이름■■전화번호■주소■직급■구역■이메일
				String[] temp = line.split("■");

				Members member = new Members(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
						temp[8]);

				Data.memberList.add(member);

			}

			reader.close();

		} catch (Exception e) {
			System.out.println("AgencyData.load");
			e.printStackTrace();
		}

	}
}
