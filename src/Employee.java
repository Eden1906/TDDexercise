public class Employee {

    private final String first_name;
    private final String last_name;
    private final String address;
    private final int age;
    private final int id_number;
    private final int salary;
    private final long phone_number;

    public Employee(String first_name, String last_name, String address, int age, int id_number, int salary,
                    long phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.age = age;
        this.id_number = id_number;
        this.salary = salary;
        this.phone_number = phone_number;
    }

    public int getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "NAME: " + first_name + ' ' + last_name + ", "
                + "ADDRESS: " + address +
                ", AGE: " + age +
                ", ID: " + id_number + ", " +
                "PHONE NUMBER: " + "05" + phone_number +
                ", SALARY: " + salary +
                '}';
    }
}
