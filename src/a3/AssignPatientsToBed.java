//Name: Chen Wang NSID: chw989
//student id: 11210314
package a3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignPatientsToBed extends JFrame {
    public AssignPatientsToBed(){
        setTitle("Assign Patients to the Beds");
        getContentPane().setLayout(null);
        setSize(1440, 900);
        setVisible(true);

        JLabel label = new JLabel("Assign Patients to the Beds");
        label.setBounds(420,80,650,60);
        label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 50));
        getContentPane().add(label);

        JLabel label1 = new JLabel("Patient Information");
        label1.setBounds(200,200,350,50);
        label1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
        getContentPane().add(label1);

        JLabel label3 = new JLabel("Health Number: ");
        label3.setBounds(200,260,250,40);
        label3.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label3);

        JTextField field_Num = new JTextField();
        field_Num.setBounds(420, 264, 200, 40);
        field_Num.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(field_Num);
        String s=Control.getMaxMin();
        JLabel label2 = new JLabel("Bed Information"+s );
        label2.setBounds(200,320,658,50);
        label2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
        getContentPane().add(label2);

        JLabel label4 = new JLabel("Bed label: ");
        label4.setBounds(200,380,250,40);
        label4.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label4);

        JTextField bed_label = new JTextField();
        bed_label.setBounds(420, 381, 200, 40);
        bed_label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(bed_label);
//        JComboBox comboBox = new JComboBox();
//        comboBox.setBounds(420,382,250,40);
//        for (String save : Control.doctors.keySet()) {
//            Doctor doctor = Control.doctors.get(save);
//            comboBox.addItem(doctor.getName());
//        }
//        comboBox.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
//        getContentPane().add(comboBox);

        JLabel label5 = new JLabel("Ward Information");
        label5.setBounds(200,440,350,50);
        label5.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
        getContentPane().add(label5);

        JLabel label6 = new JLabel("Ward Name: A_Ward");
        label6.setBounds(200,495,500,40);
        label6.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label6);

        JLabel label7 = new JLabel("Bed Purposes:");
        label7.setBounds(200,545,200,50);
        label7.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label7);

        JComboBox comboBox2 = new JComboBox();
        comboBox2.setBounds(420,553,250,40);
        comboBox2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        comboBox2.addItem("general");
        comboBox2.addItem("burn");
        comboBox2.addItem("surgical");
        getContentPane().add(comboBox2);

        JButton button = new JButton("Assign");

        class assignListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event) {

                String healthNum = field_Num.getText();
                int health_num = Integer.valueOf(healthNum).intValue();
                int bd_label = Integer.valueOf(bed_label.getText()).intValue();

                Control.assignPatientBed(health_num,bd_label,comboBox2.getSelectedItem().toString());

                try{
//                    p_name = "Doctor's Name : " + comboBox.getActionCommand();
                    health_num =Integer.parseInt(field_Num.getText());


                    if(health_num > 0) {
                        healthNum = "Patient's Health Number: " + health_num;
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "Please Enter Positive integer number!");
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,
                            "Please Enter Positive integer number!");
                }

                StringBuilder stringBuilder = new StringBuilder("Patients Information\n");
                stringBuilder.append(" " + "\n" + healthNum + " " + "\n");
                stringBuilder.append(System.getProperty("line.separator"));

                field_Num.setText("");

                System.out.println(stringBuilder);

                setVisible(false);
                dispose();
            }
        }

        button.addActionListener(new assignListener());
        button.setBounds(500, 650,100, 50);
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
        button1.setBounds(810, 650,100, 50);
        button1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(button1);
        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main (String[] args){
        AssignPatientsToBed assignPatientsToBed = new AssignPatientsToBed();
        assignPatientsToBed.setVisible(true);
    }
}
