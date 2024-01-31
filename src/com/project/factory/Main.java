package com.project.factory;

import com.project.factory.resource.Dummy;

public class Main {
	int selectNum;
	String answer;

	public static void main(String[] args) {
		Dummy.makeUserData("A");
		Dummy.makeUserData("B");
		Dummy.makeUserData("C");
		Dummy.makeUserData("D");

	}

	

}
