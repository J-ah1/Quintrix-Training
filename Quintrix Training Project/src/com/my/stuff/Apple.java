package com.my.stuff;

public class Apple {
	String color;
	
	public Apple(String color){
		this.color = color;
		try{
			if(this.color == "Red")
				throw new Exception("Red apples aren't allowed.");
			System.out.println("Hello World!");
		}catch(Exception e){
			System.out.println("Exception detected: " + e.toString());
		}
	}
	
	public String getColor() {
		return this.color;
	}
}

