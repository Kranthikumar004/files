package demo;
import java.util.*;
import java.io.*;
 class Student implements Serializable {
	int id;
	String name;
	Student (int id,String name) {
		
 this.id=id;
 this.name=name;

}

public class Serilazation {

	public static void main(String[] args) throws IOException {
		FileOutputStream fo=new FileOutputStream("/home/training/eclipse-workspace/demo kkk.txt");
		Student s1= new Student(2,"two");
		ObjectOutputStream o=new ObjectOutputStream(fo);
		o.writeObject(s1);
		o.close();
		fo.close();
		System.out.println("Done");
	}}
	}


