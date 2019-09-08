//Name: Chen Wang NSID: chw989
//student id: 11210314


package a3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class theMenu extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    theMenu frame = new theMenu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public theMenu() {

        setTitle("Hospital System");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 200, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButtonW = new JButton("Change Ward");
        btnNewButtonW.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnNewButtonW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                new WardView().setVisible(true);


            }
        });
        btnNewButtonW.setBounds(36, 66, 174, 128);
        contentPane.add(btnNewButtonW);

        JButton btnNewButton = new JButton("Add patient");
        btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                new AddPatientView().setVisible(true);

            }
        });
        btnNewButton.setBounds(221, 103, 174, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Quit");
        btnNewButton_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Quit().setVisible(true);



            }
        });
        btnNewButton_1.setBounds(221, 63, 174, 29);
        contentPane.add(btnNewButton_1);


        JButton btnNewButton_2 = new JButton("Add a New Doctor");
        btnNewButton_2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));

        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new addDoctor().setVisible(true);


            }
        });
        btnNewButton_2.setBounds(221, 137, 174, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Assign Doctors");
        btnNewButton_3.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));

        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new AssignDoctors().setVisible(true);
            }
        });
        btnNewButton_3.setBounds(221, 171, 174, 23);
        contentPane.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Display Empty Beds");
        btnNewButton_4.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));

        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new DisplayEmptyBeds().setVisible(true);
            }
        });
        btnNewButton_4.setBounds(221, 205, 174, 23);
        contentPane.add(btnNewButton_4);

        JButton btnAssignPatientTo = new JButton("Assign Patient to Bed");
        btnAssignPatientTo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnAssignPatientTo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new AssignPatientsToBed().setVisible(true);
            }
        });
        btnAssignPatientTo.setBounds(221, 239, 174, 23);
        contentPane.add(btnAssignPatientTo);

        JButton btnReleaseAPatient = new JButton("Release a Patient");
        btnReleaseAPatient.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnReleaseAPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new ReleasePatient().setVisible(true);
            }
        });
        btnReleaseAPatient.setBounds(221, 273, 174, 23);
        contentPane.add(btnReleaseAPatient);

        JButton btnDropDoctorpatientAssociation = new JButton("Drop Doctor-Patient Association");
        btnDropDoctorpatientAssociation.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnDropDoctorpatientAssociation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new DropDoctorPatient().setVisible(true);
            }
        });
        btnDropDoctorpatientAssociation.setBounds(198, 307, 227, 23);
        contentPane.add(btnDropDoctorpatientAssociation);
    }
}
