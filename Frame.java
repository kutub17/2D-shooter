import java.awt.Font;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame {
	
	JFrame f = new JFrame("Monster Shoot");	
	Board board;
	boolean running = true;
	ArrayList enemy;
	int score = 0;
	JLabel scoreText;
	JLabel gameOverText;
	
	public Frame()
	{
                
		board = new Board();
		board.setFrame(this);
		enemy = new ArrayList();
		
		Random random = new Random();
		int r = random.nextInt(6);
		scoreText = new JLabel("Score: "+String.valueOf(score));
		scoreText.setBounds(920,10,200,20);
		
		while(r<=0)
			r = random.nextInt(6);
			
		//createEnemy(r);
                
        createEnemyNew(r);
		
		scoreText = new JLabel("Score: " + String.valueOf(score));
		scoreText.setBounds(850,10,200,20);
		gameOverText = new JLabel("Game Over!");
		gameOverText.setFont(new Font("Segoe UI",Font.BOLD, 36));
		gameOverText.setBounds(450,250,200,40);
		gameOverText.setVisible(false);
		
		f.add(scoreText);
		f.add(gameOverText);
		f.add(board);
		
		f.setSize(1000,650);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		

	}
	
	/*
        public void createEnemy(int num) {
		System.out.println("something");
		for(int i=0;i<num;i++) {
			Enemy en = new Enemy();
			en.setBoard(board);
			en.setFrame(this);
			enemy.add(en);
			f.add(en.enemy);
			
			f.remove(board);
			f.repaint();
			f.add(board);
		} 
		
		board.enemy = this.enemy;
		
	}
        */
	
	public void setScore(int s) {
		scoreText.setText("Score: "+String.valueOf(s));
	}
	
	public ArrayList getEnemy() {
		return enemy;
	}
        
        public void gameOver(){
            running = false;
			//System.out.println("GAME OVER");
			gameOverText.setVisible(true);
			scoreText.setFont(new Font("Segoe UI",Font.BOLD, 18));
			scoreText.setLocation(500,300);
        }

        public void createEnemyNew(int num){
            for(int i=0; i<num; i++){
                Enemy e = new Enemy(this);
                if(score>10)
                    e.setSpeed((score/10+3));
            }
        }
	
	

	public static void main(String [] args)
	{
		new Frame();
	}
	
	
	
}
