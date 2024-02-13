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
	
	/**
	 * 부품회사 전화번호를 반환하는 메서드이다.
	 * @return 부품회사 전화번호
	 */
	public String getPieceCompanyPhoneNum() {
		return pieceCompanyPhoneNum;
	}

	/**
	 * 부품회사 전화번호를 설정하는 메서드이다.
	 * @param pieceCompanyPhoneNum 부품회사 전화번호
	 */
	public void setPieceCompanyPhoneNum(String pieceCompanyPhoneNum) {
		this.pieceCompanyPhoneNum = pieceCompanyPhoneNum;
	}

	/**부품 이름을 반환하는 메서드이다.
	 * 
	 * @return	부품이름
	 */
	public String getPieceName() {
		return pieceName;
	}
	/**
	 * 부품이름을 설정하는 메서드이다.
	 * @param pieceName 부품이름
	 */
	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
	/**
	 * 부품의 종류를 반환하는 메서드이다.
	 * @return 부품 종류
	 */
	public String getPieceType() {
		return pieceType;
	}
	/**부품의 종류를 설정하는 메서드이다.
	 * 
	 * @param pieceType 부품 종류
	 */
	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}
	/**
	 * 부품 회사의 이름을 반환하는 메서드이다.
	 * @return 부품 회사의 이름
	 */
	public String getPieceCompany() {
		return pieceCompany;
	}
	/**부품 회사의 이름을 설정하는 메서드이다.
	 * 
	 * @param pieceCompany 부품 회사의 이름
	 */
	public void setPieceCompany(String pieceCompany) {
		this.pieceCompany = pieceCompany;
	}
	/**부품의 개수를 반환하는 메서드이다.
	 * 
	 * @return 부품 개수
	 */
	public int getPieceNum() {
		return pieceNum;
	}
	/**부품의 개수를 설정하는 메서드이다.
	 * 
	 * @param pieceNum 부품 개수
	 */
	public void setPieceNum(int pieceNum) {
		this.pieceNum = pieceNum;
	}
	/**부품 회사의 아이디를 반환하는 메서드이다.
	 * 
	 * @return 부품 회사 아이디
	 */
	public String getPieceCompanyId() {
		return pieceCompanyId;
	}
	/**
	 * 부품 회사의 아이디를 설정하는 메서드이다.
	 * @param pieceCompanyId 부품 회사 아이디
	 */
	public void setPieceCompanyId(String pieceCompanyId) {
		this.pieceCompanyId = pieceCompanyId;
	}
	
	
}
