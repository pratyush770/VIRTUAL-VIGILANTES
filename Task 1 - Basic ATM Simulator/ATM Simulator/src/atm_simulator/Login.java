package atm_simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener
{
    // initialize all the components
    JButton withdraw,deposit,inquiry,pin,exit;
    JLabel l,text,select;
    ImageIcon i,i3;
    Image i2;
    public Login()
    {
        try
        {
            setTitle("Automated Teller Machine");  // sets the title for the program
            setSize(800,600); // defines the size of the frame
            setLayout(null);
            setVisible(true);  // makes the frame visible
            setLocation(550,220);  // opens the frame at the center of the screen
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

            select = new JLabel("Select a transaction");  // creates a label
            select.setBounds(250,175,400,40);
            select.setFont(new Font("Raleway",Font.BOLD,28));
            add(select);

            withdraw = new JButton("Cash withdraw");
            withdraw.setBounds(50,285,220,40);
            withdraw.setFont(new Font("Arial",Font.PLAIN,20));
            withdraw.setBackground(Color.blue);
            withdraw.setForeground(Color.white);
            add(withdraw);
            withdraw.addActionListener(this);

            deposit = new JButton("Cash deposit");
            deposit.setBounds(510,285,220,40);
            deposit.setFont(new Font("Arial",Font.PLAIN,20));
            deposit.setBackground(Color.blue);
            deposit.setForeground(Color.white);
            add(deposit);
            deposit.addActionListener(this);

            inquiry = new JButton("Balance inquiry");
            inquiry.setBounds(50,365,220,40);
            inquiry.setFont(new Font("Arial",Font.PLAIN,20));
            inquiry.setBackground(Color.blue);
            inquiry.setForeground(Color.white);
            add(inquiry);
            inquiry.addActionListener(this);

            pin = new JButton("Change PIN");
            pin.setBounds(510,365,220,40);
            pin.setFont(new Font("Arial",Font.PLAIN,20));
            pin.setBackground(Color.blue);
            pin.setForeground(Color.white);
            add(pin);
            pin.addActionListener(this);

            exit = new JButton("Exit");
            exit.setBounds(310,450,150,40);
            exit.setFont(new Font("Arial",Font.PLAIN,20));
            exit.setBackground(Color.blue);
            exit.setForeground(Color.white);
            add(exit);
            exit.addActionListener(this);
            getContentPane().setBackground(Color.WHITE);  // changes the color of the frame
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==withdraw)
        {
            setVisible(false);
            new CashWithdraw().setVisible(true);  // goes to withdraw class
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new CashDeposit().setVisible(true);  // goes to deposit class
        }
        else if(ae.getSource()==pin)
        {
            setVisible(false);
            new ChangePin().setVisible(true);  // goes to change pin class
        }
        else if(ae.getSource()==exit)
        {
            dispose();  // closes the window and stops the program
        }
    }
    public static void main(String [] args)
    {
        Login ob = new Login();
    }
}
