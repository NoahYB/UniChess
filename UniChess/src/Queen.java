import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Queen extends Pieces{
	BufferedImage whiteQueen;
	BufferedImage blackQueen;
	String color;
	public Queen(String color) {
		super(color);
		
		this.color = color;
		BufferedImage imageToSplice = getImage(0);
		int WIDTH = imageToSplice.getWidth();
		int HEIGHT = imageToSplice.getHeight();
		
		blackQueen = imageToSplice.getSubimage((WIDTH/6)*2, 
				0, WIDTH/6, HEIGHT/2);
		
		whiteQueen = imageToSplice.getSubimage((WIDTH/6)*2, 
				HEIGHT/2, WIDTH/6, HEIGHT/2);
	}
	
	
	@Override
	public boolean checkLegalMove(int lastI, int lastJ, 
			int i, int j, Pieces[][] boardArray) {
		if(lastI == i || lastJ == j) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public BufferedImage getPicture() {
		if(color.equals("White")){
			return whiteQueen;
		}
		else {
			return blackQueen;
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
	@Override
	public String getColor() {
		return this.color;
	}
	
	

}
