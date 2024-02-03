package com.project.factory.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.factory.dept.human.admin.NewMembers;
import com.project.factory.dept.human.admin.NewMembersTemp;

public class NewMemberTempData {
	public static ArrayList<NewMembersTemp> NewMemberTempList = new ArrayList<NewMembersTemp>();

	public static void load() {
        try {
        	NewMemberTempList.clear();

            BufferedReader reader = new BufferedReader(new FileReader(Path.NEWMEMBER));

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split("■");

                	
                    NewMembersTemp newMemberTemp = new NewMembersTemp(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5],temp[6]);
                    NewMemberTempList.add(newMemberTemp);
               
                    // 유효하지 않은 데이터 처리
               
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Data.load");
            e.printStackTrace();
        }
    }
		
		
	
	
	public static void save() {
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(Path.NEWMEMBERTEMP,true));

	        for (NewMembersTemp newMemberTemp : NewMemberTempData.NewMemberTempList) {
	            String line = String.format("%s■%s■%s■%s■%s■%s■%s\r\n", newMemberTemp.getId(), newMemberTemp.getName(),
	            		newMemberTemp.getPhoneNum(), newMemberTemp.getBirth(), newMemberTemp.getAddress(), newMemberTemp.getDept(),
	            		newMemberTemp.getLevel());
	            writer.write(line);
	        }

	        writer.close();
	    } catch (Exception e) {
	        System.out.println("Data.save");
	        e.printStackTrace();
	    }
	}
	
}
