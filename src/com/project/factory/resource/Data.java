package com.project.factory.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

//TODO 유저정보파일 데이터 ArrayList에 저장클래스
/**
 * 사용자 데이터 저장 리스트 관리 클래스
 */
public class Data {
	// TODO 유저 정보 담긴 리스트(memberList)
	public static ArrayList<Members> memberList = new ArrayList<Members>();

	public static void load() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBER));

			String line = null;
			while ((line = reader.readLine()) != null) {
				// 홍길동,100,90,80
				String[] temp = line.split("■");
				
				Members member = new Members(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
				
				memberList.add(member);

			}

			reader.close();

		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}

	}
	
	public static void save() {
		try {
			BufferedWriter writer =  new BufferedWriter(new FileWriter(Path.MEMBER));
			
			for(Members members : Data.memberList) {
				
				//Score 객체 1개 > 홍길동, 100, 90, 80
				String line = String.format("%s■%s■%s■%s■%s■%s■%s■%s■%d■%s", members.getId(), members.getPw(), members.getName(), members.getBirth(), members.getPhoneNum(), members.getAddress(), members.getLevel(), members.getDept(), members.getEmail());
				
				writer.write(line);
				
				
			}
			
			
			
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}
		
		
	}
}
