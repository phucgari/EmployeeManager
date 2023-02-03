package employee;

public class FullTimeEmployee extends Employee{
    private int bonus;
    private int fine;
    private int salary;

    public FullTimeEmployee() {}

    @Override
    public int getRealSalary() {
        return salary+bonus-fine;
    }

    public FullTimeEmployee(String id, String name, int age, int phone, String email, int bonus, int fine, int salary) {
        super(id, name, age, phone, email);
        this.bonus = bonus;
        this.fine = fine;
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
