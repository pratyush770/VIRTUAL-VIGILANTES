package atm_simulator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class CashWithdraw extends JFrame implements ActionListener
{
    private void userInput()
    {
        sc = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw : ");
        enteredAmount = sc.next();
        System.out.print("Enter the PIN : ");
        enteredPin = sc.next();
        amountText.setText(enteredAmount);
        pinText.setText(enteredPin);
    }
    JLabel amount,denomination,pinNo;
    JTextField amountText,pinText;
    JButton withdraw;
    ResultSet rs;
    Scanner sc;
    String enteredAmount,enteredPin;
    CashWithdraw()
    {
        try
        {
            setTitle("Automated Teller Machine");  // sets the title for the program
            setSize(800,400);
            setLayout(null);
            setLocation(550,325);
            setResizable(false);
            getContentPane().setBackground(Color.white);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            amount = new JLabel("The entered amount to withdraw is : ");
            amount.setBounds(40,50,600,40);
            amount.setFont(new Font("Raleway",Font.BOLD,28));
            add(amount);

            amountText = new JTextField();
            amountText.setBounds(540,50,190,40);
            amountText.setFont(new Font("Arial",Font.PLAIN,20));
            amountText.setBackground(Color.WHITE);
            amountText.setForeground(Color.BLACK);
            add(amountText);

            denomination = new JLabel("(Only 500 rupees denomination accepted)");
            denomination.setBounds(90,90,600,40);
            denomination.setFont(new Font("Raleway",Font.PLAIN,20));
            add(denomination);

            pinNo = new JLabel("The entered PIN is : ");
            pinNo.setBounds(300,180,250,40);
            pinNo.setFont(new Font("Arial",Font.BOLD,24));
            add(pinNo);

            pinText = new JTextField();
            pinText.setBackground(Color.WHITE);
            pinText.setBounds(540,180,190,40);
            pinText.setFont(new Font("Arial",Font.PLAIN,20));
            add(pinText);

            withdraw = new JButton("Withdraw");
            withdraw.setBackground(Color.BLUE);
            withdraw.setForeground(Color.white);
            withdraw.setFont(new Font("Arial",Font.PLAIN,20));
            withdraw.setBounds(580,260,150,40);
            add(withdraw);
            withdraw.addActionListener(this);
            setVisible(false);
            userInput();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String amount = amountText.getText();
        String pin = pinText.getText();
        if(pin.length() != 4)
        {
            JOptionPane.showMessageDialog(null,"PIN should be of 4 digits");
            setVisible(false);
            userInput();
            setVisible(true);
        }
        else
        {
            try
            {
                Conn c = new Conn();
                String q = "SELECT * FROM user WHERE pin = '"+pin+"'";
                rs = c.s.executeQuery(q);
                if (rs.next()) {
                    // If there is at least one record with the provided PIN in the database
                    int withdrawAmount = rs.getInt("amount");
                    int enteredAmount = Integer.parseInt(amountText.getText());
                    if(enteredAmount>withdrawAmount)
                    {
                        JOptionPane.showMessageDialog(null,"Insufficient funds");
                        setVisible(false);
                        userInput();
                        setVisible(true);
                    }
                    else if(enteredAmount%500!=0)
                    {
                        JOptionPane.showMessageDialog(null,"Please enter value represented by 500 denomination notes");
                        setVisible(false);
                        userInput();
                        setVisible(true);
                    }
                    else
                    {
                        withdrawAmount = withdrawAmount - enteredAmount;
                        q = "UPDATE user SET amount = '"+withdrawAmount+"'";
                        c.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "Cash Withdrawn successfully");
                        setVisible(false);
                        new Home().setVisible(true);
                    }
                }
                else
                {
                    // If no record with the provided PIN is found in the database
                    JOptionPane.showMessageDialog(null, "Invalid PIN");
                    setVisible(false);
                    userInput();
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
            CashWithdraw ob = new CashWithdraw();
            ob.setVisible(true);
        });
    }
}
