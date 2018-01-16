import java.util.Random;
import java.util.Scanner;

public class MergeSort {
	
	public static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    public static void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
 
            sort(arr, l, m);
            sort(arr , m+1, r);
 
            merge(arr, l, m, r);
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
        sort(arr, 0, arr.length-1);
        time2=System.currentTimeMillis();
        System.out.println("Sorted array");
        for(int i=0;i<size;i++)
        	System.out.println(arr[i]);
        time3=time2-time1;
        System.out.println("Total time taken (in ms):" + time3);
    }
}
