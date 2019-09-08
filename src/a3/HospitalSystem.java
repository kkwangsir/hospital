package a3;

import java.util.*;

public class HospitalSystem {
    /**
     * Patient map of this hospital .
     */
    private Map<Integer, Patient> new_patients = new HashMap<Integer, Patient>();

    /**
     * Doctor map of this hospital .
     */
    private Map<String, Doctor> new_doctors = new HashMap<String, Doctor>();

    /**
     * The ward of this hospital .
     */
    private Ward new_ward;

    /**
     * a scanner  to input.
     */
    private Scanner in = new Scanner(System.in);

    /**
     * Initialize a ward
     * Add ward to this hospital .
     */
    public void add_a_ward()
    {
        System.out.println("Adding a ward");
        System.out.println("Enter ward name:");
        String wName = in.nextLine();
        System.out.println("Please enter ward minimum bed label");
        int wMinBedLabel = read();
        wMinBedLabel = check_input(wMinBedLabel);
        System.out.println("Please enter ward maximum bed label");
        int wMaxBedLabel = read();
        wMaxBedLabel = check_input(wMaxBedLabel);
        System.out.println("Please enter number of general care");
        int general= read();
        general = check_input(general);
        System.out.println("Please enter number of burn recovery");
        int burn= read();
        burn = check_input(burn);
        System.out.println("Please enter number of surgical recovery");
        int surgical= read();
        surgical = check_input(surgical);
        new_ward = new Ward(wName, wMinBedLabel, wMaxBedLabel,general,burn,surgical);
    }

    /**
     * read type to  task id n.
     *
     * @return Return task id
     */
    public int selectTask()
    {
        System.out.println("Select a task:");
        int temp = read();
        return check_input(temp);
    }

    /**
     * Initialize a patient
     * Add patient to system.
     * @param patient_name --patient name
     * @param health_number-- patient health number
     */
    public void add_patient(int health_number, String patient_name)
    {
        try{
            Patient p = new Patient(patient_name, health_number);
            if (new_patients.containsKey(health_number))
            {
                System.out.println("This patient is in system");
            }else {
                new_patients.put(health_number, p);

                System.out.println("Patient has been added");
            }
            return;

        }catch(Exception e) {
            System.out.println(e+"invalid input");

        }


    }

    /**
     * Initialize a doctor
     * Add this doctor to this system.
     * @param doctor_name doctor name
     */
    public void add_doctor(String doctor_name)
    {try {
        Doctor d = new Doctor(doctor_name);
        if (new_doctors.containsKey(doctor_name))
        {
            System.out.println("This doctor is in system");
        }else {
            new_doctors.put(doctor_name, d);
            System.out.println("Doctor has been added");
        }
    }catch(Exception e) {
        System.out.println(e+"invalid input");

    }

    }

    /**
     * Initialize a surgeon
     * Add  surgeon to system.
     * @param sdoctor_name surgeon name
     */
    public void add_surgeon(String sdoctor_name)
    {try {
        Surgeon d = new Surgeon(sdoctor_name);
        if (new_doctors.containsKey(sdoctor_name))
        {
            System.out.println("This surgeon doctor is in system");
        }else {
            new_doctors.put(sdoctor_name, d);
            System.out.println("Surgeon Doctor has been added");
        }
    }catch(Exception e) {
        System.out.println(e+"invalid input");

    }

    }

    /**
     * Assign the specified patient to the specified doctor
     * @param dName doctor name
     * @param pNumber patient health number
     */
    public void assign_doctor_to_patient(String dName, int pNumber)
    {	try{
        if (dName == null || pNumber <= 0) {
            System.out.println("invalid doctor name or patient health number.");

        }

    }catch(Exception e){
        System.out.println("invalid doctor name or patient health number.");
    }

        if (!new_doctors.containsKey(dName)||!new_patients.containsKey(pNumber)) {
            System.out.println("can not find doctor name or patient health number");
            return;
        }
        Doctor d = new_doctors.get(dName);
        Patient p = new_patients.get(pNumber);
        p.assign_a_doctor(d);
        d.assign_patient(p);
        System.out.println("Doctor assigned to patient");
    }

    /**
     * Assign the  patient to the  bed of the ward
     * and check if or not the specified purpose is full
     * @param pNumber patient health number
     * @param bLabel bed label
     * @param purupose the purpose of beds
     */
    public void assignPatientBed(int pNumber,int label, String purpose)
    {	try {
        Patient p = new_patients.get(pNumber);
        if(new_ward.checkWithPurpose(purpose)) {
            if(new_ward.getPatient(label)==null) {
                new_ward.assignPatientToBed(p, label);
                p.assign_to_bed(String.valueOf(new_ward.get_bed_label(pNumber)));

            }else {
                System.out.println("This bed is occupied.");

            }

        }
    }catch(Exception e) {
        System.out.println("invalid input"+e);

    }

    }

    /**
     * drop association between the patient and the doctor
     * in this hospital system.
     * @param pNumber patient health number
     * @param bLabel bed label
     */
    public void drop_association(String dName, int pNumber)
    {try {
        Doctor d = new_doctors.get(dName);
        Patient p = new_patients.get(pNumber);
        p.remove_doctor(d);
        d.remove_patient(p);
        System.out.println("has dropped association");
    }catch(Exception e) {
        System.out.println("error");

    }
    }

//	/**
//	 * print out the current of this hospital system.
//	 */
//	public void currentState()
//	{
//		String info = "ward state";
//		info = info + new_ward.toString();
//		info = info + "patient state\n";
//		for (int key : new_patients.keySet())
//		{
//			Patient p = new_patients.get(key);
//			info = info + p.toString();
//		}
//		info = info + "doctor state";
//		for (String key : new_doctors.keySet())
//		{
//			Doctor d = new_doctors.get(key);
//			info = info + d.toString();
//		}
//		System.out.println(info);
//	}
//
    /**
     * display the content
     */
    public void displayTaskContent()
    {
        System.out.println("***************************\ntask1: quit");
        System.out.println("task2: add a new patient to the system");
        System.out.println("task3: add a new doctor to the system");
        System.out.println("task4: assign a doctor to a patient");
        System.out.println("task5: display the empty beds of the ward as a list of bed labels with purpose");
        System.out.println("task6: assign a patient a bed");
        System.out.println("task7: release a patient");
        System.out.println("task8: drop doctor-patient association\n***************************");
    }

    /**
     * Read and return an integer.
     *
     * @return Return an integer
     */
    public int read()
    {
        int input = 0;

        try {
            input = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        }
        in.nextLine();

        return input;
    }

    /**
     * Check the input and return an integer.
     *
     * @return Return an integer
     */
    public int check_input(int input)
    {
        while(input==0) {
            System.out.println("type again:");
            input=read();

        }
        return input;

    }
    /**
     * print out the current status.
     */
    public void currentState()
    {
        String info = "ward state:";
        info = info + new_ward.toString();
        info = info + "patient state:\n";
        for (int key : new_patients.keySet())
        {
            Patient p = new_patients.get(key);
            info = info + p.toString()+"\n________________________\n";
        }
        info = info + "doctor state:\n";
        for (String key : new_doctors.keySet())
        {
            Doctor d = new_doctors.get(key);
            info = info + d.toString();
        }
        System.out.println(info);
    }

    public void releasePatient(int pNumber) {

        if (new_patients.containsKey(pNumber)) {

            String n;
            try{

                n=new_patients.get(pNumber).get_bed_label();

                new_ward.remove(Integer.valueOf(n));
                new_patients.remove(pNumber);
                System.out.println("patient has been released");
                return;
            }catch(NullPointerException e) {
                System.out.println("error.");
            }

        }

    }


    /**
     * run the hospital system.
     */
    public void run()
    {
        displayTaskContent();
        int taskId = selectTask();
        switch(taskId) {
            case 1:

                System.out.println("Status");
                currentState();
                System.out.println("Quit system");
                break;

            case 2:

                System.out.println("Add a patient");
                System.out.println("Please enter patient name");
                String pName = in.next();
                System.out.println("Please enter patient health number");
                int pNumber = read();
                pNumber = check_input(pNumber);
                add_patient(pNumber, pName);
                run();
                break;



            case 3:
                System.out.println("Add a doctor");
                System.out.println("Is it doctor a surgeon? y/n");
                String s = in.next();
                if (s.equals("y"))
                {
                    System.out.println("Please enter surgeon name");
                    String dName = in.next();
                    add_surgeon(dName);
                }
                else
                {
                    System.out.println("Please enter doctor name");
                    String dName = in.next();
                    add_doctor(dName);
                }
                run();
                break;



            case 4:
                System.out.println("Assign a doctor to a patient");
                System.out.println("Please enter doctor name");
                String dName = in.next();
                System.out.println("Please enter patient health number");
                int pNumber1 = read();
                pNumber1 = check_input(pNumber1);
                assign_doctor_to_patient(dName, pNumber1);
                run();
                break;


            case 5:
                while(true) {
                    System.out.println("display the empty beds of the ward as a list of bed labels with purpose:");
                    System.out.println("Please enter purpose(general,burn,surgical):");
                    String purpose = in.next();
                    if(!new_ward.find_empty(purpose).equals("invalid")) {
                        System.out.println(new_ward.find_empty(purpose));

                        break;
                    }else {
                        System.out.println("invalid input,make sure the type are (general,burn,surgical)");


                    }

                }
                run();


            case 6:

                System.out.println("Assign a patient to a particular type bed");
                System.out.println("Please enter patient health number");
                int pNumber11 = read();
                pNumber11 = check_input(pNumber11);
                System.out.println("Please enter bed label");
                int bLabel = read();
                bLabel = check_input(bLabel);
                System.out.println("Please enter purpose of 'general','burn','surgical'");
                String bPurpose=in.next();


                while (!new_ward.isValidLabel(bLabel))
                {
                    System.out.println("The valid bed label range is from "
                            + new_ward.getMinBedLabel() + " to " + new_ward.getMaxBedLabel());
                    System.out.println("Please enter a valid bed label");
                    bLabel = in.nextInt();
                }
                assignPatientBed(pNumber11,bLabel, bPurpose);


                run();
                break;



            case 7:
                System.out.println("please enter the patient health number.");
                int pNumber12=read();
                pNumber12=check_input(pNumber12);
                releasePatient(pNumber12);
                run();
                break;


            case 8:
                System.out.println("Drop doctor-patient association");
                System.out.println("Please enter doctor name");
                String dName1 = in.next();
                System.out.println("Please enter patient health number");
                int pNumber13 = read();
                pNumber13 = check_input(pNumber13);
                drop_association(dName1, pNumber13);
                run();
                break;
            default :
                run();
                break;
        }



    }






    public static void main(String[] args) {
        HospitalSystem w = new HospitalSystem();


        HospitalSystem h = new HospitalSystem();
        h.add_a_ward();
//		System.out.println(h);
        h.run();
    }

}

