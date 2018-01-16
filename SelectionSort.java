package Sem3;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
	static void sel_sort(int A[])
	{
		int size=A.length;
		int small;
		for(int i=0;i<size;i++)
		{
			small=i;
		for(int j=i+1;j<size-1;j++)
		{
			if(A[small]>A[j])
			small=j;
		}
			int t=A[i];
			A[i]=A[small];
			A[small]=t;
		}
		}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		long time1,time2,time3;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the size");
		int size=input.nextInt();
		int A []=new int[size];
		Random rand=new Random();
		for(int i=0;i<size;i++)
			A[i]=rand.nextInt(500)+1;
		/*System.out.println("Array elements are");
		for(int i=0;i<size;i++)
			System.out.println(A[i]);*/
		time1=System.currentTimeMillis();
		System.out.println(time1);
		sel_sort(A);
		time2=System.currentTimeMillis();
		/*System.out.println("Array after sorting");
		for(int i=0;i<size;i++)
			System.out.println(A[i]);*/
		System.out.println(time2);
		time3=time2-time1;
		System.out.println("Total time taken (in milliseconds):" + time3);
	}

}
