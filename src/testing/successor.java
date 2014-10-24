package testing;


public class successor {

}
class BTree{
	private class Node{
		Node left;
		Node right;
		Node parent;
		int data;
		public Node(int data){
			left=null;
			right=null;
			parent=null;
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
	
	public String preorder(Node node){
		if(node==null)
		{
			return null;
		}
			
			preorder(node.left);
			System.out.print(node.data+"\t");
			s1=s1+node.data;
			String pre=s1;
			preorder(node.right);
			return pre;
	}
	public void insert(int data){
		Node temp=root;
		Node newnode=new Node(data);
		newnode.left=null;
		newnode.right=null;
		newnode.parent=null;
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
				if(temp.right==null){
					temp.right=newnode;
					newnode.parent=temp;
				}
			}
			else{
				insert(temp.left, newnode);
				if(temp.left==null){
					temp.left=newnode;
					newnode.parent=temp;
				}
			}
		}
		return temp;
	}
	public void mirror(){
		mirror(root);
	}
	public void mirror(Node temp){
		if(temp==null)
			System.out.print("");
		else{
			Node temp1;
			mirror(temp.left);
			mirror(temp.right);
			temp1=temp.left;
			temp.left=temp.right;
			temp.right=temp1;
		}
	}
	public void successor(Node node){
		Node p;
		if(node.right!=null){
			minimum(node.right);
		}
		else{
			p=node.parent;
			while(p!=null && p.right==node){
				node=p;
				p=p.parent;
			}
		}
	}
	public void minimum(Node node){
		if(node==null){
			System.out.println("");
		}
		else{
			while(node.left!=null){
				node=node.left;
			}
		}
	}
	public void diameter(){
		
	}
}