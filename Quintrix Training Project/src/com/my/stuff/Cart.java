package com.my.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {

	public static void main(String[] args) {
		List<String> items = new ArrayList<String>(
				Arrays.asList("Apple", "Banana", "Orange"));
		
		for (String item: items) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		for(int i = 0; i < items.size(); i++) {
			System.out.print(items.get(i) + " ");
		}
		System.out.println();
		
	}

}
