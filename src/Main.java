import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Graphics g = new Graphics(768, 768);
//		World world = new World(g);
//		world.initWorld();
//		Robot[] robots = new Robot[5];
//		robots[0]=world.getRobotY();
//		robots[1]=world.getRobotS();
//		robots[2]=world.getRobotB();
//		robots[3]=world.getRobotR();
//		robots[4]=world.getRobotG();
//		Random rand = new Random();
//		double n= 100000000;
//		
//		g.drawBackground();
//		world.drawWorld();
		
//		double count=0;
//		for (int i=0; i<n; i++) {
//			int r = rand.nextInt(4);
//			int d = rand.nextInt(4);
//			if(d==0) {
//				if (robots[r].moveRobotDown()) {
//					count++;
//				}
//			}
//			else if(d==1) {
//				if (robots[r].moveRobotUp()) {
//					count++;
//				}
//			} 
//			else if(d==2) {
//				if (robots[r].moveRobotLeft()) {
//					count++;
//				}
//			} 
//			else if(d==3) {
//				if (robots[r].moveRobotRight()) {
//					count++;
//				}
//			}
//			
//		}
//		double kvot = 4*count/n;
//		System.out.println(kvot);
		
//		double count = 0;
//		
//		
//		for (int i=0; i<n; i++) {
//			for (int r=0; r<4; r++) {
//				
//				int x = robots[r].getX();
//				int y = robots[r].getY();
//				String s = world.getMap()[x][y].getString();
//				boolean canLeave = false;
//				
//				if (s != "north" & s != "north-east" & s != "north-west" & s != "north-south"
//						& world.getMap()[(x)][Math.abs(y-1)].getRobot() == null) {
//					count++;
//					canLeave = true;
//				}
//				
//				if (s != "south" & s != "south-west" & s != "south-east" & s != "north-south"
//						& world.getMap()[x][(y+1)%16].getRobot() == null) {
//					count++;
//					canLeave = true;
//				}
//			
//				if (s != "east" & s != "south-east" & s != "north-east" & s != "east-west"
//						& world.getMap()[(x + 1)%16][y].getRobot() == null) {
//					count++;
//					canLeave = true;
//				}
//				
//				if (s != "west" & s != "south-west" & s != "north-west" & s != "eastwest"
//						& world.getMap()[Math.abs(x - 1)][y].getRobot() == null) {
//					count++;
//					canLeave = true;
//				}
//				
//				
//				boolean loop = true;
//				
//				while (loop & canLeave) {
//					
//					loop = false;
//					int d = rand.nextInt(4);
//					
//					if(d==0) {
//						if (!robots[r].moveRobotDown()) {
//							loop = true;
//						}
//					}
//					else if(d==1) {
//						if (!robots[r].moveRobotUp()) {
//							loop = true;
//						}
//					} 
//					else if(d==2) {
//						if (!robots[r].moveRobotLeft()) {
//							loop = true;
//						}
//					} 
//					else if(d==3) {
//						if (!robots[r].moveRobotRight()) {
//							loop = true;
//						}
//					}
//				}
//				
//			}
//			
//		}
//		
//		double svar = count / (n * 4);
//		
//		System.out.println(svar);
		
		
		
		
		
		//g.drawBackground();
		World world = new World(g);
		

		Game game = new Game(g, world);
		Text text = new Text(g);
		text.setSpace(5,3);
		text.basic("riccochet", 362, 374, Colors.YELLOW, 1);
		text.basic("robots", 370, 385, Colors.YELLOW, 1);
		
		world.initWorld();
		//world.drawWorld();

		
		
		
		// BEHÖVS DETTA FÖR ATT COLORMAP SKA FUNKA?
		
//		System.out.println();
//		
//		for (int y = 0; y < 16; y++) {
//			for (int x = 0; x < 16; x++) {
//				world.map[x][y].updateWallString();
//				//System.out.print(world.map[x][y].getString() + " ");
//				System.out.print("(" + world.map[x][y].getX() + ", " + world.map[x][y].getY() + ") ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
//		
//		
//		
//		
//		
//		
//		
		Colormap cM = new Colormap(world);
			
		int max = cM.run(0, 0, 20);
		
		cM.printMatrix();
		System.out.println(max);
		
		
		
		
		while (true) {
			g.drawBackground();
			text.setSpace(5,3);
			text.basic("riccochet", 362, 374, Colors.YELLOW, 1);
			text.basic("robots", 370, 385, Colors.YELLOW, 1);
		
			//world.initWorld();
			world.drawWorld();
			game.run();
		}
		
		
		
		
		
		
		
//		while (true) {
//			g.drawBackground();
//			World world = new World(g);
//			Game game = new Game(g, world);
//			Text text = new Text(g);
//			text.setSpace(5,3);
//			text.basic("riccochet", 362, 374, Colors.YELLOW, 1);
//			text.basic("robots", 370, 385, Colors.YELLOW, 1);
//			
//			world.initWorld();
//			world.drawWorld();
//			game.run();
//		}

	}
}
