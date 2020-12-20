package gv.randomdevs.org;

import java.awt.Graphics;

public abstract class GameObject {
	protected double x,y;
	protected ID id;
	protected double velx,vely;
	public GameObject(int x,int y, ID id) {
		this.x=x;
		this.y=y;
		this.id=id;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public double getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public ID getId() {
		return id;
	}
	public void setId(ID id) {
		this.id = id;
	}
	
	public double getVelx() {
		return velx;
	}
	
	public void setVelx(int velx) {
		this.velx = velx;
	}
	
	public double getVely() {
		return vely;
	}
	
	public void setVely(int vely) {
		this.vely = vely;
	}
}
