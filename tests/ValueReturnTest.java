import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ValueReturnTest {
    @Test

    public void Test() {
        ArrayList<Employee> unsortedEmployees = Main.employeesCreator(10);
        ArrayList<Employee> sortedEmployees = Main.bubbleSort(unsortedEmployees);
        Assert.assertNotNull("Sorted employees array should not be null", sortedEmployees);
    }
}
