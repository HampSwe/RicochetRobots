import se.lth.cs.pt.window.SimpleWindow;
import java.awt.Color;

public class Graphics {

	SimpleWindow w;
	int squareWidth;
	int wallThickness;
	int width;

	public Graphics(int width, int height) {
		squareWidth = width / 16;
		wallThickness = squareWidth / 8;
		w = new SimpleWindow(width + 2 * wallThickness, height + 2 * wallThickness, "Ricochet");
		this.width = w.getWidth();

	}

	public int getWallThickness() {
		return wallThickness;
	}

	public SimpleWindow getWindow() {
		return w;
	}

	public int getSquareWidth() {
		return squareWidth;
	}

	public void triangle(int x, int y, int b, int h, Color color) {
		int x0 = x;
		w.setLineColor(color);
		for (int i = 0; i < b; i++) {
			w.moveTo(x, y + i * (int) (h / b));
			w.lineTo(x, y + h);
			x++;
		}
		x = x0;
		for (int i = 0; i < b; i++) {
			w.moveTo(x, y + i * (int) (h / b));
			w.lineTo(x, y + h);
			x--;
		}
	}

	public void shape(int startX, int startY, int n, double radius, Color color) {
		w.setLineColor(color);

		double angle = 0;
		double change = Math.toRadians(360 / n); // 360 / n

		double x = startX; // startx
		double y = startY; // starty

		w.moveTo(startX, startY);

		for (int i = 0; i < n; i++) {
			x = x + Math.cos(angle) * radius;
			y = y + Math.sin(angle) * radius;
			angle = angle + change;

			w.lineTo((int) Math.round(x), (int) Math.round(y));

		}
	}

	public void nshape(int xmid, int ymid, double radius, int n, Color color) {
		w.setLineWidth(2);
		w.setLineColor(color);
		double angle = 0;
		double change = Math.toRadians((int) 360 / n);
		int x = (int) (xmid + radius);
		int y = ymid;
		for (int i = 0; i <= n; i++) {
			angle += change;
			w.moveTo(x, y);
			w.lineTo(x = (int) Math.round(xmid + Math.cos(angle) * radius), y = (int) Math.round(ymid + Math.sin(angle) * radius));
		}
	}
	
	public void romb(int xmid, int ymid, double width, Color color) {
		w.setLineWidth(1);
		w.setLineColor(color);
		
		int x;
		int y;
		
		w.moveTo(x = (int) (xmid - width / 2) + 1, y = ymid);
		
		int r = (int) width / 2;
		
		for (int i = 0; i <= r; i++) {
			w.lineTo(x, y);
			x++;
			y--;

		}
		
		for (int i = 0; i <= r; i++) {
			w.lineTo(x, y);
			x++;
			y++;
		}
		
		for (int i = 0; i <= r; i++) {
			w.lineTo(x, y);
			x--;
			y++;
		}
		
		for (int i = 0; i <= r; i++) {
			w.lineTo(x, y);
			x--;
			y--;
		}
		
		
		
//		w.lineTo(xmid, (int) (ymid - width / 2));
//		
//		//w.moveTo(xmid, (int) (ymid - width / 2));
//		w.lineTo((int) (xmid + width / 2), ymid);
//		
//		//w.moveTo((int) (xmid - width / 2), ymid);
//		w.lineTo(xmid, (int) (ymid + width / 2));
//		
//		//w.moveTo(xmid, (int) (ymid + width / 2));
//		w.lineTo((int) (xmid - width / 2), ymid);
//		
//		//w.moveTo((int) (xmid - width / 2), ymid);
	}
	

	public void fillromb(int x, int y, int r, Color color) {
		for (int i = 0; i < r; i++) {
			this.romb(x, y, i, color);
		}
	}
	

	public void fillnshape(int x, int y, int r, int n, Color color) {
		for (int i = 0; i < r; i++) {
			this.nshape(x, y, i, n, color);
		}
	}

	public void fillshape(int x, int y, int r, int n, Color color) {
		for (float i = 1; i < r; i += 0.01) {
			this.shape(x, y, n, i, color);
		}
	}

	public void frec(int x, int y, int b, int h, Color color) {

		w.setLineColor(color);
		w.moveTo(x, y);
		for (int i = 0; i <= b; i++) {
			w.lineTo(x + i, y + h);
			w.moveTo(x + i + 1, y);
		}
	}

	public void rec(int x, int y, int b, int h, Color color) {
		w.moveTo(x, y);
		w.setLineColor(color);
		w.lineTo(x + b, y);
		w.lineTo(x + b, y + h);
		w.lineTo(x, y + h);
		w.lineTo(x, y);
	}

	public void drawGrid(int x, int y) {

		this.frec(squareWidth * x + wallThickness, squareWidth * y + wallThickness, squareWidth, squareWidth,
				Colors.BACKGROUND);
		this.rec(squareWidth * x + wallThickness, squareWidth * y + wallThickness, squareWidth, squareWidth,
				Colors.GRID);
	}

	public void drawBackground() {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				this.drawGrid(i, j);
			}
		}
		this.frec(0, 0, width, wallThickness, Colors.WALL);
		this.frec(width - wallThickness, 0, wallThickness, width, Colors.WALL);
		this.frec(0, 0, wallThickness, width, Colors.WALL);
		this.frec(0, width - wallThickness, width, wallThickness, Colors.WALL);
		this.frec(7 * squareWidth + wallThickness / 2, 7 * squareWidth + wallThickness / 2,
				2 * squareWidth + wallThickness, 2 * squareWidth + wallThickness, Colors.WALL);
	}

	public void clearTile(Tile tile) {
		int x = tile.getX();
		int y = tile.getY();
		this.frec(3 * wallThickness / 2 + x * squareWidth, 3 * wallThickness / 2 + y * squareWidth,
				squareWidth - wallThickness, squareWidth - wallThickness, Colors.BACKGROUND);
	}

	public void markTile(Tile tile) {
		int x = tile.getX();
		int y = tile.getY();
		this.frec(x * squareWidth + 5 * wallThickness / 2, y * squareWidth + (5 * wallThickness) / 2,
				squareWidth / 2 + wallThickness, squareWidth / 2 + wallThickness, Colors.BLACK);

	}

	public void drawTile(Tile tile) {
		boolean[] walls = tile.getWalls();
		int x = tile.getX();
		int y = tile.getY();

		if (walls[0]) {
			this.frec(x * squareWidth + wallThickness, y * squareWidth + wallThickness, squareWidth, wallThickness / 2,
					Colors.WALL);

		}
		if (walls[1]) {
			this.frec((x + 1) * squareWidth + wallThickness / 2, y * squareWidth + wallThickness, wallThickness / 2,
					squareWidth, Colors.WALL);

		}
		if (walls[2]) {
			this.frec(x * squareWidth + wallThickness, (y + 1) * squareWidth + wallThickness / 2, squareWidth,
					wallThickness / 2, Colors.WALL);

		}
		if (walls[3]) {
			this.frec(x * squareWidth + wallThickness, y * squareWidth + wallThickness, wallThickness / 2, squareWidth,
					Colors.WALL);
		}
		if (walls[0] & walls[1]) {
			this.frec((x + 1) * squareWidth + wallThickness, y * squareWidth + wallThickness / 2, wallThickness / 2,
					wallThickness / 2, Colors.WALL);
		}
		if (walls[1] & walls[2]) {
			this.frec((x + 1) * squareWidth + wallThickness, (y + 1) * squareWidth + wallThickness, wallThickness / 2,
					wallThickness / 2, Colors.WALL);
		}
		if (walls[2] & walls[3]) {
			this.frec(x * squareWidth + wallThickness / 2, (y + 1) * squareWidth + wallThickness, wallThickness / 2,
					wallThickness / 2, Colors.WALL);
		}
		if (walls[3] & walls[0]) {
			this.frec(x * squareWidth + wallThickness / 2, y * squareWidth + wallThickness / 2, wallThickness / 2,
					wallThickness / 2, Colors.WALL);
		}

	}

	public void drawToken(Token token) {
		int x = token.getX();
		int y = token.getY();
		Color color = token.getColor();
		String shape = token.getShape();

		if (shape.equals("C")) {
			this.frec(x * squareWidth + 3 * wallThickness - 1, y * squareWidth + 3 * wallThickness, squareWidth / 2+1,
					squareWidth / 2, Colors.WALL);
			
			this.fillromb(x * squareWidth + 3 * wallThickness + squareWidth / 4 - 2, y * squareWidth + 3 * wallThickness + squareWidth / 4,
					squareWidth / 4 , color); //squareWidth / 2
			
//			this.fillnshape(x * squareWidth + 3 * wallThickness + squareWidth / 4, y * squareWidth + 3 * wallThickness + squareWidth / 4,
//					squareWidth / 4, 4, color);
				
//			this.fillromb(100, 100,
//					100 , Colors.TOKEN); //squareWidth / 2
			
		} else if (shape.equals("B")) {
//			this.frec(x * squareWidth + 3 * wallThickness, y * squareWidth + 3 * wallThickness, squareWidth / 2,
//					squareWidth / 2, Colors.WALL);
//			this.triangle(x * squareWidth + squareWidth / 2 + wallThickness,
//					y * squareWidth + squareWidth / 4 + wallThickness, squareWidth / 4, squareWidth / 2, color);
			
			this.frec(x * squareWidth + 3 * wallThickness - 1, y * squareWidth + 3 * wallThickness, squareWidth / 2+1,
					squareWidth / 2, Colors.WALL);
			
			this.fillromb(x * squareWidth + 3 * wallThickness + squareWidth / 4 - 2, y * squareWidth + 3 * wallThickness + squareWidth / 4,
					squareWidth / 4 , color); //squareWidth / 2
			
		} else if (shape.equals("T")) {
//			this.triangle(x * squareWidth + squareWidth / 2 + wallThickness,
//					y * squareWidth + squareWidth / 4 + wallThickness, squareWidth / 4, squareWidth / 2, color);
			
			this.frec(x * squareWidth + 3 * wallThickness - 1, y * squareWidth + 3 * wallThickness, squareWidth / 2+1,
					squareWidth / 2, Colors.WALL);
			
			this.fillromb(x * squareWidth + 3 * wallThickness + squareWidth / 4 - 2, y * squareWidth + 3 * wallThickness + squareWidth / 4,
					squareWidth / 4 , color); //squareWidth / 2
			
		} else if (shape.equals("P")) {
//			this.frec(x * squareWidth + 3 * wallThickness, y * squareWidth + 3 * wallThickness, squareWidth / 2,
//					squareWidth / 2, color);
			
			this.frec(x * squareWidth + 3 * wallThickness - 1, y * squareWidth + 3 * wallThickness, squareWidth / 2+1,
					squareWidth / 2, Colors.WALL);
			
			this.fillromb(x * squareWidth + 3 * wallThickness + squareWidth / 4 - 2, y * squareWidth + 3 * wallThickness + squareWidth / 4,
					squareWidth / 4 , color); //squareWidth / 2
			
		}
		else {
//		this.frec(x * squareWidth + 3 * wallThickness, y * squareWidth + 3 * wallThickness, squareWidth / 2,
//				squareWidth / 2, color);
			
			int aq = 7;
			
			this.frec(x * squareWidth + 3 * wallThickness + 0 - 1, y * squareWidth + 3 * wallThickness - 1, squareWidth / 2+1 + 2,
					squareWidth / 2 + 2, Colors.WALL);
			
//			this.fillromb(x * squareWidth + 3 * wallThickness + squareWidth / 4 - 1, y * squareWidth + 3 * wallThickness + squareWidth / 4,
//					squareWidth / 4 , Colors.TOKEN); //squareWidth / 2
			
			this.fillromb(x * squareWidth + 3 * wallThickness + squareWidth / 4 - 1 - aq, y * squareWidth + 3 * wallThickness + squareWidth / 4,
					squareWidth / 4 , Colors.RED); //squareWidth / 2
			
			this.fillromb(x * squareWidth + 3 * wallThickness + squareWidth / 4 - 1, y * squareWidth + 3 * wallThickness + squareWidth / 4 - aq,
					squareWidth / 4 , Colors.GREEN); //squareWidth / 2
			
			this.fillromb(x * squareWidth + 3 * wallThickness + squareWidth / 4 - 1 + aq, y * squareWidth + 3 * wallThickness + squareWidth / 4,
					squareWidth / 4 , Colors.BLUE); //squareWidth / 2
			
			this.fillromb(x * squareWidth + 3 * wallThickness + squareWidth / 4 - 1, y * squareWidth + 3 * wallThickness + squareWidth / 4 + aq,
					squareWidth / 4 , Colors.YELLOW); //squareWidth / 2
			
	}
	}

	public void drawRobot(Robot robot) {
		int x = robot.getX();
		int y = robot.getY();
		Color color = robot.getColor();
		this.frec(x * squareWidth + 3 * wallThickness, y * squareWidth + 3 * wallThickness, squareWidth / 2,
				squareWidth / 2, color);

	}

	public void moveRobotLeft(World world) {
		w.waitForMouseClick();
		int x = w.getClickedX(); // fixa så att det är om man klickar i rutan så ger den x och y som rutans
									// koordinater
		int y = w.getClickedY();
		Tile[][] map = world.getMap();
		Tile startTile = map[x][y];
		Robot robot = startTile.getRobot();
		if (robot != null) {
			startTile.setRobot(null);
			map[x - 1][y].setRobot(robot);

		}
		world.drawRobots();

	}

	public void square(int x, int y, int side, Color color) {
		this.frec(x, y, side, side, color);
	}
	
	
	


}