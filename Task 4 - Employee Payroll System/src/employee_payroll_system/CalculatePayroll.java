package employee_payroll_system;
class Employee
{
    int id,sal;
    String ename,type;
    public Employee(int id,String ename,String type,int sal)
    {
        this.id = id;
        this.ename = ename;
        this.type = type;
        this.sal = sal;
    }
}
class EmployeeDetails extends Employee
{
    int fullTimeEmpBonus = 10000;
    int partTimeEmpBonus = 5000;
    int fullTimeEmpDeduction = 2000;
    int partTimeEmpDeduction = 1000;
    int totalAmount = 0;
    public EmployeeDetails(int id,String ename,String type,int sal)
    {
        super(id,ename,type,sal);
    }
    public void calculatePayroll(String type,int sal)
    {
        this.type = type;
        this.sal = sal;
        if(type.equalsIgnoreCase("FULL TIME"))  // for full time employee
        {
            totalAmount = sal + fullTimeEmpBonus - fullTimeEmpDeduction;
            System.out.println("The payroll of the employee is : " + totalAmount);
        }
        else if(type.equalsIgnoreCase("PART TIME"))  // for part-time employee
        {
            totalAmount = sal + partTimeEmpBonus - partTimeEmpDeduction;
            System.out.println("The payroll of the employee is : " + totalAmount);
        }
    }
}
public class CalculatePayroll
{
    public static void main(String[] args)
    {
        EmployeeDetails ob = new EmployeeDetails(1,"XYZ","full time",50000);  // dummy data which will get replaced by user entered values
        ob.calculatePayroll(ob.type,ob.sal);
    }
}
