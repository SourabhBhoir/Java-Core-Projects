import  java.sql.*;
import  java.util.Scanner;

public class StudentManager{
    static final String url ="jdbc:mysql://localhost:3306/studentdb";
    static final String user="root";
    static final String password = "Pass@123";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        try( Connection conn = DriverManager.getConnection(url, user, password)){
            System.out.println("Connected To DB!");

            while (true) { 
                    System.out.println("\n--- Student Management ---");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");

                int choice= sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter name: ");
                        String name= sc.nextLine();
                        System.out.println("Enter email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter course: ");
                        String course = sc.nextLine();

                        String query = "INSERT INTO students (name,email,course) VALUES(?, ?, ?)";
                        try(PreparedStatement pst = conn.prepareStatement(query)){
                            pst.setString(1, name);
                            pst.setString(2, email);
                            pst.setString(3, course);
                            pst.executeUpdate();
                            System.out.println("Student added.");
                        }
                        break;

                    case 2:
                        String select = "SELECT * FROM students";
                        try (Statement st = conn.createStatement();
                             ResultSet rs = st.executeQuery(select)) {

                            System.out.println("\n--- Student Records ---");
                            while (rs.next()) {
                                System.out.println(rs.getInt("id") + ": " +
                                        rs.getString("name") + ", " +
                                        rs.getString("email") + ", " +
                                        rs.getString("course"));
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter student ID to update: ");
                        int idToUpdate = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();
                        System.out.print("Enter new course: ");
                        String newCourse = sc.nextLine();

                        String update = "UPDATE students SET name=?, email=?, course=? WHERE id=?";
                        try (PreparedStatement pst = conn.prepareStatement(update)) {
                            pst.setString(1, newName);
                            pst.setString(2, newEmail);
                            pst.setString(3, newCourse);
                            pst.setInt(4, idToUpdate);
                            int rows = pst.executeUpdate();
                            System.out.println(rows > 0 ? "Student updated." : "Student not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        int idToDelete = sc.nextInt();

                        String delete = "DELETE FROM students WHERE id=?";
                        try (PreparedStatement pst = conn.prepareStatement(delete)) {
                            pst.setInt(1, idToDelete);
                            int rows = pst.executeUpdate();
                            System.out.println(rows > 0 ? "Student deleted." : "Student not found.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

                        
