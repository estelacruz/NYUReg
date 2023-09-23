
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class courseRegistration {
	//global vars
	static courseMng nyuFileCourses = new courseMng ();
	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) throws IOException {	
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nWelcome to Estela's NYUReg: Course Registration System");
		System.out.println("--------------------------------------------------------------------");
		//read file
		readFileCourses();
		//display menu 
		displayMenu();
		
		
	} 
	// method to read file to hide complexity in main // abstraction
	public static void readFileCourses() throws IOException {
		// read from file
		File userFile = new File("courses");
		int numOfClasses = 0;
		try	{
			BufferedReader buffy = new BufferedReader(new FileReader(userFile));
			//System.out.println("...Uploading All Courses From File..."); 
			String classInfo = buffy.readLine();
			while(classInfo!= null) {
				numOfClasses += 1; // line is not null, so count class
				//will stop at end of text file
				// add to a list of strings
				String[] classElements = classInfo.split(",");
				// create a student course using this info
				//known that elements in index 2 & 3 are integers
				studentclass currentCourse = new studentclass(classElements[0], classElements[1], Integer.valueOf(classElements[2]),Integer.valueOf(classElements[3]), classElements[4]);
				//add to array list containing all courses
				nyuFileCourses.addCourse(currentCourse);
				//currentCourse.printStudentCourse();
				//System.out.println("----------------------------");
				
				//now read next line
				classInfo = buffy.readLine(); 
			}
			
			
			buffy.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
			System.exit(0); //end prog
		}
		//System.out.println("Complete! A total of " + numOfClasses + " NYU courses were found in 'Courses' file.");
		//System.out.println("-----------------------------------------------------------------");
		// all courses were uploaded

	}
	public static void displayMenu() throws IOException {
		System.out.println("Select Option from Menu Below: ");
		int useroption = 0;
		do {
			System.out.println(
					"1) Add Course\n2) Edit Course\n3) Display ALL Courses\n4) Search for a Course\n5) Delete Course\n6) Sort Courses by Number of Students Registered & Display\n7)Display all High Volume Courses\n8) Write Results of Menu Option #7 to New Text File\n9) Exit Menu");
			//student does not have access to edit num of students enrolled
			useroption = userInput.nextInt();
			userInput.nextLine(); // to avoid issues
			switch (useroption) {
			case 1:
				// add course
				nyuFileCourses.Add_Course();
				break;

			case 2:
				// Edit course instructor
				System.out.println("---------------------------");		
				System.out.println("Please Enter the Name of the Course you wish to Edit: ");	
				String editcourseName = userInput.nextLine();
				System.out.println("Enter Course Section Number: ");
				int editSecNum= userInput.nextInt();
				userInput.nextLine(); // to avoid issues
				nyuFileCourses.editCourse(editcourseName, editSecNum);
				
				break;

	
			case 3:
				// display all courses
				nyuFileCourses.displayAllCourses();	
				break;

			case 4:
				// search course
				System.out.println("---------------------------");		
				System.out.println("Please Enter the Name of the Course you wish to Search: ");	
				String SearchcourseName = userInput.nextLine();
				System.out.println("Enter Course Section Number: ");
				int searchSecNum= userInput.nextInt();
				userInput.nextLine(); // to avoid issues
				nyuFileCourses.searchCourse(SearchcourseName, searchSecNum);		
				break;

			case 5:
				//delete a course
				System.out.println("---------------------------");		
				System.out.println("Please Enter the Name of the Course you wish to Delete: ");	
				String DelcourseName = userInput.nextLine();
				System.out.println("Enter Course Section Number: ");
				int DelSecNum= userInput.nextInt();
				userInput.nextLine(); // to avoid issues
				nyuFileCourses.deleteCourse(DelcourseName, DelSecNum);
				break;
				
			case 6:
				//sort
				nyuFileCourses.sortByRegistered();
				break;
			
			case 7:
				//display high volume courses
				nyuFileCourses.displayHighVolumeCourses();
				break;
			
			case 8:
				//write on new file
				nyuFileCourses.writeData();
				break;
			case 9:
				break;
		

			}

		} while (useroption != 9);
			System.out.println("Thank you for using Estela's Course Registration... See you next time!");
		
	}

}
