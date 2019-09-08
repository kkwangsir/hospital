/**
 * @author
 * NSID: chw989
 * Chen Wang
 * id: 11210314
 */

package a3;

import java.util.LinkedList;

public class Ward
{
    /**
     * The name of this ward.
     */
    private String name;

    /**
     * The (external) label of the first bed
     */
    private int minBedLabel;

    /**
     * An LinkedLinst to represent the beds of the ward.  Each bed is empty (null)
     * or a Person in it.
     */
    private static LinkedList<Bed>beds;

    /**
     * Initialize the ward with the name given, and with beds those labels are
     * the consecutive integers from minBedLabel to maxBedLabel.
     *
     * @param wName the name of the ward
     * @param wMinBedLabel the label of the ward's first bed
     * @param wMaxBedLabel the label of the ward's last bed
     */
    public Ward(String wName, int wMinBedLabel, int wMaxBedLabel,int general,int burn,int surgical)
    {
        if (wName == null || wName.equals(""))
            throw new RuntimeException("The name of a ward cannot be null or empty.  "
                    + "It is " + wName);
        if (wMinBedLabel < 0 || wMaxBedLabel < wMinBedLabel)
            throw new RuntimeException("The bed labels " + wMinBedLabel + " and " + wMaxBedLabel
                    + " are invalid as they cannot be negative and must have at least one bed.");

        name = wName;
        minBedLabel = wMinBedLabel;
        int Ngeneral=general;
        int Nburn=burn;
        int Nsurgical=surgical;
        beds = new LinkedList<Bed>();
        for(int i=0;i<=wMaxBedLabel-wMinBedLabel;i++) {
            if(Ngeneral!=0) {
                Bed bed1=new Bed(this.name, "general", null, String.valueOf(wMinBedLabel+i));
                beds.add(bed1);
                Ngeneral--;
            }
            else if(Nburn!=0) {
                Bed bed1=new Bed(this.name, "burn", null, String.valueOf(wMinBedLabel+i));
                beds.add(bed1);
                Nburn--;
            }

            else if(Nsurgical!=0) {
                Bed bed1=new Bed(this.name, "surgical", null, String.valueOf(wMinBedLabel+i));
                beds.add(bed1);
                Nsurgical--;

            }
        }
    }

    /**
     * Return the name of this ward.
     *
     * @return the name of this ward
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the min label for a bed
     * @return the min label
     */
    public int getMinBedLabel()
    {
        return minBedLabel;
    }

    /**
     * Return the largest label for a bed
     *
     * @return the max  label
     */
    public int getMaxBedLabel()
    {
        return internalToExternalLabel(beds.size());
    }

    /**
     * Is bedLabel a valid external label for a bed?
     *
     * @param bedLabel we input
     * @return whether or not the provided label is within the range of possible labels
     */
    public boolean isValidLabel(int bedLabel)
    {
        return bedLabel >= minBedLabel && bedLabel <= minBedLabel + beds.size() - 1;
    }

    /**
     * convert label to list index
     *
     * @param bedLabel a bed label
     * @return the index in the bed array
     */
    private int externalToInternalIndex(int bedLabel)
    {
        return bedLabel - minBedLabel;
    }

    /**
     * convert list index to label
     *
     * @param arrayIndex an index
     * @return the bed label
     */
    private int internalToExternalLabel(int arrayIndex)
    {
        return arrayIndex + minBedLabel;
    }

    /**
     * check is the specified bed occupied?
     *
     * @param bedLabel a bed label
     * @return whether or not the bed is occupied by a patient
     */
    public boolean isOccupied(int bedLabel)
    {
        return beds.get(externalToInternalIndex(bedLabel)) != null;
    }

    /**
     * Assign the specified person to the specified bed.
     *
     * @param p the person to assign to a bed
     * @param bedLabel a bed label
     */
    public void assignPatientToBed(Patient p, int bedLabel)
    {
        String str="";
        int index=externalToInternalIndex(bedLabel);
        str=str+index;
        beds.get(index).assign_Patient_tobed(p);
    }

    /**
     * Return the person in the specified bed.
     *
     * @param bedLabel a bed label
     * @return the person that is assigned to the bed
     */
    public Patient getPatient(int bedLabel)
    {
        return beds.get(externalToInternalIndex(bedLabel)).get_patient();
    }
    /**
     * check he beds if or not have vacancy
     * @param purpose
     * @return a boolean value
     */
    public boolean checkWithPurpose(String purpose) {
        int count=0;
        int count_empty=0;
        int temp=1;
        for (Bed i:beds) {
            if (i.get_purposes().equals(purpose)) {
                count++;
                if(!i.isEmpty()) {
                    count_empty++;
                }
            }

        }
        try {
            temp=count/(count-count_empty);
        }catch(ArithmeticException e) {
            System.out.println("No empty of this purpose bed "+e);
        }
        try {
            temp=count/count;
        }catch(ArithmeticException e) {
            System.out.println("No empty of this purpose bed "+e);
        }
        return !(count==0||count-count_empty==0);
    }


    /**
     * find the empty bed  by the bed purpose and return a string
     * @param type the bed purpose
     * @return a string contain the bed purpose
     */
    public String find_empty(String type) {
        String result="";
        int index=-1;
        for (Bed i:beds) {
            index++;

            if(i.isEmpty()) {

                if(i.get_purposes().equals(type)) {
                    result=result+internalToExternalLabel(index)+" is empty. purpose: "+i.get_purposes()+"\n";
                }
                else if(!(type.equals("general")||type.equals("burn")||type.equals("surgical"))) {
                    result="invalid";

                }
            }
        }
        return result;
    }
    /**
     * remove the bed label
     * @param bedLabel the linked list bed
     */
    public void remove(int bedLabel) {
        beds.get(externalToInternalIndex(bedLabel)).remove_patient();;

    }

    /**
     * print information
     *
     * @return a String representation of the ward
     */
    public String toString()

    {

        String result = "\nWard " + name + " with capacity " + beds.size()
                + " has the following patients: ";
        for (int i = 0; i < beds.size(); i++)
        {
            result = result +"\nbed " + internalToExternalLabel(i) + " "+beds.get(i).get_purposes()+": ";
            if (beds.get(i).get_patient()!=null)
                result= result+beds.get(i).get_patient().getName();
            else {result= result+"null";

            }


        }
        return result + "\n";
    }
    public int get_bed_label(int pNumber) {
        int i = -1;
        for (int temp=0;temp<beds.size();temp++) {
            if(beds.get(temp).get_patient()!=null) {
                if (beds.get(temp).get_patient().getHealthNumber()==pNumber)
                    i=Integer.valueOf(beds.get(temp).get_patient().get_bed_label());

            }
//			if (
//					beds.get(temp).get_patient().getHealthNumber()==pNumber
//					) {
//				i=Integer.valueOf(beds.get(t).get_patient().get_bed_label());
//			}
        }
        return i;
    }


    /**
     * A method to test the class.
     */
    public static void main(String[] args)
    {	int numErrors = 0;
        // test getName

        Ward w = new Ward("surgery", 200, 210, 3, 3, 4);
        Patient	p = new Patient("Ting", 654321);
        if (w.getName()!="surgery" )
        {
            System.out.println("The getName failed");
            numErrors++;
        }
        // test get_MinBedLabel

        if (w.getMinBedLabel()!=200)
        {
            System.out.println("The get_MinBedLabel failed");
            numErrors++;
        }
        // test get_MaxBedLabel

        if (w.getMaxBedLabel()!=210)
        {
            System.out.println("The get_MaxBedLabel failed");
            numErrors++;
        }
        // test isValidLabel

        if (w.isValidLabel(200)!=true)
        {
            System.out.println("The isValidLabel failed");
            numErrors++;
        }
        //test externalToInternalIndex
        if (w.externalToInternalIndex(201)!=1)
        {
            System.out.println("The externalToInternalIndex failed");
            numErrors++;
        }
        //test internalToExternalLabel
        if (w.internalToExternalLabel(1)!=201)
        {
            System.out.println("The internalToExternalLabel failed");
            numErrors++;
        }
        //test assignPatientToBed
        w.assignPatientToBed(p, 201);
        if (w.isOccupied(201)!=true)
        {
            System.out.println("The assignPatientToBed failed");
            numErrors++;
        }
        //test isOccupied
        if (w.isOccupied(201)!=true)
        {
            System.out.println("The assignPatientToBed failed");
            numErrors++;
        }
        // test get_patient
        if (w.getPatient(201)!=p)
        {
            System.out.println("The get_patient failed");
            numErrors++;
        }
        // test checkWithPurpose
        if (w.checkWithPurpose("burn")!= true)
        {
            System.out.println("The checkWithPurpose failed");
            numErrors++;
        }
        // test find empty
        String s1 = w.find_empty("burn");
        String expect1= "203 is empty. purpose: burn\n204 is empty. purpose: burn\n205 is empty. purpose: burn\n";
        if (!s1.equals(expect1))
        {
            System.out.println("to string failed");
            numErrors++;
        }
        // test get bed label
        if (w.get_bed_label(654321)!= 201)
        {
            System.out.println("The get bed label failed");
            numErrors++;
        }
        // test remove
        w.remove(201);
        if(w.getPatient(201)!=null) {
            System.out.println("The remove failed");
            numErrors++;
        }
        // test to string
        String s2 = w.toString();
        String expect2= "\nWard " + "surgery" + " with capacity " + "10"
                + " has the following patients: " +
                "bed 200 general: null\r\n" +
                "bed 201 general: null\r\n" +
                "bed 202 general: null\r\n" +
                "bed 203 burn: null\r\n" +
                "bed 204 burn: null\r\n" +
                "bed 205 burn: null\r\n" +
                "bed 206 surgical: null\r\n" +
                "bed 207 surgical: null\r\n" +
                "bed 208 surgical: null\r\n" +
                "bed 209 surgical: null\r\n"+"\n";

        if (s2.equals(expect2))
        {
            System.out.println("to string failed");
            numErrors++;
        }

        System.out.println("The number of errors found is " + numErrors);

    }
}
