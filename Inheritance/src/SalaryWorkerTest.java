import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SalaryWorkerTest {
   private Person.Worker.SalaryWorker salaryWorker;

   @Before
   public void setUp() {
      salaryWorker = new Person.Worker.SalaryWorker("4", "Jane", "Brown", "Ms.", 1982, 0.0, 75000.0);
   }

   @Test
   public void testGetFullName() {
      assertEquals("Jane Brown", salaryWorker.getFullName());
   }

   @Test
   public void testCalculateWeeklyPay() {
      assertEquals(1442.31, salaryWorker.calculateWeeklyPay(0), 0.01);
   }

   @Test
   public void testCalculateWeeklyPayWithZeroAnnualSalary() {
      Person.Worker.SalaryWorker zeroSalaryWorker = new Person.Worker.SalaryWorker("5", "Alice", "Smith", "Ms.", 1990, 0.0, 0.0);
      assertEquals(0.0, zeroSalaryWorker.calculateWeeklyPay(0), 0.01);
   }

}
