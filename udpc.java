package cntest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket ds;
		try{
			ds=new DatagramSocket();
			String s = "khatri power + ";
			DatagramPacket p = new DatagramPacket(s.getBytes(), s.length(), InetAddress.getLocalHost(), 9000);
			ds.send(p);
			
			byte[] buf = new byte[1000];
			DatagramPacket r = new DatagramPacket(buf, buf.length);
			ds.receive(r);
			System.out.println("Message Received : " +(new String(r.getData())).substring(0,r.getLength()));
		}
		catch(Exception e){
			
		}
	}

}
