
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
public class World {

	Tile[][] map;
	Graphics g;
	Random rand = new Random();
	Robot robotY;
	Robot robotS;
	Robot robotG;
	Robot robotR;
	Robot robotB;
	int[][] tokenCoords = new int[16][2];
	String[] tokenColors = new String[16];
	String[] tokenType = new String[16];
	ArrayList<Token> tokens;
	
	String worldString;

	public World(Graphics g) {
		this.g = g;
		
		this.tokens = new ArrayList<Token>();

		map = new Tile[16][16];

		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				map[x][y] = new Tile(x, y, null);
			}
		}

	}
	
	
	public Robot getRobotY() {
		return robotY;
		}
	public Robot getRobotR() {
		return robotR;
		}
	
	public Robot getRobotG() {
		return robotG;
		}
	public Robot getRobotB() {
		return robotB;
		}
	public Robot getRobotS() {
		return robotS;
		}
	
	
	public int[] getRandomOrder() {
		boolean[] numbers = {false, false, false, false};
		int[] tmp = new int[4];
		
		Random rand = new Random();
		int count = 0;
		
		while (count < 4) {
			int num = rand.nextInt(4);
			
			if (!numbers[num]) {
				tmp[count] = num;
				numbers[num] = true;
				count++;
			}
		}
		
		return tmp;
	}
	
	public Tile[][] concatenateQuad(Tile[][] inputMap, Quad quad, int startX, int startY){
		
		// KOLLA SÅ ATT DET INTE FINNS VÄGGAR LÄNGS MED KANTERNA. VIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIKTIGT
		
		Tile[][] tmp = inputMap;
		
		for (int i=0; i < 8; i++) {
			for (int j=0; j < 8; j++) {
				quad.map[i][j].setX(j + startX); //quad.map[i][j].setX(j + startX);
				quad.map[i][j].setY(i + startY); //quad.map[i][j].setX(j + startX);
				
				tmp[j + startX][i + startY] = quad.map[i][j]; //tmp[i + startY][j + startX] = quad.map[i][j];
				//tmp[i + startX][j + startY].setString(quad.map[i][j]);
			}
		}
		
		for (int i = 0; i < 4; i++) {
			quad.tokensInQuad.get(i).setX(quad.tokensInQuad.get(i).getX() + startX);
			quad.tokensInQuad.get(i).setY(quad.tokensInQuad.get(i).getY() + startY);
		}
		
		if (quad.group.equals("B")){
			quad.tokensInQuad.get(4).setX(quad.tokensInQuad.get(4).getX() + startX);
			quad.tokensInQuad.get(4).setY(quad.tokensInQuad.get(4).getY() + startY);
		}
		
		
		return tmp;
		
	}
	
	
	public Tile[][] genMap() {
		
		Quad[] quads = new Quad[4];
		
//		quads[0] = new Quad(this);
//		quads[1] = new Quad(this);
//		quads[2] = new Quad(this);
//		quads[3] = new Quad(this);
		
		quads[0] = Quad.genQuad("A", this);
		quads[1] = Quad.genQuad("B", this); // dessa har svarta hål
		quads[2] = Quad.genQuad("C", this);
		quads[3] = Quad.genQuad("D", this);
		
		
		
		boolean showAllTokens = true;
		
		char a = 'h';
		//String a = "h";
		
		String hejs = String.valueOf(a);
		//String hejs = a.substring(0, 1);
		
		//String tjena = "h";
		
//		if (hejs.equals("h")) {
//			System.out.println("ja");
//		}
//		
//		System.out.println(hejs);
		
//		quads[1].genQuad("B", this);
//		quads[2].genQuad("C", this);
//		quads[3].genQuad("D", this);
		
		//System.out.println(quads[0].map[0][0].getWalls());
		
		
		
		
		
		int[] order = getRandomOrder();

		
//		order[0] = 0;
//		order[1] = 1;
//		order[2] = 2;
//		order[3] = 3;
		
//		order[0] = 1;
//		order[1] = 0;
//		order[2] = 2;
//		order[3] = 3;
		
		
		
		String[] out = new String[4];
		
		for (int i=0; i<4; i++) {
			out[order[i]] = quads[i].group + quads[i].variant;
		}
		
		
		this.worldString = out[0] + "-" + out[1] + "-" + out[2] + "-" + out[3];
		
		
		
		System.out.println("LL");
		System.out.println(quads[0].tokensInQuad.get(0).getShape());
		
		System.out.println("TQ");
		
		for (int i=0; i<5; i++) {
			
			int x = quads[1].tokensInQuad.get(i).getX();
			int y = quads[1].tokensInQuad.get(i).getY();
			String c = quads[1].tokensInQuad.get(i).c;
			String shape = quads[1].tokensInQuad.get(i).shape;
			
			System.out.println("(" + x + ", " + y + ") " + c + shape);
			
			
		}
		
		
		for (int i = 0; i < 4; i++) {
			quads[i].rotateQuad(order[i]);
		}
		
		//quads[1].rotateQuad(order[1]);
		
		
		System.out.println("TAA");
		
		for (int i=0; i<5; i++) {
			
			int x = quads[1].tokensInQuad.get(i).getX();
			int y = quads[1].tokensInQuad.get(i).getY();
			String c = quads[1].tokensInQuad.get(i).c;
			String shape = quads[1].tokensInQuad.get(i).shape;
			
			System.out.println("(" + x + ", " + y + ") " + c + shape);
			
			
		}
		
		
			
		
		String hej = quads[0].map[0][0].getString();
		
		System.out.println(hej);
		
		
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				String heja = quads[1].map[y][x].getString();
				
				System.out.print(heja + " ");
			}
			System.out.println("");
		}
		
		
		
		boolean[] listahej = quads[0].map[0][1].getWalls();
	
		for (int hejsan = 0; hejsan < 4; hejsan++) {
			System.out.println(listahej[hejsan]);
		}
		
		
		
		Tile[][] newMap = new Tile[16][16];
		
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				newMap[x][y] = new Tile(x, y, null);
			}
		}
		
		
		
//		for (int x = 0; x < 8; x++) {
//			for (int y = 0; y < 8; y++) {
//				quads[0].map[x][y].setX(y);
//				quads[0].map[x][y].setY(x);
//				newMap[x][y] = quads[0].map[x][y];
//			}
//		}
		
		
		

		
		
		int[] xs = {0, 8, 8, 0};
		int[] ys = {0, 0, 8, 8};
		
		for (int i = 0; i < 4; i++) {
			newMap = concatenateQuad(newMap, quads[i], xs[order[i]], ys[order[i]]);
		}
		
		//Notering: "walls" representerar [north, east, south, west]
		
		//kolla efter svart hål längs med kanterna, enda sättet för en vägg att gå över en gräns, sätt där ut vägg. cheeky af
		
		
		
		for (int i=0; i<16; i++) {
			if (newMap[8][i].getWalls()[3]) {
				boolean[] tmpWalls = newMap[7][i].getWalls();
				tmpWalls[1] = true;
				newMap[7][i].setWalls(tmpWalls); //uppdatera wall-string!!!! det görs
			}
			
			if (newMap[7][i].getWalls()[1]) {
				boolean[] tmpWalls = newMap[8][i].getWalls();
				tmpWalls[3] = true;
				newMap[8][i].setWalls(tmpWalls); //uppdatera wall-string!!!! det görs
			}		
		}
		for (int i=0; i<16; i++) {
			if (newMap[i][8].getWalls()[0]) {
				boolean[] tmpWalls = newMap[i][7].getWalls();
				tmpWalls[2] = true;
				newMap[i][7].setWalls(tmpWalls); //uppdatera wall-string!!!! det görs
			}
			
			if (newMap[i][7].getWalls()[2]) {
				boolean[] tmpWalls = newMap[i][8].getWalls();
				tmpWalls[0] = true;
				newMap[i][8].setWalls(tmpWalls); //uppdatera wall-string!!!! det görs
			}		
		}
		
		
//		for (int i=0; i<16; i++) {
//			if (newMap[i][8].getWalls()[3]) {
//				boolean[] tmpWalls = newMap[i][7].getWalls();
//				tmpWalls[1] = true;
//				newMap[i][7].setWalls(tmpWalls); //uppdatera wall-string!!!! det görs
//			}
//			
//			if (newMap[i][7].getWalls()[1]) {
//				boolean[] tmpWalls = newMap[i][8].getWalls();
//				tmpWalls[3] = true;
//				newMap[i][8].setWalls(tmpWalls); //uppdatera wall-string!!!! det görs
//			}		
//		}
//		for (int i=0; i<16; i++) {
//			if (newMap[8][i].getWalls()[0]) {
//				boolean[] tmpWalls = newMap[7][i].getWalls();
//				tmpWalls[2] = true;
//				newMap[7][i].setWalls(tmpWalls); //uppdatera wall-string!!!! det görs
//			}
//			
//			if (newMap[7][i].getWalls()[2]) {
//				boolean[] tmpWalls = newMap[8][i].getWalls();
//				tmpWalls[0] = true;
//				newMap[8][i].setWalls(tmpWalls); //uppdatera wall-string!!!! det görs
//			}		
//		}

		
		//newMap = concatenateQuad(newMap, quads[0], 0, 0);
		
//		int[] xs = {0, 7, 0, 7};
//		int[] ys = {0, 0, 7, 7};
//		
//		for (int i = 0; i < 4; i++) {
//			newMap = concatenateQuad(newMap, quads[i], xs[i], ys[i]);
//		}
		
		
		System.out.println(this.worldString);
		
		//System.out.println();
		
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				newMap[x][y].updateWallString();
				//System.out.print(newMap[x][y].getString() + " ");
			}
			//System.out.println();
		}
		

		//System.out.println();
		
	
		
		System.out.println("yyyy");
		
		for (int i=0; i<4; i++) {
			this.tokens.add(quads[0].tokensInQuad.get(i));
			this.tokens.add(quads[1].tokensInQuad.get(i));
			this.tokens.add(quads[2].tokensInQuad.get(i));
			this.tokens.add(quads[3].tokensInQuad.get(i));
		}
		
		this.tokens.add(quads[1].tokensInQuad.get(4)); // alltid denna som har ett svart hål
		
		System.out.println("hejsaaaaan");
		
		for (int i=0; i<17; i++) {
			
			if (showAllTokens) {
				newMap[this.tokens.get(i).getX()][this.tokens.get(i).getY()].setToken(this.tokens.get(i));
			}

			
			int x = this.tokens.get(i).getX();
			int y = this.tokens.get(i).getY();
			String c = this.tokens.get(i).c;
			String shape = this.tokens.get(i).shape;
			
			System.out.println("(" + x + ", " + y + ") " + c + shape);
			
			
		}
		
		
		
		//Token token5 = new Token(12, 1, "y", "triangle", this);
		
		
		return newMap;
		
		
	}

	public Graphics getGraphics() {
		return g;
	}

	public void drawWorld() {
		this.drawTiles();
		this.drawTokens();
		this.drawRobots();

	}

	public void drawRobots() {
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				Robot robot = this.map[x][y].getRobot();
				if (robot != null) {
					g.drawRobot(robot);
				}
			}
		}
	}

	public Tile getTile(int x, int y) {
		int width = g.getSquareWidth();
		int wallThickness = g.getWallThickness();
		int a = (x - wallThickness) / width;
		int b = (y - wallThickness) / width;
		return map[a][b];
	}

	public void drawTiles() {
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				if (map[x][y].getString() != null) {
					g.drawTile(map[x][y]);
				}
			}
		}
	}

	
	public int[] activateToken(int n) {
		int[] retu = new int[2];
		Token theToken = new Token(tokenCoords[n][0], tokenCoords[n][1], tokenColors[n], tokenType[n], this, true);
		retu[0]= tokenCoords[n][0];
		retu[1]= tokenCoords[n][0];
		return retu;
	}
	
	
	public void drawTokens() {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				Token token = this.map[i][j].getToken();
				if (token != null) {
					g.drawToken(token);
				}
			}
		}
	}

	public Tile[][] getMap() {
		return map;
	}

	public void updateMap(Tile[][] map) {
		this.map = map;
	}

	public void moveRobotLeft(Robot robot) {
		int x = robot.getX();
		int y = robot.getY();

		Tile tmp_tile = map[x][y];
		tmp_tile.setRobot(null);
		map[x][y] = tmp_tile;

		Tile tmp_tile2 = map[x - 1][y];
		tmp_tile2.setRobot(robot);
		map[x - 1][y] = tmp_tile2;

		robot.setX(x - 1);
		robot.setY(y);

	}

	public void moveRobotRight(Robot robot) {
		int x = robot.getX();
		int y = robot.getY();

		Tile tmp_tile = map[x][y];
		tmp_tile.setRobot(null);
		map[x][y] = tmp_tile;

		Tile tmp_tile2 = map[x + 1][y];
		tmp_tile2.setRobot(robot);
		map[x + 1][y] = tmp_tile2;

		robot.setX(x + 1);
		robot.setY(y);

	}

	public void moveRobotDown(Robot robot) {
		int x = robot.getX();
		int y = robot.getY();

		Tile tmp_tile = map[x][y];
		tmp_tile.setRobot(null);
		map[x][y] = tmp_tile;

		Tile tmp_tile2 = map[x][y + 1];
		tmp_tile2.setRobot(robot);
		map[x][y + 1] = tmp_tile2;

		robot.setX(x);
		robot.setY(y + 1);
	}

	public void moveRobotUp(Robot robot) {
		int x = robot.getX();
		int y = robot.getY();

		Tile tmp_tile = map[x][y];
		tmp_tile.setRobot(null);
		map[x][y] = tmp_tile;

		Tile tmp_tile2 = map[x][y - 1];
		tmp_tile2.setRobot(robot);
		map[x][y - 1] = tmp_tile2;

		robot.setX(x);
		robot.setY(y - 1);
	}

	public void removeRobot(int x, int y) {

	}

	public void createRobots() {
	Random rand = new Random();

	int x = rand.nextInt(16);
	int y = rand.nextInt(16);
	while (!(!(x == 7 & y == 7) & !(x == 7 & y == 8) & !(x == 8 & y == 7) & !(x == 8 & y == 8))) {
		x = rand.nextInt(16);
		y = rand.nextInt(16);
	}

	this.robotB = new Robot(x, y, Colors.BLUE, this);

	int x2 = rand.nextInt(16);
	int y2 = rand.nextInt(16);
	while (!(!(x2 == 7 & y2 == 7) & !(x2 == 7 & y2 == 8) & !(x2 == 8 & y2 == 7) & !(x2 == 8 & y2 == 8))) {
		x2 = rand.nextInt(16);
		y2 = rand.nextInt(16);
	}
	this.robotR = new Robot(x2, y2, Colors.RED, this);

	int x3 = rand.nextInt(16);
	int y3 = rand.nextInt(16);
	while (!(!(x3 == 7 & y3 == 7) & !(x3 == 7 & y3 == 8) & !(x3 == 8 & y3 == 7) & !(x3 == 8 & y3 == 8))) {
		x3 = rand.nextInt(16);
		y3 = rand.nextInt(16);
	}
	this.robotG = new Robot(x3, y3, Colors.GREEN, this);

	int x4 = rand.nextInt(16);
	int y4 = rand.nextInt(16);
	while (!(!(x4 == 7 & y4 == 7) & !(x4 == 7 & y4 == 8) & !(x4 == 8 & y4 == 7) & !(x4 == 8 & y4 == 8))) {
		x4 = rand.nextInt(16);
		y4 = rand.nextInt(16);
	}

	this.robotY = new Robot(x4, y4, Colors.YELLOW, this);

	int x5 = rand.nextInt(16);
	int y5 = rand.nextInt(16);
	while (!(!(x5 == 7 & y5 == 7) & !(x5 == 7 & y5 == 8) & !(x5 == 8 & y5 == 7) & !(x5 == 8 & y5 == 8))) {
		x5 = rand.nextInt(16);
		y5 = rand.nextInt(16);
	}

	this.robotS = new Robot(x5, y5, Colors.BLACK, this);
	
}
	public void initWorld() {
		//this.createRobots();
		//Token token1 = new Token(3, 2, Colors.YELLOW, "circle", this);
		//Token token2 = new Token(5, 3, "b", "triangle", this);
//		Token token3 = new Token(2, 4, Colors.RED, "square", this);
//		Token token4 = new Token(4, 5, Colors.GREEN, "hexagon", this);
//
		
//  	Token token6 = new Token(10, 2, Colors.RED, "hexagon", this);
//		Token token7 = new Token(11, 5, Colors.GREEN, "square", this);
//		Token token8 = new Token(14, 6, Colors.BLUE, "circle", this);
//
//		Token token9 = new Token(12, 9, Colors.BLUE, "square", this);
//		Token token10 = new Token(9, 12, Colors.YELLOW, "hexagon", this);
//		Token token11 = new Token(11, 14, Colors.RED, "circle", this);
		//Token token12 = new Token(14, 13, "g", "triangle", this);
//
//		Token token13 = new Token(5, 8, Colors.YELLOW, "square", this);
//		Token token14 = new Token(2, 9, Colors.GREEN, "circle", this);
		//Token token15 = new Token(1, 14, "r", "triangle", this);
//		Token token16 = new Token(4, 13, Colors.BLUE, "hexagon", this);

		// Koordinaten för det svarta hålet är (10, 7)

		
		boolean oldWorld = false;
		// oldworld är A2-B2-C1-D3

		
		
		// TA BORT ALLT UNDER
		
		

		if (oldWorld) {
			
			for (int i = 0; i < 16; i++) {
				this.map[0][i].setString("west");

				for (int j = 0; j < 16; j++) {
					this.map[j][0].setString("north");

				}
				for (int j = 0; j < 16; j++) {
					this.map[j][15].setString("south");

				}
				for (int j = 0; j < 16; j++) {
					this.map[15][j].setString("east");

				}
			}
		
			
			// This code is temporary and horrible
			
			this.map[5][0].setString("north-east");
			this.map[6][0].setString("north-west");
			this.map[2][2].setString("east");
			this.map[3][2].setString("north-west");
			this.map[3][1].setString("south");
			this.map[0][3].setString("south-west");
			this.map[0][4].setString("north-west");
			this.map[2][3].setString("south");
			this.map[2][4].setString("north-east");
			this.map[3][4].setString("west");
			this.map[4][3].setString("east");
			this.map[5][3].setString("south-west");
			this.map[4][5].setString("south-east");
			this.map[5][5].setString("west");
			this.map[4][6].setString("north");
			this.map[5][4].setString("north");
			this.map[7][7].setString("north-west");

			this.map[2][8].setString("south");
			this.map[4][8].setString("east");
			this.map[5][8].setString("south-west");
			this.map[1][9].setString("east");
			this.map[2][9].setString("north-west");
			this.map[5][9].setString("north");
			this.map[0][11].setString("south-west");
			this.map[0][12].setString("north-west");
			this.map[4][12].setString("south");
			this.map[4][13].setString("north-east");
			this.map[1][14].setString("south-east");
			this.map[1][15].setString("north-south");
			this.map[2][14].setString("west");
			this.map[5][15].setString("south-east");
			this.map[6][15].setString("south-west");
			this.map[5][13].setString("west");
			this.map[7][8].setString("south-west");

			this.map[8][0].setString("north-east");
			this.map[9][0].setString("north-west");
			this.map[12][1].setString("south-east");
			this.map[13][1].setString("west");
			this.map[12][2].setString("north");
			this.map[10][2].setString("south-west");
			this.map[9][2].setString("east");
			this.map[10][3].setString("north");
			this.map[15][3].setString("south-east");
			this.map[15][4].setString("north-east");
			this.map[14][5].setString("south");
			this.map[14][6].setString("north-west");
			this.map[13][6].setString("east");
			this.map[12][5].setString("west");
			this.map[11][5].setString("north-east");
			this.map[11][4].setString("south");
			this.map[10][7].setString("south-west");
			this.map[9][7].setString("east");
			this.map[10][8].setString("north");

			this.map[6][7].setString("east");
			this.map[7][6].setString("south");
			this.map[6][8].setString("east");
			this.map[8][6].setString("south");
			this.map[9][7].setString("east-west");
			this.map[9][8].setString("west");
			this.map[7][9].setString("north");
			this.map[8][9].setString("north");

			this.map[12][8].setString("south");
			this.map[12][9].setString("north-east");
			this.map[13][9].setString("west");
			this.map[15][9].setString("south-east");
			this.map[15][10].setString("north-east");
			this.map[8][12].setString("east");
			this.map[9][12].setString("north-west");
			this.map[9][11].setString("south");
			this.map[11][14].setString("south-east");
			this.map[11][15].setString("north-south");
			this.map[12][14].setString("west");
			this.map[13][15].setString("south-east");
			this.map[14][15].setString("south-west");
			this.map[14][14].setString("north");
			this.map[14][13].setString("south-west");
			this.map[13][13].setString("east");

			this.map[0][0].setString("north-west");
			this.map[0][15].setString("south-west");
			this.map[15][0].setString("north-east");
			this.map[15][15].setString("south-east");
		}
		
		else {
			
			this.map = this.genMap();
		}
		
		//Token token5 = new Token(12, 1, "Y", "T", this, true);
		
		this.createRobots();
			
	}
}
