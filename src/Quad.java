import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Quad {
	Tile[][] map;
	//Token[] tokens;
	World world;

	String group;
	String variant;
	ArrayList<Token> tokensInQuad;

	public Quad(World world) {

		map = new Tile[8][8];
		this.world = world;

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				this.map[x][y] = new Tile(x, y, null);
			}
		}

	}

	public static Quad genQuad(String group, World world) {
		Random rand = new Random();
		int r = rand.nextInt(3) + 1;

		// ta bort sen

//		if (group == "A") {
//			r = 2;
//		}
//		else if (group == "B") {
//			r = 2;
//		}
//		else if (group == "C") {
//			r = 1;
//			//r = 2;
//		}
//		else {
//			r = 3;
//		}
		
		
//		if (group == "A") {
//		r = 3;
//	}
//	else if (group == "B") {
//		r = 1;
//	}
//	else if (group == "C") {
//		r = 1;
//		//r = 2;
//	}
//	else {
//		r = 3;
//	}
		


		System.out.println("src/Quadrants/" + group + "/" + group + "" + r + ".txt");

		Quad q = new Quad(world);
		
		q.tokensInQuad = new ArrayList<Token>();

		q.group = group;
		q.variant = "" + r;

		try {
			// System.out.println(System.getProperty("user.dir"));
			Scanner f = new Scanner(new File("src/Quadrants/" + group + "/" + group + "" + r + ".txt"));

			int k;
			String value;

			for (int y = 0; y < 8; y++) {
				String line = f.nextLine();
				k = 0;

				for (int x = 0; x < 8; x++) {
					value = "";

					// System.out.println(String.valueOf(line.charAt(0)));

					while (line.charAt(k) != ' ') {
						// value += String.valueOf(line.charAt(k));
						value += line.substring(k, k + 1);
						k++;
						// System.out.println(String.valueOf(line.charAt(k)));

					}

					k += 1;

					// Detta ska bort för att läsa in tokens

					if (value.length() == 5) {
						q.map[y][x].setString(value.substring(0, 1) + value.substring(1, 2));
						
						String color = value.substring(3, 4);
						String shape = value.substring(4, 5);
						
						Token t = new Token(x, y, color, shape, world, false);
						
						q.tokensInQuad.add(t);
						
						System.out.println(shape);
						System.out.println("qqqq");
						
						
					}

					else if (value.length() == 2) {
						q.map[y][x].setString(value.substring(0, 1) + value.substring(1, 2));
						// System.out.println(value.substring(0, 1) + value.substring(1, 2));
						//System.out.println("hej");
					}

					else {
						q.map[y][x].setString(value.substring(0, 1));
						// System.out.println(value.substring(0, 1));
						//System.out.println("hej");
						//System.out.println("hej!!!");
					}

//					if (value.length() == 2) {
//						q.map[y][x].setString(String.valueOf(value.charAt(0)) + String.valueOf(value.charAt(1)));
//					}
//					
//					else {
//						q.map[y][x].setString(String.valueOf(value.charAt(0)));
//					}
				}

			}

			f.close();

//			Scanner fTokens = new Scanner(new File(group + r + "_tokens.txt"));
//			
//			for (int i = 0; i < 4; i++) {
//				String line = fTokens.nextLine();
//				
//				Color c = Colors.BLACK;
//				
//				switch (String.valueOf(line.charAt(6))) {
//				
//				case "r":
//					c = Colors.RED;
//				
//				case "b":
//					c = Colors.BLUE;
//				
//				case "g":
//					c = Colors.GREEN;
//				
//				case "y":
//					c = Colors.YELLOW;
//					
//				}
//				
//				q.tokens[i] = new Token(Integer.valueOf(String.valueOf(line.charAt(0)) + String.valueOf(line.charAt(1))), Integer.valueOf(String.valueOf(line.charAt(3)) + String.valueOf(line.charAt(4))), c, String.valueOf(line.charAt(8)), this.world);
//			}
//
//		    fTokens.close();

			// this.map = q.map;
			// return q;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return q;

	}

	public void rotateQuad(int n) {

		for (int i = 0; i < n; i++) {
			this.rotateRight();
		}

	}

	public void rotateRight() {

		// MåSTE VRIDA VäGGARNA. VIIIIIIIIIIIKTIGT
		// MåSTE VRIDA TOKENS. VIIIIIIIIIKTIGT. tror jag gjort detta, men måste parsa
		// tokens bara
		// Kan det finnas fler än två väggar? nä tror inte det

		//Quad newQuad = new Quad(this.world);

		Tile[][] otherMap = new Tile[8][8];

		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// this.map[y][x].setX(7 - y);
				// this.map[y][x].setY(x);
				// newQuad.map[x][7 - y] = this.map[y][x];

				// newQuad.map[x][7 - y] = this.map[y][x];

				String newStr = this.map[y][x].getString();

				if (newStr != null) {

					if (newStr.equals("N")) {
						newStr = "E";
					} else if (newStr.equals("E")) {
						newStr = "S";
					} else if (newStr.equals("S")) {
						newStr = "W";
					} else if (newStr.equals("W")) {
						newStr = "N";
					} else if (newStr.equals("NE")) {
						newStr = "ES";
					} else if (newStr.equals("ES")) {
						newStr = "SW";
					} else if (newStr.equals("SW")) {
						newStr = "NW";
					} else if (newStr.equals("NW")) {
						newStr = "NE";
					} else if (newStr.equals("NS")) {
						newStr = "EW";
					} else if (newStr.equals("EW")) {
						newStr = "NS";
					} else {
						newStr = "O";
					}

				}

				otherMap[x][7 - y] = new Tile(7 - y, x, newStr); // otherMap[x][7 - y] = new Tile(x, 7 - y, newStr);

			}
		}

		
		for (int i=0; i<4; i++) {
			Token tmpToken = this.tokensInQuad.get(i);
			
			int oldX = tmpToken.getX();
			
			tmpToken.setX(7 - tmpToken.getY());
			tmpToken.setY(oldX);
			
			this.tokensInQuad.set(i, tmpToken);
		}
		
		
		if (this.group.equals("B")) {
			Token tmpToken = this.tokensInQuad.get(4);
			
			int oldX = tmpToken.getX();
			
			tmpToken.setX(7 - tmpToken.getY());
			tmpToken.setY(oldX);
			
			this.tokensInQuad.set(4, tmpToken);
		}
		
		//gör detta för svart hål också
		
		
		
		// här vrids tokensen?

//			for (int i = 0; i < 4; i++) {
//				newQuad.tokens[i] = new Token(7 - this.tokens[i].getY(), this.tokens[i].getX(), this.tokens[i].getColor(), this.tokens[i].getType(), this.world);
//			}

		// this.map = newQuad.map;
		this.map = otherMap;
	}

}
