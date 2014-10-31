package threads;

public class deadlock {
	static class friend{
		String name;
		public friend(String name){
			this.name=name;
		}
		public String getname(){
			this.name=name;
			return name;
		}
		public synchronized void bow(friend bower){
			bowback();
			System.out.println(bower.getname()+"is bowing");
		}
		public synchronized void bowback(){
			System.out.println("bowed back");
		}
	}
	
	public static void main(String args[]){
		final friend f1=new friend("aston");
		final friend f2=new friend("emma");
		new Thread(new Runnable(){
			public void run(){
				f1.bow(f2);
			}
		}).start();
		new Thread(new Runnable(){
			public void run(){
				f2.bow(f1);
			}
		}).start();
	}
}
