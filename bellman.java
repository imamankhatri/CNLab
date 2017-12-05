package cntest;

import java.util.Scanner;

import cn.Bellman;

public class bellman {
	
	static int d[];
	static int max = 999;
	static int nv;
	public static void eval(int a[][],int s){
		d=new int[nv+1];
		for(int i =1;i<=nv;i++)
			d[i]=max;
		d[s]=0;
		for(int n=1;n<=nv;n++)
			for(int sn=1;sn<=nv;sn++)
				for(int dn=1;dn<=nv;dn++)
					if(a[sn][dn]!=max)
						if(d[dn]>d[sn]+a[sn][dn])
							d[dn]=d[sn]+a[sn][dn];
		for(int n=1;n<=nv;n++)
			for(int sn=1;sn<=nv;sn++)
				for(int dn=1;dn<=nv;dn++)
					if(a[sn][dn]!=max)
						if(d[dn]>d[sn]+a[sn][dn])
							System.out.println("-ve cycle");
		
		for(int v=1;v<nv;v++)
			System.out.println("Dist from " +s +" to " +v+ " is "+d[v]);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nv=0;
		int s;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		nv=sc.nextInt();
		int a[][] = new int[nv+1][nv+1];
		System.out.println("Enter matrix:");
		for(int sn=1;sn<=nv;sn++)
			for(int dn=1;dn<=nv;dn++)
			{
				a[sn][dn]=sc.nextInt();
				if(sn==dn)
				{
					a[sn][dn]=0;
					continue;
				}
				if(a[sn][dn]==0)
					a[sn][dn]=max;
			}
		System.out.println("Enter source : ");
		s=sc.nextInt();
		Bellman B = new Bellman(nv);
		B.bme(s, a);
		sc.close();

	}

}
