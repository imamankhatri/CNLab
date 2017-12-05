package cntest;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {

	static BigInteger p,q,f,n,e,d;
	static int bl = 1024;
	static Random r;
	
	public static byte[] enc(byte[] b){
		return (new BigInteger(b)).modPow(e,n).toByteArray();
	}
	
	public static byte[] dec(byte[] b){
		return (new BigInteger(b)).modPow(d, n).toByteArray();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		r = new Random();
		p=BigInteger.probablePrime(bl, r);
		q=BigInteger.probablePrime(bl, r);
		n=p.multiply(q);
		f=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e=BigInteger.probablePrime(bl, r);
		while(f.gcd(e).compareTo(BigInteger.ONE)>0 &&e.compareTo(f)<0)
			e.add(BigInteger.ONE);
		d=e.modInverse(f);
		String m,e,d;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string : ");
		m=in.nextLine();
		e=(enc(m.getBytes())).toString();
		System.out.println("Encryped bytes : " + e.substring(0,e.length()));
		d=new String(dec(enc(m.getBytes())));
		System.out.println("Dec : "+ d);
	}

}
