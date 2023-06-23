package demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

class stu implements Serializable{
	int id;
	String name;
	stu (String name,int id) {
	this.name=name;
	this.id=id;
	
	
}
public class Ser1 {
	static ArrayList al=new ArrayList();
	public static void main(String[] args)throws IOException, ClassNotFoundException{
	FileOutputStream fo= new FileOutputStream ("/home/training/Downloads/eclipse-jee-2022-12-R-linux-gtk-x86_64/eclipse/k.txtfile.txt");
	stu s= new stu("kiran",1);	
    stu s1=new stu("hari",2);
    stu s2=new stu("Praveen",3);
    al.add(s);
    al.add(s1);
    al.add(s2);
    ObjectOutputStream O=  new ObjectOutputStream(fo);
    Iterator itr=al.iterator();
    while(itr.hasNext() ){
	out.writeObject(itr.next());
    }
    
    
    
   
    
    
    
    
	}

}
