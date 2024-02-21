package employee_payroll_system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AddEmployee extends JFrame implements ActionListener
{
    // initialize all the components
    JLabel eid,ename,type,sal,payRoll;
    JTextField eidText,enameText,salText,payRollText;
    JButton add;
    JComboBox typeText;
    String typeName[] = {"Full Time","Part Time"};
    AddEmployee()
    {
        try
        {
            setTitle("Employee Payroll System");  // sets the title for the program
            setSize(800,520);
            setLayout(null);
            setVisible(true);
            setResizable(false);
            setLocation(550,260);
            getContentPane().setBackground(Color.white);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            eid = new JLabel("Enter the id of the employee : ");
            eid.setBounds(45,50,600,40);
            eid.setFont(new Font("Raleway",Font.BOLD,26));
            add(eid);
            eidText = new JTextField();
            eidText.setBounds(485,50,255,40);
            eidText.setFont(new Font("Arial",Font.PLAIN,20));
            eidText.setBackground(Color.WHITE);
            eidText.setForeground(Color.BLACK);
            add(eidText);

            ename = new JLabel("Enter the name of the employee : ");
            ename.setBounds(45,120,600,40);
            ename.setFont(new Font("Raleway",Font.BOLD,26));
            add(ename);
            enameText = new JTextField();
            enameText.setBounds(485,120,255,40);
            enameText.setFont(new Font("Arial",Font.PLAIN,20));
            enameText.setBackground(Color.WHITE);
            enameText.setForeground(Color.BLACK);
            add(enameText );

            type = new JLabel("Enter the type of employee : ");
            type.setBounds(45,190,600,40);
            type.setFont(new Font("Raleway",Font.BOLD,26));
            add(type);
            typeText = new JComboBox(typeName);
            typeText.setBounds(485,190,255,40);
            typeText.setFont(new Font("Arial",Font.PLAIN,20));
            typeText.setBackground(Color.WHITE);
            typeText.setForeground(Color.BLACK);
            add(typeText);

            sal = new JLabel("Enter the salary of the employee : ");
            sal.setBounds(45,260,600,40);
            sal.setFont(new Font("Raleway",Font.BOLD,26));
            add(sal);
            salText = new JTextField();
            salText.setBounds(485,260,255,40);
            salText.setFont(new Font("Arial",Font.PLAIN,20));
            salText.setBackground(Color.WHITE);
            salText.setForeground(Color.BLACK);
            add(salText);

            payRoll = new JLabel("The payroll of the employee is : ");
            payRoll.setBounds(45,330,600,40);
            payRoll.setFont(new Font("Raleway",Font.BOLD,26));
            add(payRoll);
            payRollText = new JTextField();
            payRollText.setBounds(485,330,255,40);
            payRollText.setFont(new Font("Arial",Font.PLAIN,20));
            payRollText.setBackground(Color.WHITE);
            payRollText.setForeground(Color.BLACK);
            payRollText.setEditable(false);
            add(payRollText);

            add = new JButton("Store Employee");
            add.setBackground(Color.BLACK);
            add.setForeground(Color.WHITE);
            add.setFont(new Font("Arial",Font.PLAIN,20));
            add.setBounds(560,400,180,40);
            add(add);
            add.addActionListener(this);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        int id = Integer.parseInt(eidText.getText());
        String ename = enameText.getText();
        String type = (String)typeText.getSelectedItem();
        int sal = Integer.parseInt(salText.getText());
        EmployeeDetails ob = new EmployeeDetails(id,ename,type,sal);
        ob.calculatePayroll(type,sal);  // calculates payRoll
        payRollText.setText(String.valueOf(ob.totalAmount));
        String payRoll = payRollText.getText();
        if(ae.getSource()==add)
        {
            try
            {
                FileWriter fw = new FileWriter("empdata.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(id + " " + ename + " " + type + " " + sal + " " + payRoll);
                bw.newLine();
                JOptionPane.showMessageDialog(null,"Added successfully");
                bw.close();
                setVisible(false);
                new Home().setVisible(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->{  // loads all the components on startup
            AddEmployee ob = new AddEmployee();
        });
    }
}
