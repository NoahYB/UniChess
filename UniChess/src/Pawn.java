import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pawn extends Pieces{
	boolean hasMoved = false;
	public Pawn(String color) {
		super(color);
		{
			this.color = color;
			BufferedImage imageToSplice = getImage(0);
			int WIDTH = imageToSplice.getWidth();
			int HEIGHT = imageToSplice.getHeight();
			
			blackPawn = imageToSplice.getSubimage((WIDTH/6)*5, 
					0, WIDTH/6, HEIGHT/2);
			
			whitePawn = imageToSplice.getSubimage((WIDTH/6)*5, 
					HEIGHT/2, WIDTH/6, HEIGHT/2);
		}
	}
	BufferedImage whitePawn;
	BufferedImage blackPawn;
	String color;
	@Override
	public String getColor() {
		return this.color;
	}
	
	/*
	 * Pawn Logic:
	 * Pawn logic is split between the use of hitboxes in the pieces class
	 * and the manipulation of indices in this subclass of pieces
	 * @param Pieces#checkLegalMove(int, int, int, int, Pieces, Pieces[][])
	 * lastI is the  index o
	 * 
	 * The black pieces and white pieces have different logic but the basic idea is 
	 * the same
	 * 
	 */
	@Override
	public boolean checkLegalMove(int lastI, int lastJ, 
			int i, int j, Pieces[][] boardArray) {
		
		if(color.equals("White")) {
		if(lastI != 6) {
			if(i-lastI < -1 || i-lastI >= 0) {
				return false;
			}
		}
		if(Math.abs(lastJ-j) == 1 && lastI>i) {
			if(boardArray[i][j].getPicture() == null) {
				return false;
			}
			else return true;
		}
		
		if(boardArray[i][j].getPicture() != null) {
			return false;
		}
		
		if(i-lastI < -2 || i-lastI >= 0) {
			return false;
		}
		if(boardArray[i][j].getPicture() == null) {
			return true;
		}
		if(lastJ != j) {
			return false;
		}
		return false;
	}
	
	if(color.equals("Black")) {
		if(!hasMoved) {
		if(i-lastI > 2 || i - lastI <= 0) {
			return false;
		}
		}
		if(hasMoved) {
			if(i-lastI > 1 || i - lastI <= 0) {
				return false;
			}
		}
		if(Math.abs(lastJ-j) == 1 && lastI<i) {
			if(boardArray[i][j].getPicture() == null) {
				return false;
			}
			else return true;
		}
		if(boardArray[i][j].getPicture() != null) {
			return false;
		}
		if(boardArray[i][j]!= null) {
			hasMoved = true;
			return true;

		}
		if(lastJ != j) {
			return false;
		}
	}
	return false;
	}
	
	
	@Override
	public BufferedImage getPicture(){
		if(color == "White") {
			return whitePawn;
		}
		else {
			return blackPawn;
		}
		
	}
	private BufferedImage getImage(int l){
		
		String path;
		BufferedImage imageOfAllPieces = null;
		if(l == 0) {
			 path = "src/pieces4.png";
		}
		else path = "src/board.png";
		try {
		    imageOfAllPieces = ImageIO.read(new File(path));
		    
		} catch (IOException e) {
		}
		return imageOfAllPieces;
		
		}
}
