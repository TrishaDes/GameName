package randomengine.randomdevs.org;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	
	
	private static final long serialVersionUID = 1L;
	
	String frameName;
	int width;
	int height;
	int maxWidth;
	int maxHeight;
	int defCloseOperation;
	boolean resizable;
	
	public Window(String frameName, int width[], int height[], boolean resizable) {
		this.frameName = frameName;
		this.width = width[0];
		this.height = height[0];
		this.maxWidth = width[1];
		this.maxHeight = height[1];
		this.defCloseOperation = JFrame.DISPOSE_ON_CLOSE;
		this.resizable = resizable;
		
		JFrame frame = new JFrame(frameName);
		frame.setMinimumSize(new Dimension(width[0], height[0]));
		frame.setMaximumSize(new Dimension(width[1], height[1]));
		frame.setResizable(resizable);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
