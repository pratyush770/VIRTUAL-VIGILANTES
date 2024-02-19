package student_grade_tracker;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class DisplayGrades extends JFrame implements ActionListener
{

    private void fetchData()
    {
        try
        {
            Conn c = new Conn();
            String q = "SELECT * FROM student";
            rs= c.s.executeQuery(q);
            rs.last();  // cursor goes to the last row to get the count of rows
            int rowCount = rs.getRow();  // gets the rowCount
            rs.beforeFirst();  // goes to the row before first to iterate through all rows
            data = new Object[rowCount][columnName.length];
            while(rs.next())
            {
                for(col=0;col<columnName.length;col++)
                {
                    data[row][col] = rs.getObject(col + 1); // ResultSet index starts from 0 so we add 1
                }
                row++;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void displayInConsole()
    {
        try
        {
            System.out.println("The details of students are as follows : ");
           for(Object[] row : data)
            {
                System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3] + " " + row[4] + " " + row[5] + " " + row[6] +
                        " " + row[7] + " " + row[8] + " " +  row[9]);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // initialization
    ResultSet rs;
    String columnName []  = {"ID","Name","Course","Marks 1","Marks 2","Marks 3","Marks 4","Marks 5","Average","Grade"};
    Object data [] [] ;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    JButton home;
    int row,col;
    JLabel label;
    DisplayGrades()
    {
        try
        {
            setTitle("Student Grade Tracker");
            setVisible(true);
            setSize(1000,800);
            setLayout(null);
            setLocation(450,110);
            getContentPane().setBackground(Color.white);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            fetchData();
            label = new JLabel("The details of students are as follows : ");
            label.setFont(new Font("Raleway",Font.BOLD,28));
            label.setBounds(250,30,600,40);
            add(label);
            model = new DefaultTableModel(data,columnName);
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
            displayInConsole();
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
            DisplayGrades ob = new DisplayGrades();
        });
    }
}

