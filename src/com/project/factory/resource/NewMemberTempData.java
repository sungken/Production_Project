package com.project.factory.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.factory.dept.human.admin.NewMembers;
import com.project.factory.dept.human.admin.NewMembersTemp;

/** 사원번호가 부여된 신입사원 데이터를 관리하는 클래스이다.
 * 
 */
public class NewMemberTempData {
	
	/** 사원번호가 부여된 신입사원 목록
	 * 
	 */
	public static ArrayList<NewMembersTemp> NewMemberTempList = new ArrayList<NewMembersTemp>();

	/** 파일에서 사원번호가 부여된 신입사원 데이터를 로드하는 메서드이다.
	 * 
	 */
	public static void load() {
        try {
        	NewMemberTempList.clear();

            BufferedReader reader = new BufferedReader(new FileReader(Path.NEWMEMBERTEMP));

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split("■");

                	
                    NewMembersTemp newMemberTemp = new NewMembersTemp(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5],temp[6],temp[7]);
                    NewMemberTempList.add(newMemberTemp);
               
                    // 유효하지 않은 데이터 처리
               
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Data.load");
            e.printStackTrace();
        }
    }
		
		
	
	/** 파일에 사원번호가 부여된 신입사원 리스트 정보를 저장하는 메서드이다.
	 * 
	 * @param newMember 신입사원 정보
	 */
	public static void save(NewMembers newMember) {
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(Path.NEWMEMBERTEMP, true));

	        String line = String.format("%s■%s■%s■%s■%s■%s■%s■%s\r\n", newMember.getId(), newMember.getPw(), newMember.getName(),
	                newMember.getPhoneNum(), newMember.getBirth(), newMember.getAddress(), newMember.getDept(),
	                newMember.getLevel());
	        writer.write(line);

	        writer.close();
	    } catch (Exception e) {
	        System.out.println("NewMemberTempData.save");
	        e.printStackTrace();
	    }
	}


	
}
