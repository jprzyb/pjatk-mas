import java.util.Map;
import java.util.TreeMap;

public class HRDepartament {
    public static Map<String, Employee> employeeAssessment = new TreeMap<>();
    public static void showAssessments(){
        System.out.println(employeeAssessment);
    }
}
