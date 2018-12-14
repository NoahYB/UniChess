import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Play extends JComponent implements MouseMotionListener, MouseListener {
	/**
	 * I assume
	 */
	private static final long serialVersionUID = 1;
	
	public boolean mouseClicked = false;
	public boolean mouseHeld = false;
	public boolean mouseReleased = false;
	public boolean mouseBeingMovedClicked = false;
	Map<String, BufferedImage> WhitePieces = new HashMap<>();
	Map<String, BufferedImage> BlackPieces = new HashMap<>();
	
	List<String> pieceOrder = new ArrayList<>();
	Board board = new Board();
	
	public JFrame window = new  JFrame("Java + Chess" + "\u2654");
	int WIDTH = 700;
	int HEIGHT = 640;
	int x = 0;
	int y = 0;
	public void newGame() {
		pieceOrder.addAll(Arrays.asList("King","Queen","Bishop","Knight","Rook","Pawn"));
		piecePositions();
		window.setSize(WIDTH,HEIGHT+(400/8/2));
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(board);
		window.getContentPane().addMouseListener(board);
		window.getContentPane().addMouseMotionListener(board);
		window.setVisible(true);
	
	}
	
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		mouseClicked = true;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseHeld = true;
		mouseClicked = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseReleased = true;
		mouseHeld = false;
		mouseClicked = false;
		mouseBeingMovedClicked = false;
		
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
	public void mouseDragged(MouseEvent j) {
		mouseBeingMovedClicked = true;
		x = j.getX();
		y = j.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent j) {
		
	}
	/*
	 * returns the image of pieces or board
	 * @param use 0 to get the picture of pieces
	 * use 1 to get picture of board
	 */
	private BufferedImage getImage(int l){
		
		String path;
		BufferedImage imageOfAllPieces = null;
		if(l == 0) {
			 path = "src/pieces.png";
		}
		else path = "src/board.png";
		try {
		    imageOfAllPieces = ImageIO.read(new File(path));
		    
		} catch (IOException e) {
		}
		return imageOfAllPieces;
		
	}
	public void piecePositions() {
		
		BufferedImage imageToSplice = getImage(0);
		
		int WIDTH = imageToSplice.getWidth();
		int HEIGHT = imageToSplice.getHeight();
		
		
		for(int i = 0; i < 6; i++) {
			WhitePieces.put(pieceOrder.get(i),imageToSplice.getSubimage(
					(WIDTH/6)*i, 0, WIDTH/6, HEIGHT/2) );

		}
		for(int j = 0; j< 6; j++) {
			BlackPieces.put(pieceOrder.get(j),imageToSplice.getSubimage(
					(WIDTH/6)*j, HEIGHT/2, WIDTH/6, HEIGHT/2));
			
		}
	}
	public static void main(String[] args) {
		Play play = new Play();
		play.newGame();
	}

}

