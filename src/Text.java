import java.awt.Color;
public class Text {

	
	Graphics g;
	int mellanslag = 3;
	int mellanbokstav = 1;
	
	public Text(Graphics g) {
		this.g = g;
	}
	public void setSpace(int mellanslag, int mellanbokstav) {
		this.mellanslag=mellanslag;
		this.mellanbokstav=mellanbokstav;
	}
	//skriver ut texten s i simplewindow med övre vänstra hörnet i (x,y) och med färgen color och blockstorleken side
	
	
	public void basic(String s, int x, int y, Color color, int side){
		int l = s.length();
		for (int i=0; i<l; i++) {
			char c = s.charAt(i);
			this.drawLetter(c, x, y, side, color);
			x+=mellanbokstav*side+side*this.getWidth(c);
		}
	}
	


	

	public void drawLetter(char c, int x, int y, int side, Color color) {
		if (c == 'a') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listA[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '.') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 1; j++) {
					if (listDot[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'b') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listB[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'c') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listC[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'd') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listD[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'e') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listE[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'f') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listF[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'g') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listG[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'h') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listH[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'i') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 1; j++) {
					if (listI[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'j') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listJ[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'k') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listK[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'l') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (listL[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'm') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (listM[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'n') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listN[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'o') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listO[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'p') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listP[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'q') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listQ[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'r') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listR[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 's') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listS[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 't') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (listT[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'u') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listU[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'v') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (listV[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'w') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (listW[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'x') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (listX[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'y') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (listY[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == 'z') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (listZ[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '!') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 1; j++) {
					if (listUtrop[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '?') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (listFråge[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '0') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (list0[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '1') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (list1[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '2') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (list2[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '3') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (list3[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '4') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (list4[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '5') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (list5[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '6') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (list6[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '7') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (list7[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '8') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (list8[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		} else if (c == '9') {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					if (list9[j][i] == 1) {
						g.square(x + j * side, y + i * side, side, color);
					}
				}
			}
		}
	}

	public int getWidth(char c) {
			if (c == 'a') {
				return listA.length;
			} else if (c == 'b') {
				return listB.length;
			} else if (c == 'c') {
				return listC.length;
			} else if (c == 'd') {
				return listD.length;
			} else if (c == 'e') {
				return listE.length;
			} else if (c == 'f') {
				return listF.length;
			} else if (c == 'g') {
				return listG.length;
			} else if (c == 'h') {
				return listH.length;
			} else if (c == 'i') {
				return listI.length;
			} else if (c == 'j') {
				return listJ.length;
			} else if (c == 'k') {
				return listK.length;
			} else if (c == 'l') {
				return listL.length;
			} else if (c == 'm') {
				return listM.length;
			} else if (c == 'n') {
				return listN.length;
			} else if (c == 'o') {
				return listO.length;
			} else if (c == 'p') {
				return listP.length;
			} else if (c == 'q') {
				return listQ.length;
			} else if (c == 'r') {
				return listR.length;
			} else if (c == 's') {
				return listS.length;
			} else if (c == 't') {
				return listT.length;
			} else if (c == 'u') {
				return listU.length;
			} else if (c == 'v') {
				return listV.length;
			} else if (c == 'w') {
				return listW.length;
			} else if (c == 'x') {
				return listX.length;
			} else if (c == 'y') {
				return listY.length;
			} else if (c == 'z') {
				return listZ.length;
			} else if (c == '!') {
				return listUtrop.length;
			} else if (c == '?') {
				return listFråge.length;
			} else if (c == '0') {
				return list0.length;
			} else if (c == '1') {
				return list1.length;
			} else if (c == '2') {
				return list2.length;
			} else if (c == '3') {
				return list3.length;
			} else if (c == '4') {
				return list4.length;
			} else if (c == '5') {
				return list5.length;
			} else if (c == '6') {
				return list6.length;
			} else if (c == '7') {
				return list7.length;
			} else if (c == '8') {
				return list8.length;
			} else if (c == '9') {
				return list9.length;
		    } else if (c == ' ') {
		    	return mellanslag;
		    } else if (c == '.') {
		    	return listDot.length;
		    }
		return 1;
	}
	
int[][] listA = { {0,1,1,1,1}, {1,0,1,0,0}, {1,0,1,0,0}, {0,1,1,1,1} };
int[][] listB = { {1,1,1,1,1}, {1,0,1,0,1}, {1,0,1,0,1}, {0,1,0,1,0} };
int[][] listC = { {0,1,1,1,0}, {1,0,0,0,1}, {1,0,0,0,1}, {1,0,0,0,1} };
int[][] listD = { {1,1,1,1,1}, {1,0,0,0,1}, {1,0,0,0,1}, {0,1,1,1,0} };
int[][] listE = { {1,1,1,1,1}, {1,0,1,0,1}, {1,0,1,0,1}, {1,0,0,0,1} };
int[][] listF = { {1,1,1,1,1}, {1,0,1,0,0}, {1,0,1,0,0}, {1,0,0,0,0} };
int[][] listG = { {0,1,1,1,0}, {1,0,0,0,1}, {1,0,1,0,1}, {1,0,1,1,1} };
int[][] listH = { {1,1,1,1,1}, {0,0,1,0,0}, {0,0,1,0,0}, {1,1,1,1,1} };
int[][] listI = { {1,1,1,1,1}, };
int[][] listJ = { {0,0,0,1,0}, {0,0,0,0,1}, {0,0,0,0,1}, {1,1,1,1,0} };
int[][] listK = { {1,1,1,1,1}, {0,0,1,0,0}, {0,1,0,1,0}, {1,0,0,0,1} };
int[][] listL = { {1,1,1,1,1}, {0,0,0,0,1}, {0,0,0,0,1}};
int[][] listM = { {1,1,1,1,1}, {0,1,0,0,0}, {0,0,1,0,0}, {0,1,0,0,0},{1,1,1,1,1} };
int[][] listN = { {1,1,1,1,1}, {0,1,0,0,0}, {0,0,1,0,0}, {1,1,1,1,1} };
int[][] listO = { {0,1,1,1,0}, {1,0,0,0,1}, {1,0,0,0,1}, {0,1,1,1,0} };
int[][] listP = { {1,1,1,1,1}, {1,0,1,0,0}, {1,0,1,0,0}, {0,1,0,0,0} };
int[][] listQ = { {0,1,1,1,0}, {1,0,0,0,1}, {1,0,0,1,1}, {0,1,1,1,1} };
int[][] listR = { {1,1,1,1,1}, {1,0,1,0,0}, {1,0,1,1,0}, {0,1,0,0,1} };
int[][] listS = { {0,1,0,0,1}, {1,0,1,0,1}, {1,0,1,0,1}, {1,0,0,1,0} };
int[][] listT = { {1,0,0,0,0}, {1,1,1,1,1}, {1,0,0,0,0} };
int[][] listU = { {1,1,1,1,1}, {0,0,0,0,1}, {0,0,0,0,1}, {1,1,1,1,1} };
int[][] listV = { {1,1,1,1,0}, {0,0,0,0,1}, {1,1,1,1,0} };
int[][] listW = { {1,1,1,1,0}, {0,0,0,0,1}, {0,0,0,1,0}, {0,0,0,0,1}, {1,1,1,1,0} };
int[][] listX = { {1,1,0,1,1}, {0,0,1,0,0}, {1,1,0,1,1}, };
int[][] listY = { {1,1,1,0,0}, {0,0,1,1,1}, {1,1,1,0,0}, };
int[][] listZ = { {1,0,0,0,1}, {1,0,0,1,1}, {1,0,1,0,1}, {1,1,0,0,1} };
int[][] listUtrop = { {1,1,1,0,1} };
int[][] listFråge = { {1,0,1,0,1}, {1,0,1,0,0}, {0,1,0,0,0} };
int[][] list0 = { {0,1,1,1,0}, {1,0,0,0,1}, {0,1,1,1,0} };
int[][] list1 = { {0,1,0,0,1}, {1,1,1,1,1}, {0,0,0,0,1} };
int[][] list2 = { {1,0,0,1,1}, {1,0,1,0,1}, {0,1,1,0,1} };
int[][] list3 = { {1,0,1,0,1}, {1,0,1,0,1}, {0,1,0,1,0} };
int[][] list4 = { {0,0,1,1,0}, {0,1,0,1,0}, {1,1,1,1,1}, {0,0,0,1,0} };
int[][] list5 = { {1,1,1,0,1}, {1,0,1,0,1}, {1,0,0,1,0} };
int[][] list6 = { {0,1,1,1,0}, {1,0,1,0,1}, {1,0,1,0,1}, {0,0,0,1,0}  };
int[][] list7 = { {1,1,0,0,0}, {1,0,0,0,0}, {1,1,1,1,1} };
int[][] list8 = { {0,1,0,1,0}, {1,0,1,0,1}, {1,0,1,0,1}, {0,1,0,1,0} };
int[][] list9 = { {0,1,0,0,0}, {1,0,1,0,1}, {1,0,1,0,1}, {0,1,1,1,0} };
int[][] listDot = { {0,0,0,0,1} };
	
}