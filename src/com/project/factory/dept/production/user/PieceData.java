package com.project.factory.dept.production.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.factory.resource.Path;

public class PieceData {
	public static ArrayList<Piece> pieceList = new ArrayList<Piece>();

	public static void pieceLoad() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.TODAYPRODUCTION));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");

				Piece piece = new Piece(temp[0], temp[1], temp[2],Integer.parseInt(temp[3]));

				pieceList.add(piece);
				

			}
			reader.close();

		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}

	}

	public static void PieceSave() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.PIECEINVENTORY));
			for (Piece piece : PieceData.pieceList) {

				String line = String.format("%s■%s■%s■%d\r\n", piece.getPieceName(), piece.getPieceType(), piece.getPieceCompany(), piece.getPieceNum());

				writer.write(line);

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}

	}
	
}
