import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class BucketSort {
	
	/*static void insertion_sort(int A[]){
		int n=A.length;
		int i, key;
		for(int j=1;j<n;j++)
		{
		key=A[j];		
		i=j-1;
		while(i>-1 && A[i]>key)		//small keys will be swapped
		{
			A[i+1]=A[i];
			i--;
		}
		A[i+1]=key;				
		}
	}*/
	
	static void bucket_sort(float A[])
	{
		int n=A.length;
		LinkedList<Float> bucket[]=new LinkedList[n];
		int i,j,k,index;
		float x;
		int B[]=new int[n];
		for(i=0;i<n;i++)
			bucket[i]=new LinkedList();
		for(i=0;i<n;i++)
		{
			x=A[i];
			index=(int) (n*A[i]);
			bucket[index].add(x);		
		}
	
		for(i=0;i<n;i++)
			Collections.sort(bucket[i]);
		
		float sorted[]=new float[n];
		k=0;
		
		for(i=0;i<n;i++)
		{	
			if(bucket[i].size()>0)
			{
				System.out.println("\nBucket " + i + ":");
				for (j = 0; j < bucket[i].size(); j++,k++)
				{	
					System.out.print(bucket[i].get(j) + " ");
					sorted[k]=bucket[i].get(j);
				}
			}
			else
			{
			System.out.println("\nBucket " + i + ":");
			System.out.print("null");
			}
		}
			
		System.out.println("\nArray after sorting is:");
		for(i=0;i<n;i++)
			System.out.println(sorted[i]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int i,n;
		System.out.println("Enter the size of an array:");
		n=input.nextInt();
		float[] A=new float[n];
		Random rand=new Random();
		
		//System.out.println("Enter the elements(0-1) in decimal:");
		 
		float x;
		for(i=0;i<n;i++)
		{
			x=rand.nextInt(101) + 0;
			A[i]=x/100;
		}
		bucket_sort(A);
		input.close();
	}
}
