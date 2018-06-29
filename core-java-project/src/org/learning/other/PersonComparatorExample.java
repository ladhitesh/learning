package org.learning.other;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonComparatorExample {
	
	public static void main(String[] args) {
		System.out.println("Hi");
		
		Person p1 = new Person("Hitesh", 37);
		Person p2 = new Person("Mitesh", 36);
		Person p3 = new Person("Jia", 3);
		Person p4 = new Person("Aarav", 2);
		List<Person> personList = new ArrayList<>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		
		
		PersonComparator<Integer> ageComparator = new PersonComparator<Integer>(Integer.class, "getAge");
		PersonComparator<String> nameComparator = new PersonComparator<String>(String.class, "getName");
		Collections.sort(personList,ageComparator);
		System.out.println(personList);
		Collections.sort(personList,nameComparator);
		System.out.println(personList);
		
		System.out.println("Done");
	}
	
	public static class Person{
		
		String name;
		Integer age;
		
		public Person(String name, Integer age) {
			this.name=name;
			this.age=age;
		}

		public String getName() {
			return name;
		}

		public Integer getAge() {
			return age;
		}
		
		@Override
		public String toString() {
			
			return "name:" + name + ", age:" + age;
		}
		
	}
	
	public static class PersonComparator<T extends Comparable<T>> implements Comparator<Person>{
		
		MethodHandle personMethodHandle;
		Class<T> classOfAttributeToCompare;
		public PersonComparator(Class<T> classOfAttributeToCompare, String methodName) {
			try{
				this.classOfAttributeToCompare = classOfAttributeToCompare;
				MethodType method = MethodType.methodType(classOfAttributeToCompare);
				personMethodHandle = MethodHandles.lookup().findVirtual(Person.class, methodName, method);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		
		@Override
		public int compare(Person p1, Person p2) {
			try{
				T attribute1 = (T) personMethodHandle.invoke(p1);
				T attribute2 = (T) personMethodHandle.invoke(p2);
				return attribute1.compareTo(attribute2);
			}
			catch(Throwable ex){
				ex.printStackTrace();
			}
			return -1;
		}
		
	}
	

}
