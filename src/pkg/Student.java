package pkg;

public class Student {
	private int id;
	private String name;
	private double grade;

	//default constructor
	public Student() {
		this.id = 0;
		this.name = "";
		this.grade = 0.0;
	}
	
	//parameterized constructor
	public Student(int id, String name, double grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	//get and set methods
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	//method to display student information
	public String toString() {
		return "Name:" + name +
				"ID:"  + id +
				"Grade:" + grade;
	}
}
