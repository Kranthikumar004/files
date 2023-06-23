package demo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
public class DeSerilazation {

	public static void main(String[] args) throws IOException,ClassNotFoundException {
		FileInputStream fi=new FileInputStream("/home/training/eclipse-workspace/demo kkk.txt");
		ObjectInputStream Oi= new ObjectInputStream(fi);
		Student S1=(Student)Oi.readObject();
		System.out.println(S1.id+" "s1.name);
		
	}

}
