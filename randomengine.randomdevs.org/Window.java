package gv.randomdevs.org;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends Canvas{
	JFrame frame;
	Dimension givenDimension=new Dimension();
	private static final long serialVersionUID = 1L;
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Window(String title, int width, int height, boolean isFullscreen, boolean canResize, Game game) {
		JFrame frame=new JFrame(title);
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(0,0));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(canResize);
		if(isFullscreen) {
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			frame.setUndecorated(true);
		}
		frame.setVisible(true);
		frame.toFront();
		frame.requestFocus();
		game.start();
	    frame.requestFocus();
		this.frame=frame;
		givenDimension.height=height;
		givenDimension.width=width;
	}
	public void closeWindow() {
		this.frame.setVisible(false);
		this.frame.dispose();
	}
	public void fullScreenHandler() {
		try {
			frame.dispose();
			GraphicsDevice fullscreenDevice=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		    if (frame.isUndecorated()) {
		      fullscreenDevice.setFullScreenWindow(null);
		      frame.setUndecorated(false);
		    } else {
		      frame.setUndecorated(true);
		      fullscreenDevice.setFullScreenWindow(frame);
		    }
		    frame.setVisible(true);
		    frame.setVisible(false);
		    frame.setVisible(true);
		    frame.repaint();
		    frame.toFront();
		    frame.requestFocus();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Dimension getDimensions() {
		return frame.getContentPane().getSize();
	}
}
