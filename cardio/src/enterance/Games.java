package enterance;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import blackjack.BlackJack;

public class Games extends JFrame{
	
	private static final long serialVersionUID = -9053597495009451219L;

	private JPanel holder;
	
	private JButton blackjack;
	
	private int prefferedX;
	private int prefferedY;
	
	public Games() {
		
		initialize();
		
		holder = new JPanel(new GridLayout(1, 1));//deðiþecek
		
		blackjack = new JButton("blackjack");
		blackjack.addActionListener(blackjacklistener);
		
		holder.add(blackjack);
		
		this.add(holder);

		setSize(prefferedX, prefferedY);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initialize() {
		Settings settings = new Settings();
		prefferedX = settings.getXX();
		prefferedY = settings.getYY();
	}
	
	
	ActionListener blackjacklistener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new BlackJack();
			dispose();
		}
	};
}
