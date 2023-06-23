package demo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

class Deserizatiom {
	public static void main(String[] args) throws Exception{
		FileInputStream fi=new FileInputStream("/home/training/Downloads/eclipse-jee-2022-12-R-linux-gtk-x86_64/eclipse/f.txt/asdf f.txt");
		ObjectInputStream oi= new ObjectInputStream(fi);
   
   System.out.println(oi.readObject());
   
   
	}

	
	}


