import java.util.ArrayList;

public class StudentService {
    
    ArrayList<Student> students = new ArrayList<>();

    // Add students
    public void addStudent(Student student){
        students.add(student);
        System.out.println("Students Added Successfully!");
    }

   //View students
   public void viewStudents(){

    if(students.isEmpty()){
        System.out.println("No Students Found!");
        return;
    }

    for(Student s : students){
        System.out.println(s);
    }
   }   

   //Update Student
   public void updateStudent(int id, String name, int age){

    for(Student s: students){
        if(s.id == id){
            s.name = name;
            s.age = age;
         
          System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
   }

   //Delete Student
   public void deleteStudent(int id){
    for(Student s : students){
        if(s.id == id){
          students.remove(id);  
        System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Student Not Found!");

    }
   }

   }
}
