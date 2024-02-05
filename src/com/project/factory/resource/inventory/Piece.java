package com.project.factory.resource.inventory;

public class Piece {
	//E94-D■engine■엔진집■200
	private String pieceName;
	private String pieceType;
	private String pieceCompany;
	private String pieceCompanyId;
	private String pieceCompanyPhoneNum;
	private int pieceNum;
	
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
