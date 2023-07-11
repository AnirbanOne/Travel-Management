package travelmanagement.system;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class About extends JFrame {
    JPanel mainPanel;
    JPanel aboutProjectPanel;

    About() {
        setTitle("About");

        // Create the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create the card for your profile
        JPanel profileCard = createProfileCard("Anirban Chakraborty", "Web Developer | Cloud Practitioner (AWS and GCP) | DevOps Enthusiast | \n| Java Programmer | Full-stack | IoT Neophyte | GHRCE Nagpur", "travelmanagement/system/icons/anirbanProfile.jpeg");
        mainPanel.add(profileCard);

        // Create cards for your teammates
        JPanel teammateCard1 = createProfileCard("Dev Mawley", "Web developer | Java Programmer | SQL and MySQL", "travelmanagement/system/icons/maw.jpeg");
        JPanel teammateCard2 = createProfileCard("Aniket Paulzagde", "Web developer | Java Programmer | Data Structures and Algorithm", "travelmanagement/system/icons/paul.jpeg");
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(teammateCard1);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(teammateCard2);

        // Create the panel for the project description
        aboutProjectPanel = createAboutProjectPanel();
        mainPanel.add(Box.createVerticalStrut(40));
        mainPanel.add(aboutProjectPanel);

        // Set up the scroll pane for the main panel
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollPane.getViewport().setScrollMode(JViewport.BLIT_SCROLL_MODE);

        // Add the scroll pane to the frame
        add(scrollPane);

        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createProfileCard(String name, String bio, String imagePath) {
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        cardPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));

        // Create the profile picture panel
        JPanel picturePanel = new JPanel();
        picturePanel.setBackground(Color.WHITE);
        picturePanel.setPreferredSize(new Dimension(100, 100));
        picturePanel.setLayout(new BorderLayout());

        // Load the profile picture
        ImageIcon profileImage = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        Image scaledImage = profileImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        profileImage = new ImageIcon(scaledImage);

        // Create a rectangular profile picture
        JLabel profilePicture = new JLabel(profileImage);
        profilePicture.setSize(100, 100);
        profilePicture.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        profilePicture.setHorizontalAlignment(JLabel.CENTER);
        profilePicture.setVerticalAlignment(JLabel.CENTER);
        picturePanel.add(profilePicture, BorderLayout.CENTER);

        cardPanel.add(picturePanel, BorderLayout.WEST);

        // Create the information panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea bioTextArea = new JTextArea(bio);
        bioTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        bioTextArea.setLineWrap(true);
        bioTextArea.setWrapStyleWord(true);
        bioTextArea.setEditable(false);
        bioTextArea.setFocusable(false);
        bioTextArea.setBackground(Color.WHITE);
        bioTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);

        infoPanel.add(nameLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        infoPanel.add(bioTextArea);

        cardPanel.add(infoPanel, BorderLayout.CENTER);

        return cardPanel;
    }

    private JPanel createAboutProjectPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        String projectDescription = "About Project\n\n"
                + "The objective of the Travel and Tourism Management System project is to develop a system that automates "
                + "the processes and activities of a travel and the purpose is to design a system using which one can perform "
                + "all operations related to traveling.\n\n"
                + "This application will help in accessing the information related to the travel to the particular destination "
                + "with great ease. The users can track the information related to their tours with great ease through this "
                + "application. The travel agency information can also be obtained through this application.\n\n"
                + "Advantages of Project:\n"
                + "- Gives accurate information\n"
                + "- Simplifies the manual work\n"
                + "- Minimizes the documentation-related work\n"
                + "- Provides up-to-date information\n"
                + "- Provides a friendly environment by providing warning messages.\n"
                + "- Provides travelers' details\n"
                + "- Booking confirmation notification";

        JTextArea projectTextArea = new JTextArea(projectDescription);
        projectTextArea.setFont(new Font("Arial", Font.BOLD, 14));
        projectTextArea.setForeground(Color.DARK_GRAY);
        projectTextArea.setLineWrap(true);
        projectTextArea.setWrapStyleWord(true);
        projectTextArea.setEditable(false);
        projectTextArea.setFocusable(false);
        projectTextArea.setBackground(Color.WHITE);

        panel.add(new JLabel("About Project", SwingConstants.CENTER), BorderLayout.NORTH);
        panel.add(projectTextArea, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(About::new);
    }
}
