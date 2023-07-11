package travelmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Payment extends JFrame implements ActionListener {
    JButton pay, back;

    Payment() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(300, 100, 850, 650);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travelmanagement/system/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(850, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 650);
        add(image);

        pay = new JButton("Pay");
        pay.setForeground(Color.white);
        pay.setBackground(Color.black);
        pay.setBounds(100, 30, 100, 30);
        pay.addActionListener(this);
        image.add(pay);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(600, 30, 100, 30);
        back.addActionListener(this);
        image.add(back);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Payment();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        } else if (ae.getSource() == pay) {
            openPaytmPaymentPortal();
        }
    }

    private void openPaytmPaymentPortal() {
        try {
            Desktop.getDesktop().browse(new URI("https://paytm.com/rent-payment"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
