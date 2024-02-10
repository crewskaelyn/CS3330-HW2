package pkg;


public class Main {

	public static void main(String[] args) {
	    StudentManager studentManager = new StudentManager();
	    boolean fileReadStatus = studentManager.readFromFile("src/studentData.txt");
	    studentManager.displayMenu();      
	}
	

}
