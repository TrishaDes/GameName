package randomengine.randomdevs.org;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Window {

	public JFrame newWindow(@NotNull String frameName, @NotNull int width, @NotNull int height, int closeEvent) {																										// teoria
		JFrame frame = new JFrame(frameName); // nuovo Frame di JFrame, non usiamo Window perché è più macchinoso
		frame.setDefaultCloseOperation(closeEvent); // altrimenti usa l'argomento fornito
		frame.setSize(width, height); // impostiamo la grandezza della finestra
		return frame; // restituiamo la finestra (altrimenti non sarebbe un costruttore)
	}

	public void obliterate(@NotNull JFrame frame) { 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(false);
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSED)); 
	}

}
