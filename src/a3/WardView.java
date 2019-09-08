//Name: Chen Wang NSID: chw989
//student id: 11210314


package a3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WardView extends JFrame {
    private JTextField textField_min;
    private JTextField textField_max;
    public WardView(){
        setTitle("WardView");
        getContentPane().setLayout(null);
        setSize(1280, 800);
        setVisible(true);

        JLabel lblNewLabel = new JLabel("Min of beds");
        lblNewLabel.setBounds(208, 551, 218, 40);
        lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));

        getContentPane().add(lblNewLabel);

        JLabel lblMax = new JLabel("Max of beds");
        lblMax.setBounds(208, 602, 218, 40);
        lblMax.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));

        getContentPane().add(lblMax);

        textField_min = new JTextField();
        textField_min.setBounds(494, 553, 193, 36);

        getContentPane().add(textField_min);
        textField_min.setColumns(10);

        textField_max = new JTextField();
        textField_max.setBounds(494, 598, 193, 36);

        getContentPane().add(textField_max);
        textField_max.setColumns(10);
        JLabel label = new JLabel("WardView Information");
        label.setBounds(530,90,550,50);
        label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
        getContentPane().add(label);

        JLabel label1 = new JLabel("Create Ward");
        label1.setBounds(210,205,420,50);
        label1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
        getContentPane().add(label1);

        JLabel label2 = new JLabel("New Ward Name: ");
        label2.setBounds(210,270,380,50);
        label2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label2);

        JTextField field_Name = new JTextField();
        field_Name.setBounds(904, 275, 150, 40);
        field_Name.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(field_Name);

        JLabel label8 = new JLabel("Set Numbers of General Care Beds: ");
        label8.setBounds(210,340,500,50);
        label8.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label8);

        JTextField field_Num1 = new JTextField();
        field_Num1.setBounds(904, 345, 200, 40);
        field_Num1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(field_Num1);

        JLabel label10 = new JLabel("Set Numbers of Burn Recovery Beds: ");
        label10.setBounds(210,410,663,50);
        label10.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label10);

        JTextField field_Num2 = new JTextField();
        field_Num2.setBounds(904, 415, 200, 40);
        field_Num2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(field_Num2);

        JLabel label9 = new JLabel("Set Numbers of Surgical Recovery Beds: ");
        label9.setBounds(210,480,684,50);
        label9.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(label9);

        JTextField field_Num3 = new JTextField();
        field_Num3.setBounds(904, 485, 200, 40);
        field_Num3.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
        getContentPane().add(field_Num3);

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int min=Integer.parseInt(textField_min.getText());
                int max=Integer.parseInt(textField_max.getText());
                int num1=Integer.parseInt(field_Num1.getText());
                int num2=Integer.parseInt(field_Num2.getText());
                int num3=Integer.parseInt(field_Num3.getText());

                Control.add_a_ward(field_Name.getText(), min, max, num1, num2, num3);
                Messages.main(null);

                dispose();

            }
        });
        btnOk.setBounds(410, 650,180, 50);
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
        button1.setBounds(741, 650,169, 50);
        button1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(button1);


        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public class main extends JFrame{
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        public main(){

        }
    }
    public static void main (String[] args){
        WardView WardView = new WardView();
        WardView.setVisible(true);
    }
}
