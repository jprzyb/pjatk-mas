public class HRAccountant extends Employee{

    String justToShowType;
    public HRAccountant(String firstName, String lastName, MyDate birthDate , Character militaryCategory, double salary) {
        super(firstName, lastName, birthDate, militaryCategory, salary);
        justToShowType = "HRAccountant";
    }
    public HRAccountant(String firstName, String lastName, MyDate birthDate , String maidenName, double salary) {
        super(firstName, lastName, birthDate, maidenName, salary);
        justToShowType = "HRAccountant";
    }

    public HRAccountant(Employee employee) {
        super(employee.firstName, employee.lastName, employee.birthDate, employee.maidenName, employee.salary);
        justToShowType = "HRAccountant";
    }
    public Employee hireProjectEmployee(String firstName, String lastName, MyDate birthDate , Character militaryCategory, double salary){
        return new ProjectEmployee(firstName,lastName,birthDate, militaryCategory,salary, ProjectEmployeeType.EMPLOYEE);
    }
    public Employee hireProjectEmployee(String firstName, String lastName, MyDate birthDate , String maidenName, double salary){
        return new ProjectEmployee(firstName,lastName,birthDate, maidenName,salary, ProjectEmployeeType.EMPLOYEE);
    }

    @Override
    public String toString() {
        return super.toString("\", accountantType=" + justToShowType + '\'');
    }
}
