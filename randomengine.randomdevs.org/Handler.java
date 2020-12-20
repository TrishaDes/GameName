package gv.randomdevs.org;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> objects=new LinkedList<GameObject>();
	
	
	public void tick() {
		for(GameObject tempObject : this.objects) {
		    tempObject.tick();
		}
	}
	public void render(Graphics g) {
		for(GameObject tempObject : this.objects) {
		    tempObject.render(g);
		}
	}
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}
}
