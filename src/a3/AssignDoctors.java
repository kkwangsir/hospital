package a3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignDoctors extends JFrame {
    public AssignDoctors(){
        setTitle("Assign Doctors to Patients");
        getContentPane().setLayout(null);
        setSize(1440, 900);
        setVisible(true);

        JLabel lblAssignDoctorsTo = new JLabel("Assign Doctors to Patient");
        lblAssignDoctorsTo.setBounds(394,-12,808,250);
        lblAssignDoctorsTo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 50));
        getContentPane().add(lblAssignDoctorsTo);

        JLabel label6 = new JLabel("Patient's Health Number: ");
        label6.setBounds(252,102,443,250);
        label6.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label6);

        JTextField field_Num = new JTextField();
        field_Num.setBounds(820, 207, 409, 40);
        field_Num.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(field_Num);

        JLabel label4 = new JLabel("Doctor Name: ");
        label4.setBounds(252,249,409,250);
        label4.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label4);

        JComboBox comboBox = new JComboBox();
        for (String i : Control.doctors.keySet()) {
//            Doctor doctor = Control.doctors.get(i);
            comboBox.addItem(i);
        }
        comboBox.setBounds(820,353,409,40);
        comboBox.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(comboBox);

        JButton button = new JButton("submit");
        class assignListener implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                String Doctor_name = (String) comboBox.getSelectedItem();
                String healthNum = field_Num.getText();
//                Object o_doctorName = comboBox.getSelectedItem();
                int health_num = Integer.valueOf(healthNum).intValue();
                Control.assign_doctor_to_patient(Doctor_name,health_num);

                try{
//                    o_doctorName = Doctor_name;
                    health_num =Integer.parseInt(field_Num.getText());


                    if(health_num > 0) {
                        healthNum = "Health Number is : " + health_num;
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "Need integer number!");
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,
                            "Need integer number!");
                }

                StringBuilder stringBuilder = new StringBuilder("Patients and Doctor\n");
                stringBuilder.append(Doctor_name + " " + "\n" + healthNum + " " + "\n");
                stringBuilder.append(System.getProperty("line.separator"));

                field_Num.setText("");

                System.out.println(stringBuilder);
//                setVisible(false);
                dispose();
                Messages.main(null);

            }
        }
        button.addActionListener(new assignListener());
        button.setBounds(490, 492,154, 50);
        button.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(button);

        JButton button1 = new JButton("Cancel");
        class cancelListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }
        button1.addActionListener(new cancelListener());
        button1.setBounds(829, 492,162, 50);
        button1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(button1);
        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main (String[] args){
        AssignDoctors assignDoctors = new AssignDoctors();
        assignDoctors.setVisible(true);
    }
}


