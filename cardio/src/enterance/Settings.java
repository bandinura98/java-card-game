package enterance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Settings {
	
	private ArrayList<String> settingsList;
	
	public Settings() {
		settingsList = getVals();
	}
	
	public ArrayList<String> getVals() {
		ArrayList<String> myarr = new ArrayList<String>();
		try {
			File file = new File("docs/settings.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String temp = new String();
			
			while((temp = br.readLine()) != null) {
				myarr.add(temp);
			}
			br.close();
		}catch (IOException e) {e.printStackTrace();}
		return myarr;
	}
	
	
	public int getXX() {
		return Integer.parseInt(settingsList.get(0));
	}
	public int getYY() {
		return Integer.parseInt(settingsList.get(1));
	}
}