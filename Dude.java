import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Dude extends KeyAdapter{

	int x,dx,dy,y;
	ImageIcon i = new ImageIcon("Images/char.png");
	
	Image c;
	
	static ArrayList bullets;
	
	Frame frame;
	
	public Dude()
	{
		c = i.getImage();
		x=0;
		y=275;

		bullets = new ArrayList();
	}
	
	public static ArrayList getBullets()
	{
		return bullets; 
		
	}
	
	public void fire()
	{
		Bullet z = new Bullet(x+70, y+70/2);
		bullets.add(z);
	}
	
	public void setFrame(Frame f){
		this.frame = f;
	}

	
	public void move()
	{
		if(frame.running==false)
			return;
		
		if(x<0)
		{
			dx=0;
			x=0;
		}
		if(x>920)
		{
			dx=0;
			x=920;
		}
		if(y<0)
		{
			dx=0;
			y=0;
		}
		if(y>520)
		{
			dy=0;
			y=520;
		}
		
		
		
		x=x+dx;
		y=y+dy;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImage()
	{
		return c;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT);
		{
			dx =-2;
			dy = 0;
		
		}
		if(key == KeyEvent.VK_RIGHT)
		{
			dx = 2;
			dy = 0;
		}
		if(key == KeyEvent.VK_UP)
		{
			dy = -2;
			dx = 0;
		}
		if(key == KeyEvent.VK_DOWN)
		{
			dy = 2;
			dx = 0;
		}
		
		if(key == KeyEvent.VK_SPACE)
		{
			fire();
		}
		
	}
	public void keyReleased(KeyEvent e)
	{
		dx=0;
		dy=0;
	}
	public void keyTyped(KeyEvent e) {}

}
