package StudentMgtSysUsingArray;

public class College {
	
	public Student[] addStudent() {
		Student s1= new Student (101,"Megha","Pune");
		Student s2= new Student(102,"Arti","Mumbai");
		Student s3= new Student(103,"Pooja","nashik");
		
		Student[] arr= {s1,s2,s3};
		return arr;
	}

}
