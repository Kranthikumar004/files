package demo;

import java.util.*;

public class Lhs {

public static void main(String[] args) {
		// TODO Auto-generated method stub
LinkedHashSet lhs= new LinkedHashSet();
lhs.add(4);
lhs.add(52);
lhs.add("Abhi");
lhs.add(52);
lhs.add(98);
Iterator i= lhs.iterator();
while(i.hasNext()) {
System.out.println(i.next());
	}
}}