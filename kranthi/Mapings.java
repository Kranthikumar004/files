package demo;
import java.util.*;
import java.util.HashMap;

public class Mapings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hm1 = new HashMap<>();
		
		
		HashMap<Integer,String>hm2=new HashMap<Integer , String>();
		hm1.put(1,"hello");
		hm1.put (2,"hai");
		hm1.put(3, "kiran");
		
		hm2.put(new Integer(1), "Hello");
		hm2.put(new Integer(2),"Hai");
		hm2.put(new Integer(3), "Kiran");
		
		
	   hm1.get("hai");
		System.out.println(hm1);
		System.out.println(hm2);
		System.out.println(hm1.get("hai"));
	} 

}
