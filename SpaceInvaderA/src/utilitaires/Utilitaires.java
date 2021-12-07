package utilitaires;

import java.util.Scanner;

public class Utilitaires {

	
	public static void readMap(char [][] mapToRead) {
		
		/*for (char[] cs : mapToRead) {
			for (char cs2 : cs) {
				System.out.print(cs2 +"   ");
			}
			System.out.println("");
		}*/
		for(int i = 0; i < mapToRead.length; i++) {
			for(int j = 0; j < mapToRead[i].length; j++) {
				System.out.print(mapToRead[j][i] +"   ");
			}
			System.out.println("");
		}
	}
	
	public static void fillMap(char [][] mapToFill) {
	
		for(int i = 0; i < mapToFill.length; i++) {
			for(int j = 0; j < mapToFill[i].length; j++) {
				mapToFill[i][0]='0';
				mapToFill[i][mapToFill[i].length-1]='0';
				mapToFill[0][j]='0';
				mapToFill[mapToFill[i].length-1][j]='0';
			}
		}
		
	}
	
	public static String saisieString() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
	
	
}
