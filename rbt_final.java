import java.util.Scanner;
enum color{red, black;}
class rbt_node{
	int info;
	rbt_node left;
	rbt_node right;
	rbt_node par;
	color c;
	rbt_node()
	{
		info=0;
		left=right=par=null;
		 c=color.black;
	}
	rbt_node(int x)
	{
		info=x;
		left=null;
		right=null;
		par=null;
		c=color.black;
	}
	
	rbt_node insert(rbt_node r,rbt_node z,rbt_node n){
		rbt_node y=n;
		rbt_node x=r;
		while(x!=n)
		{
			y=x;
			if(z.info<x.info)
				x=x.left;
			else
				x=x.right;
			}
		z.par=y;
			if(y==n)
			{
				r=z;
			}
			else if(z.info<y.info)
			{
				y.left=z;
			}
			else
			{
				y.right=z;
			}
			z.left=n;
			z.right=n;
			z.c=color.red;
			r=insert_fixup(r,z,y,n);
			return r;
			}
	rbt_node insert_fixup(rbt_node r,rbt_node z, rbt_node y,rbt_node n){
		//System.out.println("z node:"+z.info);
		//System.out.println("z node color:"+z.c);
		while(z.par.c==color.red)
		{
			if(z.par==z.par.par.left)
			{
				y=z.par.par.right; //y is an uncle
				if(y.c==color.red)		//Case 1
				{
					z.par.c=color.black;
					y.c=color.black;
					z.par.par.c=color.red;
					z=z.par.par;
					System.out.println("z node:"+z.info);
					System.out.println("color:"+z.c);
					System.out.println("Case-1(Left)");
					continue;
				}
				else if(z==z.par.right) //Case-2
				{
					z=z.par;
					r=leftrotate(r,z,y,n);
					System.out.println("z node:"+z.info);
					System.out.println("color:"+z.c);
					System.out.println("Case-2(Left)");
				}
				z.par.c=color.black;	//Case-3
				z.par.par.c=color.red;
				r=rightrotate(r,z.par.par,y,n);
				System.out.println("z node:"+z.info);
				System.out.println("color:"+z.c);
				System.out.println("Case-3(Left)");
			}
			else 
			{
				y=z.par.par.left;
				if(y.c==color.red)		//Case 1
				{
					z.par.c=color.black;
					y.c=color.black;
					z.par.par.c=color.red;
					z=z.par.par;
					System.out.println("z node:"+z.info);
					System.out.println("color:"+z.c);
					System.out.println("Case-1(Right)");
					continue;
				}
				else if(z==z.par.left) //Case-2
				{
					z=z.par;
					r=rightrotate(r,z,y,n);
					System.out.println("z node:"+z.info);
					System.out.println("color:"+z.c);
					System.out.println("Case-2(Right)");
				}
				z.par.c=color.black;	//Case-3
				z.par.par.c=color.red;
				r=leftrotate(r,z.par.par,y,n);
				System.out.println("z node:"+z.info);
				System.out.println("color:"+z.c);
				System.out.println("Case-3(Right)");
			}
		}
		r.c=color.black;
		return r;
	}
	rbt_node leftrotate(rbt_node r, rbt_node x, rbt_node y,rbt_node nil)
	{
		//rbt_node nil=new rbt_node();
		y=x.right;
		System.out.println("Before Rotation(x)-" + x.info);
		System.out.println("Before Rotation(y)-" + y.info);
		x.right=y.left;
		y.left.par=x;
		y.par=x.par;
		if(x.par==nil)
			r=y;
		else if(x==x.par.left)
			x.par.left=y;
		else
			x.par.right=y;
	y.left=x;
	x.par=y;
	System.out.println("After Rotation(x)-" + x.info);
	System.out.println("After Rotation(y)-" + y.info);
	System.out.println("After Rotation(root)-" + r.info);
	return r;
	
	}
	
	rbt_node rightrotate(rbt_node r, rbt_node x, rbt_node y,rbt_node nil)
	{
		//rbt_node nil=new rbt_node();
		//System.out.println("z node:"+z.info);
		y=x.left;
		x.left=y.right;
		y.right.par=x;
		y.par=x.par;
		if(x.par==nil)
			r=y;
		else if(x==x.par.right)
			x.par.right=y;
		else
			x.par.left=y;
	y.right=x;
	x.par=y;
	return r;
	}
	
	rbt_node successor(rbt_node x,rbt_node n)
	 {
		 if(x.right!=n)
			 return minimum(x.right,n);
		 rbt_node y=x.par;
		 while(y!=null && x==y.right)
		 {
			 x=y;
			 y=y.par;
		 }
		 return y;
	 }
	
	 rbt_node minimum(rbt_node x,rbt_node nil)
	 {
		 while(x.left!=nil)
			 x=x.left;
		 return x;
	 }
	
	rbt_node delete(rbt_node r,rbt_node z,rbt_node nil)
	{
		rbt_node y=nil;
		rbt_node x=nil;
		System.out.println("To be deleted:" + z.info);
		if(z.left==nil || z.right==nil)
			y=z;
		else
			y=successor(z,nil);
		
		if(y.left!=nil)
			x=y.left;
		else
			x=y.right;
		
		x.par=y.par;
		
		if(y.par==nil)
			r=x;
		else if(y==y.par.left)
			y.par.left=x;
		else
			y.par.right=x;
		
		if(y!=z)
			z.info=y.info;
		if(y.c==color.black)
		{
		System.out.println("x-" + x.info);
		r=delete_fixup(r,x,y,nil);		
		}
		System.out.println("y-" + y.info);
		System.out.println("After Deletion(inorder)");
		inorder(r,nil);
		return y; 
	}
	
	rbt_node delete_fixup(rbt_node r,rbt_node x,rbt_node y,rbt_node nil)// parameters and what will it return
	{
		rbt_node w;
		while(x!=r && x.c==color.black)
		{
			if(x==x.par.left) //x.par.left!=nil
			{
				w=x.par.right;  //w is sibling
				if(w.c==color.red)
				{
					w.c=color.black;
					x.par.c=color.red;
					r=leftrotate(r,x.par,y,nil);
					w=x.par.right;
					System.out.println("Case-1(Left)");
				}
				if(w.left.c==color.black && w.right.c==color.black) //both child's of BLACK sibling are black
				{
					w.c=color.red;
					x=x.par;
					System.out.println("Case-2(Left)");
					continue;
				}
				else if(w.right.c==color.black) //BLACK sibling's left child is red, right child is black
				{
					w.left.c=color.black;
					w.c=color.red;
					r=rightrotate(r,w,y,nil);
					w=x.par.right;
					System.out.println("Case-3(Left)");
				}
				if(w.right.c==color.red)
				{
				w.c=x.par.c;				//BLACK sibling's right child is red
				x.par.c=color.black;
				w.right.c=color.black;
				System.out.println("(Before rotation) x-" + x.info);
				System.out.println("(Before rotation) y-" + y.info);	
				System.out.println("Before rotation(inorder)");
				inorder(r,nil);
				r=leftrotate(r,x.par,y,nil);
				x=r;
				System.out.println("After rotation(inorder)");
				inorder(r,nil);
				System.out.println("(After rotation) x-" + x.info);	
				System.out.println("(After rotation) y-" + y.info);
				System.out.println("Case-4(Left)");
				//continue;
				}
			}
			else
			{
				w=x.par.left;
				if(w.c==color.red)
				{
					w.c=color.black;
					x.par.c=color.red;
					r=rightrotate(r,x.par,y,nil);
					w=x.par.left;
					System.out.println("Case-1(Right)");
				}
				if(w.right.c==color.black && w.left.c==color.black)
				{
					w.c=color.red;
					x=x.par;
					System.out.println("Case-2(Right)");
					continue;
				}
				else if(w.left.c==color.black)
				{
					w.right.c=color.black;
					w.c=color.red;
					r=leftrotate(r,w,y,nil);
					w=x.par.left;
					System.out.println("Case-3(Right)");
				}
				if(w.left.c==color.red)
				{
					w.c=x.par.c;
				x.par.c=color.black;
				w.left.c=color.black;
				r=rightrotate(r,x.par,y,nil);
				x=r;
				System.out.println("Case-4(Right)");
				//continue;
				}
			}
		}
		System.out.println("root(x)-" + x.info + " root(r)-" + r.info);
		x.c=color.black;
		System.out.println("After rotation(inorder)");
		inorder(r,nil);
		return r;
	}
	
	 rbt_node search(rbt_node x, int k,rbt_node nil)   //x is root
	 {
		 if(x==nil || k==x.info)
		 return x;
		 if(k<x.info)
		 return	search(x.left,k,nil);
		 else
		 return search(x.right,k,nil);
	 }
	
	void inorder(rbt_node x, rbt_node n){
		if(x!=n)
		{
			inorder(x.left,n);
			System.out.println(x.info + " " + x.c);
			inorder(x.right,n);
		}
	}
}

public class rbt_final {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rbt_node nil=new rbt_node();
		rbt_node root;
		root=nil;
		rbt_node t=nil;
		Scanner input=new Scanner(System.in);
		int size,key;
		System.out.println("\nImplementing RBT");
		int choice;
		int ch=1;
		do{
			System.out.println("\n1.Insert an element:");
			System.out.println("2.Search an element:");
			System.out.println("3.Delete an element");
			System.out.println("4.Display the elements");
			System.out.println("Enter your choice");
			choice=input.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the size");
				size=input.nextInt();
				System.out.println("Enter the node element");
				for(int i=0;i<size;i++)
				{
					key=input.nextInt();
					rbt_node z=new rbt_node(key);
					root=t.insert(root, z,nil);
				}
				break;
			case 2:
				int el;
				System.out.println("\nEnter key of the element to searched: ");
				el=input.nextInt();
				rbt_node y=t.search(root,el,nil);
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
				System.out.println("Enter key of the element to be deleted:");
				del=input.nextInt();
				rbt_node d=t.search(root, del,nil);
				if(d==null)
					System.out.println("Element not found");
				else
				{
					t.delete(root,d,nil); /*DOUBT*/
					System.out.println("\nAfter deleting the elements are:");
					t.inorder(root,nil);
				}
				break;
			case 4:
				System.out.println("\nInorder Tranversal: ");
				t.inorder(root,nil);
				break;
			default:
			System.out.println("Enter any valid choice");
			}
			System.out.println("Enter your choice(1-Yes/0-No):");
			ch=input.nextInt();
	}while(ch!='0');
	}		
}
