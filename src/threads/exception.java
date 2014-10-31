package threads;

public class exception {
	public static void main(String args[]){
		testException t=new testException();
		t.error();
		exceptiontest et=new exceptiontest();
		et.test();
	}
}
class testException{
	public void error(){
		int i=2;
		try{
			if(i==2){
				throw new numberException();
			}
			else{
				System.out.println("no exception found");
			}
			
		}catch(numberException e){
			System.out.println(e);
		}
	}
}

class numberException extends Exception{
	public numberException(){
		System.out.println("Number Exception caught");
	}
}
class exceptiontest{
	public void test(){
		int[] a=new int[3];
		try{
			a[5]=9;
		}catch(IndexOutOfBoundsException e){
			System.out.println(e);
		}
	}
}