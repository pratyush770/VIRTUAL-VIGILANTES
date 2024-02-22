package employee_payroll_system;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Arrays;

public class DisplayEmployee extends JFrame implements ActionListener
{

    // initialization
    ResultSet rs;
    String columnName []  = {"ID","Name","Type","Salary","Bonus","Deduction","Payroll"};
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    JButton home;
    JLabel label;
    String rowData[];
    DisplayEmployee()
    {
        try
        {
            setTitle("Employee Payroll System");
            setVisible(true);
            setSize(1000,800);
            setLayout(null);
            setLocation(450,110);
            getContentPane().setBackground(Color.white);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            label = new JLabel("The details of employee are as follows : ");
            label.setFont(new Font("Raleway",Font.BOLD,28));
            label.setBounds(250,30,600,40);
            add(label);
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columnName);
            loadDataFromFile("empdata.txt");
            table = new JTable(model);
            // Set up bold font for column headers
            JTableHeader header = table.getTableHeader();
            header.setFont(new Font("Arial",Font.BOLD,17));
            table.setFont(new Font("Arial",Font.PLAIN,15));
            table.setRowHeight(28);  // sets the row height
            // aligns the data in center
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < table.getColumnCount(); i++)
            {
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
            scrollPane = new JScrollPane(table);
            scrollPane.setBounds(20, 100, 960, 575);
            add(scrollPane);
            setResizable(false);
            home = new JButton("Home");
            home.setBackground(Color.BLACK);
            home.setForeground(Color.WHITE);
            home.setFont(new Font("Arial",Font.PLAIN,20));
            home.setBounds(880,700,100,40);
            home.addActionListener(this);
            add(home);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==home)
        {
            setVisible(false);
            new Home().setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->{
            DisplayEmployee ob = new DisplayEmployee();
            ob.setVisible(true);
        });
    }

    private void loadDataFromFile(String fname)
    {
        try
        {
            FileReader fr = new FileReader(fname);
            BufferedReader br = new BufferedReader(fr);
            String line;
            System.out.println("The details of employee are as follows : ");
            while((line=br.readLine())!=null)  // the value from br.readLine goes to line and it checks till it is not null
            {
                rowData = line.split(" ");  // splits by space
                model.addRow(rowData);
                System.out.println(Arrays.toString(rowData));
            }
            br.close();
            fr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

