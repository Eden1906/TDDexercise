import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;

public class RecordsLossTest {
    @Test

    public void testIfSortDoesNotLossRecords() {
        ArrayList<Employee> unsortedEmployees = Main.employeesCreator(100);
        ArrayList<Employee> sortedEmployees = Main.bubbleSort(unsortedEmployees);
        assertEquals(sortedEmployees.size(), unsortedEmployees.size());
    }
}
