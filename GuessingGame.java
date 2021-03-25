
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class GuessingGame implements ActionListener{

	private int randNum = 0;
	private Random rand;
	private JLabel inputHintLabel;
	private JLabel guessHintLabel;
	private JLabel resultHintLabel;
	private JTextField userGuess; 
	private JButton guessButton;
	private JButton playAgainButton;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GuessingGame();
	}
public GuessingGame() {
		rand = new Random();
		this.randNum = rand.nextInt(100)+1;
		System	.out.println(randNum);
		JFrame frame = new JFrame("Guessing Game");
		frame.setLayout(new FlowLayout());
		frame.setBounds(20,20,240,160);
		this.userGuess = new JTextField(10);
		this.userGuess.addActionListener(this);
		this.guessButton = new JButton("Guess");
		this.guessButton.addActionListener(this);
		this.playAgainButton = new JButton("Play Again");
		this.playAgainButton.addActionListener(this);
		this.inputHintLabel = new JLabel("Enter your guess:");
		this.guessHintLabel = new JLabel("");
		this.resultHintLabel = new JLabel("");
		frame.add(this.inputHintLabel);
		frame.add(this.userGuess);
		frame.add(this.guessButton);
		frame.add(this.guessHintLabel);
		frame.add(this.resultHintLabel);
		frame.add(this.playAgainButton);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.guessButton)) {
			int guessNum = Integer.parseInt(this.userGuess.getText());
			if(guessNum > this.randNum) {
				this.guessHintLabel.setText("Too Height!");
			}else if(guessNum < this.randNum) {
				this.guessHintLabel.setText("Too Low!");
			}else {
				this.guessHintLabel.setText("You got it!");
			}
			this.resultHintLabel.setText("last guess was: "+guessNum);
		}else if(e.getSource().equals(this.playAgainButton)){
			this.randNum = rand.nextInt(100)+1;
			this.userGuess.setText("");
			this.guessHintLabel.setText("");
			this.resultHintLabel.setText("");
		}else if(e.getSource().equals(this.userGuess)) {
			this.guessHintLabel.setText("You pressed Enter.Please press the Guess Button!");
		}
	}
	
}	

