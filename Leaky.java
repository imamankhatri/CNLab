package cntest;

import java.util.Scanner;

public class Leaky {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bs;
		System.out.println("Enter bucket size : ");
		Scanner in = new Scanner(System.in);
		bs=in.nextInt();		
		int gb[], p[],ng,np,rb,tp=0;
		System.out.println("Enter number of groups : ");
		ng=in.nextInt();
		gb=new int[ng];
		p=new int[ng];
		rb=0;
		int obw;
		for(int i=0;i<ng;i++)
		{
			System.out.println("Enter bandwidth for group "+(i+1));
			gb[i]=in.nextInt();
			System.out.println("Enter packets for group "+(i+1));
			p[i]=in.nextInt();
		
			while(tp+p[i]>bs)
			{
				System.out.println("Bucket overflow!\nEnter value less than "+(bs-tp));
				p[i]=in.nextInt();
			}
			
			rb+=gb[i]*p[i];
			tp+=p[i];
			
		}
		System.out.println("Enter output bandwidth : ");
		obw = in.nextInt();
		int tb=rb;
		System.out.println("Total packets :"+tp);
		System.out.println("Total Bandwidth :"+tb);
		while(tp>0&&tb>obw)
		{
			System.out.println("Packet sent \n"+(--tp)+" packets remain");
			System.out.println("Bandwidth left : " +(tb-=obw));
			if(tp>0&&tb<obw)
			{
				System.out.println(tp+"Packets failed");
			}
		}
		
	}

}
