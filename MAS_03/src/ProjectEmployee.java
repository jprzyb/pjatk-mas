import java.util.ArrayList;
import java.util.List;

public class ProjectEmployee extends Employee{

    private List<ProjectEmployeeType> projectEmployeeTypes;
    private List<ProjectEmployee> employees;

    public ProjectEmployee(String firstName, String lastName, MyDate birthDate,char militaryCategory, double salary, ProjectEmployeeType type) {
        super(firstName, lastName, birthDate, militaryCategory, salary);
        projectEmployeeTypes = new ArrayList<>(2);
        this.projectEmployeeTypes.add(type);
        if(type.equals(ProjectEmployeeType.MANAGER)){
            employees = new ArrayList<>();
        }
    }

    public ProjectEmployee(String firstName, String lastName, MyDate birthDate, String maidenName, double salary, ProjectEmployeeType type) {
        super(firstName, lastName, birthDate, maidenName, salary);
        projectEmployeeTypes = new ArrayList<>(2);
        this.projectEmployeeTypes.add(type);
        if(type.equals(ProjectEmployeeType.MANAGER)){
            employees = new ArrayList<>();
        }
    }

    public void addEmployee(ProjectEmployee employee){

        if(projectEmployeeTypes.contains(ProjectEmployeeType.MANAGER)){
            employees.add(employee);
        }
        else{
            try {
                throw new Exception("No permission to add new Employee to your team!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void showEmployee(){
        if(projectEmployeeTypes.contains(ProjectEmployeeType.MANAGER)){
            System.out.println(this + "\nhas cooworkers: ");
            for(ProjectEmployee e : employees){
                System.out.println(e);
            }
        }
        else{
            try {
                throw new Exception("No permission to show employee on your team!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public String toString() {
        return super.toString("\", projectEmployeeTypes=" + projectEmployeeTypes + '\'');
    }
    public void addType(ProjectEmployeeType type){
        if(projectEmployeeTypes.contains(type) || projectEmployeeTypes.size() == 2){
            System.out.println("Project employee already is " + type);
        }
        else projectEmployeeTypes.add(type);
    }
    public void removeType(ProjectEmployeeType type){
       if(projectEmployeeTypes.contains(type)){
           projectEmployeeTypes.remove(type);
       }
    }
}
