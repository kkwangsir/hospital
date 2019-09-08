package a3;//Name: Chen Wang NSID: chw989
//student id: 11210314


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Messages extends JFrame {
    public Messages() {
        setTitle("Message");
        setLayout(null);
        setSize(800, 500);
        setVisible(true);

        JLabel label = new JLabel("Success");
        label.setBounds(300, 50, 500, 60);
        label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 50));
        add(label);

        JButton button = new JButton("GO TO MENU");
        class yesListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        }
        button.addActionListener(new yesListener());
        button.setBounds(210, 200, 400, 60);
        button.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
        add(button);


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        Messages messages = new Messages();
        messages.setVisible(true);
    }
}
