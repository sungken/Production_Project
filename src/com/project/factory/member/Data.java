package com.project.factory.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Data {
	private static final String MEMBER =".\\data\\member.txt";
	
	public static ArrayList<TempMember> list = new ArrayList<TempMember>();
	
	public static void load() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				//553277A■134113411341■손진원■840924■010-7533-1895■서울특별시 강남구 언주로47길■1■생산■553277A@auto.com
				String[] temp = line.split("■");
				
				TempMember member = new TempMember(temp[0],temp[1], temp[2],temp[3], temp[4], temp[5], Integer.parseInt(temp[6]), temp[7], temp[8]);
			
				list.add(member);
			}
			
			reader.close();
			

			
			
		} catch (Exception e){
			System.out.println("Data.load");
			e.printStackTrace();
		}
	}
}
