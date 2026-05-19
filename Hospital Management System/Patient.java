public class Patient{

    // Variables
    int patientId;
    String patientName;
    int patientAge;
    String disease;

    // Constructor
    Patient(int id, String name, int age, String diseaseName) {
        this.patientId = id;
        this.patientName = name;
        this.patientAge = age;
        this.disease = diseaseName;
    }

    //Method to display Patient details
    void displayPatientDetails(){
        System.out.println("Patient ID: "+ patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Age: " + patientAge);
        System.out.println("Disease: " + disease);
    }
}