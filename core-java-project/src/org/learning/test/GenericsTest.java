package org.learning.test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
	
	public static void main(String[] args) {
		
		List<ChildClass> childs = new ArrayList<>();
		GrandChildClass grandchild = new GrandChildClass();
		childs.add(grandchild); //compiles ok
		
		childs.add(new GrandChildClass()); //compiles ok
		
		List<Object> childsObj = new ArrayList<>();
		childsObj.add(grandchild); //compiles ok
		
		//childsObj = childs; //compilation error List<Object> is not super type of List<String>
		
		System.out.println(childs);
		
		//Wildcard are used in method which takes generic argumants
		
		//super is used when you want to be able to insert
		//super means childclass and any of its super class references can be assigned
		//you can insert childclass or any of its subclasses as they all can be mapped to childclass
		//you cannot insert super classes of Childclass
		//you cannot read as you do not know what will be type. Childclass, subclass of childclass or super of childclass
		//only way to read is cast to object class
		List<? super ChildClass> childsuper = new ArrayList<>();
		childsuper.add(new GrandChildClass()); //compiles ok
		
		System.out.println(childsuper);
		
		// extends means childclass and any of its sub class references can be assigned
		// you cannot insert as you do not know exact type is childclass or any of subclass
		// you can read objects as childclass as type will be childclass or any of its subclasses
		
		List<? extends ChildClass> childextends = new ArrayList<>();
		// childextends.add(new SuperClass()); does not compile
		// childextends.add(new ChildClass()); //does not compile
		// childextends.add(new GrandChildClass()); //does not compile
		
		List<? super GrandChildClass> childsuper2 = new ArrayList<>();
		//childsuper2.add(new ChildClass()); //does not compile
		childsuper2.add(new GrandChildClass()); //compiles ok
		childsuper2.add(new GrandGrandChildClass()); //compiles ok
		
		System.out.println(childextends);
		
		
		
	}
	
	private static class SuperClass {
		
	}
	
	private static class ChildClass extends SuperClass {
		
	}
	
	private static class GrandChildClass extends ChildClass {
		
	}
	
	private static class GrandGrandChildClass extends GrandChildClass {
		
	}

}
