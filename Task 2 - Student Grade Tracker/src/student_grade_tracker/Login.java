package student_grade_tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener
{
    // initialize all the components
    JButton add,edit,display,exit;
    JLabel l,text,select;
    ImageIcon i,i3;
    Image i2;
    public Login()
    {
        try
        {
            setTitle("Student Grade Tracker");  // sets the title for the program
            setSize(800,510); // defines the size of the frame
            setLayout(null);
            setVisible(true);  // makes the frame visible
            setLocation(550,260);  // opens the frame at the center of the screen
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // closes the window and stops the program
            i = new ImageIcon(ClassLoader.getSystemResource("icons/student.png"));  // loads the image
            i2 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  // adjusts the size of the image
            i3 = new ImageIcon(i2);  // convert the image to ImageIcon to add it in frame
            l = new JLabel(i3);
            l.setBounds(100,20,100,100);
            add(l);

            text = new JLabel("Student Grade Tracker");  // creates a label
            text.setBounds(245,55,450,40);  // for aligning
            text.setFont(new Font("Arial",Font.BOLD,38));
            add(text);

            select = new JLabel("Select an option");  // creates a label
            select.setBounds(285,175,400,40);
            select.setFont(new Font("Raleway",Font.BOLD,28));
            add(select);

            add = new JButton("Add Student");
            add.setBounds(50,285,220,40);
            add.setFont(new Font("Arial",Font.PLAIN,20));
            add.setBackground(Color.black);
            add.setForeground(Color.white);
            add(add);
            add.addActionListener(this);

            edit = new JButton("Edit Student");
            edit.setBounds(510,285,220,40);
            edit.setFont(new Font("Arial",Font.PLAIN,20));
            edit.setBackground(Color.black);
            edit.setForeground(Color.white);
            add(edit);
            edit.addActionListener(this);

            display = new JButton("Display Grades");
            display.setBounds(50,365,220,40);
            display.setFont(new Font("Arial",Font.PLAIN,20));
            display.setBackground(Color.black);
            display.setForeground(Color.white);
            add(display);
            display.addActionListener(this);

            exit = new JButton("Exit");
            exit.setBounds(510,365,220,40);
            exit.setFont(new Font("Arial",Font.PLAIN,20));
            exit.setBackground(Color.black);
            exit.setForeground(Color.white);
            add(exit);
            exit.addActionListener(this);

            getContentPane().setBackground(Color.WHITE);  // changes the color of the frame
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            setVisible(false);
            new AddStudent().setVisible(true);  // goes to withdraw class
        }
        else if(ae.getSource()==edit)
        {
//            setVisible(false);
//            new CashDeposit().setVisible(true);  // goes to deposit class
        }
        else if(ae.getSource()==display)
        {
//            setVisible(false);
//            new ChangePin().setVisible(true);  // goes to change pin class
        }
        else if(ae.getSource()==exit)
        {
            System.exit(0);
        }
    }
    public static void main(String [] args)
    {
        Login ob = new Login();
    }
}
