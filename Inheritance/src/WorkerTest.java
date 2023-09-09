import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class WorkerTest {
   private Person.Worker worker;

   @Before
   public void setUp() {
      worker = new Person.Worker("1", "John", "Doe", "Mr.", 1990, 20.0);
   }

   @Test
   public void testGetFullName() {
      assertEquals("John Doe", worker.getFullName());
   }

   @Test
   public void testCalculateWeeklyPay() {
      assertEquals(800.0, worker.calculateWeeklyPay(40), 0.001);
      assertEquals(1100.0, worker.calculateWeeklyPay(50), 0.001);
   }

   @Test
   public void testCalculateWeeklyPayWithZeroHours() {
      assertEquals(0.0, worker.calculateWeeklyPay(0), 0.001);
   }
}
