package classMgtSystemWithAggregation;

public class StudentDetails {

    public Student addStudent1() {

        
        Course c = new Course();
        c.setCid(101);
        c.setCname("Java Full Stack");

   
        Faculty f = new Faculty();
        f.setFid(456);
        f.setFname("sidd");
        f.setC(c);

       
        Batch b = new Batch();
        b.setBid(76);
        b.setBname("A");
        b.setF(f);

        Student s = new Student();
        s.setSid(1);
        s.setSname("Megha");
        s.setB(b);

        return s;
    }


    public Student addStudent2() {

        
        Course c = new Course();
        c.setCid(102);
        c.setCname("Python Full Stack");

        
        Faculty f = new Faculty();
        f.setFid(457);
        f.setFname("Ram");
        f.setC(c);

        
        Batch b = new Batch();
        b.setBid(77);
        b.setBname("B");
        b.setF(f);

        
        Student s = new Student();
        s.setSid(2);
        s.setSname("Pihu");
        s.setB(b);;

        return s;
    }
}