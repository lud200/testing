package threads;

public class starting_thread implements Runnable {
	public void run(){
		String[] s={"hello", "world", "this", "is", "sleep execution"};
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
	}
	public static void main(String args[]) throws InterruptedException{
		starting_thread st=new starting_thread();
		Thread t1=new Thread(st);
		Thread t2=new Thread(st);
		t1.start();
		t1.join();
		synchronizedclass sc=new synchronizedclass();
		Thread sc1=new Thread(sc);
		sc1.start();
		
	}
	
}
class synchronizedclass implements Runnable{
	//Synchronized method
	int i;
	int j=9;
	public synchronized void increament(){
		i++;
	}
	//Synchronized block and intrinsic lock
	Object o=new Object();
	Object o2=new Object();
	
	public void incr(){
		synchronized(o){
			i++;
		}
	}
	
	public void decr(){
		synchronized(o2){
			j--;
		}
	}
	public void run(){
		incr();
		decr();
		System.out.println(i+"  "+j);
	}
}
