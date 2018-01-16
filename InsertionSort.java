
import java.util.Scanner;
import java.util.Random;
public class InsertionSort {
	public static void insertion_sort(int A[]){
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
		System.out.println("Array after Sorting");
		for(int k=0;k<n;k++)
		{
			System.out.println(A[k]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		int[] array=new int[20000];
		Random rand=new Random();
		//int array[]={2,5,1,6};
		Scanner userInput=new Scanner(System.in);
		System.out.println("Insertion Sort");
		size=array.length;
		System.out.println("Input size");
		size=userInput.nextInt();
		
		for(int i=0;i<size;i++)
		{
			array[i]=rand.nextInt(5000)+1;
			//array[i]=userInput.nextInt();
		}
		long time1=System.currentTimeMillis();
		System.out.println("Time before Sorting");
		System.out.println(time1);
		System.out.println("Array before Soring");
		for(int i=0;i<size;i++)
		{
			System.out.println(array[i]);
		}
		insertion_sort(array);
		long time2=System.currentTimeMillis();
		System.out.println("Time after Sorting");
		System.out.println(time2);
		long time=time2-time1;
		System.out.println("Total Time Taken(in milliseconds)");
		System.out.println(time);
	}
}
