
import java.util.ArrayList;
import java.util.Scanner;



public class HospitalManagementSystem{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ArrayLists
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();

        // Add Default Doctors
        doctors.add(new Doctor(1, "Dr. Rahul", "Cardiologist")); 
        doctors.add(new Doctor(2, "Dr. Priya", "Neurologist"));
        doctors.add(new Doctor(3, "Dr. Amit", "Dermatologist"));      

        int patientIdCounter = 1;

        while (true) { 
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");

            int choice = sc.nextInt();

            switch(choice){

                  // Add Patient
                case 1:
                sc.nextLine();

                System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Patient Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Patient Gender: ");
                    String gender = sc.nextLine();

                    //Create Object 
                     Patient patient = new Patient(
                            patientIdCounter,
                            name,
                            age,
                            gender
                    );

                    // Add to ArrayList
                    patients.add(patient);

                    System.out.println("Patient Added Successfully!");

                    patientIdCounter++;

                    break;


                 // View Patients
                case 2:

                    System.out.println("\n=========== PATIENT LIST ===========");

                    System.out.println("----------------------------------------------------------------");
                    System.out.printf("| %-10s | %-20s | %-10s | %-10s |\n",
                            "ID", "NAME", "AGE", "GENDER");
                    System.out.println("----------------------------------------------------------------");

                    if (patients.isEmpty()) {

                        System.out.println("No Patients Found!");

                    } else {

                        for (Patient p : patients) {
                            p.displayPatient();
                        }
                    }

                    System.out.println("----------------------------------------------------------------");

                    break;
                    
                  // View Doctors
                case 3:

                    System.out.println("\n=========== DOCTOR LIST ===========");

                    System.out.println("------------------------------------------------------------------");
                    System.out.printf("| %-10s | %-20s | %-20s |\n",
                            "ID", "NAME", "SPECIALIZATION");
                    System.out.println("------------------------------------------------------------------");

                    if (doctors.isEmpty()) {

                        System.out.println("No Doctors Found!");

                    } else {

                        for (Doctor d : doctors) {
                            d.displayDoctor();
                        }
                    }

                    System.out.println("------------------------------------------------------------------");

                    break;

                // Delete Patient
            case 4:

                  if (patients.isEmpty()) {

                   System.out.println("No Patients Available!");

                } else {

                System.out.print("Enter Patient ID to Delete: ");

                  int deleteId = sc.nextInt();

                  boolean found = false;

                 for (int i = 0; i < patients.size(); i++) {

                      if (patients.get(i).getId() == deleteId) {

                     patients.remove(i);

                       System.out.println("Patient Deleted Successfully!");

                      found = true;

                   break;
            }
        }

        if (!found) {

            System.out.println("Patient ID Not Found!");
        }
    }

    break;


// Exit
            case 5:

                 System.out.println("THANK YOU!");
                 sc.close();
                 System.exit(0);

                break;

                default:

                    System.out.println("Invalid Choice!");    

            }

        }


    }   
}