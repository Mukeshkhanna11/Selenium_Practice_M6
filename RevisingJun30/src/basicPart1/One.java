package basicPart1;
class Student{
	public static void add(int a,int b) {
		System.out.println(a+b);
	}
	public static int add(int a,int b,int c) {
		return a+b+c;
	}
}

public class One {
	public static void main(String[] args) {
		
		
		Student.add(3, 34);
		System.out.println(Student.add(3, 6,9));
		
	}

}
