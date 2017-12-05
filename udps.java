package cntest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class udps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket ds;
		try
		{
			ds = new DatagramSocket(9000);
			byte[] b = new byte[1000];
			DatagramPacket p = new DatagramPacket(b, b.length);
			ds.receive(p);
			System.out.println("Server running, Enter the string");
			
			String str1;
			Scanner in = new Scanner(System.in);
			str1 = in.nextLine();
			
			String resp = (new String(p.getData())).substring(0,p.getLength()).concat(str1);
			
			DatagramPacket r = new DatagramPacket(resp.getBytes(),resp.length(),p.getAddress(),p.getPort());
			ds.send(r);
			
		}
		catch(Exception e){
			
		}

	}

}
