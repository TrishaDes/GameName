package randomengine.randomdevs.org;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Window {

	public static JFrame newWindow(@NotNull String frameName, @NotNull int width, int height[]) {																										// teoria
		JFrame frame = new JFrame(frameName); // nuovo Frame di JFrame, non usiamo Window perché è più macchinoso
		if (height.length == 1) {
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} else {
			frame.setDefaultCloseOperation(height[1]); // altrimenti usa l'argomento fornito
		}
		frame.setSize(width, height[0]); // impostiamo la grandezza della finestra
		return frame; // restituiamo la finestra (altrimenti non sarebbe un costruttore)
	}
	
	public static JFrame newWindow(@NotNull String frameName, @NotNull int width, int height) {																										// teoria
		JFrame frame = new JFrame(frameName); // nuovo Frame di JFrame, non usiamo Window perché è più macchinoso
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(width, height); // impostiamo la grandezza della finestra
		return frame; // restituiamo la finestra (altrimenti non sarebbe un costruttore)
	}

	public static void obliterate(@NotNull JFrame frame) { 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(false);
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSED)); 
	}

}
