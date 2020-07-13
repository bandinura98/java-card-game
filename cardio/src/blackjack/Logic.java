package blackjack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JSlider;

public class Logic {
	
	//private int getUserx;
	
	public Logic() {// o birliyi en son bakarýz
		
	}
	public Integer totalValues(String[] a) {
		int returner = 0;
		
		for (int i = 0; i < a.length; i++) {
			if(a[i].equals("J") || a[i].equals("Q") || a[i].equals("K")) {//asý opsyonel ayarlýcaz
				returner += 10;
			}else {
				returner += Integer.parseInt(a[i]);
			}
		}
		return returner;
	}
	public Integer totalValues(String a) {
		int returner = 0;
		
		if(a.equals("J") || a.equals("Q") || a.equals("K")) {
			returner += 10;
		}else {
			returner += Integer.parseInt(a);
		}
		
		if(returner > 21) {
			return 0;
		}else {
			return returner;
		}
	}
	public void beton(JSlider bet) {
		
			
		bet.setMaximum(getMoney() - bet.getValue());
		
		
	}
	
	public void setMoneyWin(int i) {
		
		try {
			File file = new File("docs/lastone.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String tempStr = br.readLine();
			
			br.close();
			
			File file2 = new File("docs/user.txt");
			BufferedReader br2 = new BufferedReader(new FileReader(file2));
			
			String str;
			
			ArrayList<String> arrList = new ArrayList<String>();
			
			while((str = br2.readLine()) != null) {
				if(str.equals(tempStr)) {
					
					String[] strings = str.split(",");
					
					int temp = getMoney()-i;
					
					i = i * 2;
					i = i + temp;
					
					arrList.add(strings[0] + "," + i);
					
					File file1p2 = new File("docs/lastone.txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(file1p2,false));
					
					bw.write(strings[0] + "," + i);
					bw.close();
					
				}else {
					arrList.add(str);
				}
				
			}
			br2.close();
			
			writeArrList(arrList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setMoneyLose(int i) {
		try {
			File file = new File("docs/lastone.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String tempStr = br.readLine();
			
			br.close();
			
			
			
			
			File file2 = new File("docs/user.txt");
			BufferedReader br2 = new BufferedReader(new FileReader(file2));
			
			String str;
			
			ArrayList<String> arrList = new ArrayList<String>();
			
			while((str = br2.readLine()) != null) {
				if(str.equals(tempStr)) {
					
					String[] strings = str.split(",");
					
					i = getMoney()-i;
					
					arrList.add(strings[0] + "," + i);
					
					File file1p2 = new File("docs/lastone.txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(file1p2,false));
					
					bw.write(strings[0] + "," + i);
					bw.close();
					
				}else {
					arrList.add(str);
				}
				
			}
			
			writeArrList(arrList);
			
			br2.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getMoney() {
		int total = 0;
		try {
			File file = new File("docs/lastone.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String str = reader.readLine();
			
			String[] strings = str.split(",");
			
			total = Integer.parseInt(strings[1]);
			reader.close();
		}catch (IOException e) {e.printStackTrace();}
		
		if(total == 0) {
			System.err.println("reading from docs/lastone.txt is failed from Logic.java getMoney()");
		}
		
		return total;
	}
	public void writeArrList(ArrayList<String> arrList) {
		try {
			File file = new File("docs/user.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,false));
			
			for (int i = 0; i < arrList.size(); i++) {
				bw.write(arrList.get(i));
				bw.newLine();
			}
			
			
			bw.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}