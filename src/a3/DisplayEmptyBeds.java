//Name: Chen Wang NSID: chw989
//student id: 11210314
package a3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayEmptyBeds extends JFrame{
    public DisplayEmptyBeds(){
        setTitle("Display Beds");
        getContentPane().setLayout(null);
        setSize(1280, 800);
        setVisible(true);

        JLabel label = new JLabel("Display Beds Status");
        label.setBounds(465,90,550,60);
        label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 50));
        getContentPane().add(label);

        JButton button = new JButton("Display");
        class displayListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                new toDisplay().setVisible(true);

            }
        }
        button.addActionListener(new displayListener());
        button.setBounds(500, 650,178, 50);
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
        button1.setBounds(810, 650,160, 50);
        button1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(button1);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        revalidate();
        repaint();
    }
    public static void main (String[] args){
        DisplayEmptyBeds displayEmptyBeds = new DisplayEmptyBeds();
        displayEmptyBeds.setVisible(true);
    }
}

