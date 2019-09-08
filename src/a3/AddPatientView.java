//Name: Chen Wang NSID: chw989
//student id: 11210314
package a3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class AddPatientView extends JFrame {

    public AddPatientView() {
        setTitle("Adding New Patient");
        getContentPane().setLayout(null);
        setSize(1280, 800);

        JLabel label1 = new JLabel("Information of Patient");
        label1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 25));

        label1.setBounds(500,0,394,200);
        getContentPane().add(label1);

        JLabel label2 = new JLabel("Type Patient Name: ");
        label2.setBounds(136,52,378,250);
        label2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 25));
        getContentPane().add(label2);

        JTextField p_name = new JTextField();
        p_name.setBounds(524, 136, 350, 50);
        p_name.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 25));
        getContentPane().add(p_name);

        JLabel label3 = new JLabel("Type Health Number: ");
        label3.setBounds(149,148,350,250);
        label3.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 25));
        getContentPane().add(label3);

        JTextField p_num = new JTextField();
        p_num.setBounds(524, 248, 350, 50);
        p_num.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(p_num);

        JButton button = new JButton("OK");
        StringBuilder stringBuilder = new StringBuilder("Information\n");
        class OKListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String name = "Patient's Name : " + p_name.getText();
                int health_num = Integer.parseInt(p_num.getText());

                String healthNum = "Patient's Health Number: " + health_num;
                stringBuilder.append(name + " " + "\n" + healthNum + " ");
                stringBuilder.append(System.getProperty("line.separator"));

                p_name.setText("");
                p_num.setText("");

                System.out.println(stringBuilder);
                dispose();
                Messages.main(null);
                Control.add_patient(health_num, name);
            }
        }
        button.addActionListener(new OKListener());


        button.setBounds(500, 500,137, 50);
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
        button1.setBounds(764, 500,146, 50);
        button1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(button1);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        revalidate();
        repaint();
    }


    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        AddPatientView frame = new AddPatientView();
        frame.setVisible(true);
    }

}
