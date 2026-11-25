package classMgtSystemWithAggregation;

public class StudentDisplay {


	public static void main(String[] args) {

        StudentDetails sd = new StudentDetails();

        Student s1 = sd.addStudent1();
        Student s2 = sd.addStudent2();


        
           //student 1
        System.out.println("Course id: "+s1.getB().getF().getC().getCid());
        System.out.println("Course Name:"+ s1.getB().getF().getC().getCname());
        System.out.println("Faculty id: "+s1.getB().getF().getFid());
        System.out.println("Faculty Name: "+s1.getB().getF().getFname());
        System.out.println("Batch id: "+ s1.getB().getBid());
        System.out.println("Batch Name:"+ s1.getB().getBname());
        System.out.println("Student id: "+ s1.getSid());
        System.out.println("Student Name: "+ s1.getSname());
        
         //student 2
        System.out.println("Course id: "+s2.getB().getF().getC().getCid());
        System.out.println("Course Name:"+ s2.getB().getF().getC().getCname());
        System.out.println("Faculty id: "+s2.getB().getF().getFid());
        System.out.println("Faculty Name: "+s2.getB().getF().getFname());
        System.out.println("Batch id: "+ s2.getB().getBid());
        System.out.println("Batch Name:"+ s2.getB().getBname());
        System.out.println("Student id: "+ s2.getSid());
        System.out.println("Student Name: "+ s2.getSname());
    }
}
