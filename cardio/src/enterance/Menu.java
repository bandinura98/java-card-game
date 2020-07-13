package enterance;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame{
	private static final long serialVersionUID = 8972380142049795874L;
	
	private JPanel panel;
	private JLabel picture;
	private JPanel holder;
	private JButton games;
	private JButton settings;
	private JButton sign;
	
	private final int prefferedX = 500;
	private final int prefferedY = 500;
	
	public Menu() {
		panel = new JPanel(new GridLayout(2,1));
		
		picture = new JLabel();
		picture.setIcon(new ImageIcon("file:///C:/Users/batuh/Desktop/crm/assets/images/svg/chart.svg"));//dene
		
		
		holder = new JPanel(new GridLayout(3,1));
		games = new JButton("Games");
		games.addActionListener(gameslistener);
		settings = new JButton("Settings");
		sign = new JButton("sign");
		sign.addActionListener(signlistener);
		sign.setToolTipText("if you sign in you will be able to keep your scores and money from games that you have played!!");
		
		holder.add(games);
		holder.add(settings);
		holder.add(sign);
		
		
		
		panel.add(picture);
		panel.add(holder);
		
		add(panel);
		
		setSize(prefferedX, prefferedY);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	ActionListener gameslistener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Games();
			dispose();
		}
	};
	ActionListener signlistener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Sign();
			dispose();
		}
	};
}
