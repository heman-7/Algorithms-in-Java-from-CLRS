import java.util.Random;
import java.util.Scanner;

public class LinearSearch {
	static void ls(int A[],int x)
	{
		int flag=0,index=0;
		int size=A.length;
		for(int i=0;i<size;i++)
		{
			if(x==A[i])
			{
				flag=1;
				index=i;
			}
		}
	if(flag==1)
		System.out.println("Element found at the index : "+ index);
	else
		System.out.println("Element not found");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println("Enter the element to search");
		int el;
		el=input.nextInt();
		System.out.println("Time before Searching");
		long time=System.currentTimeMillis();
		System.out.println(time);
		ls(Array,el);
		long time2=System.currentTimeMillis();
		System.out.println("Time after Searching");
		System.out.println(time2);
		long time3=time2-time;
		System.out.println("Time taken(in millisecond)");
		System.out.println(time3);		
	}
}
