package employee;

public class PartTimeEmployee extends Employee{
    int workingHour;

    public PartTimeEmployee() {
    }

    @Override
    public int getRealSalary() {
        return workingHour*100000;
    }

    public PartTimeEmployee(String id, String name, int age, int phone, String email,int workingHour) {
        super(id, name, age, phone, email);
        this.workingHour=workingHour;
    }

    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{"+
                super.toString() +
                ", workingHour=" + workingHour +
                "} " ;
    }
}
