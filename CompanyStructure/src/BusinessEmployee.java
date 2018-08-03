
abstract class BusinessEmployee extends Employee{
    public double bonusBudget;

    public BusinessEmployee(String name){
        super(name, 50000);
    }
    public double getBonusBudget(){
        return Math.round(bonusBudget*100.0) / 100.0;
    }
    public String employeeStatus(){
        return getName() + " (ID: " + getEmployeeID() + ") with a budget of " + getBonusBudget();
    }
}
