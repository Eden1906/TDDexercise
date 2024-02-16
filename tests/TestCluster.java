import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class TestCluster {
    @Test
    public void testIfSortDoesNotLossRecords() {
        ArrayList<Employee> unsortedEmployees = Main.employeesCreator(100);
        ArrayList<Employee> sortedEmployees = Main.bubbleSort(unsortedEmployees);
        assertEquals(sortedEmployees.size(), unsortedEmployees.size());
    }
    @Test
    public void testIfArrayDontReturnNull() {
        ArrayList<Employee> unsortedEmployees = Main.employeesCreator(100);
        ArrayList<Employee> sortedEmployees = Main.bubbleSort(unsortedEmployees);
        Assert.assertNotNull("Sorted employees array should not be null", sortedEmployees);
    }
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
