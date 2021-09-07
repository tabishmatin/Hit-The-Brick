package breakoutBall;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  

//bug free frames

public class breakoutBallGame {
	private JFrame frame = new JFrame("Hit The Brick Game by Tabish Matin");
	private JButton button = new JButton("Start Game");
	private JLabel label = new JLabel("Welcome to the HIT THE BRICK Game");
	private JPanel panel = new JPanel();
	private JLabel userLabel;
	public static JTextField name;
	
	public breakoutBallGame() {
	
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(350,100,700,600);
		panel.setLayout(null);
		
	//	panel.setLayout(new GridLayout(2,1));
	//	panel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
	//	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.setBackground(Color.BLACK);
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
		frame.add(panel, BorderLayout.CENTER);
		
		label.setBounds(240,100,500,50);
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		userLabel = new JLabel("Name: ");
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(200,150,100,50);
		panel.add(userLabel);
		
		name = new JTextField(20);
		name.setBounds(250,160,250,30);
		panel.add(name);
		
		button.setBounds(290,400,120,50); 
		panel.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new homepage();
			}
		});
		frame.setSize(700,600);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public static void main(String[] args) {
		new breakoutBallGame();
	}
}



/* Code with start game frame with bugs */

//public class breakoutBallGame implements ActionListener 
//{
//	static private JFrame frame;
//	private JPanel panel;
//	private JLabel label;
//	private JButton button;
//	gameplay gamePlay;
//	
//	public breakoutBallGame()
//	{
//		frame = new JFrame("Breakout Ball Game");
//		frame.setBounds(350, 100, 700, 600);
//		
////		panel.setLayout(new FlowLayout());  
//		label = new JLabel("Welcome to the Breakout Ball Game");
//		
//		button = new JButton("Start Game");
//		button.setBounds(50,80,30,30); 
//		button.addActionListener(this);
//		
//		panel = new JPanel();
//		panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
//		panel.setLayout(new GridLayout(2,1));
//		panel.add(label);
//		panel.add(button);
//		
//		frame.add(panel, BorderLayout.CENTER);
//		
//		frame.setResizable(false);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
//	}
//	
//	public static void main(String[] args)
//	{
//		new breakoutBallGame();
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		frame.dispose();
//		gamePlay = new gameplay();
//		
//		frame.setBounds(350, 100, 700, 600);
//		frame.add(gamePlay);
//		frame.setResizable(false);
//	    frame.setVisible(true);  
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//	}
//}


/* Code directly into the game */

//public class breakoutBallGame {
//
//	public static void main(String[] args)
//	{
//		
//		JFrame frame = new JFrame("Breakout Ball Game");  
//		gameplay gamePlay = new gameplay();
//		
//		frame.setBounds(10, 10, 700, 600);
//		
////        JPanel panel = new JPanel();  
////        panel.setLayout(new FlowLayout());  
////      
////        JLabel label = new JLabel("Welcome to the Breakout Ball Game");  
////        panel.add(label); 
////        
////        JButton button = new JButton();  
////        button.setText("Start Game");  
////         
////        panel.add(button);  
////        frame.add(panel);  
////        frame.setSize(900, 700);  
////        frame.setLocationRelativeTo(null);  
//       
//		frame.add(gamePlay); 
//		frame.setResizable(false);
//	    frame.setVisible(true);  
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//	}
//}