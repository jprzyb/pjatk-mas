public class Main {
    public static void main(String[] args) {
//        showMultiAspectInheritance();
//        showMultipleInheritance();
//        showOverlapping();
//        showDynamicInheritance();
    }

    private static void showMultiAspectInheritance(){
        System.out.println("\n========== MultiAspectInheritance ==========");
        //        String firstName, String lastName, MyDate birthDate, Gender gender, Character militaryCategory, double salary
        ProjectEmployee pem = new ProjectEmployee("Janek", "Dzbanek", new MyDate(1,1,1999), 'A', 5555.1, ProjectEmployeeType.EMPLOYEE);
        //        String firstName, String lastName, MyDate birthDate, Gender gender, String maidenName, double salary
        ProjectEmployee pef = new ProjectEmployee("Janka", "Dzbanka", new MyDate(2,2,1998), "Dudek", 4444.2, ProjectEmployeeType.MANAGER);

        System.out.println("Male employee: " + pem);
        System.out.println("Female employee: " + pef);

        System.out.println("Male employee militaryCategory: " + pem.getMilitaryCategory());
        try{
            System.out.println("Male employee maidenName: " + pem.getMaidenName());
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("Female employee maidenName: " + pef.getMilitaryCategory());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Female employee maidenName: " + pef.getMaidenName());
    }
    private static void showMultipleInheritance(){
        System.out.println("\n========== MultipleInheritance ==========");
        President president = new President("Andrzej", "Konewka", new MyDate(14,3,1989), 'G', 20110.99);
        System.out.println("President (male): "+president);
        ProjectEmployee pem = new ProjectEmployee("Janek", "Dzbanek", new MyDate(1,1,1999), 'A', 5555.1, ProjectEmployeeType.EMPLOYEE);
        System.out.println("Military category of president: "+ president.getMilitaryCategory());
        try{
            System.out.println("Maiden name of president: "+ president.getMaidenName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        president.addAssessment(pem, "Good employee");
        HRDepartament.showAssessments();
    }
    private static void showOverlapping(){
        System.out.println("\n========== Overlapping ==========");
        ProjectEmployee employee1 = new ProjectEmployee("Jan", "Nowak", new MyDate(10,10,2010),'C', 9999, ProjectEmployeeType.EMPLOYEE);
        ProjectEmployee employee2 = new ProjectEmployee("Anna", "Puchacz", new MyDate(11,10,2002), "Bylajakas", 8888, ProjectEmployeeType.EMPLOYEE);
        ProjectEmployee employee3 = new ProjectEmployee("Zuzanna", "Jakas", new MyDate(5,5,2005), "niewiadomo", 7777, ProjectEmployeeType.MANAGER);
        ProjectEmployee manager = new ProjectEmployee("Krzysztof", "Kowalski", new MyDate(11,11,1999), 'C', 10000, ProjectEmployeeType.MANAGER);
        manager.addEmployee(employee1);
        manager.addEmployee(employee2);
        manager.addEmployee(employee3);
        manager.showEmployee();

        try{
            System.out.println("trying to add employee to employee type person");
            employee1.addEmployee(employee2);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("trying to show employee to employee type person");
            employee1.showEmployee();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void showDynamicInheritance(){
        HRAccountant hrAccountant = new HRAccountant("aaaa", "aaaa", new MyDate(1,1,1), 'C', 1111);
        ResourcesAccountant resourcesAccountant = new ResourcesAccountant("bbbb", "bbbb", new MyDate(2,2,2),'C', 2222);
        ContractAccountant contractAccountant = new ContractAccountant("cccc", "cccc", new MyDate(3,3,3), 'C', 3333);
        System.out.println("hrAccountant: " + hrAccountant);
        System.out.println("resourcesAccountant: " + resourcesAccountant);
        System.out.println("contractAccountant: " + contractAccountant);
        System.out.println();

        HRAccountant HRfromRES = new HRAccountant(resourcesAccountant);
        HRAccountant HRfromCON = new HRAccountant(contractAccountant);
        System.out.println("dynamic Hr Accountant from Resources Accountant: " + HRfromRES);
        System.out.println("dynamic Hr Accountant from Contract Accountant: " + HRfromCON);
        System.out.println();

        ResourcesAccountant RESfromHR = new ResourcesAccountant(hrAccountant);
        ResourcesAccountant RESfromCON = new ResourcesAccountant(contractAccountant);
        System.out.println("dynamic Resources Accountant from HR Accountant: " + RESfromHR);
        System.out.println("dynamic Resources Accountant from Contract Accountant: " + RESfromCON);
        System.out.println();

        ContractAccountant CONfromRES = new ContractAccountant(resourcesAccountant);
        ContractAccountant CONfromHR = new ContractAccountant(hrAccountant);
        System.out.println("dynamic Contract Accountant from Resources Accountant: " + CONfromRES);
        System.out.println("dynamic Contract Accountant from HR Accountant: " + CONfromHR);
    }
}