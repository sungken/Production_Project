package com.project.factory.resource.user;

import com.project.factory.Today;
import com.project.factory.member.Identify;

public class Board {
	//게시판	
	private int noticeNumber;
	private String id;
	private String title;
	private String content;
	private String today;
	private String deleteDate;
	
	/**
	 * 
	 * @param noticeNumber = 공지사항 번호
	 * @param id = 작성자
	 * @param title = 제목
	 * @param content = 내용
	 * @param today = 작성일
	 * @param deleteDate = 삭제할 날짜
	 */
	public Board(int noticeNumber, String id, String title, String content, String today, String deleteDate) {
		this.noticeNumber = 1;
		this.id = Identify.auth;
		this.title = title;
		this.content = content;
		this.today = Today.day();
		this.deleteDate = deleteDate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public int getNoticeNumber() {
		return noticeNumber;
	}
	public String getId() {
		return id;
	}
	public String getToday() {
		return today;
	}
	
}
