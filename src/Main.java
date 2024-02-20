import java.util.Random;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static ArrayList<Employee> employeesCreator(int n) {
        ArrayList<Employee> employees = new ArrayList<>();
        Random rand = new Random();
        final String[] FIRST_NAME_ARRAY = {"guy", "eden", "dan", "dor", "ben", "shay", "roi", "itzik", "israel",
                "anat", "ronit", "ron", "shani", "eyal", "israel", "maya"};
        final String[] LAST_NAME_ARRAY = {"levy", "cohen", "ashkenzi", "mizrahi", "dan", "gur", "parker"};
        final String[] ADDRESS_ARRAY = {"ashdod", "tel aviv", "jerusalem", "akko", "bnei brak", "gedera",
                "hedera", "haifa"};
        for (int i = 0; i < n; i++) {
            int age = rand.nextInt(18, 65); // age between 18 and 65
            int idNumber = rand.nextInt(0, 100000000);
            int salary = rand.nextInt(5000, 30000); // salary between 5k and 30k
            long phoneNumber = rand.nextLong(10000000,99999999);
            String firstName = FIRST_NAME_ARRAY[rand.nextInt(FIRST_NAME_ARRAY.length)];
            String lastName = LAST_NAME_ARRAY[rand.nextInt(LAST_NAME_ARRAY.length)];
            String address = ADDRESS_ARRAY[rand.nextInt(ADDRESS_ARRAY.length)];

            Employee employee = new Employee(firstName, lastName, address, age, idNumber, salary, phoneNumber);
            employees.add(employee);
        }
        return employees;
    }

    /*
    public static ArrayList<Employee> bubbleSort(ArrayList<Employee> employees) {
        ArrayList<Employee> sortedEmployees = new ArrayList<>(employees);
        long startTime = System.currentTimeMillis();
        int n = sortedEmployees.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedEmployees.get(j).getSalary() > sortedEmployees.get(j + 1).getSalary()) {
                    Employee temp = sortedEmployees.get(j);
                    sortedEmployees.set(j, sortedEmployees.get(j + 1));
                    sortedEmployees.set(j + 1, temp);
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long totalSortTime = endTime - startTime;

        System.out.println("Sorted array by original bubble sort");
        System.out.println("Time taken to sort: " + totalSortTime + " milliseconds");
        return sortedEmployees;
    }
     */

    public static ArrayList<Employee> reFactorSort(ArrayList<Employee> employees) {
        ArrayList<Employee> sortedEmployees = new ArrayList<>(employees);
        long startTime = System.currentTimeMillis();
        reFactorSortHelper(sortedEmployees, 0, sortedEmployees.size() - 1);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Sorted array by quick sort");
        System.out.println("Time taken to sort:" + totalTime + " milliseconds");
        return sortedEmployees;
    }

    private static void reFactorSortHelper(ArrayList<Employee> employees, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(employees, low, high);
            reFactorSortHelper(employees, low, partitionIndex - 1);
            reFactorSortHelper(employees, partitionIndex + 1, high);
        }
    }

    private static int partition(ArrayList<Employee> employees, int low, int high) {
        Employee pivot = employees.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (employees.get(j).getSalary() < pivot.getSalary()) {
                i++;
                Employee temp = employees.get(i);
                employees.set(i, employees.get(j));
                employees.set(j, temp);
            }
        }
        Employee temp = employees.get(i + 1);
        employees.set(i + 1, employees.get(high));
        employees.set(high, temp);
        return i + 1;
    }

    public static void printEmployees(ArrayList<Employee> employees) {
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = employeesCreator(10000);
        //ArrayList<Employee> sortedEmployees = bubbleSort(employees);
        ArrayList<Employee> sortedEmployees = reFactorSort(employees);
        printEmployees(sortedEmployees);
    }
}