package demo;
import java.util.*;
import java.io.*;

import javax.swing.Spring;
public class Programm{

	public static  void main(String[] args) {
	
HashMap<Object, Integer> Map=new HashMap<>();
  Map.put("krian", 34);
  Map.put("staish", 528);
  Map.put("kiran" ,234 );
  
	  for (HashMap.Entry<Object, Integer> e :Map.entrySet())
	System.out.println(((Object) e).getObject()+" ".getBytes());	  
	}

}
