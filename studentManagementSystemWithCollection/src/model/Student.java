package model;

import java.util.Arrays;
import java.util.Objects;

public class Student implements Comparable <Student>{
 private int rollNo;
 private String name;
 private String course;
 private int[] marks;
 
 public Student(int rollNo, String name, String course, int[] marks){
	 this.rollNo=rollNo;
	 this.name=name;
	 this.course=course;
	 this.marks = new int[marks.length];

     for (int i = 0; i < marks.length; i++) {
         this.marks[i] = marks[i];
     }
	 
 }
 public int getRollNo() {
	return rollNo;
 }
 public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
 }
 public String getName() {
	return name;
 }
 public void setName(String name) {
	this.name = name;
 }
 public String getCourse() {
	return course;
 }
 public void setCourse(String course) {
	this.course = course;
 }
 public int[] getMarks() {
	 int[] temp = new int[marks.length];

     for (int i = 0; i < marks.length; i++) {
         temp[i] = marks[i];
     }

     return temp;
 }
 public void setMarks(int[] marks) {
	 this.marks = new int[marks.length];

     for (int i = 0; i < marks.length; i++) {
         this.marks[i] = marks[i];
     }
     
 }
 public int getTotal() {
	 int total=0;
	 for(int i=0;i<marks.length;i++) {
		 total +=marks[i];
		 
	 }
	 return total;
 }
 
 public double getPercentage() {
	 return (getTotal()/500.0)*100;
 }
 
 public String getGrade() {
	 double percentage=getPercentage();
	 if(percentage>=90) {
		 return "A";
		 }
	 else if(percentage>=75) {
		 return "B";
	 }else if(percentage >= 60)
	 {
		 return "C";
				 }
	 else if(percentage>= 40) {
		 return "D";
	 }
	 else {
		 return "Fail";
	 }
 }
 @Override
 public int compareTo(Student o) {
	 return Integer.compare(this.rollNo, o.rollNo);
	
 }
 

 
 @Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Student other = (Student) obj;
	return Objects.equals(course, other.course) && Arrays.equals(marks, other.marks) && Objects.equals(name, other.name)
			&& rollNo == other.rollNo;
}
 @Override
 public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.hashCode(marks);
	result = prime * result + Objects.hash(course, name, rollNo);
	return result;
 }
 @Override
 public String toString() {
	return "Student [rollNo=" + rollNo + ", name=" + name + ", course=" + course + ", marks=" + Arrays.toString(marks)
			+ "]";
 }
 
 
 
 
 
 
 
 
}