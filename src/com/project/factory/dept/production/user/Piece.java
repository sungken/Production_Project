package com.project.factory.dept.production.user;

public class Piece {
	//E94-D■engine■엔진집■200
	private String pieceName;
	private String pieceType;
	private String pieceCompany;
	private int pieceNum;
	
	public Piece(String pieceName, String pieceType, String pieceCompany, int pieceNum) {
		this.pieceName = pieceName;
		this.pieceType = pieceType;
		this.pieceCompany = pieceCompany;
		this.pieceNum = pieceNum;
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
	
	
}
