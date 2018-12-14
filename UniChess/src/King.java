import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class King extends Pieces{
	BufferedImage blackKing;
	BufferedImage whiteKing;
	String color;
	public King(String color) {
		super(color);
		this.color = color;
		BufferedImage imageToSplice = getImage(0);
		int WIDTH = imageToSplice.getWidth();
		int HEIGHT = imageToSplice.getHeight();
		
		blackKing = imageToSplice.getSubimage((WIDTH/6)*3, 
				0, WIDTH/6, HEIGHT/2);
		
		whiteKing = imageToSplice.getSubimage((WIDTH/6)*3, 
				HEIGHT/2, WIDTH/6, HEIGHT/2);
	}
	@Override
	public BufferedImage getPicture(){
		if(color == "White") {
			return whiteKing;
		}
		else {
			return blackKing;
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
