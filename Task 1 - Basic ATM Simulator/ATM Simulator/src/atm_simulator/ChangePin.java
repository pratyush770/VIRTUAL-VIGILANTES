package atm_simulator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ChangePin extends JFrame implements ActionListener
{
    JLabel cardNo,pinNo,confirmPinNo;
    JTextField cardText,pinText,confirmPinText;
    JButton change;
    ChangePin()
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

            cardNo = new JLabel("Enter Card Number : ");
            cardNo.setBounds(40,40,250,40);
            cardNo.setFont(new Font("Arial",Font.BOLD,24));
            add(cardNo);
            cardText = new JTextField();
            cardText.setBounds(300,40,430,40);
            cardText.setBackground(Color.WHITE);
            cardText.setForeground(Color.BLACK);
            cardText.setFont(new Font("Arial",Font.PLAIN,20));
            add(cardText);

            pinNo = new JLabel("Enter New PIN : ");
            pinNo.setBounds(40,110,250,40);
            pinNo.setFont(new Font("Arial",Font.BOLD,24));
            add(pinNo);
            pinText = new JTextField();
            pinText.setBackground(Color.WHITE);
            pinText.setBounds(300,110,430,40);
            pinText.setFont(new Font("Arial",Font.PLAIN,20));
            add(pinText);

            confirmPinNo = new JLabel("Confirm New PIN : ");
            confirmPinNo.setBounds(40,180,250,40);
            confirmPinNo.setFont(new Font("Arial",Font.BOLD,24));
            add(confirmPinNo);
            confirmPinText = new JTextField();
            confirmPinText.setBackground(Color.WHITE);
            confirmPinText.setBounds(300,180,430,40);
            confirmPinText.setFont(new Font("Arial",Font.PLAIN,20));
            add(confirmPinText);

            change = new JButton("Change PIN");
            change.setBackground(Color.BLUE);
            change.setForeground(Color.white);
            change.setFont(new Font("Arial",Font.PLAIN,20));
            change.setBounds(580,250,150,40);
            add(change);
            change.addActionListener(this);

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
        String pin = pinText.getText();
        String confirm = confirmPinText.getText();
        if(card.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Card Number is required");
        }
        else if(pin.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"PIN is required");
        }
        else if(confirm.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please re-enter your PIN");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->{  // loads all the components on startup
            ChangePin ob = new ChangePin();
        });
    }
}
