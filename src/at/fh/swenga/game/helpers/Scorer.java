package at.fh.swenga.game.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Scorer {
	
	public static void SaveScore(String highScoreFileName, int score){ 
		String highScore = "" + score;

		try {
			File file = new File(highScoreFileName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(highScore);
			bw.close();
		} catch (Exception e) {
			System.out.println("No idea what could go wrong here, so look at this info: " + e);
			e.printStackTrace();
		}
	}
	
	public static int LoadScore(String highScoreFileName) {
		int highScore = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(highScoreFileName));
			highScore = Integer.parseInt(br.readLine());
			br.close();
		} catch (Exception e) {
			return 0;
		}
		
		return highScore;
	}
}
