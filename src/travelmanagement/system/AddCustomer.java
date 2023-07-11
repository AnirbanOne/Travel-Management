package travelmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelusername, labelname;
    Choice security;
    JComboBox combo;
    JTextField tfnumber, tfcountry, tfaddress, email, phonenumber;
    JRadioButton radio, radiofemale;
    JButton add , back;

    AddCustomer(String user){
//        this.user = user;
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

         labelusername = new JLabel("Username");
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        combo = new JComboBox(new String[] {"Aadhar card", "License", "Voter ID", "PAN Card", "Passport", "Ration Card"});
        combo.setBounds(220, 90, 150, 25);
        add(combo);

        JLabel lblnumber = new JLabel("Value");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JLabel("Username");
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        radio = new JRadioButton("Male");
        radio.setBounds(220, 210, 70, 25);
        radio.setBackground(Color.WHITE);
        add(radio);

        radiofemale = new JRadioButton("Female");
        radiofemale.setBounds(300, 210, 70, 25);
        radiofemale.setBackground(Color.WHITE);
        add(radiofemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radio);
        bg.add(radiofemale);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdess = new JLabel("Address");
        lbladdess.setBounds(30, 290, 150, 25);
        add(lbladdess);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 330, 150, 25);
        add(lblemail);

        email = new JTextField();
        email.setBounds(220, 330, 150, 25);
        add(email);

        JLabel lblphonenum = new JLabel("Phone Number");
        lblphonenum.setBounds(30, 370, 150, 25);
        add(lblphonenum);

        phonenumber = new JTextField();
        phonenumber.setBounds(220, 370, 150, 25);
        add(phonenumber);

        add = new JButton("Add");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travelmanagement/system/icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        try {
            Conn c = new Conn();
           ResultSet rs =  c.s.executeQuery("select * from account where username = '"+user+"'");
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               labelname.setText(rs.getString("name"));
           }
        } catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String username = labelusername.getText();
            String id = (String) combo.getSelectedItem();
            String num = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;

            if (radio.isSelected()){
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String ph = phonenumber.getText();
            String mail = email.getText();

            try {
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"', '"+id+"', '"+num+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+ph+"', '"+mail+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer added successfully");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
//            new Dashboard(user);
        }
    }
    public static void main(String[] args) {
        new AddCustomer("");
    }
}
