/**
 * @author
 * NSID: chw989
 * Chen Wang
 * id: 11210314
 */

package a3;

public class Surgeon extends Doctor {
    /**
     * constructor inherit from doctor
     * @param pName doctor name
     */
    public Surgeon(String pName) {
        super(pName);

        // TODO Auto-generated constructor stub
    }
    /**
     * print information
     */
    public String toString() {
        String infor;
        infor="Surgeon Doctor: "+this.getName()+"\n";

        // TODO Auto-generated method stub
        return infor;
    }

    public static void main(String[] args) {

        int numErrors = 0;
        //test constructor
        Surgeon s =new Surgeon("big");
        if (s.getName() !="big" )
        {
            System.out.println("The constructor failed");
            numErrors++;
        }
        // test to string
        String s1 = s.toString();
        String expect1= "Surgeon Doctor: "+"big\n";
        if (!s1.equals(expect1))
        {
            System.out.println("The to string failed");
            numErrors++;
        }
        System.out.println("The number of errors found is " + numErrors);

    }

}
