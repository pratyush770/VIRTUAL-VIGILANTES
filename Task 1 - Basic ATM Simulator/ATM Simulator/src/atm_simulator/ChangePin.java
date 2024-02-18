package atm_simulator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class ChangePin extends JFrame implements ActionListener
{
    JLabel cardNo,oldPinNo,newPinNo;
    JTextField cardText,oldPinText,newPinText;
    JButton change;
    ResultSet rs;
    Scanner sc;
    String cardNumber,oldPinNumber,newPinNumber;
    ChangePin()
    {
        try
        {
            setTitle("Automated Teller Machine");  // sets the title for the program
            setSize(800,400);
            setLayout(null);
            setVisible(false);
            setLocation(550,325);
            getContentPane().setBackground(Color.white);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            cardNo = new JLabel("The entered card number is  : ");
            cardNo.setBounds(40,40,450,40);
            cardNo.setFont(new Font("Arial",Font.BOLD,24));
            add(cardNo);
            cardText = new JTextField();
            cardText.setBounds(400,40,330,40);
            cardText.setBackground(Color.WHITE);
            cardText.setForeground(Color.BLACK);
            cardText.setFont(new Font("Arial",Font.PLAIN,20));
            add(cardText);

            oldPinNo = new JLabel("The entered old PIN is : ");
            oldPinNo.setBounds(40,110,450,40);
            oldPinNo.setFont(new Font("Arial",Font.BOLD,24));
            add(oldPinNo);
            oldPinText = new JTextField();
            oldPinText.setBackground(Color.WHITE);
            oldPinText.setBounds(400,110,330,40);
            oldPinText.setFont(new Font("Arial",Font.PLAIN,20));
            add(oldPinText);

            newPinNo = new JLabel("The entered new PIN is : ");
            newPinNo.setBounds(40,180,450,40);
            newPinNo.setFont(new Font("Arial",Font.BOLD,24));
            add(newPinNo);
            newPinText = new JTextField();
            newPinText.setBackground(Color.WHITE);
            newPinText.setBounds(400,180,330,40);
            newPinText.setFont(new Font("Arial",Font.PLAIN,20));
            add(newPinText);

            change = new JButton("Change PIN");
            change.setBackground(Color.BLUE);
            change.setForeground(Color.white);
            change.setFont(new Font("Arial",Font.PLAIN,20));
            change.setBounds(580,250,150,40);
            add(change);
            change.addActionListener(this);
            sc = new Scanner(System.in);
            System.out.print("Enter the card number : ");
            cardNumber = sc.next();
            System.out.print("Enter the old PIN : ");
            oldPinNumber = sc.next();
            System.out.print("Enter the new PIN : ");
            newPinNumber = sc.next();
            cardText.setText(cardNumber);
            oldPinText.setText(oldPinNumber);
            newPinText.setText(newPinNumber);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String card = cardText.getText();
        String oldPin = oldPinText.getText();
        String newPin = newPinText.getText();
        if(card.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Card Number is required");
        }
        else if(card.length() != 16)
        {
            JOptionPane.showMessageDialog(null,"Card number should be of 16 digits");
        }
        else if(oldPin.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"PIN is required");
        }
        else if(oldPin.length() != 4)
        {
            JOptionPane.showMessageDialog(null,"PIN should be of 4 digits");
        }
        else if(newPin.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"PIN is required");
        }
        else if(newPin.length() != 4)
        {
            JOptionPane.showMessageDialog(null,"PIN should be of 4 digits");
        }
        else
        {
            try
            {
                Conn c = new Conn();
                String q = "SELECT * FROM user WHERE pin = '"+oldPin+"'";
                rs = c.s.executeQuery(q);
                if (rs.next())
                {
                    // If there is at least one record with the provided PIN in the database
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    // Update the PIN in the database
                    q = "UPDATE user SET pin = '" + newPin + "' WHERE card = '" + card + "'";
                    c.s.executeUpdate(q);
                    setVisible(false);
                    new Login().setVisible(true);
                }
                else {
                    // If no record with the provided PIN is found in the database
                    JOptionPane.showMessageDialog(null, "Invalid PIN");
                    cardText.setText("");
                    oldPinText.setText("");
                    newPinText.setText("");
                    setVisible(false);
                    System.out.print("Enter the card number : ");
                    cardNumber = sc.next();
                    System.out.print("Enter the old PIN : ");
                    oldPinNumber = sc.next();
                    System.out.print("Enter the new PIN : ");
                    newPinNumber = sc.next();
                    cardText.setText(cardNumber);
                    oldPinText.setText(oldPinNumber);
                    newPinText.setText(newPinNumber);
                    setVisible(true);
                }
            }
            catch (Exception e2)
            {
                System.out.println(e2.getMessage());
            }
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->{  // loads all the components on startup
            ChangePin ob = new ChangePin();
            ob.setVisible(true);
        });
    }
}
