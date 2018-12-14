import java.awt.image.BufferedImage;

public class EmptySquare extends Pieces{
	public EmptySquare(String color) {
		
		super(color);
		this.color = color;
		// TODO Auto-generated constructor stub
	}
	String color;
	
	@Override
	public BufferedImage getPicture() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getColor() {
		return this.color;
		
	}
	

}
