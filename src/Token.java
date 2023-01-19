import java.awt.Color;
public class Token {

	
	Color color;
	String c;
	String shape;
	int x;
	int y;
	World world;;
	
	public Token(int x, int y, String color, String shape, World world, boolean giveTile) {

		this.shape=shape;
		this.c = color;
		this.x =x;
		this.y=y;
		this.world=world;
		
		if (giveTile) {
			world.getMap()[x][y].setToken(this);
		}

		
		if (color.equals("R")) {
			this.color = Colors.RED;
		}
		else if (color.equals("G")) {
			this.color = Colors.GREEN;
		}
		else if (color.equals("B")) {
			this.color = Colors.BLUE;
		}
		else if (color.equals("Y")) {
			this.color = Colors.YELLOW;
		}
		else if (color.equals("H")) {
			this.color = Colors.BLACK;
		}
		
		//this.color = Colors.TOKEN; // ta bort detta sen
		
	}
	
	
	public String getShape() {
		return shape;
	}
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Color getColor() {
		return color;
	}
	
		
	
}

