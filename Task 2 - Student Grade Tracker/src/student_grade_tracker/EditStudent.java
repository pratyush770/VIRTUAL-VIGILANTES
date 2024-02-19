package student_grade_tracker;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class EditStudent extends JFrame implements ActionListener
{
    EditStudent()
    {
        setVisible(true);
        setSize(500,500);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->{
            EditStudent ob =new EditStudent();
        });
    }
}
