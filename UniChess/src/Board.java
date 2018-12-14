import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Board extends JComponent implements MouseMotionListener, MouseListener {
	List<Rectangle2D> allPiecePositions = new ArrayList<>();
	List<Rectangle2D> blackPiecePositions = new ArrayList<>();
	List<Rectangle2D> whitePiecePositions = new ArrayList<>();
	List<Rectangle2D> rectanglesThatIntersect = new ArrayList<>();
	
	
	Map<String, BufferedImage> WhitePieces = new HashMap<>();
	Map<String, BufferedImage> BlackPieces = new HashMap<>();
	List<BufferedImage> imageList = new ArrayList<>();
	List<String> pieceOrder = new ArrayList<>();
	Color redHighlight = new Color(255,0,0,90);
	Pawn aPawnW;
	Pawn bPawnW;
	Pawn cPawnW;
	Pawn dPawnW;
	Pawn ePawnW;
	Pawn fPawnW;
	Pawn gPawnW;
	Pawn hPawnW;
	Pawn aPawnB;
	Pawn bPawnB;
	Pawn cPawnB;
	Pawn dPawnB;
	Pawn ePawnB;
	Pawn fPawnB;
	Pawn gPawnB;
	Pawn hPawnB;
	Rook aRookW;
	Rook hRookW;
	Rook aRookB;
	Rook hRookB;
	Queen QueenW;
	Queen QueenB;
	Bishop lightBishopB;
	Bishop darkBishopB;
	Bishop lightBishopW;
	Bishop darkBishopW;
	Pieces lastMouseClick;
	EmptySquare emptySquare;
	
	King kingW;
	King kingB;
	Knight whiteKnightB;
	Knight whiteKnightG;
	Knight blackKnightB;
	Knight blackKnightG;
	int lastI;
	int lastJ;
	Rectangle2D removeMe;
	Pieces[][]	pieceArray;
	public Board() {
		aPawnW = new Pawn("White");
		bPawnW = new Pawn("White");
		cPawnW = new Pawn("White");
		dPawnW = new Pawn("White");
		ePawnW = new Pawn("White");
		fPawnW = new Pawn("White");
		gPawnW = new Pawn("White");
		hPawnW = new Pawn("White");
		
		aPawnB = new Pawn("Black");
		bPawnB = new Pawn("Black");
		cPawnB = new Pawn("Black");
		dPawnB = new Pawn("Black");
		ePawnB = new Pawn("Black");
		fPawnB = new Pawn("Black");
		gPawnB = new Pawn("Black");
		hPawnB = new Pawn("Black");
		
		aRookW = new Rook("White");
		hRookW = new Rook("White");
		aRookB = new Rook("Black");
		hRookB = new Rook("Black");
		
		darkBishopB = new Bishop("Black");
		lightBishopB = new Bishop("Black");
		darkBishopW = new Bishop("White");
		lightBishopW = new Bishop("White");
		
		QueenW = new Queen("White");
		QueenB = new Queen("Black");
		
		kingW = new King("White");
		kingB = new King("Black");
		
		whiteKnightB = new Knight("White");
		whiteKnightG = new Knight("White");
		blackKnightB = new Knight("Black");
		blackKnightG = new Knight("Black");
		
		emptySquare = new EmptySquare("j");
		
		String debug = "yes";
		pieceArray = new Pieces[][]{ {aRookB,  blackKnightB,lightBishopB,QueenB, kingB,darkBishopB,blackKnightB,hRookB},
									 {aPawnB, bPawnB,cPawnB,dPawnB, ePawnB,fPawnB,gPawnB,hPawnB},
									 {emptySquare, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,emptySquare,emptySquare},
									 {emptySquare, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,emptySquare,emptySquare},
									 {emptySquare, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,emptySquare,emptySquare},
									 {emptySquare, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,emptySquare,emptySquare},
									 {aPawnW, bPawnW,cPawnW,dPawnW, ePawnW,fPawnW,gPawnW,hPawnW},
									 {aRookW, whiteKnightB,darkBishopW,QueenW,kingW,lightBishopW,whiteKnightG,hRookW,emptySquare}
								  }; 
								  //For Debugging set up custom board
		if(debug.equals("yes")) {
		    pieceArray = new Pieces[][]{ {aRookB, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,emptySquare,emptySquare},
										 {dPawnW, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,emptySquare,emptySquare},
										 {dPawnW, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,emptySquare,emptySquare},
										 {dPawnW, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,hPawnB,emptySquare},
										 {dPawnW, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,hPawnB,emptySquare},
										 {emptySquare, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,hPawnB,emptySquare},
										 {emptySquare, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,hPawnB,emptySquare},
										 {emptySquare, emptySquare,emptySquare,emptySquare, emptySquare,emptySquare,hRookW,emptySquare,emptySquare}
									  }; 
		}
	}


	
	int piecesCount = 0;
	Rectangle2D rectClickedOn = new Rectangle2D.Double(-100,-100, -100, -100);
	Rectangle2D rectToHighlight = new Rectangle2D.Double(-100,-100, -100, -100);
	public List<Rectangle2D> allRectangles = new ArrayList<>();
	public Set<Rectangle2D> intersect = new HashSet<>();
	Color color;
	int x = 0;
	int y = 0;
	public void changeColor() {
		color = color == Color.WHITE ? Color.GRAY : Color.WHITE;
	}
	int WIDTH = 600;
	int HEIGHT = 600;
	Color colorToUse = Color.RED;
	boolean clickedAlreadyWhite= false;
	boolean clickedAlreadyBlack = false;
	boolean canMove = false;
	boolean canMoveLogic = false;
	Line2D checkForIntersection = new Line2D.Double();
	String turn = "white";
	
	double lastX;
	double lastY;
	// Here we use a hit box system. I draw a line from each rectangle that lives inside 
	// the piece to the next one. This way we can see what is intersecting with the pieces 
	// movements and make decisions about rules using that information.
	public void paint(Graphics g) {
		
		
		
		Graphics2D g2 = (Graphics2D) g;
		//Draw The Board
		x = 0;
		y = 0;
		for(int i = 0; i <pieceArray.length; i++) {

			for(int j = 0; j<pieceArray[i].length; j++) {
				//I cant figure this out but for whatever reason the last 
				// rectangle is really glitchy so we dont want that rectangle
				// to be one that we use. So I can add an extra one at the end,
				// this deals with that one case so that the color doesen't get 
				// glitchy
				if(j != 8) {
				changeColor();
				}
				g2.setColor(color);
				Rectangle2D rect = new Rectangle2D.Double(x,y,80,80);
				
				allRectangles.add(rect);
				
				if(rect.getX() == rectToHighlight.getX()&&rect.getY() == rectToHighlight.getY()) {
					g2.setColor(redHighlight);
				}
				//Black Piece Movement
				if(turn == "black") {
					
				if(rect.getX() == rectClickedOn.getX()&&rect.getY() == rectClickedOn.getY()) {
					g2.setColor(Color.blue);
					
					if(pieceArray[i][j].getColor().equals("Black")) {
						lastMouseClick = pieceArray[i][j];
						
						lastI = i;
						lastJ = j;
						lastX = rect.getCenterX();
						lastY = rect.getCenterY();
						clickedAlreadyBlack = true;
					}
					
					else if(clickedAlreadyBlack) {
						canMove = true;
						canMoveLogic = lastMouseClick.checkLegalMove(lastI,lastJ,i,j,pieceArray);
						
						checkForIntersection = new Line2D.Double(lastX,lastY+12,
								rect.getCenterX(),rect.getCenterY());
						if(pieceArray[lastI][lastJ] instanceof Knight) {
							
						}
						else {
						for(Rectangle2D r: blackPiecePositions) {
							if(checkForIntersection.intersects(r)){
								canMove = false;
							}
						}
						for(Rectangle2D r: whitePiecePositions) {
							if(checkForIntersection.intersects(r)){
								intersect.add(r);
							}
						}
						if(intersect.size()>1) {
							canMove = false;
						}	
						intersect.clear();
						}
						
						if(canMove && canMoveLogic) {
						pieceArray[i][j] = lastMouseClick;
						pieceArray[lastI][lastJ] = (Pieces) emptySquare;
						clickedAlreadyBlack = false;
						allPiecePositions.clear();
						blackPiecePositions.clear();
						rectClickedOn =  new Rectangle2D.Double(-100,-100, -100, -100);
						turn = "white";
						}
						else clickedAlreadyBlack = false;
					}
				}
				}
				if(turn == "white") {
				if(rect.getX() == rectClickedOn.getX()&&rect.getY() == rectClickedOn.getY()) {
					
					g2.setColor(Color.RED);
					
					if(pieceArray[i][j].getColor().equals("White")) {
						lastMouseClick = pieceArray[i][j];
						lastI = i;
						lastJ = j;
						lastX = rect.getCenterX();
						lastY = rect.getCenterY();
						clickedAlreadyWhite = true;
						
					}
					
					else if(clickedAlreadyWhite) {
						canMove = true;
						canMoveLogic = lastMouseClick.checkLegalMove(lastI,lastJ,i,j,pieceArray);
						checkForIntersection = new Line2D.Double(lastX,lastY-12,
								rect.getCenterX(),rect.getCenterY());
						for(Rectangle2D r: whitePiecePositions) {
							if(checkForIntersection.intersects(r)){
								canMove = false;
							}
						}
						for(Rectangle2D r: blackPiecePositions) {
							if(checkForIntersection.intersects(r)){
								intersect.add(r);
							}
						}
						if(intersect.size()>1) {
							canMove = false;
						}
						
						
						intersect.clear();
						piecesCount = 0;
						System.out.println(canMoveLogic + " " + canMove);
						if(canMove && canMoveLogic) {
							pieceArray[i][j] = lastMouseClick;
							pieceArray[lastI][lastJ] = emptySquare;
							clickedAlreadyWhite = false;
							allPiecePositions.clear();
							whitePiecePositions.clear();
							rectClickedOn =  new Rectangle2D.Double(-100,-100, -100, -100);
							turn = "black";
						}
						
						else clickedAlreadyWhite = false;
					}
				}
				}
				
				g2.draw(rect);
				g2.fill(rect);
				// "Debug" mode for intersections
				// WARNING: Causes signifigant slow down.
				//2.draw(checkForIntersection);
				//for(Rectangle2D r: allPiecePositions) {
				//	g2.draw(r);
				//}
			if(pieceArray[i][j] != null) {
				
				if(pieceArray[i][j].getColor().equals("White")) {
					allPiecePositions.add(new Rectangle2D.Double(rect.getCenterX()-10,rect.getCenterY()-10,20,20));
					whitePiecePositions.add(new Rectangle2D.Double(rect.getCenterX()-10,rect.getCenterY()-10,20,20));
				}
				if(pieceArray[i][j].getColor().equals("Black")) {
					allPiecePositions.add(new Rectangle2D.Double(rect.getCenterX()-10,rect.getCenterY()-10,20,20));
					blackPiecePositions.add(new Rectangle2D.Double(rect.getCenterX()-10,rect.getCenterY()-10,20,20));
				}
				
				g2.drawImage(pieceArray[i][j].getPicture(),(int)rect.getX()+3,(int)rect.getY()-4,this);
				
				}
				
				x += 80;
				if(x >= 600) {
					changeColor();
					y+=80;
					x = 0;
				}

			}
		}
	}
			
		
		
	public void changeColorMouse(Rectangle2D rect) {
		rectToHighlight = rect;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		

	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.repaint();
		for(Rectangle2D rect: this.allRectangles) {
			if(rect.contains(e.getX(), e.getY())) {
				this.repaint();
				rectClickedOn = rect;
				
			}
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		this.repaint();
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		this.repaint();
		for(Rectangle2D rect: this.allRectangles) {
			if(rect.contains(e.getX(), e.getY())) {
				this.repaint();
				rectClickedOn = rect;
				
			}
		}
		
	}
	@Override
	public void mouseMoved(MouseEvent j) {
		this.repaint();
		for(Rectangle2D rect: this.allRectangles) {
			if(rect.contains(j.getX(), j.getY())) {
				this.changeColorMouse(rect);
				
			}
		}
		
	}
	public String getTurn() {
		return this.turn;
	}




}
