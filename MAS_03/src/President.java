public class President extends Employee implements IHREmployee{

    private double presidentsBonus;
    public President(String firstName, String lastName, MyDate birthDate, Character militaryCategory, double salary) {
        super(firstName, lastName, birthDate, militaryCategory, salary);
        presidentsBonus = 0;
    }

    public President(String firstName, String lastName, MyDate birthDate, String maidenName, double salary) {
        super(firstName, lastName, birthDate, maidenName, salary);
        presidentsBonus = 0;
    }
    public void setPresidentsBonus(double bonus){
        this.presidentsBonus = bonus;
    }
    @Override
    public void addAssessment(Employee employee, String assessment) {
        IHREmployee.super.addAssessment(employee, assessment);
    }
    @Override
    public double getYearlySalary(){
        return super.getYearlySalary()+presidentsBonus;
    }
}
