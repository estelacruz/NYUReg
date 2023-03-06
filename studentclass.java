public class studentclass {
	//member vars
	private String courseName;
	private String courseInstructor;
	private int sectionNumber;
	private int currentNumOfStudents;
	private String courseLocation;
	
	//default constructor just in case
	public studentclass() {
		
	}
	//assume all information is provided when constructing a course
	public studentclass(String coursename, String courseInstructor, int sectionNum, int NumStudents, String location) {
		this.courseName = coursename;
		this.courseInstructor = courseInstructor;
		this.sectionNumber = sectionNum;
		this.currentNumOfStudents = NumStudents;
		this.courseLocation = location;
	}
	//getters and setters
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseInstructor() {
		return courseInstructor;
	}
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	public int getSectionNumber() {
		return sectionNumber;
	}
	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	public int getCurrentNumOfStudents() {
		return currentNumOfStudents;
	}
	public void setCurrentNumOfStudents(int currentNumOfStudents) {
		this.currentNumOfStudents = currentNumOfStudents;
	}
	public String getCourseLocation() {
		return courseLocation;
	}
	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	public void printStudentCourse() {
		System.out.println("Course Name: " + this.courseName);
		System.out.println("Course Instructor: " + this.courseInstructor);
		System.out.println("Section: " + this.sectionNumber);
		System.out.println("Number of Students Currently Enrolled: " + this.currentNumOfStudents);
		System.out.println("Course Location: " + this.courseLocation);
	}
	public String strCourseInfo() {
		String courseInfo = ""; 
		//PAC II,Mohamed Zahran,1,45,CIWW 312
		courseInfo = this.courseName + "," + this.courseInstructor + "," + this.sectionNumber + "," + this.currentNumOfStudents + "," + this.courseLocation;
		return courseInfo;
	}

}
