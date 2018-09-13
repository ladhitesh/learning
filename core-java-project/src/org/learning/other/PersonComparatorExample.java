package org.learning.other;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PersonComparatorExample {
	
	public static void main(String[] args) {
		System.out.println("Hi");
		
		Person p1 = new Person("Hitesh", 37);
		Person p2 = new Person("Mitesh", 36);
		Person p3 = new Person("Jia", 3);
		Person p4 = new Person("Aarav", 3);
		Person p5 = new Person("Aarav", 2);
		List<Person> unsortedPersonList = new ArrayList<>();
		unsortedPersonList.add(p1);
		unsortedPersonList.add(p2);
		unsortedPersonList.add(p3);
		unsortedPersonList.add(p4);
		unsortedPersonList.add(p5);
		
		
		PersonComparator<Integer> ageComparator = new PersonComparator<Integer>(Integer.class, "getAge");
		PersonComparator<String> nameComparator = new PersonComparator<String>(String.class, "getName");
		
		//// Java 8 example //////
		Comparator<Person> personAgeComparator = Comparator.comparing(Person::getAge);
		Comparator<Person> personNameComparator = Comparator.comparing(Person::getName);
		Comparator<Person> personNameAgeComparator = Comparator.comparing(Person::getName)
														.thenComparing(Person::getAge);
		
		
		Map<String,Comparator> comparatorsMap = new TreeMap<>();
		comparatorsMap.put("methodhandle-age",ageComparator);
		comparatorsMap.put("methodhandle-name",nameComparator);
		comparatorsMap.put("java8-age",personAgeComparator);
		comparatorsMap.put("java8-name",personNameComparator);
		comparatorsMap.put("java8-name-age",personNameAgeComparator);
		
		comparatorsMap.forEach( (comparatorName, comparator) -> {
			List<Person> sorted = new ArrayList<>(unsortedPersonList);
			Collections.sort(sorted,comparator);
			System.out.println(comparatorName+ ":" + sorted);
		});
		
		
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
