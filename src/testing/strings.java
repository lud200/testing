package testing;
import java.util.*;
//		int[] a={1, 2, 3, 4, 5};
//		int[] b=Arrays.copyOf(a, 5);
//		System.out.println(Arrays.toString(a));
//		for(int x:a){
////			x=45;
//			System.out.println(x+"  ");
//		}
//		StringBuilder sb=new StringBuilder();
//		sb.insert(0, "hello");
//		sb.append("done");
//		sb.reverse();
//		System.out.println(sb);
//		String s="a";
//		String s2="a";
//		String s3=new String("a");
////		System.out.println(s==s3);
////		System.out.println(s.equals(s2));
////		System.out.println("**********");
//		s2.concat("apple");
////		System.out.println(s2);
//		s2+=" apple";
////		System.out.println(s2);

class Base { }
class Derived extends Base { }
public class strings {
void foo(Base thing) { System.out.println("foo(Base)"); }
void foo(Derived thing) { System.out.println("foo(Derived)"); }
public static void main(String[] args) {
strings tester = new strings();
Base base = new Base();
tester.foo(base); // 1st call
base = new Derived();
tester.foo(base); // 2nd call
tester.foo(new Derived()); // 3rd call
}
}