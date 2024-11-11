
public abstract class Employee {
    String firstName;
    String lastName;
    MyDate birthDate;
    Gender gender;
    Character militaryCategory;
    String maidenName;
    double salary;
    public Employee(String firstName, String lastName, MyDate birthDate, Character militaryCategory, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = Gender.MALE;
        this.militaryCategory = militaryCategory;
        this.salary = salary;
    }
    public Employee(String firstName, String lastName, MyDate birthDate, String maidenName, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = Gender.FEMALE;
        this.maidenName = maidenName;
        this.salary = salary;
    }

    public String getMaidenName(){
        if(gender.equals(Gender.FEMALE)){
            return maidenName;
        }
        try {
            throw new Exception(firstName + " is "+ gender + " and males do not have maiden names!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public char getMilitaryCategory(){
        if(gender.equals(Gender.MALE)){
            return militaryCategory;
        }
        try {
            throw new Exception(firstName + " is "+ gender + " and females do not have military categories!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toString(String addMsg) {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                (gender.equals(Gender.FEMALE) ? ", maidenName='" + maidenName + '\'' : ", militaryCategory=" + militaryCategory) +
                ", salary=" + salary +
                addMsg +
                '}';
    }
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                (gender.equals(Gender.FEMALE) ? ", maidenName='" + maidenName + '\'' : ", militaryCategory=" + militaryCategory) +
                ", salary=" + salary +
                '}';
    }

    public double getYearlySalary() {
        return salary*12;
    }
}
