import java.util.Random;
import java.util.Scanner;

class QuickSort
{
   
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
 
 
    public static void main(String args[])
    {
    	Scanner input=new Scanner(System.in);
    	int size;
    	long time1,time2,time3;
    	System.out.println("Enter the size of the array:");
    	size=input.nextInt();
    	int arr[]=new int[size];
    	Random rand=new Random();
    	for(int i=0;i<size;i++)
    		arr[i]=rand.nextInt(size)+1;        
        System.out.println("Given Array");
        for(int i=0;i<size;i++)
        	System.out.println(arr[i]);
        time1=System.currentTimeMillis();
        
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, size-1);
        
        time2=System.currentTimeMillis();
        System.out.println("Sorted array");
        for(int i=0;i<size;i++)
        	System.out.println(arr[i]);
        time3=time2-time1;
        System.out.println("Total time taken (in ms):" + time3);
    }
}