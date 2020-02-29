import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Enemy implements Runnable {
	JLabel enemy;
	int x;
	int y;
	Random random;
	Frame fr;
	Rectangle r;
	Board board;
	Frame frame;
	boolean alive = true;
	ArrayList<Bullet> bullet;
	
	//public Enemy() {}
	
	public Enemy() {
		//this.fr = m;
		
		enemy = new JLabel();
		random = new Random();
		x = 910;
		y = random.nextInt(600);
		ImageIcon i = new ImageIcon("Images/enemy"+random.nextInt(2)+".png");
		enemy.setIcon(i);
		
		r = new Rectangle(x, y,70, 80);

		enemy.setSize(70,80);
		enemy.setLocation(x,y);		
		
		Thread thread = new Thread(this);
		thread.start();
	
	}
	
	public void setFrame(Frame f) {
		this.frame = f;
	}
	
	public void setBoard(Board b) {
		this.board = b;
	}
	
	public void setBullet(ArrayList b) {
		bullet = board.d.getBullets();
	}
	
	
	
	public void run() {
		while(x>0 && frame.running==true && alive==true) {
			try{
				x-=5;
			enemy.setLocation(x,y);
			r.setBounds(x,y,70,80);
			
			
			
			
			if(r.intersects(board.rect)) {
				System.out.println("GAME OVER");
                                frame.gameOver();
				//frame.running = false;
			}
			
			/*
			for(int i=0; i<bullet.size();i++) {
				System.out.println("for loop");
				if(r.intersects(bullet.get(i).rect))
					System.out.println("SHESH");
			}
			*/
		
			
			
			Thread.sleep(100);
			}
			catch (Exception e) {
				System.out.println("exception enemy");
			}
		}
		if(frame.running==true) enemy.setVisible(false);
		enemy.setVisible(false);
	}
}