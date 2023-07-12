public class Salary
{
    public static void main(String[] args)
    {
        Employee emp = new Employee(4500);
        Manager mng = new Manager(4500,50);
        SalesEmployee s_emp = new SalesEmployee(4500,550);
        SalesManager s_mng = new SalesManager(4500,50,550);
        System.out.println("Name: " + emp.getName() + "\n" + "Salary: " + emp.ComputeSalary());
        System.out.println("Name: " + mng.getName() + "\n" + "Salary: " + mng.ComputeSalary());
        System.out.println("Name:" + s_emp.getSaleName() + "\n" + "Salary: " + s_emp.ComputeSalary());
        System.out.println("Name:" + s_mng.getSaleName() + "\n" + "Salary: " + s_mng.ComputeSalary());
    }
}

