package pkg;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


public class StudentManager {
	//Array called Student
	private Student[] students;
	public boolean readFromFile(String fileName) {
	    try {
	    	// Takes the fileName variable and attached it to 'file'. 
	    	// 'file' is run through the Scanner.
	    	// Create Variable Count.
	        File file = new File(fileName);
	        Scanner scanner = new Scanner(file);
	        int count = 0;

	        // Count the number of lines in the file.
	        while (scanner.hasNextLine()) {
	            scanner.nextLine();
	            count++;
	        }

	        scanner.close();
	        
	        // Makes an array based on how many were counted.
	        students = new Student[count]; 
	        scanner = new Scanner(file);

	        // Read data and initialize Student objects
	        for (int i = 0; i < count; i++) {
	            int id = scanner.nextInt();
	            String firstName = scanner.next();
	            String lastName = scanner.next();
	            String name = firstName + " " + lastName;
	            double grade = scanner.nextDouble();
	            // Sends the information through the Student.java
	            students[i] = new Student(id, name, grade);
	        }
	        // Close the scanner.
	        scanner.close();
	        // Returns true.
	        return true;
					
		            //Catch part of the try/catch block.
					} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
					}
		
	};
	
	// Method to Display Menu of Options.
	// Prints Menu, Scans user Input, Calls Method based on Choice.
	public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Display Students");
            System.out.println("2. Search Students");
            System.out.println("3. Update Students");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayStudents();
                    break;
                case 2:
                	 System.out.println("Enter student ID:");
                	 int searchID = scanner.nextInt();
                	 boolean found = searchStudentById(searchID);
                    //searchStudentById();
                    break;
                case 3:
                	System.out.println("Enter student ID");
                	int updateId = scanner.nextInt();
                	System.out.println("Enter new grade");
                	double grade = scanner.nextDouble();
                	boolean updated = updateStudentGradeById(updateId, grade );
                	if (!updated) {
                		System.out.println("Student not found.");
                	}
                	//updateStudentGradeById();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
        scanner.close();
    }
	
	public void displayStudents() {
		if (students == null || students.length == 0) {
			System.out.println("No students found.");
			return;
		}
		for (Student student : students) {
			System.out.println(student);
		}
			
	}
	
	
	public boolean searchStudentById(int id) {
		if (students == null || students.length == 0) {
			System.out.println("No Students Found.");
			return false;
		}
		
		for (Student student : students) {
			if (student.getId() == id) {
				System.out.println("Student found: ");
				System.out.println(student);
				return true;
			}
		}
		
		System.out.println("Student with ID" + id + "not found.");
		return false;
	}

	public boolean updateStudentGradeById(int id, double grade) {
		if (students == null || students.length == 0) {
			System.out.println("No Students found.");
			return false;
		}
		
		for (Student student : students) {
			if (student.getId() == id) {
				student.setGrade(grade);
				System.out.println("Student grade updated:");
				System.out.println(student);
				return true;
			}
		}
		System.out.println("Student with ID" + id + "not found.");
		return false;
	}
	

	
	
}
