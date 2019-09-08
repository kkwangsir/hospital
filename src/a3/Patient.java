/**
 * @author
 * NSID: chw989
 * Chen Wang
 * id: 11210314
 */

package a3;
import java.util.*;

public class Patient extends Person{
    // create patient bed label
    private String bed_label;
    //create doctors linked list
    private LinkedList<Doctor> doctors;

    /**
     * create constructor of Patient with and health number
     * @param pName patient name
     * @param pNumber health number
     */
    public Patient(String pName, int pNumber) {
        super(pName, pNumber);
        bed_label=null;
        doctors=new LinkedList<Doctor>();

    }

    /**
     * get the bed label.
     *
     * return bed_label of  patient
     */
    public String get_bed_label()
    {
        return bed_label;
    }
    /**
     * Assign patient to the a bed.
     * a_bed_label is a bed label of patient
     */
    public void assign_to_bed(String a_bed_label)
    {
        this.bed_label = a_bed_label;
    }
    /**
     * remove bed label
     */
    public void remove_label()
    {
        this.bed_label = null;
    }
    /**
     * assign a doctor to this patient
     * @param a_doctor we want to assign
     */
    public void assign_a_doctor(Doctor a_doctor)
    {
        doctors.add(a_doctor);
    }
    /**
     * remove the doctor when input doctor d
     * use loop to find if or not the doctor is in the linkedlist
     * then remove
     * @param d a doctor
     */
    public void remove_doctor(Doctor d)
    {
        String dName = d.getName();
        int removeDoctor = -1;
        for (int i = 0; i < doctors.size(); i++)
        {
            Doctor temp = doctors.get(i);
            String tempName = temp.getName();
            if (dName.equals(tempName))
            {
                removeDoctor = i;
            }
        }
        if (removeDoctor != -1)
        {
            doctors.remove(removeDoctor);
        }
    }



    /**
     * create a variable infor, and print it for patient information
     * if this patient don't have bed label, it will just return information
     * else if patient has label, it will return all the information + bed label and doctor name by
     * iterate linked list 'doctors'
     */
    public String toString() {
        String infor;
        infor = "\nName: " + super.getName() + "\nHealth number: " + super.getHealthNumber() + "\n";
        if (bed_label!= null) {
            infor = infor+"Bed label: "+bed_label+"\n"+"Has a doctor: ";
            if (doctors.size()==0) {
                infor=infor+"null\n";
                for (int j =0;j<doctors.size();j++) {
                    Doctor doctor=doctors.get(j);
                    infor = infor +doctor.getName()+"\n";
                }
            }


        }else {
            infor = infor+"Bed label: "+"null"+"\n"+"Has a doctor: ";
            if (doctors.size()==0) {
                infor=infor+"null\n";
            }else {
                for (int j =0;j<doctors.size();j++) {
                    Doctor doctor=doctors.get(j);
                    infor = infor +doctor.getName()+"\n";
                }

            }



        }
        return infor;
    }





    public static void main(String[] args) {
        //test constructor
        int numErrors = 0;
        Patient p = new Patient("wang", 123456);
        if (p.getHealthNumber() !=123456 )
        {
            System.out.println("The constructor failed");
            numErrors++;
        }
        //test getBedLabel
        p.assign_to_bed("112");
        if (p.get_bed_label() != "112")
        {
            System.out.println("get_bed_label failed");
            numErrors++;
        }
        //test getBedLabel
        p.remove_label();
        if (p.get_bed_label()!= null)
        {
            System.out.println("remove_label failed");
            numErrors++;
        }
        //test assignADoctor
        Doctor d1 = new Doctor("Chen");
        p.assign_a_doctor(d1);
        String s1 = p.toString();
        String expect1 = "\nName: "+"wang"+"\nHealth number: "+"123456"+"\n"+"Bed label: "+"null"+"\n"+
                "Has a doctor: "+"Chen"+"\n";

        if (!s1.equals(expect1))
        {
            System.out.println("assign_a_doctor failed ");
            numErrors++;
        }
        //test remove doctor
        Doctor d2 = new Doctor("li");
        p.assign_a_doctor(d2);
        p.remove_doctor(d2);
        String s2 = p.toString();
        String expect2 = "\nName: "+"wang"+"\nHealth number: "+"123456"+"\n"+"Bed label: "+"null"+"\n"+
                "Has a doctor: "+"Chen"+"\n";
        if (!s2.equals(expect2))
        {
            System.out.println("assign_a_doctor failed ");
            numErrors++;
        }
        // test to string
        String expect3 = "\nName: "+"wang"+"\nHealth number: "+"123456"+"\n"+"Bed label: "+"null"+"\n"+
                "Has a doctor: "+"Chen"+"\n";
        if (!s2.equals(expect3))
        {
            System.out.println("to string failed ");
            numErrors++;
        }
        System.out.println("The number of errors found is " + numErrors);

    }
}
