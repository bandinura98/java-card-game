package cardio;

import java.awt.Color;

import javax.swing.JTextField;

public class Card extends JTextField {//jpanele çevirmemiz lazým jlabelle içini doldurucaz
	private static final long serialVersionUID = 2353547558962106982L;
	
	private final String [] faces = {"Hearts","Spides","Diamonds","Clubs"};
	private String face;
	private final String[] values = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private String value;
	private final String cantsee = "";
	private boolean reveal = true;
	
	public Card getCard(int a , int b) {
		
		face = faces[a];
		value = values[b];
		
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);
		this.setEditable(false);
		this.setFocusable(true);
		this.setText(face + " " + value);
		
		return this;
	}
	public void hixe() {
		reveal = false;
		this.setText(cantsee);
	}
	public void revealCard() {
		reveal = true;
		this.setText(face + " " + value);
	}
	public boolean getStatus(){
		return reveal;
	}
	public String getValue() {
		return value;
	}
	public String getFace() {
		return face;
	}
	public void setBoth(String face , String value) {
		this.value = value;
		this.face = face;
	}
}