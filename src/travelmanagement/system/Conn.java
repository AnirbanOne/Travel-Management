package travelmanagement.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
//        Step 1: Register The Driver
        try{
//            Step 2: Connecting to the mysql database and configuring the JAR file
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "root");
//           Step 3: Creating a statement
            s = c.createStatement();
// Step: 4 Check the signup page


        } catch (Exception e){
//            System.out.println(e);
            e.printStackTrace();
        }

    }
}
