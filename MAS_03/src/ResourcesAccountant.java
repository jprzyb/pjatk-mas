public class ResourcesAccountant extends Employee{
    String justToShowType;
    double resourceRevenueRate;
    public ResourcesAccountant(String firstName, String lastName, MyDate birthDate, Character militaryCategory, double salary) {
        super(firstName, lastName, birthDate, militaryCategory, salary);
        this.resourceRevenueRate = 0;
        justToShowType = "ResourcesAccountant";
    }

    public ResourcesAccountant(Employee employee) {
        super(employee.firstName, employee.lastName, employee.birthDate, employee.maidenName, employee.salary);
        this.resourceRevenueRate = 0;
        justToShowType = "ResourcesAccountant";
    }

    public void buyNewResource(double price){
        resourceRevenueRate -= price;
    }

    public void selResource(double price){
        resourceRevenueRate += price;
    }

    @Override
    public String toString() {
        return super.toString("\", accountantType=" + justToShowType + '\'');
    }
}
