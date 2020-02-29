import java.awt.*;
import javax.swing.ImageIcon;
import org.w3c.dom.css.Rect;

public class Bullet {
	
int x,y;
Image img;
boolean visible;
Rectangle rect;

public Bullet(int strtX,int strtY)
{
		x = strtX;
		y = strtY;
		
		rect = new Rectangle(x, y, 20, 20);
		
		ImageIcon newBullet = new ImageIcon("Images/Bullet.png");
		img = newBullet.getImage();
		visible = true;
		


}
public int getX()
{
	return x;
	
}
public int getY()
{
	return y;
	
}
public boolean getVisible()
{
	return visible;
	
}
public Image getImage()
{
	return img;
	
}

public void move()
{
	x = x+2;
	rect.setBounds(x, y, 20, 20);
	
	if(x > 1000)
		visible = false;
	
	
}

	

}
