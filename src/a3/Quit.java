//Name: Chen Wang NSID: chw989
//student id: 11210314
package a3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Quit extends JFrame{
    public Quit() {
        this.setTitle("Quit");

        setSize(500, 400);
        getContentPane().setLayout(null);
        getContentPane().setLocation(900,200);

        setVisible(true);
        JLabel title = new JLabel("Do you want to quit");
        title.setBounds(150, 100, 400, 50);
        title.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(title);

        JButton b1 = new JButton("Yes");
        class YBListener implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                Control.quit();
            }
        }
        b1.setBounds(131, 194, 75, 40);
        b1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
        b1.addActionListener(new YBListener());
        getContentPane().add(b1);

        JButton b2 = new JButton("No");
        class NListener implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                dispose();
                setVisible(false);
            }
        }
        b2.setBounds(306, 194, 75, 40);
        b2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
        b2.addActionListener(new NListener());
        getContentPane().add(b2);

    }
    public static void main(String[] args){
        Quit options = new Quit();
        options.setVisible(true);
    }
}
