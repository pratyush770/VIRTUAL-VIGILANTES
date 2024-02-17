package atm_simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener
{
    // initialize all the components
    JButton signIn,clear,signUp;
    JLabel l,text,cardNo,pinNo;
    JTextField cardTextField;
    JPasswordField pinPasswordField;
    ImageIcon i,i3;
    Image i2;
    public Login()
    {
        try
        {
            setTitle("Automated Teller Machine");  // sets the title for the program
            setSize(800,440); // defines the size of the frame
            setLayout(null);
            setVisible(true);  // makes the frame visible
            setLocation(550,300);  // opens the frame at the center of the screen
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // closes the window and stops the program
            i = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));  // loads the image
            i2 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  // adjusts the size of the image
            i3 = new ImageIcon(i2);  // convert the image to ImageIcon to add it in frame
            l = new JLabel(i3);
            l.setBounds(150,20,100,100);
            add(l);
            text = new JLabel("Welcome to ATM");  // creates a label
            text.setBounds(285,55,400,40);  // for aligning
            text.setFont(new Font("Arial",Font.BOLD,38));
            add(text);
            cardNo = new JLabel("Card No : ");  // creates a label
            cardNo.setBounds(160,155,180,40);
            cardNo.setFont(new Font("Raleway",Font.BOLD,22));
            add(cardNo);
            cardTextField = new JTextField();  // creates a textfield
            cardTextField.setBounds(280,160,310,35);
            cardTextField.setFont(new Font("Arial",Font.BOLD,18));
            add(cardTextField);
            pinNo = new JLabel("PIN : ");  // creates a label
            pinNo.setBounds(160,220,150,40);
            pinNo.setFont(new Font("Raleway",Font.BOLD,22));
            add(pinNo);
            pinPasswordField = new JPasswordField();  // creates a textfield
            pinPasswordField.setBounds(280,225,310,35);
            pinPasswordField.setFont(new Font("Arial",Font.BOLD,18));
            add(pinPasswordField);
            signIn = new JButton("SIGN IN");  // creates a button
            signIn.setBounds(280,285,90,30);
            signIn.setBackground(Color.BLUE);
            signIn.setForeground(Color.WHITE);
            add(signIn);
            signIn.addActionListener(this);
            clear = new JButton("CLEAR");  // creates a button
            clear.setBounds(390,285,90,30);
            clear.setBackground(Color.BLUE);
            clear.setForeground(Color.WHITE);
            add(clear);
            clear.addActionListener(this);
            signUp = new JButton("SIGN UP");  // creates a button
            signUp.setBounds(500,285,90,30);
            signUp.setBackground(Color.BLUE);
            signUp.setForeground(Color.WHITE);
            add(signUp);
            signUp.addActionListener(this);
            getContentPane().setBackground(Color.WHITE);  // changes the color of the frame
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==signIn)
        {

        }
        else if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinPasswordField.setText("");
        }
        else if(ae.getSource()==signUp)
        {

        }
    }
    public static void main(String [] args)
    {
        Login ob = new Login();
    }
}
