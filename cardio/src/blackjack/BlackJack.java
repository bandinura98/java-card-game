package blackjack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cardio.Card;
import cardio.Deck;

public class BlackJack extends JFrame{
	private static final long serialVersionUID = -1547079723606126155L;
	private Deck deck;
	private ArrayList<Card> cards;
	private JPanel panel;
	private JPanel userCardPanel;
	private JPanel softCardPanel;//boterinna
	private JPanel twoTimesPanel;
	
	private JPanel butonHolder;
	private JButton drawCard;
	private JButton results;
	private JButton twoTimes;//it can not be able to be a double (guess why :D)
	private JButton bet;
	private JButton saveExit;
	
	private JPanel resultHolder;
	private JTextField userResult;
	private JTextField softResult;
	private JTextField condition;
	private JTextField betCash;
	
	private JSlider betSlider;
	private int minValue = 0,maxValue;
	
	protected int prefferedX = 500;
	protected int prefferedY = 500;
	
	private boolean betok = false;
	
	private Logic logic= new Logic();
	
	public BlackJack() {
		panel = new JPanel();
		
		deck = new Deck();
		cards = deck.getDeck();
		
		cards.get(2).hixe();
		cards.get(3).hixe();
		cards.get(4).hixe();
		
		userCardPanel = new JPanel(new GridLayout(1,5));
		softCardPanel = new JPanel(new GridLayout(1,5));
		twoTimesPanel = new JPanel(new GridLayout(1,5));
		
		
		for (int i = 0; i < 15; i++) {
			if(i<5) {
				userCardPanel.add(cards.get(i));
			}else if(i<10) {
				cards.get(i).hixe();//þimdilik hayd olarak kalsýn daha sonrasýnda indeksleri setlememiz gerekecek (gosh its so long fuck me plz)
				twoTimesPanel.add(cards.get(i));//yada locikte sikiþtiririz boolean atarýz burdan kurtarýrýz ama olmasý gereken getter setter kullanmak
			}
			else {
				cards.get(i).hixe();
				softCardPanel.add(cards.get(i));
			}
		}
		
		
		butonHolder = new JPanel(new GridLayout(1,6));
		
		results = new JButton("Results");
		results.addActionListener(resultsListener);
		
		twoTimes = new JButton("Double");
		
		
		saveExit = new JButton("Save&Exit");
		saveExit.addActionListener(saveExitListener);
		
		drawCard = new JButton("Draw card");
		drawCard.addActionListener(drawCardListener);
		
		bet = new JButton("Bet");
		bet.addActionListener(betlistener);
		
		butonHolder.add(drawCard);
		butonHolder.add(twoTimes);
		butonHolder.add(results);
		butonHolder.add(bet);
		butonHolder.add(saveExit);
		
		
		resultHolder = new JPanel(new GridLayout(1,4));
		condition = new JTextField("win/lose");
		condition.setEditable(false);
		userResult = new JTextField("user total card");
		userResult.setEditable(false);
		softResult = new JTextField("Bank total card");
		softResult.setEditable(false);
		betCash = new JTextField("money");
		betCash.setEditable(false);
		
		resultHolder.add(condition);
		resultHolder.add(userResult);
		resultHolder.add(softResult);
		resultHolder.add(betCash);
		
		maxValue = logic.getMoney();
		
		betSlider = new JSlider(JSlider.VERTICAL , minValue , maxValue , minValue);
		betSlider.addChangeListener(betSliderListener);
		//betSlider.setPaintTicks(true);
		//betSlider.setPaintLabels(true);
		
		
		userCardPanel.setBounds((prefferedX/2)-((prefferedX/10)*4), prefferedY-((prefferedY/10)*3), ((prefferedX/5)*4), ((prefferedY/10)*2));
		softCardPanel.setBounds((prefferedX/3)-((prefferedX/4)), prefferedY/10, ((prefferedX/5)*4), ((prefferedY/10)*2));
		twoTimesPanel.setBounds(userCardPanel.getX() , userCardPanel.getY() - ((prefferedY/10)*2), ((prefferedX/5)*4), ((prefferedY/10)*2));
		butonHolder.setBounds(0, 0, prefferedX, prefferedY/10);
		resultHolder.setBounds((prefferedX/2)-((prefferedX/5)*2), twoTimesPanel.getY()-prefferedY/5, (prefferedX/5)*4, prefferedY/5);
		betSlider.setBounds(0, (prefferedY/10), prefferedX/14, prefferedY-(prefferedY/5));
		
		//System.out.println(userCardPanel.getY());
		
		
		
		
		
		panel.setLayout(null);//242, 245, 242
		panel.add(userCardPanel);//29, 242, 5
		panel.add(softCardPanel);
		panel.add(butonHolder);
		panel.add(twoTimesPanel);
		panel.add(resultHolder);
		panel.add(betSlider);
		
		//panel.setBackground(new Color(8, 227, 0));dark grey// white light grey// white
		//panel.setBackground(new Color(29,242,5));dark grey// white light grey// white
		panel.setBackground(new Color(242,242,242));
		
		this.add(panel);
		
		setVisible(true);
		setSize(new Dimension(prefferedX,prefferedY));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	ActionListener drawCardListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {//
			
			if(betok == true) {
				if(cards.get(1).getStatus() == false) {
					for (int i = 9; i < 15; i++) {
						cards.get(i).hixe();
					}
				}
				for (int i = 0; i < 5; i++) {
					if((cards.get(i).getStatus()) == false) {
						cards.get(i).revealCard();
						//int totals = logic.totalValues(cards.get(i).getValue());
						i=5;
						//System.out.println(totals);
					}
				}
				
				int totals = 0;
				
				for (int i = 0; i < 5; i++) {
					if((cards.get(i).getStatus()) == true) {
						totals += logic.totalValues(cards.get(i).getValue());
						
					}
				}
				//System.out.println(totals);
				userResult.setText(String.valueOf(totals));
			}
		}
	};
	
	ActionListener resultsListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int totals = 0;
			
			for (int i = 0; i < 5; i++) {
				if((cards.get(i).getStatus()) == true) {
					totals += logic.totalValues(cards.get(i).getValue());
				}
			}
			
			userResult.setText(String.valueOf(totals));
			
			int softTotal = 0;
			
			//cards.get(10).revealCard();
			
			for (int i = 10; i < 15; i++) {
				if(softTotal <= totals && totals < 22) {
					cards.get(i).revealCard();
					softTotal += logic.totalValues(cards.get(i).getValue());
				}
			}
			
			//System.out.println(totals);
			
			softResult.setText(String.valueOf(softTotal));
			
			if((softTotal < totals || 21 < softTotal) && totals < 22) {
				//System.out.println("congratulations big winner");// from (super mario bros prize castle)
				condition.setText("biiiig WINNER congrats");
				logic.setMoneyWin((Integer.parseInt(betCash.getText())));
				
			}else {
				condition.setText("you lost XD");
				logic.setMoneyLose((Integer.parseInt(betCash.getText())));
				//betSlider.setMaximum(logic.getMoney());
			}
			
			betSlider.setMaximum(logic.getMoney());
			
			deck.innerShufle(cards);//Collections.shuffle() doesnot work because java swing JTextField cant replace able while runtime (if it is replace able please send me as code my mail address = batuhansenogluis@gmail.com)
			for (int j = 0; j < 5; j++) {
				cards.get(j).hixe();
			}
			betok = false;
			//Collections.shuffle(cards);
			//System.out.println(cards.get(0).getValue() + cards.get(1).getValue());
		}
	};
	
	ActionListener betlistener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!(betCash.getText().equals("money") && betok == false)) {
				betok = true;
				logic.beton(betSlider);
				System.out.println(betok);
			}
		}
	};
	
	
	ActionListener saveExitListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(betok == false) {
				System.exit(1);// dispose();
			}else {
				JOptionPane.showMessageDialog(null, "before you exit you must finish this hand");
			}
		}
	};
	
	ChangeListener betSliderListener = new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			if(betok == false) {
				betCash.setText(String.valueOf(betSlider.getValue()));
				//logic.beton(betSlider);
			}
		}
	};
}