import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();

        while (true) { 
            
              System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.println("Enter Choice: ");
            int Choice = sc.nextInt();

            switch(Choice) {
                case 1 :
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();

                     System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    Student student = new Student(id, name, age);
                
                    service.addStudent(student);

                    break;

                case 2 :
                     service.viewStudents();
                     
                 case 3:

                    System.out.print("Enter Student ID To Update: ");
                    int updateId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();

                    service.updateStudent(updateId, newName, newAge);

                    break;

                 case 4:

                    System.out.print("Enter Student ID To Delete: ");
                    int deleteId = sc.nextInt();

                    service.deleteStudent(deleteId);

                    break;

                case 5:

                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");    
                }
               
                    
                    
        }
    }
}
