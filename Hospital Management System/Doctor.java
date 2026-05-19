

public class Doctor {

    private int id;
    private String name;
    private String specialization;

    // Constructor
    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // Getter Methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    // Display Doctor Details
    public void displayDoctor() {
        System.out.printf("| %-10s | %-20s | %-20s |\n",
                id, name, specialization);
    }
}