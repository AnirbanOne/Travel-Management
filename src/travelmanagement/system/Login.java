package travelmanagement.system;

import javax.swing.*;
import javax.swing.border.LineBorder; //In java the packages got imported while using the * but not the subpackages!
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton signup, password, login;
    JLabel lblusername, lblpassword, text;
    JTextField tfusername, tfpassword;
    Login(){
        setSize(850, 400);
        setLocation(350, 200);
        setLayout(null);

//        Setting up the oerall bg of the frame different colour
        getContentPane().setBackground(Color.WHITE);

//        LEFT PANEL
        JPanel pl = new JPanel();
        pl.setBackground(new Color(131, 193, 233));
        pl.setBounds(0, 0, 400, 400);
        pl.setLayout(null);
        add(pl);

//        Setting up Icon On the Panel (Left) using the label
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travelmanagement/system/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        pl.add(image);
//        LEFT PANEL END


//        RIGHT PANEL
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

//        Input Fields START
        lblusername = new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblusername);

         tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30 );
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

         lblpassword = new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);

         tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30 );
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

//Button START
         login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193,233)));
        login.addActionListener(this);
        p2.add(login);

         signup = new JButton("SignUp");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193,233)));
        signup.addActionListener(this);
        p2.add(signup);

         password = new JButton("Password");
        password.setBounds(130, 250, 130, 30);
        password.setBackground(new Color(133, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133, 193,233)));
        password.addActionListener(this);
        p2.add(password);

         text = new JLabel("Trouble Signing In?");
        text.setBounds(300, 250, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);
//        RIGHT PANEL END



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == login){
            try{
                 String user = tfusername.getText();
                 String pass = tfpassword.getText();

                 String query = "select * from account where username = '"+user+"' AND password = '"+pass+"'";
                 Conn c = new Conn();
                 ResultSet rs = c.s.executeQuery(query);

                 if (rs.next()){
                     setVisible(false);
                     new Loading(user);
                 }else {
                     JOptionPane.showMessageDialog(null, "Incorrect username password");
                 }
            } catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == signup){
            setVisible(false);
            new Signup();
        } else {
            setVisible(false);
            new Forgetpassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
