import java.util.HashSet;
import java.util.Vector;
import java.util.Random;

public class Department {
   private String name; // the name of school Dept of Computing and Info Science
   private String id; // short name for courses SOFE, ELEE, STAT, etc
   private Vector<Course> courseList; // all courses offered by the department
   private Vector<Student> registerList; // all students taking courses in the department.

   Random rand = new Random();

   public Department(String name, String id) {
      // Initialize the vectors

      //Initialize name and id
      name = this.name;
      id = this.id;

      //Create new vectors to store lists of courses and students
      Vector<Course> courselist = new Vector<Course>();
      Vector<Student> registerlist = new Vector<Student>();

   }

   //ID and Name

   public String getName() {

      return name;

   }

   public String getId() {

      return id;

   }


   public String toString() {

      // String representation of department name, number
      // Number of courses offered and number of students registered in the
      // department. Use the format:
      // ECSE: 53 courses, 460 students

      System.out.println(name+ ": " + courseList.size() + " courses, " + registerList.size() + " students");

      return null;

   }

   //adding a course to the courseList
   public void offerCourse(Course course){

      //adding course to the vector
      courseList.add(course);

   }

   //Prints the course info about each course in the department
   public void printCoursesOffered(){

      //repeat the loop for the same amount of times as the courseList vector size
      for (int i = 0; i < courseList.size(); i++){

         //print the course info of the ith element of courseList
         courseList.elementAt(i).toString();

      }

   }

   //adding student to the registerList
   public void addStudentToRegister(Student stud){

      //adding student to regiester if they are not regiestered
      if (isStudentRegistered(stud)) {

         //adds student to the vector
         registerList.add(stud);

      }

   }

   //returns whether or not student is registered in a course in the department or not
   public boolean isStudentRegistered(Student student){

      return (registerList.contains(student)); //returns true if student is in registerList vector

   }

   //this returns a course's classList after checking that the course is in the department
   public Vector<Student> studentsRegisteredInCourse(int code){

      //initialize variables
      boolean found = false;
      Vector<Student> studentsInCourse = new Vector<Student>(); //create a new vector to return

      //run through the vector elements to see which one is the one we're looking for and id it's there
      for (int i = 0; i < courseList.size(); i ++){

         //if the course is found execute the following
         if (code==((courseList.elementAt(i)).getCode())){

            //make studentsInCourse equal to the class list of the found course
            studentsInCourse = (courseList.elementAt(i)).getClassList();
            found =true; // confirm that the course was found
            break; //exit loop

         }

      }

      //if the course was found
      if (found){

         //return the vector
         return studentsInCourse;

      } else {

         //otherwise return nothing and tell the user the course is not in this department
         System.out.println("This course is not taught in this department.");
         return null;

      }

   }

   //this method prints student info of all the students in the course
   public void printStudentsRegisteredInCourse(int code){

      //print a header
      System.out.println("These are the students enrolled in " + id + code + ": ");

      int hold, size; //hold will store a random integer, size will hold the size of the student vector

      Vector<Student> courseStudents = studentsRegisteredInCourse(code);//get vector of students in the course
      size = courseStudents.size(); // get the size of the vector
      Vector<Student> copy = new Vector<Student>(size); // holds the students that already had their info printed

      //Student information in random order
      for (int i = 0; i < size; i++){

         do {//find the index of a student whose info hasn't been displayed

            hold = rand.nextInt(size);//finding a random number within a possible index of the vector

         } while (!(copy.contains(courseStudents.elementAt(hold)))); // randomize if the student's already been displayed

         copy.add(courseStudents.elementAt(hold)); // add the new student to this vector of students that have already been printed
         (courseStudents.elementAt(hold)).toString(); // display their info

      }


   }

}
