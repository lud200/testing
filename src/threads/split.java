package threads;
import java.util.*;

public class split {
	public static void main(String args[]){
		splitstring("a#b#c#d", "#");
	}
	public static void splitstring(String s, String regex){
		int start=0;
		int pos=s.indexOf(regex);
		Vector<String> v=new Vector<String>();
		while(start<=pos){
			if(start<pos){
				v.add(s.substring(start, pos));
			}
			start=pos+regex.length();
			pos=s.indexOf(regex, start);
		}
		if(start<s.length()){
			v.add(s.substring(start));
		}
		System.out.println(v.toString());
	}

}
