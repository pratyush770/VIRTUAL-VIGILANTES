package atm_simulator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class CashDeposit extends JFrame implements ActionListener
{
    JLabel amount,denomination,pinNo;
    JTextField amountText,pinText;
    JButton deposit;
    ResultSet rs;
    CashDeposit()
    {
        try
        {
            setTitle("Automated Teller Machine");  // sets the title for the program
            setSize(800,400);
            setLayout(null);
            setVisible(true);
            setLocation(550,325);
            getContentPane().setBackground(Color.white);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            amount = new JLabel("Select an amount to deposit : ");
            amount.setBounds(65,50,600,40);
            amount.setFont(new Font("Raleway",Font.BOLD,28));
            add(amount);

            amountText = new JTextField();
            amountText.setBounds(480,50,250,40);
            amountText.setFont(new Font("Arial",Font.PLAIN,20));
            amountText.setBackground(Color.WHITE);
            amountText.setForeground(Color.BLACK);
            add(amountText);

            denomination = new JLabel("(Only 500 rupees denomination accepted)");
            denomination.setBounds(75,90,600,40);
            denomination.setFont(new Font("Raleway",Font.PLAIN,20));
            add(denomination);

            pinNo = new JLabel("Enter PIN : ");
            pinNo.setBounds(335,180,250,40);
            pinNo.setFont(new Font("Arial",Font.BOLD,24));
            add(pinNo);

            pinText = new JTextField();
            pinText.setBackground(Color.WHITE);
            pinText.setBounds(480,180,250,40);
            pinText.setFont(new Font("Arial",Font.PLAIN,20));
            add(pinText);

            deposit = new JButton("Deposit");
            deposit.setBackground(Color.BLUE);
            deposit.setForeground(Color.white);
            deposit.setFont(new Font("Arial",Font.PLAIN,20));
            deposit.setBounds(580,260,150,40);
            add(deposit);
            deposit.addActionListener(this);

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
        if(amount.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Amount is required");
        }
        else if(pin.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"PIN is required");
        }
        else if(pin.length() != 4)
        {
            JOptionPane.showMessageDialog(null,"PIN should be of 4 digits");
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
                    int depositAmount = rs.getInt("amount");
                    int enteredAmount = Integer.parseInt(amountText.getText());
                    depositAmount = depositAmount + enteredAmount;
                    q = "UPDATE user SET amount = '"+depositAmount+"'";
                    c.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Cash deposited successfully");
                    setVisible(false);
                    new Login().setVisible(true);
                } else {
                    // If no record with the provided PIN is found in the database
                    JOptionPane.showMessageDialog(null, "Invalid PIN");
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
            CashDeposit ob = new CashDeposit();
        });
    }
}
