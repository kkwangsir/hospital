/**
 * @author
 * NSID: chw989
 * Chen Wang
 * id: 11210314
 */

package a3;

public class Bed {
    /**
     * purpose of the bed
     */
    private String purpose;
    /**
     * the bed label
     */
    private String bed_label;
    /**
     * the name of ward
     */
    private String ward_name;
    /**
     * the name of patient
     */
    private String patient_name;
    /**
     * the patient
     */
    private Patient the_patient_inbed;
    /**
     * the constructor to create a bed attribute
     * @param wardName  ward name
     * @param thePurpose recover purpose
     * @param new_patient the patient in the bed
     * @param bedLabel bed label
     */
    public Bed(String wardName, String thePurpose, Patient new_patient,String bedLabel){
        this.ward_name = wardName;
        this.purpose = thePurpose;
        this.the_patient_inbed = new_patient;
        this.bed_label =bedLabel;
    }
    /**
     * to get patient number
     * @return the patient number
     */
    public int get_patient_number() {
        return the_patient_inbed.getHealthNumber();
    }
    /**
     * to get patien name
     * @return the patient name
     */
    public String get_patient_name()
    {
        return this.patient_name;
    }
    /**
     * to get ward name
     * @return the ward name
     */
    public String get_ward_name(){
        return this.ward_name;
    }
//    public void set_purposes(String purposes){
//    	this.purpose=purposes;
//
//    }
    /**
     * to get purpose
     * @return the purpose which are general care , burn recovery , surgical recovery
     */
    public String get_purposes(){
        return this.purpose;
    }
    /**
     * to get the patient
     * @return the patient in the bed
     */
    public Patient get_patient(){
        return this.the_patient_inbed;
    }
    /**
     * to assign patient to bed if the bed is occupied, print warning
     * else assign patient to a_patient ,and assign
     * @param a_patient  the new patient should be assign to the bed
     */
    public void assign_Patient_tobed(Patient a_patient){
        if (the_patient_inbed!=null) {
            System.out.println("this bed is occupied!");
        }else {
            the_patient_inbed= a_patient;
            a_patient.assign_to_bed(bed_label);
            System.out.println("new patient is assigned");
        }
    }
    /**
     * check the bed if is empty
     * @return the boolean value, true is empty ,false is not.
     */
    public boolean isEmpty(){
        return this.the_patient_inbed == null;
    }
    /**
     * remove the patient in the bed
     */
    public void remove_patient(){
        this.the_patient_inbed.remove_label();
        this.the_patient_inbed=null;

    }



    public static void main(String[] args) {
        int numErrors = 0;
        // test get_patient_number

        Patient p = new Patient("laowang",123321);
        if (p.getHealthNumber() !=123321 )
        {
            System.out.println("The get_patient_number failed");
            numErrors++;
        }
        // test get_patient_name
        if (p.getName()!= "laowang")
        {
            System.out.println("The get_patient_name failed");
            numErrors++;
        }
        //		 test get_ward_name
        Bed bed1=new Bed("ward1", "general", p, "201");

        if (bed1.get_ward_name()!="ward1")
        {
            System.out.println("The get_ward_name failed");
            numErrors++;
        }

        //		 test get_purposes

        if (bed1.get_purposes()!="general")
        {
            System.out.println("The get_purposes failed");
            numErrors++;
        }

        //		 test get_patient

        if (bed1.get_patient()!=p)
        {
            System.out.println("The get_patient failed");
            numErrors++;
        }

        // test remove_patient
        bed1.remove_patient();

        Patient p2 = new Patient("rib",121121);
        bed1.assign_Patient_tobed(p2);
        if (bed1.get_patient()!=p2)
        {
            System.out.println("The remove_patient failed");
            numErrors++;
        }
        // test assign_Patient_tobed
        bed1.remove_patient();

        bed1.assign_Patient_tobed(p);
        if (bed1.get_patient()!=p)
        {
            System.out.println("The assign_Patient_tobed failed");
            numErrors++;
        }
        // test isEmpty
        if (!bed1.isEmpty()==false)
        {
            System.out.println("The isEmpty failed");
            numErrors++;
        }
        System.out.println("The number of errors found is " + numErrors);
    }
}