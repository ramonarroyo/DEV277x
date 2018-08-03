

abstract class TechnicalEmployee extends Employee {
    public int checkIns;

    public TechnicalEmployee(String name){
        super(name, 75000);
    }
    public String employeeStatus(){
        return getName() + " (ID: " + getEmployeeID() + ") has " + checkIns + " successful check ins";
    }
}
