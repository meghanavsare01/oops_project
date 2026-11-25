package StudentMgtSysUsingArray;

public class University {
	public static void main(String[] args) {
		
		College college= new College();
	Student[] std	=college.addStudent();
	
	System.out.println("using for loop");
	for(int i=0;i<std.length;i++) {
		System.out.println(std[i].id+" "+std[i].name+" "+std[i].address);
	}
	
	System.out.println("using for each loop");
	for(Student s:std) {
		System.out.println(s.id+" "+s.name+" "+s.address);
		
	}
		
	}

}
