package com.project.factory.resource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
//TODO 유저정보파일 데이터 ArrayList에 저장클래스
/**
* 사용자 데이터 저장 리스트 관리 클래스
*/
public class Data {
	// TODO 유저 정보 담긴 리스트(memberList)
	public static ArrayList<Members> memberList = new ArrayList<Members>();

	public static void load(){
			try {
				BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBER));
				String line = null;
				while((line = reader.readLine()) != null) {
					String[] temp = line.split("■");
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		}
}
