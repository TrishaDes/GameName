package gv.randomdevs.org;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -3186274467318295790L;
	
	static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	public final static int width=screen.width,height=screen.height;
	
	private Thread thread;
	
	private boolean running=false;
	
	private Handler handler;
	static Window window;
	public Game() {
		 window = new Window("Gioco :)", width, height, true, true, this);
		 handler=new Handler();
		 this.addKeyListener(new KeyInput(window,handler));
		 handler.addObject(new Player(width/2-32,height/2-32,ID.Player));

	}

	public static void main(String[] args) {
		new Game();
	}
	
	public synchronized void start() {
		thread=new Thread(this);
		thread.start();
		running=true;
	}

	public synchronized void stop() {
		try {	
			thread=new Thread(this);
			thread.interrupt();
			running=false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		long lastTime=System.nanoTime();
		double amountOfTicks=60.0;
		double ns=1000000000/amountOfTicks;
		double delta=0;
		long timer=System.currentTimeMillis();
		//int frames=0;
	    while (running){
	        long now = System.nanoTime();
	        delta += (now-lastTime)/ns;
	        lastTime = now;
	        while(delta>=1){
	        	tick();
	        	delta--;
	        }
	        if(running) render();
	        //frames++;
	        if(System.currentTimeMillis()-timer>1000) {
	        	timer+=1000;
	        	//Qui posso ottenere gli FPS con frames, mi basta soltanto de-commentare il codice con frames e printarlo (esempio)
	        	//frames=0;
	        }
	    }
	    stop();
	}
	private void tick() {
		handler.tick();
	}
	
	public static double clamp(double var,char dimension) {
		double max=dimension=='w'?window.getDimensions().width-32:window.getDimensions().height-32.5;
		if(var>=max) return var=max;
		else if(var<=0) return var=0;
		else return var;
	}
	
	private void render() {
		BufferStrategy bs=this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g=bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,width,height);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}
}
