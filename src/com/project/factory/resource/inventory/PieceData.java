package com.project.factory.resource.inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.factory.resource.Path;
/**
 * 부품데이터 관리 클래스이다.
 */
public class PieceData {
	/**
	 * 부품정보를 담는 ArrayLIst이다.
	 */
	public static ArrayList<Piece> pieceList = new ArrayList<Piece>();
	/**
	 * txt파일의 부품정보 데이터를 ArrayList에 담는 메소드이다.
	 */
	public static void pieceLoad() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.PIECEINVENTORY));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");

				Piece piece = new Piece(temp[0], temp[1], temp[2],temp[3], temp[4], Integer.parseInt(temp[5]));

				pieceList.add(piece);
				

			}
			reader.close();

		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}

	}
	/**
	 * 부품ArrayList의 내용을 txt파일에 담는 클래스이다.
	 */
	public static void PieceSave() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.PIECEINVENTORY));
			for (Piece piece : PieceData.pieceList) {

				String line = String.format("%s■%s■%s■%s■%s■%d\r\n", piece.getPieceName(), piece.getPieceType(), piece.getPieceCompany(),piece.getPieceCompanyId(), piece.getPieceCompanyPhoneNum(),piece.getPieceNum());

				writer.write(line);

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}

	}
	
}
