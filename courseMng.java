import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class courseMng {
	private ArrayList<studentclass> nyuClasses = new ArrayList <studentclass> ();
	static Scanner userInput = new Scanner(System.in);
	//def constructor
	public courseMng() {
		
	}
	//getters and setters
	public ArrayList<studentclass> getNyuClasses() {
		return nyuClasses;
	}
	public void setNyuClasses(ArrayList<studentclass> nyuClasses) {
		this.nyuClasses = nyuClasses;
	}
	//methods
	public void addCourse(studentclass nyuclass) {
		nyuClasses.add(nyuclass);
	}
	
	public void Add_Course() { //includes user action
		//1. add course, can assume all information is provided
		System.out.println("Add Course to Schedule Option");
		System.out.println("-------------------------");		
		System.out.println("Enter New Course Name: ");	
		String coursename = userInput.nextLine();
		System.out.println("Enter Course Instructor: ");
		String courseInstructor = userInput.nextLine();
		System.out.println("Enter Course Section Number: ");
		int courseSecNum = userInput.nextInt();
		userInput.nextLine(); // to avoid issues
		System.out.println("Enter Number of Students Currently Registered: ");	
		int courseStu = userInput.nextInt();
		userInput.nextLine(); // to avoid issues
		System.out.println("Enter Course Location: ");
		String courseLoc = userInput.nextLine();
		studentclass addingclass = new studentclass(coursename,courseInstructor,courseSecNum,courseStu,courseLoc);	
		nyuClasses.add(addingclass);
		System.out.println(addingclass.getCourseName() + " was successfully added!");
	}
	
	public void editCourse(String courseName, int SectionNum) {
		//given: you need to edit the course name and the instructor’s name.
		System.out.println("Edit Course Option");
		System.out.println("------------------");
		int found = 0;
		for(int i = 0; i<nyuClasses.size(); i++) {
			// check course name and section number
			if((nyuClasses.get(i).getCourseName().equals(courseName))&& (nyuClasses.get(i).getSectionNumber()== SectionNum)) {
				// this is the course that needs to be edited	
				System.out.println("Class Found: " + nyuClasses.get(i).getCourseName());
				found = 1;
				// switch case
				System.out.println("Select Option from Menu Below: ");
				int useroption = 0;
				do {
					System.out.println(
							"1) Edit Course Name\n2) Edit Course Instructor\n3) Edit Section Number\n4) Edit Course Location\n5) Edit Number of Students Registered\n6) Exit Menu");
			
					useroption = userInput.nextInt();
					userInput.nextLine(); // to avoid issues
					switch (useroption) {
					case 1:
						//1. edit course name
						System.out.println("----------------");		
						System.out.println("Please Enter New Course Name: ");	
						nyuClasses.get(i).setCourseName(userInput.nextLine());	
						System.out.println("Successfully Updated Course Name!");
						break;

					case 2:
						// Edit course instructor
						System.out.println("----------------");		
						System.out.println("Please Enter New Course Instructor: ");	
						nyuClasses.get(i).setCourseInstructor(userInput.nextLine());
						System.out.println("Successfully Updated Course Instructor!");
						
						break;

			
					case 3:
						// edit section number
						System.out.println("----------------");		
						System.out.println("Please Enter New Course Section Number: ");	
						nyuClasses.get(i).setSectionNumber(userInput.nextInt());
						userInput.nextLine(); // to avoid issues
						System.out.println("Successfully Updated Course Section Number!");	
						break;

					case 4:
						// edit course location
						System.out.println("----------------");		
						System.out.println("Please Enter New Course Location: ");	
						nyuClasses.get(i).setCourseLocation(userInput.nextLine());
						System.out.println("Successfully Updated Course Location!");
						break;

					case 5:
						//edit number of students registered
						System.out.println("----------------");		
						System.out.println("Please Enter Number of Students Registered: ");	
						nyuClasses.get(i).setCurrentNumOfStudents(userInput.nextInt());
						userInput.nextLine(); // to avoid issues
						System.out.println("Successfully Updated Number of Students Registered!");					
						break;
					case 6:
						//break
						break;
				

					}

				} while (useroption != 6);
					System.out.println("Leaving Edit Menu... See you next time!");
				

			}
		}
		if(found == 0) {
			System.out.println("Course Name: " + courseName + " Section Number: " + SectionNum + " was not found in system.");
		}
	}
	//display all courses
	public void displayAllCourses() {
		System.out.println("Displaying All Courses Option");
		System.out.println("------------------------------");
		for(int i = 0; i<nyuClasses.size(); i++) {
			nyuClasses.get(i).printStudentCourse();
			System.out.println("-----------------------------------------------");
		}
	}
	public void searchCourse(String courseName, int SectionNum) {
		System.out.println("Search for a Course Option");
		System.out.println("----------------------");
		int found = 0;
		for(int i = 0; i<nyuClasses.size(); i++) {
			//make sure course name and section number match
			if((nyuClasses.get(i).getCourseName().equals(courseName)) && (nyuClasses.get(i).getSectionNumber()== SectionNum)) {
				System.out.println("Course Found: ");
				System.out.println("----------------");
				found = 1;
				nyuClasses.get(i).printStudentCourse();
				System.out.println("---------------------------------");
				
			}
		}
		if(found ==0) {
			System.out.println("Course Name: " + courseName + " Section Number: " + SectionNum + " was not found in system.");
		}
		
	}
	//delete a course
	public void deleteCourse(String courseName, int SectionNum) {
		System.out.println("----------------------");
		int found = 0;
		for(int i = 0; i<nyuClasses.size(); i++) {
			//make sure course name and section number match
			if((nyuClasses.get(i).getCourseName().equals(courseName)) && (nyuClasses.get(i).getSectionNumber()== SectionNum)) {
				System.out.println("Successfully Removed Course: " + nyuClasses.get(i).getCourseName());
				found = 1;
				nyuClasses.remove(i);						
			}
		}
		if(found ==0) {
			System.out.println("Course Name: " + courseName + " Section Number: " + SectionNum + " was not found in system.");
		}

	}
	
	public void sortByRegistered() {
		// sort by number of students registered
			
		// sort selection example
		//33 90 76 33 21 10 
		//first:
		//10 90 76 33 21 33
		//second:
		//10 21 76 33 90 33
		//third:
		//10 21 33 76 90 33
		//fourth: 
		//10 21 33 33 90 76
		//fifth:
		//10 21 33 33 76 90
	
		for(int i = 0; i<nyuClasses.size(); i++) {
			// assume this element in array is the smallest
			int currentNumStu = nyuClasses.get(i).getCurrentNumOfStudents();
			int minIndex = i;
			
			// go through every other element to check if this is truly the smallest value
			for(int e = i + 1; e <nyuClasses.size(); e++) {
				if(currentNumStu > nyuClasses.get(e).getCurrentNumOfStudents()) {
					//if current min is greater than other element, update
					currentNumStu = nyuClasses.get(e).getCurrentNumOfStudents();
					minIndex = e;
				}
			}
			// now that you have lowest number of students registered, swap if needed
			if(minIndex != i) { //smallest value was found in another index
				Collections.swap(nyuClasses, i, minIndex);
			}
			
		}
		// array list has been sorted 
		System.out.println("Classes have been sorted by Number of Students Currently Registered!");
		displayAllCourses(); // will print out all classes sorted		
	
	}
	public void displayHighVolumeCourses() {
		
		System.out.println("Displaying High Volume Courses (30+ Registered Students)");
		System.out.println("--------------------------------------------------------------");
		int highvolume = 0;
		for(int i = 0; i<nyuClasses.size(); i++) {
			if(nyuClasses.get(i).getCurrentNumOfStudents() >= 30) {
				highvolume += 1;
				nyuClasses.get(i).printStudentCourse();
				System.out.println("----------------");
			}
			
		}
		if(highvolume == 0) {
			System.out.println("Currently, there are no high volume courses.");
		}else {
			System.out.println("*There are a total of " + highvolume + " high volume courses*");
		}		

	}
	public void writeData() throws IOException {
		//Write data (of the results of menu option# 8) to a new text
		System.out.println("Write Data of High Volume Courses Option");
		System.out.println("-----------------------------------------");
		// read file
		int highvolume = 0;
		File userFile = new File("newTextFile");
		try	{
			BufferedWriter buffyWrite = new BufferedWriter(new FileWriter(userFile));
			// go through for loop to get high volume classes
			for(int i = 0; i<nyuClasses.size(); i++) {
				if(nyuClasses.get(i).getCurrentNumOfStudents() >= 30) {
					//get information
					String course_info = nyuClasses.get(i).strCourseInfo();
					// add to new text file
					buffyWrite.write(course_info);
					//new line
					buffyWrite.write("\n");
					highvolume += 1;
				}
				
			}
			buffyWrite.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
			System.exit(0); //end prog
		}
		if(highvolume == 0) {
			System.out.println("Currently, there are no high volume courses.");
		}else {
			System.out.println("There were a total of " + highvolume + " high volume courses. All their information was successfully written in new text file!");
		}
	}
}
