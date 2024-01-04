package java_programs;
//import java.math.BigInteger;
import java.util.Scanner;

public class credit_card {

	static boolean validate(int no, int bal, int amt, String ind) {
		String sno = String.valueOf(no);
		String sbal = String.valueOf(bal);
		String samt = String.valueOf(amt);
		String sind = String.valueOf(ind);
		
		if(sno.length()!=8) {
			System.out.println("c1 failed");
			return false;
		}
		
		char a = sno.charAt(0);
		char b = sno.charAt(1);
		
		if(a!='3' && (b!='6' || b!='7')) {
			System.out.println("c2 failed");
			return false;
		}
			
		//36345621
		
		/*
		int sum=0;
		for(int i=2; i<sno.length(); i++) {
			
			int s = sno.charAt(i);
			System.out.println(s);
			sum = sum + s;
			//BigInteger s1 = BigInteger.valueOf(s);
			//System.out.println(s1);
			//int s2 = s1.intValue();
			//System.out.println(s2);
			//sum = sum + s1;
			System.out.println(sum);
		}*/
		
		int sum=0;
		for(int i=2; i<sno.length(); i++) {
			char s =  sno.charAt(i);
			int s1 = s - '0';
			sum = sum + s1;
		}
		
		if(sum>=36 || sum>=37) {
			System.out.println("c3 failed");
			return false;
		}
		
		if(ind.equals("y") && amt>bal) {
			System.out.println("c4 failed");
			return false;
		}
			
		if(sno.isEmpty() || sbal.isEmpty() ||samt.isEmpty() || sind.isEmpty()) {
			System.out.println("c5 failed");
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter card number: ");
		int no = sc.nextInt();
		System.out.print("Enter credit Balance: ");
		int bal = sc.nextInt();
		System.out.print("Enter Txn_amount: ");
		int amt = sc.nextInt();
		System.out.print("Enter Debit Indicator (Y/N): ");
		String ind = sc.next();
		
		if(validate(no, bal, amt, ind))
			System.out.println("valid records");
		else
			System.out.println("Invalid records");
		sc.close();
	}

}

//sample input
//Txn Record 1 - 36345621, 20000, 1000, Y
//Txn Record 2 - 37347621,40000,10000,Y
//Txn Record 3 - 37347898,20000,1000,Y
//Txn Record 4 - 37347191,2000,10000,Y
//Txn Record 5 - 37347191,20000,1000,N
