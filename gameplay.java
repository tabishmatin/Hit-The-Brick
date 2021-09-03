package breakoutBall;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class gameplay extends JPanel implements KeyListener, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean play = false;
	protected int score = 0;
	
	protected int totalBricks = 21;
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 300;
	
	int min = 200;
	int max = 500;
	int random_positionX = (int)Math.floor(Math.random()*(max-min+1)+min);
	private int ballPosX = random_positionX;
	private int ballPosY = 530;
	
	protected int ballXDirec = -1;
	protected int ballYDirec = -2;
	
	public String pname = breakoutBallGame.name.getText();
	
	private MapGenerator map;
	
	public gameplay() 
	{
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();		
		
	}
	
	public void paint(Graphics g)
	{
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 698, 590);
		
		//Map drawing
		map.draw((Graphics2D)g);	
		
		//player name
		g.setColor(Color.white);
		g.setFont(new Font("roboto", Font.BOLD, 15));
		g.drawString("Welcome, " + pname, 50, 30);
		
		//scores
		g.setColor(Color.white);
		g.setFont(new Font("roboto", Font.BOLD, 15));
		g.drawString("Score: " + score, 600, 30);
		
		//borders
		g.setColor(Color.blue);
		g.fillRect(0, 0, 3, 590);
		g.fillRect(0, 0, 698, 3);
		g.fillRect(697, 0, 3, 592);
		
		//the paddle
		g.setColor(Color.blue);
		g.fillRect(playerX, 550, 100, 8);
		
		//the ball
		g.setColor(Color.yellow);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		if(totalBricks <= 0)			//if player wins
		{
			play = false;
			ballXDirec = 0;
			ballYDirec = 0;
			g.setColor(Color.red);
			g.setFont(new Font("verdana", Font.BOLD, 30));
			g.drawString("YOU WON!", 250, 300);
			
			g.setColor(Color.white);
			g.setFont(new Font("roboto", Font.BOLD, 20));
			g.drawString("Score: " + score, 300, 400);
			
			g.setColor(Color.gray);
			g.setFont(new Font("roboto", Font.BOLD, 15));
			g.drawString("Press return to restart", 250, 450);
		}
		
		if(ballPosY > 570)				//if player loses
		{
			play = false;
			ballXDirec = 0;
			ballYDirec = 0;
			g.setColor(Color.red);
			g.setFont(new Font("verdana", Font.BOLD, 25));
			g.drawString("GAME OVER!", 250, 300);
			
			g.setColor(Color.white);
			g.setFont(new Font("roboto", Font.BOLD, 20));
			g.drawString("Score: " + score, 300, 400);
			
			g.setColor(Color.gray);
			g.setFont(new Font("roboto", Font.BOLD, 15));
			g.drawString("Press return to restart", 250, 450);
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play)
		{
			if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8)))
			{
				ballYDirec = -ballYDirec;
			}
			
	labelA:	for(int i=0; i < map.map.length; i++)
			{
				for(int j=0; j<map.map[0].length; j++)
				{
					if(map.map[i][j] > 0)
					{
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect))
						{
							map.setBrickValue(0, i, j);
							totalBricks--;
							score = score + 5;
							
							if (ballPosX + 19 <= brickRect.x + 1 || ballPosX + 1 >= brickRect.x + brickRect.width)
								ballXDirec = -ballXDirec;
							else
								ballYDirec = -ballYDirec;
							
							break labelA;
						}
					}
				}
			}
			
			ballPosX += ballXDirec;
			ballPosY += ballYDirec;
			if(ballPosX < 0)
			{
				ballXDirec = -ballXDirec;
			}
			if(ballPosY < 0)
			{
				ballYDirec = -ballYDirec;
			}
			if(ballPosX > 670)
			{
				ballXDirec = -ballXDirec;
			}
		}
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(playerX >= 600)
				playerX = 600;
			else 
				moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(playerX < 10)
				playerX = 10;
			else 
				moveLeft();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			if (!play)
			{
				play = true;
				
				int random_positionX = (int)Math.floor(Math.random()*(max-min+1)+min);
				ballPosX = random_positionX;
				ballPosY = 350;
				ballXDirec = -1;
				ballYDirec = -2;
				playerX = 300;
				ballPosX = random_positionX;
				ballPosY = 530;
				score = 0;
				totalBricks = 21;
				map = new MapGenerator(3, 7);
				
				repaint();
			}
		}
		
	}
	
	public void moveRight()
	{
		play = true;
		playerX = playerX + 20;
	}

	public void moveLeft()
	{
		play = true;
		playerX = playerX - 20;
	}
}