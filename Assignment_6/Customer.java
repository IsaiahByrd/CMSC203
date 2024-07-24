/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Create a class to represent a customer.
 * Due: 08/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Isaiah Byrd
*/
public class Customer {

	//variables
	private String name;
	private int age;
	
	
	
	//constructors
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Customer(Customer c) {
		this.name = c.name;
		this.age = c.age;
	}
	
	//accessors and mutators
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	//toString method
	public String toString() {
		return name + " " + age;
	}
}
