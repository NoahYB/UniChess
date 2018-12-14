import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Knight extends Pieces{
	BufferedImage blackKnight;
	BufferedImage whiteKnight;
	private String color;
	
	public Knight(String color) {
		super(color);
		this.color = color;
		BufferedImage imageToSplice = getImage(0);
		int WIDTH = imageToSplice.getWidth();
		int HEIGHT = imageToSplice.getHeight();
		
		blackKnight = imageToSplice.getSubimage((WIDTH/6)*4, 
				0, WIDTH/6, HEIGHT/2);
		
		whiteKnight = imageToSplice.getSubimage((WIDTH/6)*4, 
				HEIGHT/2, WIDTH/6, HEIGHT/2);
		// TODO Auto-generated constructor stub
	}
	@Override
	public BufferedImage getPicture(){
		if(color == "White") {
			return whiteKnight;
		}
		else {
			return blackKnight;
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
