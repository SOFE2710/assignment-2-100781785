import java.util.Vector;

public class Student extends Person{

	private String id;
	private String name;
	private Vector courses; // contains all courses the student is registered in


	public Student(String stdId, String stdName) {

		//Parent class constructor
		super(stdName);

		//Initialize other variables
		id = stdId;

		//Vector to hold all of the student's enrolled courses
		Vector<Course> courses = new Vector<Course>();

	}

	//name and ID

	public String getName() {

		return name;

	}

	public String getId() {

		return id;

	}

	public String toString() {
		// return a string representation of a student using the following format:
		// 100234546 John McDonald
		// Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850

		System.out.println(id + " " + name);
		System.out.println("Registered courses: " + courses);

		return null;

	}

	//Adds a student to a course and updates the list of courses the student
	// is registered in, the list of students registered in the course and the list of students
	// in the department
	public void registerFor(Course course){

		//if the student is already in the course or not
		if (!(courses.contains(course))){

			courses.add(course);//adds the course to the student's list
			course.addToClassList(this);//adds student to the class list
			course.addStudToRegister(this); //adds student to the course department registerList

		}

	}

	//Checks whether or not a student is in a certain course
	public Boolean isRegisteredInCourse(Course course){

		return courses.contains(course);//returns true if the course is found in student's courses vector

	}

}