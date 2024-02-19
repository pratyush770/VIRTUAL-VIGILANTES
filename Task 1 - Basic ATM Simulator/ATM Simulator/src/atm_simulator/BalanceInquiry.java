package atm_simulator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class BalanceInquiry extends JFrame implements ActionListener
{
    private void userInput()
    {
        sc = new Scanner(System.in);
        System.out.print("Enter the PIN : ");
        pinNo = sc.next();
        pinText.setText(pinNo);
    }
    JLabel pin;
    JTextField pinText;
    JButton check;
    ResultSet rs;
    Scanner sc;
    String pinNo;
    BalanceInquiry()
    {
        try
        {
            setTitle("Automated Teller Machine");  // sets the title for the program
            setSize(600,250);
            setLayout(null);
            setLocation(650,435);
            getContentPane().setBackground(Color.white);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            pin = new JLabel("The entered PIN is : ");
            pin.setBounds(60,40,400,40);
            pin.setFont(new Font("Raleway",Font.BOLD,32));
            add(pin);
            pinText = new JTextField();
            pinText.setBackground(Color.WHITE);
            pinText.setForeground(Color.BLACK);
            pinText.setFont(new Font("Arial",Font.PLAIN,20));
            pinText.setBounds(370,42,145,40);
            add(pinText);

            check = new JButton("Check Balance");
            check.setBackground(Color.BLUE);
            check.setForeground(Color.WHITE);
            check.setBounds(200,120,200,40);
            check.setFont(new Font("Raleway",Font.PLAIN,20));
            add(check);
            check.addActionListener(this);
            setVisible(false);
            userInput();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            String pin = pinText.getText();
            if(pin.length() != 4)
            {
                JOptionPane.showMessageDialog(null,"PIN should be of 4 digits");
                setVisible(false);
                userInput();
                setVisible(true);
            }
            else if(ae.getSource()==check)
            {
                try
                    {
                        Conn c = new Conn();
                        String q = "SELECT * FROM user WHERE pin = '"+pin+"'";
                        rs = c.s.executeQuery(q);
                        if (rs.next()) {
                            setVisible(false);
                            new BalanceInquiry2(pin).setVisible(true);
                        } else {
                            // If no record with the provided PIN is found in the database
                            JOptionPane.showMessageDialog(null, "Invalid PIN");
                            setVisible(false);
                            userInput();
                            setVisible(true);
                        }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->{
            BalanceInquiry ob = new BalanceInquiry();
            ob.setVisible(true);
        });
    }
}
