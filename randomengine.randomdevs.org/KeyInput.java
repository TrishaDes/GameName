package gv.randomdevs.org;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	Window window;
	Handler handler;
	public KeyInput(Window window,Handler handler) {
		this.window=window;
		this.handler=handler;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		int keyModifiers=e.getModifiersEx();
		int down = KeyEvent.CTRL_DOWN_MASK;
		/*per aggiungere un altro qualsivoglia modificatore a down basta fare cosi:
		 *int down=KeyEvent.keyMask|keyMask2 (es:
		 *int down = KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK;
		 * ma, in quel caso va aggiunto un altro if->switch, cambiando nome alla var down,
		 *dato che se non si effettua questo, i binding con solo control (ad esempio)
		 *non funizoneranno
		*/
		bindingsChecker(keyModifiers,down,key);
		isMovementChecker(key,false);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		isMovementChecker(key,true);
	}

	private void bindingsChecker(int keyModifiers, int down, int key) {
		if((keyModifiers & down) == down) {
			switch(key) {
				case(KeyEvent.VK_W):
				case(KeyEvent.VK_Q):
					window.closeWindow();
					break;
				case(KeyEvent.VK_N):
					window.fullScreenHandler();
					break;
				default:
					break;
			}
		}
		switch(key) {
			case(KeyEvent.VK_F11):
				window.fullScreenHandler();
				break;
			default:
				break;
		}
	}
	private void isMovementChecker(int key,boolean hasReleasedIntent) {
		for(GameObject object : handler.objects) {
			if(object.getId()==ID.Player) 
				switch(key) {
					case(KeyEvent.VK_D):
						object.setVelx(hasReleasedIntent?0:5);
						break;
					case(KeyEvent.VK_A):
						object.setVelx(hasReleasedIntent?0:-5);
						break;
				}
		}	
	}
}