import java.util.Scanner;
import java.util.Random;
public class HeapSort {
	
	public static void maxHeapify(int arr[],int i,int n)
	{
		int left=2*i+1;
		int right=2*i+2;
		//int parent= i/2;
		int l=left,r=right;
		int largest;
		if(l<=n && arr[l]>arr[i])
			largest=l;
		else
			largest=i;
		if(r<=n && arr[r]>arr[largest])
			largest=r;
		
		if(largest!=i)
		{
			int t=arr[i];
			arr[i]=arr[largest];
			arr[largest]=t;
		maxHeapify(arr,largest,n);
		}
	}
	
	public static void buildMaxHeap(int arr[],int n)
	{
		//int heapSize=arr.length;
		for(int i=(n/2);i>=0;i--)
			maxHeapify(arr,i,n); 
	}
	
	public static void heap_Sort(int arr[], int n)
	{
		buildMaxHeap(arr,n);
		System.out.println("Array after Build Max Heap-");
		for(int i=0;i<=n;i++)
		{
			System.out.println(arr[i]);
		}
		
		for(int i=n;i>=1;i--)
		{
		int t=arr[0];
		arr[0]=arr[i];
		arr[i]=t;
		n=n-1;
		maxHeapify(arr,0,n);
		}
	}

public static void main(String args[])
{
	System.out.println("Heap Sort");
	Scanner input=new Scanner(System.in);
	Random rand= new Random();
	int n;
	System.out.println("Input size of the array");
	int size;
	int array[]= new int[20000];
	size=input.nextInt();
	//System.out.println("Input the array values");
	for(int i=0;i<size;i++)
	{
		n=rand.nextInt(5000)+1;
		array[i]=n;
		//array[i]=input.nextInt();
	}
	/*System.out.println("Array Values Are");
	for(int i=0;i<size;i++)
	{
		System.out.println(array[i]);
	}*/
	//int array[]={5,2,7,9,1,4,8};
	//int size=array.length;
	long time1=System.currentTimeMillis();
	System.out.println("Time before Sorting");
	System.out.println(time1);
	heap_Sort(array,size-1);
	/*System.out.println("Sorted Array");
	for(int i=0;i<=size-1;i++)
		System.out.println(array[i]);*/
	long time2=System.currentTimeMillis();
	System.out.println("Time after Sorting");
	System.out.println(time2);
	long time=time2-time1;
	System.out.println("Total Time Taken(in milliseconds)");
	System.out.println(time);
	/*Runtime r=Runtime.getRuntime();
	long mem1=r.freeMemory();
	System.out.println("Free Memory" + mem1);
	r.gc();
	r.freeMemory();*/
	
}
}

