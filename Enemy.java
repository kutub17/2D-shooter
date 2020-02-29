import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Enemy implements Runnable {
    int x,dx,dy,y;
    ImageIcon i; // = new ImageIcon("Images/char.png");
    Image c;
    Random random;
    Rectangle r;
    Frame frame;
    boolean alive = true;
    int speed = 2;
    
    public Enemy(){}
    
    public Enemy(Frame f){
        this.frame = f;
        random = new Random();
        i = new ImageIcon("Images/enemy"+random.nextInt(2)+".png");
        c = i.getImage();
        
        x = 910;
        y = random.nextInt(600);
        
        r = new Rectangle(x, y,70, 80);
        
        Thread t = new Thread(this);
        t.start();
    }
    
    public void setFrame(Frame f){
        this.frame = f;
    }
    
    public void setSpeed(int s){
        speed = s;
        System.out.println("Speed: "+ speed);
    }
    
    public Image getImage(){
        return c;
    }
    
    public void run(){
        frame.board.enemy.add(this);
        
        while(x>0 && frame.running==true && alive==true) {
		try{
			x-=2;
			r.setBounds(x,y,70,80);
			
			if(r.intersects(frame.board.rect)) {
				System.out.println("GAME OVER");
                frame.gameOver();
			}

                        //frame.board.repaint();
			Thread.sleep(50);
                    }
		catch (Exception e) {
			System.out.println("exception enemy");
                    }
		}
        if(frame.running==true) {
			frame.board.enemy.remove(this); //enemy.setVisible(false);
			frame.createEnemyNew(2);
		}
        frame.board.enemy.remove(this); //enemy.setVisible(false);
    }
}