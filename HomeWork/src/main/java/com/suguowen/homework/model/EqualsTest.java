package com.suguowen.homework.model;

import java.util.HashMap;

/*public class HashTset {
	public static void main(String[] args) {
		HashMap<String, String> hashtest = new HashMap<>();
		hashtest.put("hello", "world");
	}
}*/
public class EqualsTest {
    public static void main(String[] args) {
    	Fish f1 = new Fish(1, "blue");
    	Fish f2 = new Fish(1, "blue");

 

        System.out.println(f1 == f2);
        System.out.println(f1.equals(f2));
    }
}
class Fish  {
    private int weight;
    private String color;

 

    public Fish(int weight, String color) {
        this.color = color;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

 

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

