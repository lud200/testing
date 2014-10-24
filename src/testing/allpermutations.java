package testing;
import java.util.*;

public class allpermutations {
	public static void main(String args[]){
		permutations p=new permutations();
		System.out.println(p.perm("abc"));
	}

}
class permutations{
	public Set<String> perm(String str){
		Set<String> s=new HashSet<String>();
		if(str==null)
			return null;
		else if(str.length()==0){
			s.add("");
			return s;
		}
		char start=str.charAt(0);
		String rem=str.substring(1);
		Set<String> words=perm(rem);
		for(String snew:words){
			for(int i=0;i<=snew.length();i++){
				s.add(charInsert(snew, start, i));
			}
		}
		return s;
	}
	public String charInsert(String str, char c, int j) {
	        String begin = str.substring(0, j);
	        String end = str.substring(j);
	        return begin+c+end;
	}		
}