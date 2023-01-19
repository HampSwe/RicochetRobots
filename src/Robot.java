import java.awt.Color;

public class Robot {

	int x;
	int y;
	Color color;
	World world;
	
	public Robot(int x, int y, Color color, World world){
		this.x=x;
		this.y=y;
		this.color=color;
		this.world=world;
		world.getMap()[x][y].setRobot(this);
		
	}
	
	public int getY(){
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
	
	
	
	
	public boolean moveRobotLeft() {
		String s = world.getMap()[x][y].getString();
		int i=0;
		while (s != "west" & s != "south-west" & s != "north-west" & s != "eastwest"
				& world.getMap()[Math.abs(x - 1)][y].getRobot() == null) {
			this.moveRobotLeftOneStep();
			s = world.getMap()[x][y].getString();
			i++;
		}
		if (i==0) {
			return false;
		}
		return true;
	}
	
	public boolean moveRobotRight() {
		String s = world.getMap()[x][y].getString();
		int i=0;
		while (s != "east" & s != "south-east" & s != "north-east" & s != "east-west"
				& world.getMap()[(x + 1)%16][y].getRobot() == null) {
			this.moveRobotRightOneStep();
			s = world.getMap()[x][y].getString();
			i++;
		}
		if (i==0) {
			return false;
		}
		return true;
	}
	
	public boolean moveRobotUp() {
		String s = world.getMap()[x][y].getString();
		int i=0;
		while (s != "north" & s != "north-east" & s != "north-west" & s != "north-south"
				& world.getMap()[(x)][Math.abs(y-1)].getRobot() == null) {
			this.moveRobotUpOneStep();
			s = world.getMap()[x][y].getString();
			i++;
		}
		if (i==0) {
			return false;
		}
		return true;
	}
	
	public boolean moveRobotDown() {
		String s = world.getMap()[x][y].getString();
		int i=0;
		while (s != "south" & s != "south-west" & s != "south-east" & s != "north-south"
				& world.getMap()[x][(y+1)%16].getRobot() == null) {
			this.moveRobotDownOneStep();
			s = world.getMap()[x][y].getString();
			i++;
		}
		if (i==0) {
			return false;
		}
		return true;
	}
	
	public void moveRobotLeftOneStep() {
		world.getMap()[x][y].setRobot(null);
		world.getMap()[Math.abs(x-1)][y].setRobot(this);
		this.x-=1;
	}
	
	public void moveRobotRightOneStep() {
		world.getMap()[x][y].setRobot(null);
		world.getMap()[(x+1)][y].setRobot(this);
		this.x+=1;
	}
	
	public void moveRobotUpOneStep() {
		world.getMap()[x][y].setRobot(null);
		world.getMap()[x][Math.abs(y-1)].setRobot(this);
		this.y-=1;
	}
	
	public void moveRobotDownOneStep() {
		world.getMap()[x][y].setRobot(null);
		world.getMap()[x][(y+1)].setRobot(this);
		this.y+=1;
	}
}
