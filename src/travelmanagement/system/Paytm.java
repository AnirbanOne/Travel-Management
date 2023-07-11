package travelmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {
    JButton back;

    Paytm() {
        setBounds(300, 100, 850, 650);

        // Create a JEditorPane to display the web page
        JEditorPane j = new JEditorPane();

        try {
            // Load the Paytm payment portal
            j.setPage("https://paytm.com/rent-payment");

            // Add the JEditorPane to a JScrollPane
            JScrollPane scrollPane = new JScrollPane(j);
            getContentPane().add(scrollPane);

            // Create a back button
            back = new JButton("Back");
            back.setForeground(Color.white);
            back.setBackground(Color.black);
            back.setBounds(600, 30, 100, 30);
            back.addActionListener(this);

            // Create a JPanel to hold the back button
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.white);
            buttonPanel.add(back);

            // Add the button panel to the JFrame
            getContentPane().add(buttonPanel, BorderLayout.NORTH);
        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load the Paytm payment portal.</html>");
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
