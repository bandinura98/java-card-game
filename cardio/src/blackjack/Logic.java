package blackjack;

public class Logic {
	public Logic() {
		
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
}
