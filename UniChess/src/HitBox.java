import java.awt.geom.Rectangle2D;

public class HitBox extends Rectangle2D.Double {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String blackWhite;
	public HitBox(String blackWhite) {
		this.blackWhite = blackWhite;
	}
	
	public String getColor() {
		return blackWhite;
	}
	@Override
	public void setRect(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int outcode(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rectangle2D createIntersection(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
