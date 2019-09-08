//Name: Chen Wang NSID: chw989
//student id: 11210314


package a3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropDoctorPatient extends JFrame{
    public DropDoctorPatient(){
        setTitle("DropAssociation");
        getContentPane().setLayout(null);
        setSize(1280, 800);
        setVisible(true);

        JLabel label = new JLabel("Doctor and Patients Status");
        label.setBounds(390,80,850,70);
        label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 50));
        getContentPane().add(label);

        JLabel label1 = new JLabel("Doctor List");
        label1.setBounds(200,306,350,50);
        label1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
        getContentPane().add(label1);

        JLabel label3 = new JLabel("Doctor Name: ");
        label3.setBounds(200,379,250,40);
        label3.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label3);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(423,379,373,40);
        comboBox.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(comboBox);

        JLabel label2 = new JLabel("Patient Information" );
        label2.setBounds(200,452,350,50);
        label2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
        getContentPane().add(label2);

        JLabel label4 = new JLabel("Health Number: ");
        label4.setBounds(200,513,250,40);
        label4.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label4);

        JTextField field_Num = new JTextField();
        for (String i : Control.doctors.keySet()) {
            Doctor doctor = Control.doctors.get(i);
            comboBox.addItem(doctor.getName());
        }
        field_Num.setBounds(434, 513, 250, 40);
        field_Num.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(field_Num);

        JButton button = new JButton("Drop");
        class dropListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event) {
                String doctorType = (String) comboBox.getSelectedItem();
                int healthNum = Integer.parseInt(field_Num.getText());
                Control.drop_association(doctorType,healthNum)     ;


                StringBuilder stringBuilder = new StringBuilder("Patients Information\n");
                stringBuilder.append(healthNum + " " + "\n");
                stringBuilder.append(System.getProperty("line.separator"));

                field_Num.setText("");

                System.out.println(stringBuilder);

                setVisible(false);
                dispose();
            }
        }
        button.addActionListener(new dropListener());
        button.setBounds(450, 650,150, 50);
        button.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(button);

        JButton button1 = new JButton("Cancel");
        class cancelListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }
        button1.addActionListener(new cancelListener());
        button1.setBounds(760, 650,150, 50);
        button1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(button1);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        revalidate();
        repaint();
    }
    public static void main (String[] args){
        DropDoctorPatient dropDoctorPatient = new DropDoctorPatient();
        dropDoctorPatient.setVisible(true);
    }
}
