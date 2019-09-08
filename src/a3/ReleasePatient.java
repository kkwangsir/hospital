//Name: Chen Wang NSID: chw989
//student id: 11210314

package a3;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ReleasePatient extends JFrame{
    public ReleasePatient() {
        this.setTitle("Remove Patient");

        setSize(700, 500);
        getContentPane().setLayout(null);
        setVisible(true);


        JLabel title = new JLabel("Remove Patient");
        title.setBounds(200, 42, 300, 50);
        title.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(title);


        JLabel hN = new JLabel("Select a Patient's health number:");
        hN.setBounds(62, 101, 221, 50);
        hN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
        getContentPane().add(hN);

        final JComboBox comboBox = new JComboBox();
        for (Integer i : Control.patients.keySet()) {
            comboBox.addItem(i);}
        comboBox.setEditable(true);
        comboBox.setBounds(300, 110, 200, 30);
        getContentPane().add(comboBox);

        class ClickerListener implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                int healthID=Integer.parseInt(comboBox.getSelectedItem().toString());
                Control.releasePatient(healthID);
                System.out.println("released");
                dispose();
            }
        }
        ActionListener listener = new ClickerListener();

        JButton b1 = new JButton("Release");
        b1.setBounds(106, 156, 107, 40);
        b1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
        b1.addActionListener(listener);
        getContentPane().add(b1);

        JButton b2 = new JButton("Cancel");
        class CListener implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        }
        b2.setBounds(353, 156, 99, 40);
        b2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
        b2.addActionListener(new CListener());
        getContentPane().add(b2);
    }
    public static void main(String[] args) {

        ReleasePatient frame = new ReleasePatient();
        frame.setVisible(true);
    }

}
