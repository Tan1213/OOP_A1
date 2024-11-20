
import java.util.ArrayList;

// 1. HealthProfessional;
class HealthProfessional {
    int id;
    String name;
    String description;

    public HealthProfessional() {
    }

    public HealthProfessional(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // 详情;
    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
    }
}

// GeneralPractitioner;
class GeneralPractitioner extends HealthProfessional {
    public GeneralPractitioner() {
    }

    public GeneralPractitioner(int id, String name, String description) {
        super(id, name, description);
    }

    @Override
    public void printDetails() {
        super.printDetails();
    }
}

// Part 2;
class Nurse extends HealthProfessional {

    final String specialty = "Nurse";

    public Nurse() {

    }

    public Nurse(int id, String name, String description) {
        super(id, name, description);
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Specialty: " + this.specialty);
    }
}

// Part 4 Appointment;
class Appointment {

    String name;
    String phone;
    String time;
    HealthProfessional doctor;

    public Appointment() {

    }

    public Appointment(String name, String phone, String time, HealthProfessional doctor) {
        this.name = name;
        this.phone = phone;
        this.time = time;
        this.doctor = doctor;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Time: " + time);
        System.out.print("Doctor: ");
        doctor.printDetails();
    }
}

// AssignmentOne;
public class AssignmentOne {
    // appointments;
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Part 3:----------------------");
        // Part 3;
        GeneralPractitioner gen1 = new GeneralPractitioner(1, "Ms. Taylor", "Pediatric care");
        GeneralPractitioner gen2 = new GeneralPractitioner(2, "Mr. Johnson", "Mental health");
        GeneralPractitioner gen3 = new GeneralPractitioner(3, "Dr. Lee", "Geriatric care");
        // Nurses
        Nurse Nurse1 = new Nurse(4, "Dr. Miller", "Emergency care");
        Nurse Nurse2 = new Nurse(5, "Mr. Davis", "Family medicine");  
        // Details;   
        gen1.printDetails(); System.out.println("------------------------------");
        gen2.printDetails(); System.out.println("------------------------------");
        gen3.printDetails(); System.out.println("------------------------------");
        Nurse1.printDetails(); System.out.println("------------------------------");
        Nurse2.printDetails(); System.out.println("------------------------------");

        System.out.println("Part 5:----------------------");
        // Part5;
        // createAppointment  GeneralPractitioner;
        createAppointment("Jane Smith", "9876543210", "2:30",gen1);
        createAppointment("Alice Johnson", "5551234567", "3:00",gen2);
        // createAppointment  Nurse1;
        createAppointment("Bob Brown", "4449876543", "9:00",Nurse1);
        createAppointment("Charlie Davis", "3335551234", "10:30",Nurse2);

        // Appointments;
        printExistingAppointments();

        // cancel;
        cancelBooking("9876543210");

        // Canceled Appointments;
        printExistingAppointments();

        // cancel error;
        cancelBooking("xxxxxxxxx");
    }

    // createAppointment;
    public static void createAppointment(String name, String phone, String time, HealthProfessional health) {
        Appointment appointment = new Appointment(name, phone, time, health);
        appointments.add(appointment);
        System.out.println("createAppointment success!");
    }

    // printExistingAppointments;
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("appointments is empty");
            return;
        }
        for (int i = 0; i < appointments.size(); i++) {
            appointments.get(i).printDetails();
            System.out.println("------------------------------");
        }
    }

    // cancelBooking;
    public static void cancelBooking(String phone) {
        int index = -1;
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).phone.equals(phone)) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            appointments.remove(index);
            System.out.println("cancel: " + phone);
        } else {
            System.out.println("error:" + phone);
        }
    }
}
