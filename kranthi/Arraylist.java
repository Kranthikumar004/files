package demo;

import java.util.ArrayList;

public class Arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList al = new ArrayList();
		al.add(1);
		al.add("A");
		al.add("xyz");
		al.add(2.234);
		al.add(1);
		for (int i = 0; i < al.size(); i++) {

			System.out.println(al.get(i));

		}
	}
}
