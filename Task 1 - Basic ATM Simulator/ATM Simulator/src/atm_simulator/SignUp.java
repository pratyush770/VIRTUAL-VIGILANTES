package atm_simulator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignUp extends JFrame implements ActionListener
{
    JLabel applicationNo,page1,name,fatherName,dob,email,gender,status,country,pin;
    JTextField nameText,fatherText,emailText,pinText;
    Random random;
    long randomNo;
    JButton next;
    JDateChooser dateChooser;
    ButtonGroup buttonGroup,buttonGroup1;
    JRadioButton male,female,single,married,other;
    JComboBox comboBox;
    String countryName [] = {"India","Pakistan","SriLanka","NewZealand","England"};
    public SignUp()
    {
        try
        {
            setTitle("Automated Teller Machine");  // sets the title for the program
            setSize(800,800); // defines the size of the frame
            setLayout(null);
            setVisible(true);
            setLocation(550,120);// makes the frame visible
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // closes the window and stops the program
            random = new Random();
            randomNo = Math.abs((random.nextLong()%9000L) + 1000L);  // generates 4 digit random number everytime
            getContentPane().setBackground(Color.WHITE);  // changes the color of the frame

            applicationNo = new JLabel("APPLICATION NUMBER : " + randomNo);
            applicationNo.setBounds(115,35,600,40);
            applicationNo.setFont(new Font("Raleway",Font.BOLD,38));
            add(applicationNo);

            page1 = new JLabel("1) Personal Details");
            page1.setBounds(260,95,300,40);
            page1.setFont(new Font("Raleway",Font.BOLD,28));
            add(page1);

            name = new JLabel("Your Name : ");
            name.setBounds(85,165,200,40);
            name.setFont(new Font("Arial",Font.BOLD,24));
            add(name);
            nameText = new JTextField();
            nameText.setBounds(300,170,400,35);
            nameText.setFont(new Font("Arial",Font.PLAIN,18));
            add(nameText);

            fatherName = new JLabel("Father Name : ");
            fatherName.setBounds(85,225,200,40);
            fatherName.setFont(new Font("Raleway",Font.BOLD,24));
            add(fatherName);
            fatherText = new JTextField();
            fatherText.setBounds(300,230,400,35);
            fatherText.setFont(new Font("Raleway",Font.PLAIN,18));
            add(fatherText);

            dob = new JLabel("Date of Birth : ");
            dob.setBounds(85,285,200,40);
            dob.setFont(new Font("Arial",Font.BOLD,24));
            add(dob);
            dateChooser = new JDateChooser();
            dateChooser.setBounds(300,290,400,35);
            dateChooser.setFont(new Font("Raleway",Font.PLAIN,18));
            dateChooser.setForeground(Color.BLACK);
            dateChooser.setForeground(Color.WHITE);
            ((JTextField)dateChooser.getDateEditor().getUiComponent()).setEditable(false);
            add(dateChooser);

            gender = new JLabel("Gender : ");
            gender.setBounds(85,345,200,40);
            gender.setFont(new Font("Arial",Font.BOLD,24));
            add(gender);
            male = new JRadioButton("Male");
            male.setBackground(Color.WHITE);
            male.setBounds(295,345,90,40);
            male.setFont(new Font("Arial",Font.PLAIN,18));
            add(male);
            female = new JRadioButton("Female");
            female.setBackground(Color.WHITE);
            female.setBounds(395,345,150,40);
            female.setFont(new Font("Arial",Font.PLAIN,18));
            add(female);
            buttonGroup = new ButtonGroup();
            buttonGroup.add(male);
            buttonGroup.add(female);

            email = new JLabel("Email : ");
            email.setBounds(85,405,200,40);
            email.setFont(new Font("Arial",Font.BOLD,24));
            add(email);
            emailText = new JTextField();
            emailText.setBounds(300,410,400,35);
            emailText.setFont(new Font("Raleway",Font.PLAIN,18));
            add(emailText);

            status = new JLabel("Marital Status : ");
            status.setBounds(85,465,220,40);
            status.setFont(new Font("Arial",Font.BOLD,24));
            add(status);
            single = new JRadioButton("Single");
            single.setBackground(Color.WHITE);
            single.setBounds(295,465,90,40);
            single.setFont(new Font("Arial",Font.PLAIN,18));
            add(single);
            married = new JRadioButton("Married");
            married.setBackground(Color.WHITE);
            married.setBounds(395,465,120,40);
            married.setFont(new Font("Arial",Font.PLAIN,18));
            add(married);
            other = new JRadioButton("Other");
            other.setBackground(Color.WHITE);
            other.setBounds(515,465,250,40);
            other.setFont(new Font("Arial",Font.PLAIN,18));
            add(other);
            buttonGroup1 = new ButtonGroup();
            buttonGroup1.add(single);
            buttonGroup1.add(married);
            buttonGroup1.add(other);

            country = new JLabel("Country : ");
            country.setBounds(85,525,220,40);
            country.setFont(new Font("Arial",Font.BOLD,24));
            add(country);
            comboBox = new JComboBox(countryName);
            comboBox.setBounds(300,525,400,35);
            comboBox.setFont(new Font("Raleway",Font.PLAIN,18));
            comboBox.setBackground(Color.WHITE);
            add(comboBox);

            pin = new JLabel("Pin Code : ");
            pin.setBounds(85,585,220,40);
            pin.setFont(new Font("Arial",Font.BOLD,24));
            add(pin);
            pinText = new JTextField();
            pinText.setBounds(300,590,400,35);
            pinText.setFont(new Font("Raleway",Font.PLAIN,18));
            add(pinText);

            next = new JButton("Next");
            next.setBackground(Color.BLUE);
            next.setForeground(Color.WHITE);
            next.setBounds(600,650,100,40);
            next.setFont(new Font("Arial",Font.BOLD,18));
            add(next);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {

    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {  // loads all the components on startup
            SignUp ob = new SignUp(); // for starting the program
        });
    }
}
