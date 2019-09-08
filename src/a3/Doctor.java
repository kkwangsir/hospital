/**
 * @author
 * NSID: chw989
 * Chen Wang
 * id: 11210314
 */

package a3;

import java.util.LinkedList;

public class Doctor extends Person implements BasicDoctor{
    /**
     * the constructor inherit from Person so use super to inherit
     * and add a patients linked list to it
     * @param pName - patient name
     */
    public Doctor(String pName) {
        super(pName);
        patients=new LinkedList<Patient>();
        // TODO Auto-generated constructor stub
    }
    // a patients linked list
    private LinkedList<Patient> patients;




    @Override
    /**
     * override the remove_patient
     * create a int health number get form p.getHealthNumber
     * iterate he linked list find the patient we input and remove it
     * @param p - is a patient
     */
    public void remove_patient(Patient p) {
        int health_number=p.getHealthNumber();
        for(int i = 0; i < patients.size(); i++) {
            Patient p1 = patients.get(i);
            int a_number = p1.getHealthNumber();
            if (health_number == a_number)
            {
                patients.remove(i);
            }

        }
    }


    /**
     * override assign_patient
     * add patient to linked list
     * @param p - is a patient
     */
    @Override
    public void assign_patient(Patient p) {
        patients.add(p);

    }


    /**
     * Override to string print out the information
     */
    @Override
    public String toString() {
        String infor;
        infor="Doctor's name is: "+this.getName();
        for (int i = 0; i < patients.size(); i++)
        {
            Person p = patients.get(i);
            infor = infor + "\n*** patient ***\nName: " + p.getName() + "\nHealth number: " + p.getHealthNumber();
        }

        // TODO Auto-generated method stub
        return infor;
    }
    //to test
    public static void main(String[] args) 	{
        //test assign_patient
        int numErrors = 0;

        Doctor d1=new Doctor("ww");
        Patient p1=new Patient("wang",123);
        d1.assign_patient(p1);
        String s1 = d1.toString();
        String expect1= "Doctor's name is: "+"ww"+"\n*** patient ***\nName: "+"wang"+"\nHealth number: "+"123";
        if (!s1.equals(expect1))
        {
            System.out.println("The constructor or assignAPatient failed");
            numErrors++;
        }
        // test to string
        String s2 = d1.toString();
        String expect2= "Doctor's name is: "+"ww"+"\n*** patient ***\nName: "+"wang"+"\nHealth number: "+"123";
        if (!s1.equals(expect2))
        {
            System.out.println("to string failed");
            numErrors++;
        }
        //test remove patient
        Patient p2=new Patient("liu",111);
        d1.assign_patient(p2);
        d1.remove_patient(p2);
        if (!s1.equals(expect1))
        {
            System.out.println(" remove_patient failed");
            numErrors++;
        }
        System.out.println("The number of errors found is " + numErrors);

    }

}


