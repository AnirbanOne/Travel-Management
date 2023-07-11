package travelmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JButton create;
    JButton back;
    JTextField lbltextfield, tfname, tfpassword, tfanswer;
    JLabel lblusername, lblname, lblpassword, lblsecurity, lblanswer;
    Choice security;

    Signup(){
//        SETTING UP THE FRAME:
        setBounds(350, 200, 900, 360); //setBounds is the combination of setSize and setLocation
        getContentPane().setBackground(Color.WHITE); //Gets the frame
        setLayout(null);

//        SETTING UP THE PANEL (LEFT)
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

//        LABEL AND TEXT FIELD
         lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);

         lbltextfield = new JTextField();
        lbltextfield.setBounds(190, 20, 180, 25);
        lbltextfield.setBorder(BorderFactory.createEmptyBorder());
        p1.add(lbltextfield);

         lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);

         tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

         lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);

         tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

         lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsecurity.setBounds(50,140,125,25);
        p1.add(lblsecurity);

         security = new Choice();
        security.add("Favorite Color?");
        security.add("Favorite Ice Cream Flavour?");
        security.add("Favorite Character?");
        security.add("Your Lucky Number?");
        security.add("Your Favorite Animal?");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);

         lblanswer = new JLabel("Answer: ");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setBounds(50,180,125,25);
        p1.add(lblanswer);

         tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

//        LEFT PANEL BUTTON
        create  = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,93,233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80, 250, 100, 30);
        create.addActionListener(this);
        p1.add(create);

        back  = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,93,233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(250, 250, 100, 30);
        back.addActionListener(this);
        p1.add(back);
//  LEFT PANEL END

//        RIGHT PANEL START

//        IMAGE RIGHT PANEL
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travelmanagement/system/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);
//        RIGHT PANEL END


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create){
            String username = lbltextfield.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();

            String query = "INSERT INTO account VALUES('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try {
                 Conn c = new Conn();
                //Step 4: Establishing an connection
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created: Successful"); //Generates a popup!
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
}
