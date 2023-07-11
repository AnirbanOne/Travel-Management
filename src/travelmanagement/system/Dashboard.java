package travelmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class Dashboard extends JFrame implements ActionListener {
    Timer timer;
    String user;
    JButton personalDetails,updateDetails,payments,calculator,notepad,about,destination,bookHotel,viewbookHotel,viewHotels,deleteDetails,checkPackages,viewDetails, viewPackage, bookPackage;

    private void addButtonHoverAnimation(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
//                button.setLocation(button.getX(), button.getY() - 10);
                button.setBackground(new Color(51, 51, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                button.setLocation(button.getX(), button.getY() + 10);
                button.setBackground(new Color(0, 0, 102));
            }
        });
    }




    Dashboard(String user){
        this.user = user;
//        setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travelmanagement/system/icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

         personalDetails = new JButton("Add personal details");
        personalDetails.setBounds(0, 0, 300, 50);
        personalDetails.setBackground(new Color(0, 0, 102));
        personalDetails.setForeground(Color.WHITE);
        personalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        personalDetails.setMargin(new Insets(0, 0, 0, 60));
        personalDetails.addActionListener(this);
        p2.add(personalDetails);

         updateDetails = new JButton("Update personal details");
        updateDetails.setBounds(0, 50, 300, 50);
        updateDetails.setBackground(new Color(0, 0, 102));
        updateDetails.setForeground(Color.WHITE);
        updateDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updateDetails.setMargin(new Insets(0, 0, 0, 30));
        updateDetails.addActionListener(this);
        p2.add(updateDetails);

        viewDetails = new JButton("View Details");
        viewDetails.setBounds(0, 100, 300, 50);
        viewDetails.setBackground(new Color(0, 0, 102));
        viewDetails.setForeground(Color.WHITE);
        viewDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewDetails.setMargin(new Insets(0, 0, 0, 130));
        viewDetails.addActionListener(this);
        p2.add(viewDetails);

         deleteDetails = new JButton("Delete Personal Details");
        deleteDetails.setBounds(0, 150, 300, 50);
        deleteDetails.setBackground(new Color(0, 0, 102));
        deleteDetails.setForeground(Color.WHITE);
        deleteDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deleteDetails.setMargin(new Insets(0, 0, 0, 30));
        deleteDetails.addActionListener(this);
        p2.add(deleteDetails);

         checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0, 200, 300, 50);
        checkPackages.setBackground(new Color(0, 0, 102));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackages.setMargin(new Insets(0, 0, 0, 90));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

         bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, 250, 300, 50);
        bookPackage.setBackground(new Color(0, 0, 102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPackage.setMargin(new Insets(0, 0, 0, 110));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0, 300, 300, 50);
        viewPackage.setBackground(new Color(0, 0, 102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPackage.setMargin(new Insets(0, 0, 0, 110));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

         viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, 350, 300, 50);
        viewHotels.setBackground(new Color(0, 0, 102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewHotels.setMargin(new Insets(0, 0, 0, 120));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

         bookHotel = new JButton("Book Hotels");
        bookHotel.setBounds(0, 400, 300, 50);
        bookHotel.setBackground(new Color(0, 0, 102));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookHotel.setMargin(new Insets(0, 0, 0, 120));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewbookHotel = new JButton("View Booked Hotels");
        viewbookHotel.setBounds(0, 450, 300, 50);
        viewbookHotel.setBackground(new Color(0, 0, 102));
        viewbookHotel.setForeground(Color.WHITE);
        viewbookHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookHotel.setMargin(new Insets(0, 0, 0, 50));
        viewbookHotel.addActionListener(this);
        p2.add(viewbookHotel);

         destination = new JButton("Destinations");
        destination.setBounds(0, 500, 300, 50);
        destination.setBackground(new Color(0, 0, 102));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destination.setMargin(new Insets(0, 0, 0, 125));
        destination.addActionListener(this);
        p2.add(destination);

          payments = new JButton("Payments");
        payments.setBounds(0, 550, 300, 50);
        payments.setBackground(new Color(0, 0, 102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0, 0, 0, 145));
        payments.addActionListener(this);
        p2.add(payments);

         calculator = new JButton("Calculator");
        calculator.setBounds(0, 600, 300, 50);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.setMargin(new Insets(0, 0, 0, 145));
        calculator.addActionListener(this);
        p2.add(calculator);

         notepad = new JButton("Notepad");
        notepad.setBounds(0, 650, 300, 50);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0, 0, 0, 155));
        notepad.addActionListener(this);
        p2.add(notepad);

         about = new JButton("About");
        about.setBounds(0, 700, 300, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0, 0, 0, 165));
        about.addActionListener(this);
        p2.add(about);

        addButtonHoverAnimation(personalDetails);
        addButtonHoverAnimation(updateDetails);
        addButtonHoverAnimation(viewDetails);
        addButtonHoverAnimation(deleteDetails);
        addButtonHoverAnimation(checkPackages);
        addButtonHoverAnimation(bookPackage);
        addButtonHoverAnimation(viewPackage);
        addButtonHoverAnimation(viewHotels);
        addButtonHoverAnimation(bookHotel);
        addButtonHoverAnimation(viewbookHotel);
        addButtonHoverAnimation(destination);
        addButtonHoverAnimation(payments);
        addButtonHoverAnimation(calculator);
        addButtonHoverAnimation(notepad);
        addButtonHoverAnimation(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("travelmanagement/system/icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == personalDetails){
            new AddCustomer(user);
        } else if (ae.getSource() == viewDetails) {
            new ViewCustomer(user);
        } else if (ae.getSource() == checkPackages) {
            new CheckPackage();
        } else if(ae.getSource() == updateDetails){
            new UpdateCustomer(user);
        } else if (ae.getSource() == bookPackage) {
            new BookPackage(user);
        } else if (ae.getSource() == deleteDetails) {
            new DeleteDetails(user);
        } else if (ae.getSource() == viewPackage) {
            new ViewPackage(user);
        } else if (ae.getSource() == viewHotels) {
            new CheckHotel();
        } else if (ae.getSource()==destination) {
            new Destination();
        } else if (ae.getSource() == viewbookHotel) {
            new ViewBookHotels(user);
        } else if (ae.getSource() == bookHotel){
            new BookHotels(user);
        } else if (ae.getSource() == payments) {
            new Payment();
        } else if (ae.getSource() == calculator) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == about) {
            new About();
        }
    }
    public static void main(String[] args) {
        new Dashboard("");
    }
}
