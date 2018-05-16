package org.learning.designpatterns.structural.flyweight;


public class FlyWeightPatternDemo {
	   private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
	   public static void main(String[] args) {

	      for(int i=0; i < 20; ++i) {
	         Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
	         //The intrinsic state is color which is stored in object
	         //The extrinsic state is radius and co ordinates which vary for each circle object.
	         //Hence it is passed from client. This saves memory footprint and is performant as new objects created are few.
	         circle.draw(100, getRandomX(),getRandomY());
	      }
	   }
	   private static String getRandomColor() {
	      return colors[(int)(Math.random()*colors.length)];
	   }
	   private static int getRandomX() {
	      return (int)(Math.random()*100 );
	   }
	   private static int getRandomY() {
	      return (int)(Math.random()*100);
	   }
	}