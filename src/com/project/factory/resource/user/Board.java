package com.project.factory.resource.user;

public class Board {
	//공지사항(게시판)	
	private int noticeNumber;
	private String id;
	private String title;
	private String contents;
	private String today;
	private String deleteDate;
	
	/**
	 * 
	 * @param noticeNumber = 공지사항 번호
	 * @param id = 작성자
	 * @param title = 제목
	 * @param contents = 내용
	 * @param today = 작성일
	 * @param deleteDate = 삭제할 날짜
	 */
	public Board(int noticeNumber, String id, String title, String contents, String today, String deleteDate) {
		this.noticeNumber = noticeNumber;
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.today = today;
		this.deleteDate = deleteDate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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

	@Override
	public String toString() {
		return "noticeNumber=" + noticeNumber + ", id=" + id + ", title=" + title + ", contents=" + contents
				+ ", today=" + today + ", deleteDate=" + deleteDate + "]";
	}
	
}
