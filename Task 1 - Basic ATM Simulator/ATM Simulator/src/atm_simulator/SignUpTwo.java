package atm_simulator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SignUpTwo extends JFrame implements ActionListener
{
    JLabel page2,religion,category,income,education,pan,aadhar,senior,occupation;
    JTextField panText,aadharText;
    JButton next;
    ButtonGroup buttonGroup;
    JRadioButton Yes,No;
    String religionName [] = {"Hindu","Muslim","Christian","Sikh","Other"};
    String categoryName [] = {"General","OBC","SC","ST","Other"};
    String incomeName [] = {"< 2,50,000","< 5,00,000","< 7,50,000","> 10,00,000","None"};
    String educationName [] = {"Post Graduate","Graduate","12th","10th","Uneducated"};
    String occupationName [] = {"Salaried","Self Employed","Business","Retired","None"};
    JComboBox religionText,categoryText,incomeText,educationText,occupationText;
    String formNo;
    public SignUpTwo(String formNo)
    {
        try
        {
            this.formNo = formNo;
            setTitle("Automated Teller Machine");  // sets the title for the program
            setSize(800,800); // defines the size of the frame
            setLayout(null);
            setVisible(true);
            setLocation(550,120);// makes the frame visible
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // closes the window and stops the program
            getContentPane().setBackground(Color.WHITE);  // changes the color of the frame

            page2 = new JLabel("2) Additional Details");
            page2.setBounds(260,55,300,40);
            page2.setFont(new Font("Raleway",Font.BOLD,28));
            add(page2);

            religion = new JLabel("Religion : ");
            religion.setBounds(85,135,200,40);
            religion.setFont(new Font("Arial",Font.BOLD,24));
            add(religion);
            religionText = new JComboBox(religionName);
            religionText.setBounds(300,140,400,35);
            religionText.setFont(new Font("Arial",Font.PLAIN,18));
            religionText.setBackground(Color.white);
            religionText.setForeground(Color.BLACK);
            add(religionText);

            category = new JLabel("Category : ");
            category.setBounds(85,195,200,40);
            category.setFont(new Font("Raleway",Font.BOLD,24));
            add(category);
            categoryText = new JComboBox(categoryName);
            categoryText.setBounds(300,200,400,35);
            categoryText.setFont(new Font("Raleway",Font.PLAIN,18));
            categoryText.setBackground(Color.WHITE);
            categoryText.setForeground(Color.BLACK);
            add(categoryText);

            income = new JLabel("Income : ");
            income.setBounds(85,255,200,40);
            income.setFont(new Font("Arial",Font.BOLD,24));
            add(income);
            incomeText = new JComboBox(incomeName);
            incomeText.setBounds(300,260,400,35);
            incomeText.setFont(new Font("Raleway",Font.PLAIN,18));
            incomeText.setForeground(Color.BLACK);
            incomeText.setBackground(Color.WHITE);
            add(incomeText);

            education = new JLabel("Qualification : ");
            education.setBounds(85,315,200,40);
            education.setFont(new Font("Arial",Font.BOLD,24));
            add(education);
            educationText = new JComboBox(educationName);
            educationText.setBounds(300,320,400,35);
            educationText.setFont(new Font("Raleway",Font.PLAIN,18));
            educationText.setForeground(Color.BLACK);
            educationText.setBackground(Color.WHITE);
            add(educationText);

            occupation = new JLabel("Occupation : ");
            occupation.setBounds(85,385,200,40);
            occupation.setFont(new Font("Arial",Font.BOLD,24));
            add(occupation);
            occupationText = new JComboBox(occupationName);
            occupationText.setBounds(300,390,400,35);
            occupationText.setFont(new Font("Raleway",Font.PLAIN,18));
            occupationText.setForeground(Color.BLACK);
            occupationText.setBackground(Color.WHITE);
            add(occupationText);

            pan = new JLabel("Pan Number : ");
            pan.setBounds(85,445,200,40);
            pan.setFont(new Font("Arial",Font.BOLD,24));
            add(pan);
            panText = new JTextField();
            panText.setBounds(300,450,400,35);
            panText.setFont(new Font("Raleway",Font.PLAIN,18));
            add(panText);

            aadhar = new JLabel("Aadhaar Number : ");
            aadhar.setBounds(85,505,220,40);
            aadhar.setFont(new Font("Arial",Font.BOLD,24));
            add(aadhar);
            aadharText = new JTextField();
            aadharText.setBounds(300,510,400,35);
            aadharText.setFont(new Font("Raleway",Font.PLAIN,18));
            add(aadharText);
            senior = new JLabel("Senior Citizen: ");
            senior.setBounds(85,565,220,40);
            senior.setFont(new Font("Arial",Font.BOLD,24));
            add(senior);
            Yes = new JRadioButton("Yes");
            Yes.setBounds(295,565,80,40);
            Yes.setFont(new Font("Raleway",Font.PLAIN,18));
            Yes.setBackground(Color.WHITE);
            add(Yes);
            No = new JRadioButton("No");
            No.setBounds(375,565,80,40);
            No.setFont(new Font("Raleway",Font.PLAIN,18));
            No.setBackground(Color.WHITE);
            add(No);
            buttonGroup = new ButtonGroup();
            buttonGroup.add(Yes);
            buttonGroup.add(No);

            next = new JButton("Next");
            next.setBackground(Color.BLUE);
            next.setForeground(Color.WHITE);
            next.setBounds(600,630,100,40);
            next.setFont(new Font("Arial",Font.BOLD,18));
            add(next);
            next.addActionListener(this);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String religion = (String)religionText.getSelectedItem() ;
        String category = (String)categoryText.getSelectedItem();
        String income = (String)incomeText.getSelectedItem();
        String qualification = (String)educationText.getSelectedItem();
        String occupation = (String)occupationText.getSelectedItem();
        String pan = panText.getText();
        String aadhar = aadharText.getText();
        String senior = "";
        if(Yes.isSelected())
        {
            senior = "yes";
        }
        if(No.isSelected())
        {
            senior = "no";
        }
        try
        {
            // validation
            if(pan.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Pan Number is required");
            }
            else if(aadhar.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Aadhaar Number is required");
            }
            else if(senior.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Value is required");
            }
            else
            {
                Conn c = new Conn();
                String q = "INSERT INTO signuptwo VALUES('"+formNo+"','"+religion+"','"+category+"','"+income+"'," +
                        "'"+qualification+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior+"')";  // generates sql insert query
                c.s.executeUpdate(q);  // executes the query
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {  // loads all the components on startup
            SignUpTwo ob = new SignUpTwo(""); // for starting the program
        });
    }
}
