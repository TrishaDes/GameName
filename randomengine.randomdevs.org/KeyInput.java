package gv.randomdevs.org;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private Window window;
	Handler handler;
	private GameObject player;
	private boolean keyDown[];
	public KeyInput(Window window,Handler handler) {
		this.window=window;
		this.handler=handler;	//W     S      D      A
		keyDown = new boolean[] {false, false, false, false};
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
	private void isMovementChecker(int key, boolean hasReleasedIntent) {
		//TODO: Migliorare questo codice per farlo funzionare sia con releaseKey che con keyPressed
        for(GameObject object:handler.objects) {
			if(object.getId()==ID.Player) {
				player=object;
			}
		}
		if(key == KeyEvent.VK_W && hasReleasedIntent) keyDown[0] = false;
        if(key == KeyEvent.VK_S && hasReleasedIntent) keyDown[1] = false;
        if(key == KeyEvent.VK_D && hasReleasedIntent) keyDown[2] = false;
        if(key == KeyEvent.VK_A && hasReleasedIntent) keyDown[3] = false;
        if(!keyDown[0] && !keyDown[1] && hasReleasedIntent) {
            player.setVely(0);
        }
        if(!keyDown[2] && !keyDown[3] && hasReleasedIntent) {
            player.setVelx(0);
        }
        if(key == KeyEvent.VK_W && !keyDown[1] && !hasReleasedIntent) {
            player.setVely(-5); keyDown[0] = true;
        }
        if(key == KeyEvent.VK_S && !keyDown[0] && !hasReleasedIntent) {
            player.setVely(5); keyDown[1] = true;
        }
        if(key == KeyEvent.VK_D && !keyDown[3] && !hasReleasedIntent) {
            player.setVelx(5); keyDown[2] = true;
        }
        if(key == KeyEvent.VK_A && !keyDown[2] && !hasReleasedIntent) {
            player.setVelx(-5); keyDown[3] = true;
        }
	}
}