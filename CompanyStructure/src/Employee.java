

abstract class Employee {
    private String name;
    private double baseSalary;
    private int employeeID;
    private Employee manager;
    private static int employees;

    public Employee(String name, double baseSalary){
        employees++;
        this.name = name;
        this.baseSalary = baseSalary;
        this.employeeID = employees;
    }
    public double getBaseSalary(){
        return this.baseSalary;
    }
    public void setBaseSalary(double baseSalary){
        this.baseSalary = baseSalary;
    }
    public String getName(){
        return this.name;
    }
    public int getEmployeeID(){
        return this.employeeID;
    }
    public Employee getManager(){
        return this.manager;
    }
    public boolean equals(Employee other){
        return this.employeeID == other.employeeID;
    }
    public String toString(){
        return "Name, salary, ID, manager: " + name + ", " + baseSalary + ", " + employeeID + ", " + manager;
    }
    abstract String employeeStatus();
}
