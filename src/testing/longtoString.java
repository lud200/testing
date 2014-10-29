package testing;

public class longtoString {
public static void main(String[] args){
	String s="1992";
	String s1=null;
//	s1=s1+1;
	Integer i=null;
	i=i*i;
	System.out.println(s1+"  "+i);
	long l=stringLong(s);
	if(l==1992)
		System.out.println("true");
	else
		System.out.println("false");
//	System.out.println(stringLong(s));
}
public static long stringLong(String s){
	long answer=0, factor=1;
	for(int i=s.length()-1;i>=0;i--){
		answer=answer+(s.charAt(i)-'0')*factor;
		factor=factor*10;
	}
	return answer;
}
}

