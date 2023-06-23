package demo;

import java.util.ArrayList;

public class Arraylistclass2 {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Ravi");
		al.add("Kiran");
		al.add("Kiran");
		al.add(0, "Ramesh");
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}

	}
}
