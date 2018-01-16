import java.util.Random;
import java.util.Scanner;
public class BubbleSort {
	public static void b_sort(int A[])
	{
		int size=A.length;
		//System.out.println(size);
		
		for(int i=0;i<size-1;i++)
		{
			for(int j=0;j<size-i-1;j++)
			{
				if(A[j]>A[j+1])
				{
					int t=A[j];
					A[j]=A[j+1];
					A[j+1]=t;
				}
			}
		}
		/*System.out.println("\nSorted Array Is");
		for(int i=0;i<size;i++)
		{
			System.out.print(A[i]+" ");
		}*/
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter size");
		size=input.nextInt();
		int array[] = new int[size];
		//size=array.length;
		Random rand=new Random();
		//System.out.println("Enter array elements");
		for(int i=0;i<size;i++)
		{
			array[i]=rand.nextInt(10000)+1;
		}
		System.out.print("Entered array is- ");
		for(int i=0;i<size;i++)
		{
			System.out.print(array[i]+" ");
		}
		long time1=System.currentTimeMillis();
		System.out.println("\nTime before sorting");
		System.out.println(time1);
		System.out.println("\nApplying Bubble Sorting");
		b_sort(array);
		long time2=System.currentTimeMillis();
		System.out.println("Time after sorting");
		System.out.println(time2);
		System.out.println("\nSorted Array Is");
		for(int i=0;i<size;i++)
		{
			System.out.print(array[i]+" ");
		}
		long time3=time2-time1;
		System.out.println("\nTotal time taken in sorting(in milli seconds)");
		System.out.println(time3);
	}

}
