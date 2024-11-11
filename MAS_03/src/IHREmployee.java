import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface IHREmployee {
    public default void addAssessment(Employee employee, String assessment){
        HRDepartament.employeeAssessment.put(assessment, employee);
    }

}
