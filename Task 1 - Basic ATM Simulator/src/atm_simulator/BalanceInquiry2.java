package atm_simulator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class BalanceInquiry2 extends JFrame implements ActionListener
{
    JLabel total,cardNo;
    JTextField totalText,cardText;
    JButton done;
    String pin;
    ResultSet rs;
    BalanceInquiry2(String pin)
    {
        this.pin = pin;
        try
        {
            setTitle("Automated Teller Machine");  // sets the title for the program
            setSize(800,400);
            setLayout(null);
            setVisible(true);
            setLocation(550,325);
            setResizable(false);
            getContentPane().setBackground(Color.white);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            total = new JLabel("Total Balance is : ");
            total.setBounds(120,40,400,40);
            total.setFont(new Font("Raleway",Font.BOLD,32));
            add(total);
            totalText = new JTextField();
            totalText.setBackground(Color.WHITE);
            totalText.setForeground(Color.BLACK);
            totalText.setFont(new Font("Arial",Font.PLAIN,20));
            totalText.setBounds(400,42,260,40);
            totalText.setEditable(false);
            add(totalText);

            cardNo = new JLabel("Card Number : ");
            cardNo.setBounds(120,150,400,40);
            cardNo.setFont(new Font("Raleway",Font.BOLD,32));
            add(cardNo);
            cardText= new JTextField();
            cardText.setBackground(Color.WHITE);
            cardText.setForeground(Color.BLACK);
            cardText.setFont(new Font("Raleway",Font.PLAIN,20));
            cardText.setBounds(400,152,260,40);
            cardText.setEditable(false);
            add(cardText);

            done = new JButton("Done");
            done.setBackground(Color.BLUE);
            done.setForeground(Color.WHITE);
            done.setBounds(560,230,100,40);
            done.setFont(new Font("Raleway",Font.PLAIN,20));
            add(done);
            done.addActionListener(this);
            Conn c = new Conn();
            String q = "SELECT * FROM user WHERE pin = '" + pin + "'";
            rs = c.s.executeQuery(q);
            if (rs.next()) {
                int amount = rs.getInt("amount");
                String card = rs.getString("card");
                String last4digits = card.substring(card.length()-4);
                SwingUtilities.invokeLater(() -> {
                    totalText.setText(Integer.toString(amount));
                    cardText.setText("XXXX-XXXX-XXXX-"+last4digits);
                });
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try
        {
            if (ae.getSource() == done) {
                setVisible(false);
                new Login().setVisible(true);
            }
        }
        catch (Exception e) {
            e.printStackTrace(); // Print exception stack trace for debugging
        }
    }


    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->{
            BalanceInquiry2 ob = new BalanceInquiry2("");
        });
    }
}
