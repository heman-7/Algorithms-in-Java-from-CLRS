import java.util.Random;
import java.util.Scanner;

class BinarySearch
{
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
            if (arr[mid] == x)
               return mid;
 
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
            
            return binarySearch(arr, mid+1, r, x);
        }
 
        return -1;
    }
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
    }
 
    public static void main(String args[])
    {
    	Random rand= new Random();
		Scanner input=new Scanner(System.in);
		int size;
		System.out.println("Enter the size");
		size=input.nextInt();
		int Array[]=new int[size];
		
		for(int i=0;i<size;i++)
		{
			Array[i]=rand.nextInt(500)+1;
		}
		for(int i=0;i<size;i++)
		{
			System.out.println(Array[i]);
		}
		insertion_sort(Array);
		System.out.println("Enter the element to search");
		int el;
		el=input.nextInt();
		System.out.println("Time before Searching");
		long time=System.currentTimeMillis();
		System.out.println(time);
		
        BinarySearch ob = new BinarySearch();
        int result = ob.binarySearch(Array,0,size-1,el);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "+result);
        
        long time2=System.currentTimeMillis();
		System.out.println("Time after Searching");
		System.out.println(time2);
		long time3=time2-time;
		System.out.println("Time taken(in millisecond)");
		System.out.println(time3);	
    }
}