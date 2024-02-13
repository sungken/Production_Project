package com.project.factory.resource.inventory;
/**
 * 부품 클래스이다.
 */
public class Piece {
	//E94-D■engine■엔진집■200
	private String pieceName;
	private String pieceType;
	private String pieceCompany;
	private String pieceCompanyId;
	private String pieceCompanyPhoneNum;
	private int pieceNum;
	/**
	 * 부품 클래스의 생성자이다.
	 * @param pieceName	부품이름
	 * @param pieceType	부품종류
	 * @param pieceCompany	부품회사이름
	 * @param pieceCompanyId	부품회사ID
	 * @param pieceCompanyPhoneNum	부품회사전화번호
	 * @param pieceNum	부품 개수
	 */
	public Piece(String pieceName, String pieceType, String pieceCompany, String pieceCompanyId, String pieceCompanyPhoneNum, int pieceNum) {
		this.pieceName = pieceName;
		this.pieceType = pieceType;
		this.pieceCompany = pieceCompany;
		this.pieceCompanyId = pieceCompanyId;
		this.pieceCompanyPhoneNum = pieceCompanyPhoneNum;
		this.pieceNum = pieceNum;
	}
	

	public String getPieceCompanyPhoneNum() {
		return pieceCompanyPhoneNum;
	}


	public void setPieceCompanyPhoneNum(String pieceCompanyPhoneNum) {
		this.pieceCompanyPhoneNum = pieceCompanyPhoneNum;
	}


	public String getPieceName() {
		return pieceName;
	}

	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}

	public String getPieceType() {
		return pieceType;
	}

	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}

	public String getPieceCompany() {
		return pieceCompany;
	}

	public void setPieceCompany(String pieceCompany) {
		this.pieceCompany = pieceCompany;
	}

	public int getPieceNum() {
		return pieceNum;
	}

	public void setPieceNum(int pieceNum) {
		this.pieceNum = pieceNum;
	}

	public String getPieceCompanyId() {
		return pieceCompanyId;
	}

	public void setPieceCompanyId(String pieceCompanyId) {
		this.pieceCompanyId = pieceCompanyId;
	}
	
	
}
