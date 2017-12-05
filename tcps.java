package cntest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class tcps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss;
		try{
			ss=new ServerSocket(9210);
			Socket rp =ss.accept();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(rp.getInputStream()));
			
			String fn = br.readLine();
			System.out.println(fn + " Requested");
			
			PrintWriter pw = new PrintWriter(rp.getOutputStream(), true);
			BufferedReader fr = new BufferedReader(new FileReader("C:/Users/Aman/workspace/khatri/src/cntest/" + fn ));
			String str;
			while((str=fr.readLine())!=null)
				pw.println(str);
			rp.close();
			
		}
		catch(Exception e){
			
		}
	}

}
