package cntest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class tcpc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket s;
		try{
			s = new Socket(InetAddress.getLocalHost(), 9210);
			String fname;
			Scanner in = new Scanner(System.in);	
			System.out.println("Enter file to be searched : ");
			fname = in.nextLine();
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println(fname);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String msg;
			while((msg=br.readLine())!=null)
				System.out.println(msg);
			s.close();
			
		}
		catch(Exception e){
			
		}
	}

}
