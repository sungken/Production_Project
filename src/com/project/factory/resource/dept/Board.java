package com.project.factory.resource.dept;

public class Board {
	// 공지사항(게시판)
	private int noticeNumber;
	private String id;
	private String dept;
	private String title;
	private String contents;
	private String writeDate;
	private String deleteDate;

	/**
	 * 
	 * @param noticeNumber = 공지사항 번호
	 * @param id           = 작성자
	 * @param dept         = 작성자의 부서
	 * @param title        = 제목
	 * @param contents     = 내용
	 * @param writeDate    = 작성일
	 * @param deleteDate   = 삭제할 날짜
	 */
	public Board(int noticeNumber, String id, String dept, String title, String contents, String writeDate, String deleteDate) {
		this.noticeNumber = noticeNumber;
		this.id = id;
		this.dept = dept;
		this.title = title;
		this.contents = contents;
		this.writeDate = writeDate;
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

	public String getDept() {
		return dept;
	}

	public String getWriteDate() {
		return writeDate;
	}

	@Override
	public String toString() {
		return "noticeNumber=" + noticeNumber + ", id=" + id + ", dept=" + dept + ", title=" + title + ", contents="
				+ contents + ", writeDate=" + writeDate + ", deleteDate=" + deleteDate;
	}

}
