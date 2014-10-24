package testing;

public class userdefinedexception {
	public static void main(String[] args){
		test t=new test();
		try{
			t.testinput();
		}
		catch(myexception e){
			e.printerror();
		}
	}
}

class myexception extends Exception{
	public void printerror(){
		System.out.println("I'm filled with errors yayy....!!");
	}
}
class test{
	public static void testing(){
		System.out.println("Hello world");
	}
	public void testinput() throws myexception{
		throw new myexception();
	}
}
