package travelmanagement.system;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage()
    {
        setBounds ( 450,200,900,600 );

        String [] Package1={"Gold Package","6 days 7 Nights","Airport Assistance","Half Day City Tour","Daily Buffet","Soft Drinks","Full Day 3 Island Cruise"," English Speaking Guide","BOOK PACKAGE"," SUMMER SPECIAL","Rs 12000/-","package1.jpg"};
        String [] Package2={"Silver Package","5 Days and 6 Nights"," Toll Free "," Entrance Free Tickets","Meet and Greet at Airport","Welcome Drinks on Arrival","Night Safari"," Cruise with Dinner"," BOOK NOW","WINTER SPECIAL ","Rs 24000/-","package2.jpg"};
        String [] Package3={"Bronze Package"," 6 days and 5 Nights"," Return Airfare"," Free Clubbing,Horse Riding & Other Games","River Rafting"," Hard Drinks Free","Daily Buffet","BBQ Dinner","BOOK NOW"," MOONSOON SPECIAL","Rs 32000/-","package3.jpg"};

        JTabbedPane tab=new JTabbedPane ();
        JPanel p1=createPackage (Package1);
        tab.addTab ( "Package1",null,p1);
        JPanel p2=createPackage (Package2);
        tab.addTab ( "Package2",null,p2);
        JPanel p3=createPackage (Package3);
        tab.addTab ( "Package3",null,p3);
        add ( tab );



        setVisible ( true );

    }

    public JPanel createPackage(String[] Package)
    {
        JPanel p1=new JPanel ();
        p1.setLayout ( null );
        p1.setBackground ( Color.white );

        JLabel l1=new JLabel (Package[0]);
        l1.setBounds ( 50,5,300,30 );
        l1.setForeground ( Color.yellow );
        l1.setFont ( new Font ( "Tahoma",Font.BOLD,30 ) );
        p1.add ( l1 );


        JLabel l2=new JLabel (Package[1]);
        l2.setBounds ( 30,60,300,30 );
        l2.setForeground ( Color.RED);
        l2.setFont ( new Font ( "Tahoma",Font.BOLD,20 ) );
        p1.add ( l2 );

        JLabel l3=new JLabel (Package[2]);
        l3.setBounds ( 30,110,300,30 );
        l3.setForeground ( Color.BLUE);
        l3.setFont ( new Font ( "Tahoma",Font.BOLD,20 ) );
        p1.add ( l3 );

        JLabel l4=new JLabel (Package[3]);
        l4.setBounds ( 30,160,300,30 );
        l4.setForeground ( Color.red);
        l4.setFont ( new Font ( "Tahoma",Font.BOLD,20 ) );
        p1.add ( l4 );

        JLabel l5=new JLabel (Package[4]);
        l5.setBounds ( 30,210,300,30 );
        l5.setForeground ( Color.blue);
        l5.setFont ( new Font ( "Tahoma",Font.BOLD,20 ) );
        p1.add ( l5 );

        JLabel l6=new JLabel (Package[5]);
        l6.setBounds ( 30,260,300,30 );
        l6.setForeground ( Color.RED);
        l6.setFont ( new Font ( "Tahoma",Font.BOLD,20 ) );
        p1.add ( l6 );

        JLabel l7=new JLabel (Package[6]);
        l7.setBounds ( 30,310,300,30 );
        l7.setForeground ( Color.BLUE);
        l7.setFont ( new Font ( "Tahoma",Font.BOLD,20 ) );
        p1.add ( l7 );

        JLabel l8=new JLabel (Package[7]);
        l8.setBounds ( 30,360,300,30 );
        l8.setForeground ( Color.red);
        l8.setFont ( new Font ( "Tahoma",Font.BOLD,20 ) );
        p1.add ( l8 );

        JLabel l9=new JLabel (Package[8]);
        l9.setBounds ( 60,420,300,30 );
        l9.setForeground ( Color.black);
        l9.setFont ( new Font ( "Tahoma",Font.BOLD,25 ) );
        p1.add ( l9 );

        JLabel l10=new JLabel (Package[9]);
        l10.setBounds ( 80,480,300,30 );
        l10.setForeground ( Color.magenta);
        l10.setFont ( new Font ( "Tahoma",Font.BOLD,25 ) );
        p1.add ( l10 );

        JLabel l11=new JLabel (Package[10]);
        l11.setBounds ( 500,480,300,30 );
        l11.setForeground ( Color.cyan );
        l11.setFont ( new Font ( "Tahoma", Font.BOLD,25 ) );
        p1.add ( l11 );

        ImageIcon i1=new ImageIcon (ClassLoader.getSystemResource ( "travelmanagement/system/icons/"+Package[11] ));
        Image i2= i1.getImage ().getScaledInstance ( 500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon (i2);
        JLabel   l12=new JLabel (i3);
        l12.setBounds ( 350,20,500,300 );
        p1.add ( l12 );

        return p1;

    }

    public static void main(String[] args) {
        new CheckPackage ();
    }



}
