package board;
/*
 * this class creates the board
 * it must be abstract class cuz ill run 2many card games
 * I MAKING THIS GAME CUZ ILL PLAY IT ohh gosh you so exausting(talking 2 my self no offancive security);)))))))
 * here : https://www.youtube.com/watch?v=Qg1qZq5yjps&list=RDGMEMYH9CUrFO7CfLJpaD7UR85wVMKrVC5dm5fFc&index=6
 * listen smt good
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JFrame;

import board.Board;
import cardio.Card;
import cardio.Deck;

public class Board extends JFrame{
	private static final long serialVersionUID = -1547079723606126155L;
	private Deck deck;
	private ArrayList<Card> cards;
	private JPanel panel;
	private JPanel cardPanel;
	
	protected int prefferedX = 500;
	protected int prefferedY = 500;
	
	public Board() {
		panel = new JPanel();
		
		deck = new Deck();
		cards = deck.getDeck();
		
		cardPanel = new JPanel(new GridLayout(1,2));
		cardPanel.setBounds((prefferedX/2)-75, prefferedY-160, 150, 130);//100 e 70 , 160 a 130
		
		cardPanel.add(cards.get(0));
		cardPanel.add(cards.get(1));
		
		panel.setLayout(null);//242, 245, 242
		panel.add(cardPanel);//29, 242, 5
		
		//panel.setBackground(new Color(8, 227, 0));dark grey// white light grey// white
		//panel.setBackground(new Color(29,242,5));dark grey// white light grey// white
		panel.setBackground(new Color(242,242,242));
		this.add(panel);
		
		setTitle("sdsad");
		setVisible(true);
		setSize(new Dimension(prefferedX,prefferedY));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Board();
	}
}
