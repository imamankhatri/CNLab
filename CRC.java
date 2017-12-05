package cntest;

import java.util.Arrays;
import java.util.Scanner;

public class CRC {

	public static int[] comp(int trans[],int gen[])
	{
		int c=0,i;
		int temp[]=new int[trans.length];
		for ( i = 0; i < trans.length; i++)
            temp[i]=trans[i];
		
		while(true){
			for(i=0;i<gen.length;i++)
				temp[c+i]^=gen[i];
			while(temp[c]==0&&c!=temp.length-1)
				c++;
			if(temp.length-c<gen.length)
				break;
		}
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mb,gb,tb;
		int m[],g[],a[],t[],r[];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of Message bits : ");
		mb = in.nextInt();
		int i;
		m=new int[mb];
		System.out.println("Enter Message Bits :");
		for(i=0;i<mb;i++)
			m[i]=in.nextInt();
		System.out.println("Enter number of Generator bits : ");
		gb = in.nextInt();
		g=new int[gb];
		System.out.println("Enter Generator Bits :");
		for(i=0;i<gb;i++)
			g[i]=in.nextInt();
		tb=mb+gb-1;
		a=new int[tb];
		r=new int[tb];
		t=new int[tb];
		System.out.println("\nMessage Bits are :");
		for(i=0;i<m.length;i++)
			System.out.print(m[i]);
		System.out.println("\nGenerator Bits are :");
		for(i=0;i<g.length;i++)
			System.out.print(g[i]);
		for(i=0;i<m.length;i++)
			a[i]=m[i];
		for(i=0;i<a.length;i++)
			r[i]=a[i];
		r = comp(a,g);
		for(i=0;i<r.length;i++)
			t[i]=(int)(a[i]^r[i]);
		
		System.out.println("\nTransmitted Message : ");
		for(i=0;i<t.length;i++)
			System.out.print(t[i]);
		
		System.out.println("\nEnter Received Message : ");
		for(i=0;i<a.length;i++)
			a[i]=in.nextInt();
		System.out.println("gg1");
		
		System.out.println("\nReceived message : ");
		for(i=0;i<a.length;i++)
			System.out.print(t[i]);
		r=comp(a,g);
		System.out.println("gg2");
		for(i=0;i<r.length;i++)
		{
			if(r[i]!=0)
			{
				System.out.println("Error");
				break;
			}
			if(i==r.length-1)
				System.out.println("No error");
		}
		
		
		
			
				
				
		
		
	}

}
