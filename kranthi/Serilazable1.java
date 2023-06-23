package demo;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Emp implements Serializable {
int id;
String name;
Emp(int id, String name){

this.id=id;
this.name =name;
}

}
public class Serilazable1{
	public static void main(String[] args) throws Exception {
	FileOutputStream fo=new FileOutputStream ("/home/training/Downloads/eclipse-jee-2022-12-R-linux-gtk-x86_64/eclipse/f.txt/asdf f.txt");
	Emp c1 = new Emp(1,"one");
	
	ObjectOutputStream o=new ObjectOutputStream(fo);
	ArrayList al = new ArrayList();
	al.add(c1);
	
	o.writeObject(al);
	o.close();
	fo.close();
	
	System.out.println("Done");
	
		
	}

	

}

	