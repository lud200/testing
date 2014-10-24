package testing;
import java.util.*;

public class linkedlist {
	public static void main(String args[]){
		list l=new list();
		l.insert(4);
		l.insert(6);
		l.insert(4);
		l.insert(0);
		l.insert(42);
		System.out.println("hey printing...");
		l.print();
		l.reverse();
		l.print();
	}
}

class list{
	class node{
		int data;
		node next;
	}
	node head=null;
	public void insert(int data){
		node node=new node();
		if(head==null){
			head=node;
			head.data=data;
			head.next=null;
		}
		else{
			node.next=head;
			node.data=data;
			head=node;
		}
	}
	public void print(){
		node n=new node();
		n=head;
		while(n!=null){
			System.out.print(n.data+"->");
			n=n.next;
		}
	}
	public void reverse(){
		node current=head;
		node next;
		node prev=null;
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
		System.out.println();
	}
}