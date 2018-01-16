package Sem3;
import java.util.Scanner;

public class MCM {
	
	static int m[][]=new int[6][6];
	static int s[][]=new int[6][6];
	MCM()
	{
		for(int i=0;i<m.length;i++)
			{
			for(int j=0;j<m.length;j++)
				m[i][j]=0;
			}
		for(int i=0;i<s.length;i++)
		{
		for(int j=0;j<s.length;j++)
			s[i][j]=0;
		}
	}
	static void matrix_chain_order(int dim[])
	{
	int n=dim.length-1;
	int i,j,k,l,q;
	for(i=0;i<n;i++)
		m[i][i]=0;
	
	for(l=2;l<=n;l++)
	{
		for(i=1;i<=n-l+1;i++)
			{
			j=i+l-1;
			m[i][j]=Integer.MAX_VALUE;
			for(k=i;k<=j-1;k++)
				{
				q=m[i][k]+m[k+1][j] + dim[i-1]*dim[k]*dim[j];
				if(q<m[i][j])
					{
					m[i][j]=q;
					s[i][j]=k;
					}
				}
			}
	}
	System.out.println("Matrix M ");
	for(i=1;i<=n;i++)
		{
		System.out.println();
		for(j=1;j<=n;j++)
			System.out.print(m[i][j] + "\t");
		}
	System.out.println("\n\nMatrix S ");
	for(i=1;i<=n;i++)
	{
		System.out.println();
	for(j=1;j<=n;j++)
			System.out.print(s[i][j] + " ");
	}	
	}
	static void print_optimal_parens(int s[][],int i,int j)
	{
		if(i==j)
			System.out.print("A[" + i + "]");
		else
			{
			System.out.print("(");
			print_optimal_parens(s,i,s[i][j]);
			print_optimal_parens(s,s[i][j]+1,j);
			System.out.print(")");
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the no. of dimensions");
		int dim=input.nextInt();
		System.out.println("Enter dimensions");
		int p[]=new int[dim];
		for(int i=0;i<dim;i++)
			p[i]=input.nextInt();
		matrix_chain_order(p);
		System.out.println("\n\nOptimal Parenthesis");
		print_optimal_parens(s,1,dim-1);
	}

}
