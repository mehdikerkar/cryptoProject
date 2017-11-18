package panel;

public class Algorithmes {


//the mod for to code Cesar and Vigenere id modulo
	public static String codeCesar(String text, Integer x, int mod) {

		char[] texta = text.toCharArray();
		String code= "";

		for (int i=0;i<texta.length;i++) {
			code = code + (char)(  ( ((int)texta[i])+x )%mod  );	
		}
		return code;
	}
	public static String decodeCesar(String text, Integer x, int mod) {

		char[] texta = text.toCharArray();
		String code= "";

		for (int i=0;i<texta.length;i++) {
			code = code + (char)(   ( ((int)texta[i])-x )%mod   );	
		}
		return code;

	}

	public static String codeVigenere(String msg,String key, int mod) {
		
		char[] msgc;
		char[] keyc = key.toCharArray();
		String code= "";
		int msgsize=msg.length();

		while(msgsize % key.length()!=0) {
			msgsize++;
			msg=msg+"X";
		}
		msgc = msg.toCharArray();
		for (int i=0;i<msgsize;i++) {
			System.out.println("msgc["+i+"]: "+(int)msgc[i]+" keyc["+i%key.length()+"]: "+(int)keyc[i%key.length()]+" somm%126["+i+"]: "+(   ((int)msgc[i]) + ((int)keyc[i%key.length()])   )%mod);
			code = code + (char)(   (   ((int)msgc[i]) + ((int)keyc[i%key.length()])   )%mod  );	
		}
		System.out.println("msg: "+msg+" == code: "+code);
		
		return code;
		
	}
	public static String decodeVigenere(String msg,String key,int mod) {
		char[] msgc;
		char[] keyc = key.toCharArray();
		String code= "";
		int msgsize=msg.length();

		while(msgsize % key.length()!=0) {
			msgsize++;
			msg=msg+"X";
		}
		msgc = msg.toCharArray();
		for (int i=0;i<msgsize;i++) {
			code = code + (char)(   mod+(   ((int)msgc[i]) - ((int)keyc[i%key.length()])   )%mod  );	
		}
		System.out.println("msg: "+msg+" == code: "+code);
		
		return code;
	}
	
	public static String codePolybe(String msg, String key, String mod) {
		
		char[] msgc = msg.toCharArray();
		String code= "";
		int f=0,e=0;
		char[][] care = null;
		if(mod=="ascci") {
			 care = matAscci(); f=16;e=16;
		}else {
			care = matAlphaNum();f=10;e=9;
		}

		/*
		for (int i=0; i<16; i++) {
			for (int j=0; j<16; j++) {
				care[i][j]=ascci.charAt(k++);
				System.out.print(care[i][j]+", ");
			}
			System.out.print("\n");
		}*/
		
		int i=-1,j=0;
		for(int k=0;k<=msgc.length;k++) {
			while(msgc[k]!=care[++i][j] || i<f) {
				while(msgc[k]!=care[i][j] || j<e) {
					if (msgc[k]==care[i][j]) {
						code=code+i+j;
						break; 
					}
					j++;
				}
				if (msgc[k]==care[i][j])
					break;
			}
		}
		
		

		return code;
	}
	public static char[][] matAscci() {
		String ascci="";
		char[][] care = new char [16][16];
		int k=0;
		
		for (int c=0; c<256; c++) {
			ascci=ascci+(char)c;
		}
		for (int i=0; i<16; i++) {
			for (int j=0; j<16; j++) {
				care[i][j]=ascci.charAt(k++);
				System.out.print(care[i][j]+", ");
			}
			System.out.print("\n");
		}
		return care;
	}
	public static char[][] matAlphaNum() {
		String alphanum="";
		char[][] care = new char [10][9];
		int k=0,m=0;
		
		for (int c=33; c<123; c++) {
			alphanum=alphanum+(char)c;
			System.out.print(alphanum.charAt(m++)+", ");
		}
		System.out.print("\n\n");
		for (int i=0; i<10; i++) {
			for (int j=0; j<9; j++) {
				care[i][j]=alphanum.charAt(k++);
				System.out.print(care[i][j]+", ");
			}
			System.out.print("\n");
		}
		return care;
	}
	
	public static void main (String[] args) {
		/*
		String leftAlignFormat = "| %-4s | %-4s | %-4s | %-4s | %-4s | %-4s | %-4s | %-4s |%n";

		System.out.format("+------+------+------+------+------+------+------+------+%n");
		System.out.format("| CAR  | ID   | ID   | ID   | CAR  | ID   | ID   | ID   |%n");
		System.out.format("+------+------+------+------+------+------+------+------+%n");
		for (int i = 32; i < 123; i++) {
		    System.out.format(leftAlignFormat, (char)i,(char)++i,(char)++i,(char)++i,(char)i,(char)++i,(char)++i,(char)++i);
		}
		System.out.format("+------+------+------+------+------+------+------+------+%n");
		*/

		
		codePolybe("msg","key","alphanum");
		
	}
}
