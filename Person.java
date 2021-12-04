public class Person {

   private String   name;


   public Person(String initialName) {

      name = initialName;

   }

   public Person() {

   }

   //setter for name
   public void setName( String fullName) {

      name = fullName;

   }

   //getter for name
   public String getName() {

      return name;
   }

   //prints the person's name
   public String toString() {

      System.out.println("Name: " + name);

      return null;

   }
}