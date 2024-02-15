import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ArrayIsSortedTest {
    @Test

    public void testIfArrayIsSorted() {
        ArrayList<Employee> unsortedEmployees = Main.employeesCreator(10);
        ArrayList<Employee> sortedEmployees = Main.bubbleSort(unsortedEmployees);

        for(int i = 0; i < sortedEmployees.size() - 1; i++) {
            assertTrue("Array is not sorted", sortedEmployees.get(i).getSalary() <=
                    sortedEmployees.get(i + 1).getSalary());
        }
    }
}
