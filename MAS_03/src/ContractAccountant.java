public class ContractAccountant extends Employee{
    String justToShowType;
    public ContractAccountant(String firstName, String lastName, MyDate birthDate,Character militaryCategory, double salary) {
        super(firstName, lastName, birthDate, militaryCategory, salary);
        justToShowType = "ContractAccountant";
    }

    public ContractAccountant(Employee employee) {
        super(employee.firstName, employee.lastName, employee.birthDate, employee.maidenName, employee.salary);
        justToShowType = "ContractAccountant";
    }

    public double calcContract(double price, int workingMonths){
        return price *workingMonths;
    }

    @Override
    public String toString() {
        return super.toString("\", accountantType=" + justToShowType + '\'');
    }
}
