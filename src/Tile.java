
public class Tile {
	
	int x;
	int y;
	boolean[] walls;
	boolean occupied = false;
	String s;
	Token token = null;
	Robot robot = null;
	
	
	// Notering: "walls" representerar [north, east, south, west]
	
	public Tile(int x, int y, String s) {
		this.x = x;
		this.y = y;
		this.s = s;
		//this.token = token;
 
		this.updateWalls(s);

	}
	
	
	public void setToken(Token token) {
		this.token=token;
	}
	
	public void removeToken() {
		token = null;
	}
	
	public void setRobot(Robot robot) {
		this.robot=robot;
		
	}
	
	public Robot getRobot() {
		return robot;
	}
	
	
	public Token getToken() {
		return this.token;
	}
	
	public String getString() {
		return this.s;
	}
	
	
	public void updateWalls(String s) {
		if (s == "north" || (s != null && s.equals("N"))) {
			boolean[] tmp = {true, false, false, false};
			walls = tmp;
		}
		else if (s == "east" || (s != null && s.equals("E"))) {
			boolean[] tmp = {false, true, false, false};
			walls = tmp;
		}
		else if (s == "south" || (s != null && s.equals("S"))) {
			boolean[] tmp = {false, false, true, false};
			walls = tmp;
		}
		else if (s == "west" || (s != null && s.equals("W"))) {
			boolean[] tmp = {false, false, false, true};
			walls = tmp;
		}
		else if (s == "north-east" || (s != null && s.equals("NE"))) {
			boolean[] tmp = {true, true, false, false};
			walls = tmp;
		}
		else if (s == "north-west" || (s != null && s.equals("NW"))) {
			boolean[] tmp = {true, false, false, true};
			walls = tmp;
		}
		else if (s == "south-east" || (s != null && s.equals("ES"))) {
			boolean[] tmp = {false, true, true, false};
			walls = tmp;
		}
		else if (s == "south-west" || (s != null && s.equals("SW"))) {
			boolean[] tmp = {false, false, true, true};
			walls = tmp;
		}
		else if (s == "north-south" || (s != null && s.equals("NS"))) {
			boolean[] tmp = {true, false, true, false};
			walls = tmp;
		}
		else if (s == "east-west" || (s != null && s.equals("EW"))) {
			boolean[] tmp = {false, true, false, true};
			walls = tmp;
		}
		else {
			boolean[] tmp = {false, false, false, false};
			walls = tmp;
		}
		
	}
	
	
	public void updateWallString() {
		boolean a = this.walls[0];
		boolean b = this.walls[1];
		boolean c = this.walls[2];
		boolean d = this.walls[3];
		
		if ((a) & (!b) & (!c) & (!d)) {
			//this.s = "N";
			this.s = "north";
		}
		else if ((!a) & (b) & (!c) & (!d)) {
			this.s = "E";
			this.s = "east";
		}
		else if ((!a) & (!b) & (c) & (!d)) {
			this.s = "S";
			this.s = "south";
		}
		else if ((!a) & (!b) & (!c) & (d)) {
			this.s = "W";
			this.s = "west";
		}
		else if ((a) & (b) & (!c) & (!d)) {
			this.s = "NE";
			this.s = "north-east";
		}
		else if ((a) & (!b) & (!c) & (d)) {
			this.s = "NW";
			this.s = "north-west";
		}
		else if ((!a) & (b) & (c) & (!d)) {
			this.s = "ES";
			this.s = "south-east";
		}
		else if ((!a) & (!b) & (c) & (d)) {
			this.s = "SW";
			this.s = "south-west";
		}
		else if ((a) & (!b) & (c) & (!d)) {
			this.s = "NS";
			this.s = "north-south";
		}
		else if ((!a) & (b) & (!c) & (d)) {
			this.s = "EW";
			this.s = "east-west";
		}
		else {
			this.s = null; //ska den vara det? eller O?
		}
	}
	
	
	public void setString(String s) {
		this.s = s;
		this.updateWalls(s);
		//this.updateWallString();
		
	}

	public boolean[] getWalls(){
		return walls;
	}
	
	public void setWalls(boolean[] walls){
		this.walls = walls;
		this.updateWallString();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
}
