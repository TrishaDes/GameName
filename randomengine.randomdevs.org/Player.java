package gv.randomdevs.org;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Player extends GameObject{
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
	}

	@Override
	public void tick() {
		x+=velx;
		y+=vely;
		x=Game.clamp(x, 'w');
		y=Game.clamp(y, 'h');
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		Rectangle2D rect = new Rectangle2D.Double(x, y, 32, 32);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(rect); 
	}
}
