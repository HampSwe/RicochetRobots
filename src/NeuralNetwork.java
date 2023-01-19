//
//import java.io.DataOutputStream;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.PrintStream;
//import java.util.Random;
//
//public class NeuralNetwork {
//
//	World world;
//
//	// för en given bana; den givna banan
//	public double[][] tilevaluesyellow = new double[16][16];
//	public double[][] compensator = new double[16][16];
//
//	// 1-5 bestämmer vilken robot som rör sig (röd, grön, blå, gul eller svart) och
//	// sen har vi riktning (norr, öster, söder, väst, ingen alls)
//	public double[] outputneurons = new double[10];
//
//	// x och y koordinat för dena röda, gröna, blåa, gula och svarta roboten i den
//	// ämnda ordningen
//	public double[] inputneurons = new double[10];
//
//	public double[] firstlayer = new double[20];
//	public double[] secondlayer = new double[20];
//
//	// första 10 är input, nästa 20 firstlayer, nästa 20 är secondlayer ochsista 10
//	// är output
//	// sista är output
//	public double[] neuronbase = new double[60];
//
//	public double[][] weights1 = new double[10][20];
//	public double[][] weights2 = new double[20][20];
//	public double[][] weights3 = new double[20][10];
//
//	Random rand = new Random();
//
//	public NeuralNetwork(World world) {
//		this.world = world;
//	}
//
//	public void run() {
//		int bestValue = -64;
//		for (int j = 0; j < 100; j++) {
//			this.initializeBrain();
//
//			for (int i = 0; i < 10; i++) {
//				this.setInputNeurons(world.getRobotR().getX(), world.getRobotR().getY(), world.getRobotG().getX(),
//						world.getRobotG().getY(), world.getRobotB().getX(), world.getRobotB().getY(),
//						world.getRobotY().getX(), world.getRobotY().getY(), world.getRobotS().getX(),
//						world.getRobotS().getY());
//				this.calculateNeurons();
//				this.useOutPut(world);
//			}
//			int x = world.getRobotY().getX();
//			int y = world.getRobotY().getY();
//			if (tilevaluesyellow[x][y]>bestValue) {
//				
//			}
//		}
//	}
//
//	public void initializeBrain() {
//		this.initializeWeights(1);
//		this.initializeNeuronBase(2);
//		this.setTileValues();
//
//	}
//
//	public void calculateNeurons() {
//		this.calculateFirstLayer();
//		this.calculateSecondLayer();
//		this.calculateOutputNeurons();
//	}
//
//	public void useOutPut(World world) {
//		int color = 4;
//		int direction = 9;
//		for (int i = 0; i < 4; i++) {
//			if (outputneurons[i] > outputneurons[color]) {
//				color = i;
//			}
//		}
//		for (int i = 0; i < 4; i++) {
//			if (outputneurons[i + 5] > outputneurons[direction]) {
//				direction = i + 5;
//			}
//		}
//
//		Robot robot = world.getRobotR();
//
//		if (color == 1) {
//			robot = world.getRobotG();
//		} else if (color == 2) {
//			robot = world.getRobotB();
//		} else if (color == 3) {
//			robot = world.getRobotY();
//		} else {
//			robot = world.getRobotS();
//		}
//
//		if (direction == 5) {
//			robot.moveRobotUp();
//		} else if (direction == 6) {
//			robot.moveRobotRight();
//		} else if (direction == 7) {
//			robot.moveRobotDown();
//		} else if (direction == 8) {
//			robot.moveRobotLeft();
//		}
//
//	}
//
//	public void setInputNeurons(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5) {
//		inputneurons[0] = x1;
//		inputneurons[1] = y1;
//		inputneurons[2] = x2;
//		inputneurons[3] = y2;
//		inputneurons[4] = x3;
//		inputneurons[5] = y3;
//		inputneurons[6] = x4;
//		inputneurons[7] = y4;
//		inputneurons[8] = x5;
//		inputneurons[9] = y5;
//
//	}
//
//	public void setTileValues() {
//		for (int i = 0; i < 16; i++) {
//			for (int j = 0; j < 16; j++) {
//				compensator[i][j] = 0;
//			}
//		}
//
//		compensator[12][0] = 10;
//		compensator[12][1] = 100;
//		for (int i = 0; i < 13; i++) {
//			compensator[i][1] = 10;
//		}
//
//		for (int i = 0; i < 16; i++) {
//			for (int j = 0; j < 16; j++) {
//				tilevaluesyellow[i][j] = -Math.abs(i - 12) + -Math.abs(j - 1) + compensator[i][j];
//			}
//		}
//
//	}
//
//	public void initializeNeuronBase(int n) {
//
//		for (int j = 0; j < 60; j++) {
//			neuronbase[j] = rand.nextDouble(2 * n + 1) - n;
//		}
//
//	}
//
//	public void initializeWeights(int n) {
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 20; j++) {
//				weights1[i][j] = rand.nextDouble(2 * n + 1) - n;
//			}
//		}
//
//		for (int i = 0; i < 20; i++) {
//			for (int j = 0; j < 20; j++) {
//				weights2[i][j] = rand.nextDouble(2 * n + 1) - n;
//			}
//		}
//
//		for (int i = 0; i < 20; i++) {
//			for (int j = 0; j < 10; j++) {
//				weights3[i][j] = rand.nextDouble(2 * n) - n;
//			}
//		}
//	}
//
//	public void calculateFirstLayer() {
//		int l1 = firstlayer.length;
//		int l2 = inputneurons.length;
//		for (int j = 0; j < l1; j++) {
//			for (int i = 0; i < l2; i++) {
//				firstlayer[j] += inputneurons[i] * weights1[i][j];
//			}
//		}
//
//		for (int i = 0; i < l1; i++) {
//			firstlayer[i] = this.sigmoidF(firstlayer[i] + neuronbase[i + 10]);
//		}
//	}
//
//	public void calculateSecondLayer() {
//		int l1 = secondlayer.length;
//		int l2 = firstlayer.length;
//		for (int j = 0; j < l1; j++) {
//			for (int i = 0; i < l2; i++) {
//				secondlayer[j] += firstlayer[i] * weights2[i][j];
//			}
//		}
//
//		for (int i = 0; i < l1; i++) {
//			secondlayer[i] = this.sigmoidF(secondlayer[i] + neuronbase[i + 30]);
//		}
//	}
//
//	public void calculateOutputNeurons() {
//		int l1 = outputneurons.length;
//		int l2 = secondlayer.length;
//		for (int j = 0; j < l1; j++) {
//			for (int i = 0; i < l2; i++) {
//				outputneurons[j] += secondlayer[i] * weights3[i][j];
//			}
//		}
//
//		for (int i = 0; i < l1; i++) {
//			outputneurons[i] = this.sigmoidF(outputneurons[i] + neuronbase[i + 50]);
//		}
//	}
//	
//	public static void skriv() {
//		
//			  
//			    String strFilePath = "C:/Double.txt";
//			    FileOutputStream fos = new FileOutputStream(strFilePath);
//			    DataOutputStream dos = new DataOutputStream(fos);
//			    double d = 1;
//			    dos.writeDouble(d);
//			    dos.close();
//			
//		try {
//			PrintStream ps = new PrintStream(new File("weigths.txt"));
//			for (int i=0; i<20; i++) {
//				try {
//					ps.println(firstlayer[i]);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			
//			public double[] secondlayer = new double[20];
//
//			// första 10 är input, nästa 20 firstlayer, nästa 20 är secondlayer ochsista 10
//			// är output
//			// sista är output
//			public double[] neuronbase = new double[60];
//
//			public double[][] weights1 = new double[10][20];
//			public double[][] weights2 = new double[20][20];
//			public double[][] weights3 = new double[20][10];
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public double sigmoidF(double x) {
//		return 1 / (1 + Math.exp(-x));
//	}
//
//}
