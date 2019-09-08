//Name: Chen Wang NSID: chw989
//student id: 11210314
package a3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class toDisplay extends JFrame {
    public toDisplay(){
        setTitle("Display all the Empty Beds");
        getContentPane().setLayout(null);
        setSize(1280,800);
        setVisible(true);

        JLabel label = new JLabel("Empty Beds: ");
        label.setBounds(440,90,650,60);
        label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 50));
        getContentPane().add(label);

        JButton button = new JButton("EXIT");
        class cancelListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }
        button.addActionListener(new cancelListener());
        button.setBounds(549, 654,100, 50);
        button.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        getContentPane().add(button);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        revalidate();
        repaint();
    }
    public static void main (String[] args) {
        toDisplay display = new toDisplay();
        display.setVisible(true);
    }
}
