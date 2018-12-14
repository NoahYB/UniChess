import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bishop extends Pieces{
	
	BufferedImage blackBishop;
	BufferedImage whiteBishop;
	public Bishop(String color) {
		super(color);
		{
			this.color = color;
			BufferedImage imageToSplice = getImage(0);
			int WIDTH = imageToSplice.getWidth();
			int HEIGHT = imageToSplice.getHeight();
			
			blackBishop = imageToSplice.getSubimage((WIDTH/6)*1, 
					0, WIDTH/6, HEIGHT/2);
			
			whiteBishop = imageToSplice.getSubimage((WIDTH/6)*1, 
					HEIGHT/2, WIDTH/6, HEIGHT/2);
		}
	}
	String color;
	@Override 
	public boolean checkLegalMove(int lastI, int lastJ, int i, int j, 
			Pieces[][] pieceArray) {
		if(Math.abs(i-lastI) != Math.abs(j -lastJ)
		|| lastI  == i || lastJ  == j) {
			return false;
		}
		if(Math.abs(i-lastI) != Math.abs(j -lastJ)
				|| lastI  == i || lastJ  == j) {
					return false;
				}
		else {
			return true;
		}
				
		
	}
	@Override
	public BufferedImage getPicture(){
		if(color == "White") {
			return whiteBishop;
		}
		else {
			return blackBishop;
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
