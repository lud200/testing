package testing;

public class deadlocktest {
	public static void main(String[] args){
		final friend f1=new friend("aston");
		final friend f2=new friend("jersy");
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
	static class friend{
		String name;
		public friend(String name){
			this.name=name;
		}
		public String getname(){
			return this.name;
		}
		public void bow(friend f){
			bowback(this);
		}
		public void bowback(friend f){
			System.out.println("Bowedback");
		}
	}
}