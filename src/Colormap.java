import java.util.ArrayList;

public class Colormap {

	World world;

	int[][] matris = new int[16][16];

	int max; // högsta steget som har tagit med stepcounter (högsta värdet i matrisen som
				// inte är 30), nollställs när man kör run.

	public Colormap(World world) {

		this.world = world;

	}

	public int[][] getMatrix() {

		return matris;

	}

	public int run(int x, int y, int n) {

		max = 0;

		for (int i = 0; i < 16; i++) {

			for (int k = 0; k < 16; k++) {

				matris[i][k] = 20;

			}

		}

		ArrayList<Integer> pointsX = new ArrayList<Integer>();

		ArrayList<Integer> pointsY = new ArrayList<Integer>();

		ArrayList<Integer> previousDirection = new ArrayList<Integer>();

		pointsX.add(x);

		pointsY.add(y);

		previousDirection.add(10);

		matris[y][x] = 0;

		for (int i = 1; i <= n; i++) {

			int length = pointsX.size();

			ArrayList<Integer> currentPointsY = new ArrayList<Integer>();

			for (int h = 0; h < length; h++) {

				currentPointsY.add(pointsY.get(h));

			}

			ArrayList<Integer> currentPointsX = new ArrayList<Integer>();

			for (int h = 0; h < length; h++) {

				currentPointsX.add(pointsX.get(h));

			}

			ArrayList<Integer> currentDirections = new ArrayList<Integer>();

			for (int h = 0; h < length; h++) {

				currentDirections.add(previousDirection.get(h));

			}

			previousDirection.clear();

			pointsY.clear();

			pointsX.clear();

			ArrayList<Integer> help = new ArrayList<Integer>();

			for (int j = 0; j < currentPointsX.size(); j++) {

				int xj = currentPointsX.get(j);

				int yj = currentPointsY.get(j);

				int d = currentDirections.get(j);

				String s = world.getMap()[xj][yj].getString();
				boolean[] walls = world.getMap()[xj][yj].getWalls();

				if ((walls[0]) & d != 0) { //if ((s == "north" || s == "north-west" || s == "north-south" || s == "north-east") & d != 0) {

					help = this.south(xj, yj, i);

					for (int ö = 0; ö < help.size() - 1; ö += 2) {

						pointsX.add(help.get(ö));

						pointsY.add(help.get(ö + 1));

						previousDirection.add(1);

					}

				}

				if ((walls[2]) & d != 1) { //s == "south" || s == "south-west" || s == "north-south" || s == "south-east"

					help = this.north(xj, yj, i);

					for (int ö = 0; ö < help.size() - 1; ö += 2) {

						pointsX.add(help.get(ö));

						pointsY.add(help.get(ö + 1));

						previousDirection.add(0);

					}

				}

				if ((walls[1]) & d != 2) { //(s == "east" || s == "north-east" || s == "south-east" || s == "east-west")

					help = this.west(xj, yj, i);

					for (int ö = 0; ö < help.size() - 1; ö += 2) {

						pointsX.add(help.get(ö));

						pointsY.add(help.get(ö + 1));

						previousDirection.add(3);

					}

				}

				if (walls[3] & d != 3) { //(s == "west" || s == "north-west" || s == "south-west" || s == "east-west")

					help = this.east(xj, yj, i);

					for (int ö = 0; ö < help.size() - 1; ö += 2) {

						pointsX.add(help.get(ö));

						pointsY.add(help.get(ö + 1));

						previousDirection.add(2);

					}

				}

			}

		}

		return max;

	}

	private ArrayList<Integer> south(int x, int y, int stepCounter) {

		int x1 = x;

		int y1 = y;

		ArrayList<Integer> xyvalues = new ArrayList<Integer>();

		String s = world.getMap()[x][y].getString();
		boolean[] walls = world.getMap()[x][y].getWalls();

		while (!walls[2]) { //s != "south" & s != "south-west" & s != "south-east" & s != "north-south"

			y1 += 1;

			xyvalues.add(x1);

			xyvalues.add(y1);

			if (matris[y1][x1] == 20) {

				matris[y1][x1] = stepCounter;

				max = stepCounter;

			}

			s = world.getMap()[x1][y1].getString();
			walls = world.getMap()[x1][y1].getWalls();

		}

		return xyvalues;

	}

	private ArrayList<Integer> north(int x, int y, int stepCounter) {

		int x1 = x;

		int y1 = y;

		ArrayList<Integer> xyvalues = new ArrayList<Integer>();

		String s = world.getMap()[x][y].getString();
		boolean[] walls = world.getMap()[x][y].getWalls();

		while (!walls[0]) { //s != "north" & s != "north-west" & s != "north-east" & s != "north-south"

			y1 -= 1;

			xyvalues.add(x1);

			xyvalues.add(y1);

			if (matris[y1][x1] == 20) {

				matris[y1][x1] = stepCounter;

				max = stepCounter;

			}

			s = world.getMap()[x1][y1].getString();
			walls = world.getMap()[x1][y1].getWalls();

		}

		return xyvalues;

	}

	private ArrayList<Integer> west(int x, int y, int stepCounter) {

		int x1 = x;

		int y1 = y;

		ArrayList<Integer> xyvalues = new ArrayList<Integer>();

		String s = world.getMap()[x][y].getString();
		boolean[] walls = world.getMap()[x][y].getWalls();

		while (!walls[3]) { //s != "west" & s != "south-west" & s != "north-west" & s != "east-west"

			x1 -= 1;

			xyvalues.add(x1);

			xyvalues.add(y1);

			if (matris[y1][x1] == 20) {

				matris[y1][x1] = stepCounter;

				max = stepCounter;

			}

			s = world.getMap()[x1][y1].getString();
			walls = world.getMap()[x1][y1].getWalls();

		}

		return xyvalues;

	}

	private ArrayList<Integer> east(int x, int y, int stepCounter) {

		int x1 = x;

		int y1 = y;

		ArrayList<Integer> xyvalues = new ArrayList<Integer>();

		String s = world.getMap()[x][y].getString();
		boolean[] walls = world.getMap()[x][y].getWalls();

		while (!walls[1]) { //s != "east" & s != "south-east" & s != "north-east" & s != "east-west"

			x1 += 1;

			xyvalues.add(x1);

			xyvalues.add(y1);

			if (matris[y1][x1] == 20) {

				matris[y1][x1] = stepCounter;

				max = stepCounter;

			}

			s = world.getMap()[x1][y1].getString();
			walls = world.getMap()[x1][y1].getWalls();

		}

		return xyvalues;

	}

	public void printMatrix() {

		System.out.print("[");

		for (int r = 0; r < 16; r++) {

			for (int c = 0; c < 16; c++) {

				if (c != 15) {

					System.out.print(matris[r][c] + " ");

				} else if (r != 15) {

					System.out.println(matris[r][c] + ";");

				} else {

					System.out.print(matris[r][c] + "]");

				}

			}

		}
		
		System.out.println();

	}

}