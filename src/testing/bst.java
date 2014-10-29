package testing;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class bst implements Runnable{
	public static void main(String args[]){
		AtomicInteger count=new AtomicInteger();
		count.incrementAndGet();
		
		Tree b1=new Tree();
		b1.insert(12);
		b1.insert(15);
		b1.insert(13);
		b1.insert(17);
		b1.insert(10);
		b1.insert(14);
		b1.insert(12);
		b1.insert(16);
		b1.insert(19);
		b1.insert(18);
//		b1.insert(15);
//		b1.insert(12);
//		b1.insert(17);
//		b1.insert(16);
//		b1.insert(18);
		b1.preorder();
//		b1.deleteNode(19);
		b1.deleteNode(18);
		System.out.println();
//		b1.mirror();
		b1.preorder();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
class Tree{
	private class Node{
		Node left;
		Node right;
		int data;
		public Node(int data){
			left=null;
			right=null;
			this.data=data;
		}
	}
	Node root;
	public void Tree(){
		root=null;
	}
	public String preorder(){
		return preorder(root);
	}
	String s1=" ";
	public void inordersuccessor(Node node){
		
	}
	public String preorder(Node node){
		if(node==null)
		{
			return null;
		}
			System.out.print(node.data+"\t");
			s1=s1+node.data;
			String pre=s1;
			preorder(node.left);
			preorder(node.right);
			return pre;
	}
	public void insert(int data){
		Node temp=root;
		Node newnode=new Node(data);
		newnode.left=null;
		newnode.right=null;
		newnode.data=data;
		root=insert(root, newnode);
	}
	public Node insert(Node temp, Node newnode){
		int data;
		if(temp==null){
			temp=newnode;
		}
		else{
			if(temp.data<=newnode.data){
				insert(temp.right, newnode);
				if(temp.right==null)
					temp.right=newnode;
			}
			else{
				insert(temp.left, newnode);
				if(temp.left==null)
					temp.left=newnode;
			}
		}
		return temp;
	}
//	public void mirror(){
//		mirror(root);
//	}
//	public void mirror(Node temp){
//		if(temp==null)
//			System.out.print("");
//		else{
//			Node temp1;
//			mirror(temp.left);
//			mirror(temp.right);
//			temp1=temp.left;
//			temp.left=temp.right;
//			temp.right=temp1;
//		}
//	}
	public void deleteNode(int data){
		boolean found=false;
		if(root==null){
			System.out.println("empty tree");
		}
		Node current=root;
		Node parent=null;
		while(current!=null){
			if(current.data==data){
				found=true;
				break;
			}
			else{
				parent=current;
				if(current.data<data){
					current=current.right;
				}
				else{
					current=current.left;
				}
			}
		}
		if(found==false){
			System.out.println("data not found");
		}
		
		/*The node does not have children*/
		if(current.left==null && current.right==null){
			if(parent.left==current){
				parent.left=null;
				current=null;
			}
			else{
				parent.right=null;
				current=null;
			}
		}
		/*If the node has one child*/
			if(current.right!=null && current.left==null){
				if(parent.left==current){
					parent.left=current.right;
					current=null;
				}
				else{
					parent.right=current.right;
					current=null;
				}
			}
			if(current.right==null && current.left!=null){
				if(parent.left==current){
					parent.left=current.left;
					current=null;
				}
				else{
					parent.right=current.left;
					current=null;
				}
			}
			/*If the node has two children*/
			if(current.left!=null && current.right!=null){
				Node test=current.right;
				if(test.left==null && test.right==null){
					current=test;
					current.right=null;
				}
				else{
					while(test.left!=null){
						parent=test;
						test=test.left;
					}
					current.data=test.data;
					test=null;
				}
			}
	}
		
//		Node x, xsucc, parent;
//		x=search(data);
//		System.out.println("value="+x.data);
//		/*If the node has two children*/
//		if(x.left!=null && x.right!=null){
//			parent=x;
//			xsucc=x.right;
//			while(xsucc.left!=null){
//				parent=xsucc;
//				xsucc=xsucc.left;
//			}
//			x.data=xsucc.data;
////			x.right=null;
//			xsucc.data=0;
//			xsucc=null;
//			
////			xsucc.left=x.left;
////			parent.right=xsucc.right;
////			parent.left=null;
//		}
//		/*if the node has no children*/
//		if(x.left==null && x.right==null){
//			x.data=0;
//			x=null;
//		}
//		/*if node has only left child*/
		
	public Node search(int data){
		return search(root, data);
	}
	public Node search(Node temp, int data){
		if(temp==null){
			System.out.println("Empty tree");
		}
		else if(temp.data==data){
			System.out.println("Value found");
		}
		else if(data<temp.data){
			temp=search(temp.left, data);
		}
		else{
			temp=search(temp.right, data);
		}
		return temp;
	}
	
		/*if node to be deleted has two children*/
//		if(temp.left!=null && temp.right!=null){
//			System.out.println("I;m inside");
//			xsucc=temp.right;
//			parent=temp;
//			while(xsucc.left!=null){
//				parent=xsucc;
//				xsucc=xsucc.left;
//			}
//			temp.data=xsucc.data;
//			xsucc.left=temp.left;
//			xsucc.right=temp.right;
//			parent.left=null;
//		}
//		
//		if(temp==root){
//			if(temp.right==null && temp.left==null)
//				root=temp.right;
//			else if(temp.left==null)
//				root=temp.right;
//			else if(temp.right==null)
//				root=temp.left;
//			else{
//				Node temp1;
//				temp1=temp.right;
//				while(temp1.left!=null){
//					temp=temp1;
//					temp1=temp1.left;
//				}
//				if(temp1!=temp.right){
//					temp.left=temp1.right;
//					temp1.right=root.right;
//				}
//				temp1.left=root.left;
//				root=temp1;
//			}
//		}
//		else{
//			if(temp.right==null && temp.left==null){
//				if(parent.right==temp)
//					parent.right=null;
//				else
//					parent.left=null;
//			}
//			else if(temp.left==null){
//				if(parent.right==temp)
//					parent.right=temp.right;
//				else
//					parent.left=temp.right;
//			}
//			else if(temp.right==null){
//				if(parent.right==temp)
//					parent.right=temp.left;
//				else
//					parent.left=temp.left;
//			}
//			else{
//				Node temp1;
//				parent=temp;
//				temp1=temp.right;
//				while(temp1.left!=null){
//					parent=temp1;
//					temp1=temp1.left;
//				}
//				if(temp1!=temp.right){
//					temp1.left=temp.left;
//					temp1.right=parent.right;
//					parent.left=null;
//				}
//				temp1.left=parent.left;
//				parent=temp1;
//			}
//			marker=null;
//		}
}