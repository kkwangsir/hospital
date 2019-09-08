//Name: Chen Wang NSID: chw989
//student id: 11210314

package a3;
import java.util.HashMap;
import java.io.*;


public class Control  {
    private static Ward A_ward= new Ward("Ward",200,205,2,2,2);

    static HashMap<String, Doctor> doctors = new HashMap<String, Doctor>();

    static HashMap<Integer, Patient> patients = new HashMap<Integer, Patient>();


    public static String getMaxMin() {
        String MM="";
        int max=A_ward.getMaxBedLabel()-1;
        int min=A_ward.getMinBedLabel();
        MM="From "+min+" to "+max;
        return MM;
    }

    public static void add_a_ward(String wName, int wMinBedLabel, int wMaxBedLabel,int general,int burn,int surgical)
    {

        A_ward = new Ward(wName, wMinBedLabel, wMaxBedLabel,general,burn,surgical);
    }


    public static void add_patient(int health_number, String patient_name)
    {
        try{
            Patient p = new Patient(patient_name, health_number);
            if (patients.containsKey(health_number))
            {
                System.out.println("This patient is in system");
            }else {
                patients.put(health_number, p);

                System.out.println("Patient has been added");
            }
            return;

        }catch(Exception e) {
            System.out.println(e+"invalid input");

        }
    }

    public static void add_doctor(String doctor_name)
    {try {
        Doctor d = new Doctor(doctor_name);
        if (doctors.containsKey(doctor_name))
        {
            System.out.println("This doctor is in system");
        }else {
            doctors.put(doctor_name, d);
            System.out.println("Doctor has been added");
        }
    }catch(Exception e) {
        System.out.println(e+"invalid input");

    }

    }
    public static void add_surgeon(String sdoctor_name)
    {try {
        Surgeon d = new Surgeon(sdoctor_name);
        if (doctors.containsKey(sdoctor_name))
        {
            System.out.println("This surgeon doctor is in system");
        }else {
            doctors.put(sdoctor_name, d);
            System.out.println("Surgeon Doctor has been added");
        }
    }catch(Exception e) {
        System.out.println(e+"invalid input");

    }
    }

    public static void assign_doctor_to_patient(String dName, int pNumber) {

        Doctor d = doctors.get(dName);
        Patient p = patients.get(pNumber);
        p.assign_a_doctor(d);
        d.assign_patient(p);
    }


    public static void assignPatientBed(int pNumber,int label, String purpose)
    {	try {
        Patient p = patients.get(pNumber);
        if(A_ward.checkWithPurpose(purpose)) {
            if(A_ward.getPatient(label)==null) {
                A_ward.assignPatientToBed(p, label);
                p.assign_to_bed(String.valueOf(A_ward.get_bed_label(pNumber)));

            }else {
                System.out.println("This bed is occupied.");

            }

        }
    }catch(Exception e) {
        System.out.println("invalid input"+e);

    }

    }

    public static void releasePatient(int pNumber) {

        if (patients.containsKey(pNumber)) {

            String n;
            try{

                n=patients.get(pNumber).get_bed_label();

                A_ward.remove(Integer.valueOf(n));
                patients.remove(pNumber);
                return;
            }catch(NullPointerException e) {
                System.out.println("error.");
            }

        }

    }

    public static void drop_association(String dName, int pNumber)
    {try {
        Doctor d = doctors.get(dName);
        Patient p = patients.get(pNumber);
        p.remove_doctor(d);
        d.remove_patient(p);
    }catch(Exception e) {
        System.out.println("error");

    }
    }
    public static void quit() {
        try {
            File writename = new File("./output.txt");
            FileWriter fileWriter = new FileWriter(writename);

            String s = new String("");

            s=s+A_ward.toString();
            fileWriter.write(s);
            fileWriter.close();

            System.exit(0);

        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }










}

