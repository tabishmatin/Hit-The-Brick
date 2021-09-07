package breakoutBall;

import javax.swing.JFrame;

//SecondFrame.java
public class homepage {
	private JFrame frame = new JFrame("Hit The Brick Game by Tabish Matin");
	
	public homepage() {
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(350,100,700,600);
		frame.setVisible(true);
		
		gameplay gamePlay = new gameplay();
		frame.add(gamePlay);
		frame.setResizable(false);
		
	}
}