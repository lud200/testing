package testing;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class practice {
	public static void main(String[] args){
		Map<String, String> m=new ConcurrentHashMap<String, String>();
		m.put("1", "1");
		m.put("2", "1");
		m.put("3", "1");
		m.put("4", "1");
		m.put("5", "1");
		m.put("6", "1");
		Iterator<String> it=m.keySet().iterator();
		while(it.hasNext()){
			String value=it.next();
			if(value == "3"){
				m.remove("3");
			}
		}
		System.out.println(m);
		employee[] e=new employee[4];
		e[0] = new employee(10, "Mikey", 25, 10000);
		e[1] = new employee(20, "Arun", 29, 20000);
		e[2] = new employee(5, "Lisa", 35, 5000);
		e[3] = new employee(1, "Pankaj", 32, 50000);
		Arrays.sort(e);
		System.out.println(Arrays.toString(e));
	}
}
class employee implements Comparator<employee>{
	private int id;
	private String name;
	private int age;
	private long salary;
	public int getId(){
//		System.out.println(this.id);
		return id;
	}
	public String getname(){
		return name;
	}
	public int getage(){
		return age;
	}
	public long getsal(){
		return salary;
	}
	public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                this.salary + "]";
    }
	public employee(int id, String name, int age, long salary){
		this.id=id;
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	public static Comparator<employee> SalaryComparator = new Comparator<employee>() {
		 
        @Override
        public int compare(employee e1, employee e2) {
            return (int) (e1.getsal() - e2.getsal());
        }
    };
 
    /**
     * Comparator to sort employees list or array in order of Age
     */
    public static Comparator<employee> AgeComparator = new Comparator<employee>() {
 
        @Override
        public int compare(employee e1, employee e2) {
            return e1.getage() - e2.getage();
        }
    };
// 
//    /**
//     * Comparator to sort employees list or array in order of Name
//     */
//    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
// 
//        @Override
//        public int compare(Employee e1, Employee e2) {
//            return e1.getName().compareTo(e2.getName());
//        }
//    };
//	public int compareTo(employee e){
//		return (this.id-e.id);
//	}
	@Override
	public int compare(employee o1, employee o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
