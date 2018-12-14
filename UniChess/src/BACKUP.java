
//public class BACKUP {
//	import java.awt.Color;
//	import java.awt.Graphics;
//	import java.awt.Graphics2D;
//	import java.awt.Point;
//	import java.awt.event.MouseEvent;
//	import java.awt.event.MouseListener;
//	import java.awt.event.MouseMotionListener;
//	import java.awt.geom.Line2D;
//	import java.awt.geom.Rectangle2D;
//	import java.awt.image.BufferedImage;
//	import java.io.File;
//	import java.io.IOException;
//	import java.util.ArrayList;
//	import java.util.Arrays;
//	import java.util.HashMap;
//	import java.util.List;
//	import java.util.Map;
//
//	import javax.imageio.ImageIO;
//	import javax.swing.JComponent;
//
//	public class Board extends JComponent implements MouseMotionListener, MouseListener {
//		List<Rectangle2D> allPiecePositions = new ArrayList<>();
//		List<Rectangle2D> blackPiecePositions = new ArrayList<>();
//		List<Rectangle2D> whitePiecePositions = new ArrayList<>();
//		Map<String, BufferedImage> WhitePieces = new HashMap<>();
//		Map<String, BufferedImage> BlackPieces = new HashMap<>();
//		List<BufferedImage> imageList = new ArrayList<>();
//		List<String> pieceOrder = new ArrayList<>();
//		Color redHighlight = new Color(255,0,0,90);
//		BufferedImage whiteKing;
//		BufferedImage whiteRook;
//		BufferedImage whitePawn;
//		BufferedImage whiteKnight;
//		BufferedImage whiteBishop;
//		BufferedImage whiteQueen;
//		BufferedImage blackKing;
//		BufferedImage blackRook;
//		BufferedImage blackPawn;
//		BufferedImage blackKnight;
//		BufferedImage blackBishop;
//		BufferedImage blackQueen;
//		Pawn aPawnW;
//		Pawn bPawnW;
//		Pawn cPawnW;
//		Pawn dPawnW;
//		Pawn ePawnW;
//		Pawn fPawnW;
//		Pawn gPawnW;
//		Pawn hPawnW;
//		Pawn aPawnB;
//		Pawn bPawnB;
//		Pawn cPawnB;
//		Pawn dPawnB;
//		Pawn ePawnB;
//		Pawn fPawnB;
//		Pawn gPawnB;
//		Pawn hPawnB;
//		Rook aRookW;
//		Rook hRookW;
//		Rook aRookB;
//		Rook hRookB;
//		Queen QueenW;
//		Queen QueenB;
//		int lastMouseClick;
//		int lastI;
//		int lastJ;
//		Pieces pieceLogic = new Pieces();
//		Pieces[][]	pieceArray;
//		public Board() {
//			this.piecePositions();
//			whiteKing = WhitePieces.get("King");
//			whiteRook = WhitePieces.get("Rook");
//			whitePawn = WhitePieces.get("Pawn");
//			whiteKnight = WhitePieces.get("Knight");
//			whiteBishop = WhitePieces.get("Bishop");
//			whiteQueen = WhitePieces.get("Queen");
//			blackKing = BlackPieces.get("King");
//			blackRook = BlackPieces.get("Rook");
//			blackPawn = BlackPieces.get("Pawn");
//			blackKnight = BlackPieces.get("Knight");
//			blackBishop = BlackPieces.get("Bishop");
//			blackQueen = BlackPieces.get("Queen");
//			
//			
//			aPawnW = new Pawn("White");
//			bPawnW = new Pawn("White");
//			cPawnW = new Pawn("White");
//			dPawnW = new Pawn("White");
//			ePawnW = new Pawn("White");
//			fPawnW = new Pawn("White");
//			gPawnW = new Pawn("White");
//			hPawnW = new Pawn("White");
//			aPawnB = new Pawn("Black");
//			bPawnB = new Pawn("Black");
//			cPawnB = new Pawn("Black");
//			dPawnB = new Pawn("Black");
//			ePawnB = new Pawn("Black");
//			fPawnB = new Pawn("Black");
//			gPawnB = new Pawn("Black");
//			
//			aRookW = new Rook("White");
//			hRookW = new Rook("White");
//			aRookB = new Rook("Black");
//			hRookB = new Rook("Black");
//			
//			QueenW = new Queen("White");
//			QueenB = new Queen("Black");
//			
//			imageList.addAll(Arrays.asList(whiteKing,whiteRook,whitePawn
//					,whiteKnight,whiteBishop,whiteQueen,blackKing,blackRook,blackPawn,blackKnight,
//					blackBishop,blackQueen));
//			pieceArray = new Pieces[][]{ {aRookB, null,null,QueenB, null,null,null,hRookB},
//										 {aPawnB, bPawnB,cPawnB,dPawnB, ePawnB,fPawnB,gPawnB,hPawnB},
//										 {null, null,null,null, null,null,null,null},
//										 {null, null,null,null, null,null,null,null},
//										 {null, null,null,null, null,null,null,null},
//										 {null, null,null,null, null,null,null,null},
//										 {aPawnW, bPawnW,cPawnW,dPawnW, ePawnW,fPawnW,gPawnW,hPawnW},
//										 {aRookW, null,null,QueenW,null,null,null,hRookW}
//									  }; 
//
//		}
//		public void piecePositions() {
//			
//			pieceOrder.addAll(Arrays.asList("Rook","Bishop","Queen","King","Knight","Pawn"));
//		
//			
//			BufferedImage imageToSplice = getImage(0);
//			
//			int WIDTH = imageToSplice.getWidth();
//			int HEIGHT = imageToSplice.getHeight();
//			
//			
//			for(int i = 0; i < 6; i++) {
//				BlackPieces.put(pieceOrder.get(i),imageToSplice.getSubimage(
//						(WIDTH/6)*i, 0, WIDTH/6, HEIGHT/2) );
//
//			}
//			for(int j = 0; j< 6; j++) {
//				WhitePieces.put(pieceOrder.get(j),imageToSplice.getSubimage(
//						(WIDTH/6)*j, HEIGHT/2, WIDTH/6, HEIGHT/2));
//				
//			}
//		}
//		int[][] boardArray = new int[][]{ {0,2,3,4,5,3,2,1}, 
//										  {6,6,6,6,6,6,6,6},
//										  {0,0,0,0,0,0,0,0},
//										  {0,0,0,0,0,0,0,0},
//										  {0,0,0,0,0,0,0,0},
//										  {0,0,0,0,0,0,0,0},
//										  {-6,-6,-6,-6,-6,-6,-6,-6},
//										  {-1,-2,-3,-4,-5,-3,-2,-1}
//										  }; 
//
//		
//		
//		Rectangle2D rectClickedOn = new Rectangle2D.Double(-100,-100, -100, -100);
//		Rectangle2D rectToHighlight = new Rectangle2D.Double(-100,-100, -100, -100);
//		public List<Rectangle2D> allRectangles = new ArrayList<>();
//		Color color;
//		int x = 0;
//		int y = 0;
//		public void changeColor() {
//			color = color == Color.WHITE ? Color.GRAY : Color.WHITE;
//		}
//		int WIDTH = 600;
//		int HEIGHT = 600;
//		Color colorToUse = Color.RED;
//		boolean clickedAlreadyWhite= false;
//		boolean clickedAlreadyBlack = false;
//		boolean canMove = false;
//		boolean canMoveLogic = false;
//		Line2D checkForIntersection = new Line2D.Double();
//		String turn = "white";
//		
//		double lastX;
//		double lastY;
//		public void paint(Graphics g) {
//			
//			
//			
//			Graphics2D g2 = (Graphics2D) g;
//			//Draw The Board
//			
//			
//			int k = 0;
//			x = 0;
//			y = 0;
//			for(int i = 0; i <boardArray.length; i++) {
//
//				for(int j = 0; j<boardArray[i].length; j++) {
//					
//					changeColor();
//					g2.setColor(color);
//					Rectangle2D rect = new Rectangle2D.Double(x,y,80,80);
//					allRectangles.add(rect);
//					
//					if(rect.getX() == rectToHighlight.getX()&&rect.getY() == rectToHighlight.getY()) {
//						g2.setColor(redHighlight);
//						
//					}
//					//Black Piece Movement
//					if(turn == "black") {
//						
//					if(rect.getX() == rectClickedOn.getX()&&rect.getY() == rectClickedOn.getY()) {
//						g2.setColor(Color.RED);
//						
//						if(boardArray[i][j] > 0) {
//							lastMouseClick = boardArray[i][j];
//							
//							lastI = i;
//							lastJ = j;
//							lastX = rect.getCenterX();
//							lastY = rect.getCenterY();
//							clickedAlreadyBlack = true;
//						}
//						
//						else if(clickedAlreadyBlack) {
//							canMove = true;
//							canMoveLogic = pieceLogic.checkLegalMove(lastI,lastJ,i,j,lastMouseClick,boardArray);
//							checkForIntersection = new Line2D.Double(lastX,lastY+12,
//									rect.getCenterX(),rect.getCenterY());
//							for(Rectangle2D r: blackPiecePositions) {
//								if(checkForIntersection.intersects(r)){
//									canMove = false;
//								}
//							}
//							if(canMove && canMoveLogic) {
//							boardArray[i][j] = lastMouseClick;
//							boardArray[lastI][lastJ] = 0;
//							clickedAlreadyBlack = false;
//							allPiecePositions.clear();
//							blackPiecePositions.clear();
//							rectClickedOn =  new Rectangle2D.Double(-100,-100, -100, -100);
//							turn = "white";
//							}
//							else clickedAlreadyBlack = false;
//						}
//					}
//					}
//					if(turn == "white") {
//					if(rect.getX() == rectClickedOn.getX()&&rect.getY() == rectClickedOn.getY()) {
//						
//						g2.setColor(Color.RED);
//						
//						if(boardArray[i][j] < 0) {
//							lastMouseClick = boardArray[i][j];
//							lastI = i;
//							lastJ = j;
//							lastX = rect.getCenterX();
//							lastY = rect.getCenterY();
//							clickedAlreadyWhite = true;
//							
//						}
//						
//						else if(clickedAlreadyWhite) {
//							canMove = true;
//							canMoveLogic = pieceLogic.checkLegalMove(lastI,lastJ,i,j,lastMouseClick,boardArray);
//							checkForIntersection = new Line2D.Double(lastX,lastY-12,
//									rect.getCenterX(),rect.getCenterY());
//							for(Rectangle2D r: whitePiecePositions) {
//								if(checkForIntersection.intersects(r)){
//									canMove = false;
//								}
//							}
//							blackPiecePositions.remove(rect);
//							
//							for(Rectangle2D r: blackPiecePositions) {
//								if(checkForIntersection.intersects(r)){
//									canMove = false;
//								}
//							}
//							System.out.println(canMoveLogic + " " + canMove);
//							
//							if(canMove && canMoveLogic) {
//								boardArray[i][j] = lastMouseClick;
//								boardArray[lastI][lastJ] = 0;
//								clickedAlreadyWhite = false;
//								allPiecePositions.clear();
//								whitePiecePositions.clear();
//								rectClickedOn =  new Rectangle2D.Double(-100,-100, -100, -100);
//								turn = "black";
//								
//							}
//							
//							else clickedAlreadyWhite = false;
//						}
//					}
//					}
//					
//					g2.draw(rect);
//					g2.fill(rect);
//					g2.draw(checkForIntersection);
//					for(Rectangle2D r: allPiecePositions) {
//						g2.draw(r);
//					}
//					if(boardArray[i][j] < 0) {
//						allPiecePositions.add(new Rectangle2D.Double(rect.getCenterX()-10,rect.getCenterY()-10,20,20));
//						whitePiecePositions.add(new Rectangle2D.Double(rect.getCenterX()-10,rect.getCenterY()-10,20,20));
//					}
//					if(boardArray[i][j] > 0) {
//						allPiecePositions.add(new Rectangle2D.Double(rect.getCenterX()-10,rect.getCenterY()-10,20,20));
//						blackPiecePositions.add(new Rectangle2D.Double(rect.getCenterX()-10,rect.getCenterY()-10,20,20));
//					}
//					if(pieceArray[i][j]!= null) {
//						g2.drawImage(pieceArray[i][j].getPicture(),(int)rect.getX()+3,(int)rect.getY()-4,this);
//					}
//					
////					switch(boardArray[i][j]){
////					case 0:
////						break;
////					case -6:
////						g2.drawImage(whitePawn, (int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case 6:
////						g2.drawImage(blackPawn, (int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case -1:
////						g2.drawImage(whiteRook,(int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case -2:
////						g2.drawImage(whiteKnight,  (int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case -3:
////						g2.drawImage(whiteBishop, (int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case -4:
////						g2.drawImage(whiteQueen, (int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case -5:
////						g2.drawImage(whiteKing, (int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case 1:
////						g2.drawImage(blackRook,(int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case 2:
////						g2.drawImage(blackKnight,  (int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case 3:
////						g2.drawImage(blackBishop, (int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case 4:
////						g2.drawImage(blackQueen, (int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					case 5:
////						g2.drawImage(blackKing, (int)rect.getX()+3,(int)rect.getY()-4,this);
////						break;
////					}
//
//					
//					x += 80;
//					if(x >= 600) {
//						changeColor();
//						y+=80;
//						x = 0;
//					}
//
//				}
//			}
//		}
//				
//			
//			
//		public void changeColorMouse(Rectangle2D rect) {
//			rectToHighlight = rect;
//		}
//		
//		/*
//		 * returns the image of pieces or board
//		 * @param use 0 to get the picture of pieces
//		 * use 1 to get picture of board
//		 */
//		private BufferedImage getImage(int l){
//			
//			String path;
//			BufferedImage imageOfAllPieces = null;
//			if(l == 0) {
//				 path = "src/pieces4.png";
//			}
//			else path = "src/board.png";
//			try {
//			    imageOfAllPieces = ImageIO.read(new File(path));
//			    
//			} catch (IOException e) {
//			}
//			return imageOfAllPieces;
//			
//			}
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			
//
//		}
//		@Override
//		public void mousePressed(MouseEvent e) {
//			this.repaint();
//			for(Rectangle2D rect: this.allRectangles) {
//				if(rect.contains(e.getX(), e.getY())) {
//					this.repaint();
//					rectClickedOn = rect;
//					
//				}
//			}
//			
//		}
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			this.repaint();
//			
//		}
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void mouseDragged(MouseEvent e) {
//			this.repaint();
//			for(Rectangle2D rect: this.allRectangles) {
//				if(rect.contains(e.getX(), e.getY())) {
//					this.repaint();
//					rectClickedOn = rect;
//					
//				}
//			}
//			
//		}
//		@Override
//		public void mouseMoved(MouseEvent j) {
//			this.repaint();
//			for(Rectangle2D rect: this.allRectangles) {
//				if(rect.contains(j.getX(), j.getY())) {
//					this.changeColorMouse(rect);
//					
//				}
//			}
//			
//		}
//		public String getTurn() {
//			return this.turn;
//		}
//
//
//
//
//	}
//}
