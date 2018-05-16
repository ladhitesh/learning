package org.learning.designpatterns.structural.flyweight;

public class Circle implements Shape {
	   private String color;


	   public Circle(String color){
	      this.color = color;		
	   }

	   @Override
	   public void draw(int radius, int x, int y) {
	      System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
	   }
	}