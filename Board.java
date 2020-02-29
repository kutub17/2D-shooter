import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Board extends JComponent implements ActionListener{
	
	Dude d;
	
	ImageIcon bg = new ImageIcon("Images/bg.jpg");
	
	Image img;
	
	Timer t;
	Rectangle rect;
	ArrayList<Enemy> enemy;
	Frame frame ;
	
	public Board()
	{
		d = new Dude();
        //d.setFrame(frame);
		//enemy = new ArrayList();
		
		addKeyListener(new AL());
		
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		rect = new Rectangle(d.getX(), d.getY(), 70, 70);
                
                enemy = new ArrayList<Enemy>();
		
		
		img = bg.getImage();
		
		t = new Timer(5, this);
		
		t.start();
		
	}
	
	public void setFrame(Frame f) {
		this.frame = f;
		d.setFrame(frame);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		ArrayList bullets = Dude.getBullets();
		for(int w=0;w<bullets.size();w++)
		{
			Bullet m = (Bullet) bullets.get(w);
			if(m.getVisible()==true)
			  m.move();
			else
				bullets.remove(w);			
		}
		
		checkCollision();
		
		d.move();
		repaint();
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(img, 0, 0,null);
		g2d.drawImage(d.getImage(),d.getX(),d.getY(),null);
		rect.setBounds(d.getX(),d.getY(),70,70);
		//System.out.println(d.getY());
		
		
		ArrayList bullets = Dude.getBullets();
		for(int w=0;w<bullets.size();w++)
		{
			Bullet m = (Bullet) bullets.get(w);
			g2d.drawImage(m.getImage(),m.getX(),m.getY(),null);		
		}
                
                for(int i=0; i<enemy.size(); i++){
                    Enemy e = enemy.get(i);
                    g2d.drawImage(e.getImage(), e.x, e.y, null);
                }
		
		
	}
	
	
	public void checkCollision() {
		int hit = 0;
		ArrayList bullets = Dude.getBullets();
		
		for(int w=0;w<bullets.size();w++)
		{
			for(int i=0; i<enemy.size();i++) {
				Enemy e = (Enemy) enemy.get(i);
				Bullet m = (Bullet) bullets.get(w);
				if(e.r.intersects(m.rect)) {
					bullets.remove(w);
					enemy.remove(i);
					//e.enemy.setVisible(false);
					e.alive = false;
					
					hit = 1;
					
					//System.out.println("hit");
					
					//System.out.println(frame.score++);
					
					frame.scoreText.setText("Score: "+String.valueOf(++frame.score));
					//frame.createEnemy(2);
                                        Random rand = new Random();
                                        int number = rand.nextInt(3);
                                        while(number<=0) number = rand.nextInt(3);
                                        
                                        frame.createEnemyNew(number);
					break;
				}
			}
			if(hit == 1) break;
		}
	}
	
	public class AL extends KeyAdapter{
		
		public void keyReleased(KeyEvent e)
		{
			d.keyReleased(e);
			
		}
		
		public void keyPressed(KeyEvent e)
		{
			d.keyPressed(e);
		}
		
	}
	
	

}
