//Name: Chen Wang NSID: chw989
//student id: 11210314
package a3;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDoctor extends JFrame{
    public addDoctor(){
        setSize(1440, 900);
        setTitle("Add a New Doctor");
        getContentPane().setLayout(null);
        setVisible(true);

        JLabel label1 = new JLabel("Add Doctor" );
        label1.setBounds(440,0,550,250);
        label1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 50));
        getContentPane().add(label1);

        JLabel label2 = new JLabel("Doctor Name: ");
        label2.setBounds(350,250,200,60);
        label2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label2);

        JTextField Name_field = new JTextField();
        Name_field.setBounds(575, 263, 250, 40);
        Name_field.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(Name_field);

        JRadioButton radioButton = new JRadioButton("Doctor");
        JRadioButton radioButton1 = new JRadioButton("Surgeon");
        radioButton.setBounds(437, 352, 150, 50);
        radioButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 25));
        radioButton1.setBounds(660, 352, 150, 50);
        radioButton1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 25));
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton);
        group.add(radioButton1);
        getContentPane().add(radioButton);
        getContentPane().add(radioButton1);

        JButton btnOk = new JButton("OK");
        class saveListener implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                String name = "Doctor's Name : " + Name_field.getText();
                String selections = " ";
                if (radioButton.isSelected()) {
                    selections = radioButton.getText();
                    Control.add_doctor(name);
                    selections="Type: " + radioButton.getText();
                }
                else if (radioButton1.isSelected()) {
                    selections = radioButton1.getText();
                    Control.add_surgeon(name);
                    selections="Type: " + radioButton1.getText();
                }


                StringBuilder stringBuilder = new StringBuilder("About Doctors\n");
                stringBuilder.append(name + " " + "\n" + "\n" + selections + " ");
                stringBuilder.append(System.getProperty("line.separator"));

                Name_field.setText("");

                System.out.println(stringBuilder);

                dispose();
                Messages.main(null);

            }
        }
        btnOk.addActionListener(new saveListener());
        btnOk.setBounds(477, 427,110, 50);
        btnOk.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(btnOk);

        JButton button1 = new JButton("Cancel");
        class cancelListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }
        button1.addActionListener(new cancelListener());
        button1.setBounds(670, 427,126, 50);
        button1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(button1);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        revalidate();
        repaint();
    }
    public static void main (String[] args){
        addDoctor doctorInformation = new addDoctor();
        doctorInformation.setVisible(true);
    }
}



