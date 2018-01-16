import java.util.Scanner;

class BST_node {
	int info;
	BST_node parent;
	BST_node left,right;
	BST_node()
	{
		info=0;
		left=right=null;
		parent=null;
	}
	BST_node(int x)
	{
		info=x;
		left=right=null;
		parent=null;
	}
	 BST_node insert(BST_node r,BST_node z){
		BST_node y=null;
		BST_node x=r;
		while(x!=null)
		{
			y=x;
			if(z.info<x.info)
				x=x.left;
			else
				x=x.right;
		}
		z.parent=y;
		if(y==null)
			r=z;
		else if(z.info<y.info)
			y.left=z;
		else
			y.right=z;
		return r;
	}
	 
	 void inorder(BST_node x)
	 {
	 if(x!=null)
	 {
	 	inorder(x.left);
	 	System.out.print(x.info + " ");
	 	inorder(x.right);
	 }
	 }
	 
	 void preorder(BST_node x)
	 {
		 if(x!=null)
		 {
			 System.out.print(x.info + " ");
			 preorder(x.left);
			 preorder(x.right);
		 }
	 }
	 
	 void postorder(BST_node x)
	 {
		 if(x!=null)
		 {
			 postorder(x.left);
			 postorder(x.right);
			 System.out.print(x.info + " ");
		 }
	 }
	 
	 BST_node Search(BST_node x, int k)   //x is root
	 {
		 if(x==null || k==x.info)
		 return x;
		 if(k<x.info)
		 return	Search(x.left,k);
		 else
		 return Search(x.right,k);
	 }
	 
	 BST_node successor(BST_node x)
	 {
		 if(x.right!=null)
			 return minimum(x.right);
		 BST_node y=x.parent;
		 while(y!=null && x==y.right)
		 {
			 x=y;
			 y=y.parent;
		 }
		 return y;
	 }
	 
	 BST_node minimum(BST_node x)
	 {
		 while(x.left!=null)
			 x=x.left;
		 return x;
	 }
	 
	 BST_node delete(BST_node r,BST_node z)
	 {
		BST_node y=null;
		BST_node x=null;
		if(z.left==null || z.right==null)
			y=z;
		else
			y=successor(z);
		
		if(y.left==null)
			x=y.left;
		else
			x=y.right;
		
		if(x!=null)
			x.parent=y.parent;
		
		if(y.parent==null)
			r=x;
		else if(y==y.parent.left)
			y.parent.left=x;
		else 
			y.parent.right=x;
		
		if(y!=z)
			z.info=y.info;
		
		return r;

	 }
	 
}
	 
public class bst_final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size,value;
		Scanner input=new Scanner(System.in);
		BST_node root=null;
		//BST_node z= new BST_node(5);
		//BST_node z2=new BST_node(7);
		BST_node t=new BST_node();
		//root=t.insert(root, z);
		//root=t.insert(root, z2);
		System.out.println("\nImplementing BST");
		int choice;
		int ch=1;
		int sel=1;
		do{
			System.out.println("\n1.Insert an element:");
			System.out.println("2.Search an element:");
			System.out.println("3.Delete an element");
			System.out.println("4.Display the elements");
			System.out.println("5.Find successor");
			System.out.println("Enter your choice");
			choice=input.nextInt();
			switch(choice)
			{
			case 1:
				do{
				System.out.println("Enter the node element");
					value=input.nextInt();
					BST_node z=new BST_node(value);
					root=t.insert(root, z);
					System.out.println("Do you want to continue the insertion (Yes-1/No-0):");
					sel=input.nextInt();
				}while(sel!=0);
				break;
			case 2:
				int el;
				System.out.println("\nEnter key of the element to searched: ");
				el=input.nextInt();
				BST_node y=t.Search(root,el);
				if(y==null)
				System.out.println("Element not found");
				else
				{
					System.out.println(y.info);
					System.out.println("Element Found");
				}
				break;
			case 3:
				int del;
				System.out.println("\nEnter key of the element to be deleted:");
				del=input.nextInt();
				BST_node d=t.Search(root, del);
				if(d==null)
					System.out.println("Element not found");
				else
				{
					t.delete(root,d);
					System.out.println("\nAfter deleting the elements are:");
					t.inorder(root);
				}
				break;
			case 4:
				System.out.println("\nInorder Tranversal: ");
				t.inorder(root);
				System.out.println("\nPostorder Tranversal: ");
				t.postorder(root);
				System.out.println("\nPreorder Tranversal: ");
				t.preorder(root);
				break;
			case 5:
				int find;
				System.out.println("Enter the key of the element of which successor is to be found");
				find=input.nextInt();
				BST_node f=t.Search(root,find);
				BST_node s=t.successor(f);
				System.out.println("Successor node is- "+ s.info);
				break;
			default:
				System.out.println("Enter any valid choice");
			}
			System.out.println("\nDo you want to continue the BST implementation(Yes-1/No-0):");
			ch=input.nextInt();
	}while(ch!=0);
}
}
