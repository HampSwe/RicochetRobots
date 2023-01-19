import java.util.Random;

public class Game {
	
	int[] currentToken = new int[3]; //x- och y-koordinat samt vilken av de 16 tokensen det är
	Graphics g;
	World world;
	Text text;
	Random rand = new Random();
	int[] tokenPattern;

	public Game(Graphics g, World world) {
		this.g = g;
		this.world = world;
		this.text = new Text(g);
		tokenPattern = this.tokenPattern();
	}
	

	public void run() {
		
		int move = 0;
		Boolean win = false;
		while (!win) {

			g.getWindow().waitForMouseClick();
			int x = g.getWindow().getClickedX();
			int y = g.getWindow().getClickedY();
			Tile t = world.getTile(x, y);
			String s = t.getString();
			int x1 = t.getX();
			int y1 = t.getY();
			
			Boolean b = true;
			int tid = 50;

			if (t.getRobot() == null) {
				
			} else {
				g.markTile(t);
				g.drawRobot(t.getRobot());
				Tile t2 = t;
				g.getWindow().waitForMouseClick();
				int X = g.getWindow().getClickedX();
				int Y = g.getWindow().getClickedY();
				String s1 = this.direction(x, y, X, Y);
				if (s1 == "left") {
					while (s != "west" & s != "south-west" & s != "north-west"
							& world.getMap()[Math.abs(x1 - 1)][y1].getRobot() == null) {
						world.moveRobotLeft(t2.getRobot());
						g.clearTile(t2);
						world.drawWorld();
						g.getWindow().delay(tid);
						x1 -= 1;

						t2 = world.getMap()[x1][y1];
						s = t2.getString();
					}
					g.frec(382,399,20,20,Colors.WALL);
					move++;
					String string = String.valueOf(move);
					text.basic(string, 384, 399, Colors.GRID, 2);
				} else if (s1 == "right") {
					while (s != "east" & s != "south-east" & s != "north-east"
							& world.getMap()[x1 + 1][y1].getRobot() == null) {
						world.moveRobotRight(t2.getRobot());
						g.clearTile(t2);
						world.drawWorld();
						g.getWindow().delay(tid);
						x1 += 1;
						t2 = world.getMap()[x1][y1];
						s = t2.getString();
						if (x1 == 15) {
							x1 = 14;
						}
					}
					g.frec(382,399,20,20,Colors.WALL);
					move++;
					String string = String.valueOf(move);
					text.basic(string, 384, 399, Colors.GRID, 2);

				} else if (s1 == "down") {
					while (s != "south" & s != "south-east" & s != "south-west"
							& world.getMap()[x1][y1 + 1].getRobot() == null) {
						world.moveRobotDown(t2.getRobot());
						g.clearTile(t2);
						world.drawWorld();
						g.getWindow().delay(tid);
						y1 += 1;
						t2 = world.getMap()[x1][y1];
						s = t2.getString();
						if (y1 == 15) {
							y1 = 14;
						}
					}
					g.frec(382,399,20,20,Colors.WALL);
					move++;
					String string = String.valueOf(move);
					text.basic(string, 384, 399, Colors.GRID, 2);
				} else {
					while (s != "north" & s != "north-east" & s != "north-west"
							& world.getMap()[x1][Math.abs(y1 - 1)].getRobot() == null) {
						world.moveRobotUp(t2.getRobot());
						g.clearTile(t2);
						world.drawWorld();
						g.getWindow().delay(tid);
						y1 -= 1;
						t2 = world.getMap()[x1][y1];
						s = t2.getString();

					}
					g.frec(382,399,20,20,Colors.WALL);
					move++;
					String string = String.valueOf(move);
					text.basic(string, 384, 399, Colors.GRID, 2);
				}
				if (t2.getToken() != null) {
					if (t2.getRobot().getColor() == t2.getToken().getColor()) {
						win = true;
					}
				}

			}

		}

	}
	
	public void reset() {
		
	}
	
	public void nextToken() {
		 world.getMap()[currentToken[0]][currentToken[1]].removeToken();
		 int[] coords = world.activateToken(tokenPattern[currentToken[2]]);
		 currentToken[0]= coords[0];
		 currentToken[1]= coords[1];
		 currentToken[2]+=1;
		 
	}
	
	public int[] tokenPattern() {
		int[] pattern = new int[16];
		for (int i=0; i<16; i++) {
			boolean b = true;
			while (b) {
				int a = rand.nextInt(16);
				if (pattern[a]==0) {
					pattern[a]=i+1;
					b=false;
				}
			}
		}
		return pattern;
	}

	
	
	public String direction(int x, int y, int x2, int y2) {
		int difx = x - x2;
		int dify = y - y2;
		if (Math.abs(difx) > Math.abs(dify) & difx < 0) {
			return "right";
		}
		if (Math.abs(difx) > Math.abs(dify) & difx > 0) {
			return "left";
		}
		if (Math.abs(difx) < Math.abs(dify) & dify < 0) {
			return "down";
		}
		if (Math.abs(difx) < Math.abs(dify) & dify > 0) {
			return "up";
		}

		return null;
	}
}
