package enterance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import blackjack.BlackJack;

public class Sign extends JFrame{
	private static final long serialVersionUID = 4187904996981021309L;
	
	private JPanel panel;
	private JTextField singupField;
	private JButton inside;
	
	private int prefferedX = 500;
	private int prefferedY = 500;
	
	private boolean userExists = false;
	
	public Sign() {
		panel = new JPanel(new GridLayout(2,1));
		
		singupField = new JTextField("ENTER A VALID NAME");
		singupField.setBackground(Color.DARK_GRAY);
		singupField.setForeground(Color.WHITE);
		singupField.addMouseListener(mouseListener);
		
		inside = new JButton("START GAME");
		inside.setBackground(Color.DARK_GRAY);
		inside.setForeground(Color.WHITE);
		inside.addActionListener(actionListener);
		
		panel.add(singupField);
		panel.add(inside);
		
		this.add(panel);
		setSize(new Dimension(prefferedX,prefferedY));
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("sign");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(false);
	}
	MouseListener mouseListener = new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {
			singupField.setText("");
		}
	};
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean isCommaUsed = false;
			
			if(singupField.getText().contains(",")) {
				isCommaUsed = true;
				JOptionPane.showMessageDialog(null, "you cannot use ',' in your username");
			}
			
			
			if(!(singupField.getText().equalsIgnoreCase("")) && !(singupField.getText().equalsIgnoreCase("ENTER A VALID NAME")) && isCommaUsed == false) {
				try {
					File file = new File("docs/user.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					
					//String[] strings = 
					
					String temp = new String();
					
					while((temp = br.readLine()) != null && userExists == false) {
						
						String[] strs = temp.split(",");
						
						if(strs[0].equals(singupField.getText())) {
							File file2 = new File("docs/lastone.txt");
							BufferedWriter bw = new BufferedWriter(new FileWriter(file2,false));
							
							bw.write(temp);
							bw.close();
							userExists = true;
						}
					}
					
					br.close();
					
					if(userExists == false) {
						File file3 = new File("docs/user.txt");
						BufferedWriter bw = new BufferedWriter(new FileWriter(file3,true));//why i dont use JavasScriptObjectNotation aka JSON i dont know why :D
						
						bw.write(singupField.getText() + ",500");
						bw.newLine();
						bw.close();
						
						File file4 = new File("docs/lastone.txt");
						BufferedWriter bw2 = new BufferedWriter(new FileWriter(file4));
						
						bw2.write(singupField.getText() + ",500");
						bw2.close();
					}
				}catch (IOException e2) {e2.printStackTrace();}
				new BlackJack();
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "THIS INPUT VALUE IS CANNOT BE ABLE TO USEABLE FOR THIS PROGRAM PLEASE CHANGE THE VALUES");
			}
		}
	};
}