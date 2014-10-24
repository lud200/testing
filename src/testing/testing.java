package testing;

import java.io.IOException;
import java.util.*;
public class testing {
	public static void main(String args[]){
		trinaryTree t=new trinaryTree();
		t.insert(26);
		t.insert(10);
		t.insert(26);
		t.insert(4);
		t.insert(11);
		t.insert(4);
//		t.preorder();
	}
}
class trinaryTree{
	private class Node{
		int data;
		Node left;
		Node right;
		Node middle;
		public Node(int newnode){
			left=null;
			right=null;
			middle=null;
			data=newnode;
		}
	}
		private Node root;
		public void trinaryTree(){
			root=null;
		}
		public void insert(int data){
			Node temp=root;
			Node newnode=new Node(data);
			newnode.left=null;
			newnode.right=null;
			newnode.middle=null;
			newnode.data=data;
			root=insert(root, newnode);
		}
		public Node insert(Node temp, Node newnode){
			int data;
			if(temp==null){
				temp=newnode;
			}
			else{
				if(temp.data<newnode.data){
					insert(temp.right, newnode);
					if(temp.right==null)
						temp.right=newnode;
				}
				else if(temp.data>newnode.data){
					insert(temp.left, newnode);
					if(temp.left==null)
						temp.left=newnode;
				}
				else if(temp.data==newnode.data){
					insert(temp.middle, newnode);
					if(temp.middle==null)
						temp.middle=newnode;
				}
			}
			return temp;
		}
		public void delete(int val){
			Node temp=root;
			Node parent = root, marker;
			if(temp==null){
				System.out.println("Tree is empty");
			}
			else{
				while(temp!=null && temp.data!=val){
					parent=temp;
					if(temp.data<val){
						temp=temp.right;
					}
					else if(temp.data>val){
						temp=temp.left;
					}
					else if(temp.data==val){
						temp=temp.middle;
					}
				}
			}
			marker=temp;
			if(temp==null){
				System.out.println("No node is present");
			}
			else if(temp==root){
				if(temp.right==null && temp.left==null){
					root=temp.middle;
				}
				else if(temp.left==null && temp.middle==null){
					root=temp.right;
				}
				else if(temp.right==null && temp.middle==null){
					root=temp.left;
				}
				else if(temp.left==null || temp.right==null){
					root=temp.middle;
				}
				else{
					Node temp1;
					temp1=temp.right;
					while(temp1.left!=null){
						temp=temp1;
						temp1=temp1.left;
					}
					if(temp1!=temp.right){
						temp.left=temp1.right;
						temp1.right=root.right;
					}
					temp1.left=root.left;
					root=temp1;
				}
			}
			else{
				if(temp.right==null && temp.left==null){
					if(parent.middle==temp)
						parent.middle=null;
					else if(parent.right==temp)
						parent.right=null;
					else
						parent.left=null;
				}
				else if(temp.left==null && temp.middle==null){
					if(parent.right==temp)
						parent.right=temp.right;
					else
						parent.left=temp.right;
						
				}
				else if(temp.right==null && temp.middle==null){
					if(parent.right==temp)
						parent.right=temp.left;
					else
						parent.left=temp.left;
				}
				else{
					Node temp1;
					parent=temp;
					temp1=temp.right;
					while(temp1.left!=null){
						parent=temp1;
						temp1=temp1.left;
					}
					if(temp1!=temp.right){
						temp1.left=temp.left;
						temp1.right=parent.right;
						parent.left=null;
					}
					temp1.left=parent.left;
					parent=temp1;
				}
				
			}
		}		
}
//public String preorder(){
//	return preorder(root);
//}
//String s1=" ";
//
//public String preorder(Node node){
//	if(node==null)
//	{
//		return null;
//	}
//		System.out.print(node.data+"\t");
//		s1=s1+node.data;
//		String pre=s1;
//		preorder(node.left);
//		preorder(node.middle);
//		preorder(node.right);
//		return pre;
//}

//	enum letters{a, b, c};
//	public static void main(String[] s) 
//	{ 
//	System.out.println("Hello"); 
//	} 
//	public static void main() 
//	{ 
//	System.out.println("Hello1"); 
//	} 
//	public static void main (int args[]) 
//	{ 
//	System.out.println("Hello2"); 
//	} 
//	public static void main(String args[]){
//		List list = new ArrayList();
//		list.add(6);
////		list.add(new Integer(7));
////		list.add(new Integer(8));
//		for( int i = 0; i != list.size(); ++i ) {
//		    int x = (int) list.get(i);
//		    System.out.println("i[" + i + "] val[" + x+ "]");
//		}
//
//		Base b1 = new Base();
//        Base b2 = new Sub();
//        b1.foo(2);
//        b2.foo(7);
//        b2.foo("2");
//        Sub1 s4 = new Sub1(1);
//	}
//}
//class Sub1 extends Base {
//    public Sub1(int i) {
//    }
//    public Sub1(int j, int k) {
//        super(j + k);
//    }
//}
//
//class Base {
//    protected Base() {}
//    public Base(int i) {
//        foo(i);
//    }
//    public void foo(int i) {
//        System.out.println("Base value is " + i);
//    }
//    public void foo(String s) {
//        System.out.println("Base string is " + s);
//}
//}
//class Sub extends Base {
//    public void foo(int j) {
//        System.out.println("Sub value is " + j);
//    }
//}
