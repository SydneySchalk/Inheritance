import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
   private Person person;

   @Before
   public void setUp() {
      person = new Person("000005", "John", "Doe", "Mr.", 1990);
   }

   @Test
   public void testConstructor() {
      assertEquals("000005", person.getIDNum());
      assertEquals("John", person.getFirstName());
      assertEquals("Doe", person.getLastName());
      assertEquals("Mr.", person.getTitle());
      assertEquals(1990, person.getYOB());
   }

   @Test
   public void testSetIDNum() {
      person.setIDNum("000007");
      assertEquals("000007", person.getIDNum());
   }

   @Test
   public void testSetFirstName() {
      person.setFirstName("Alice");
      assertEquals("Alice", person.getFirstName());
   }

   @Test
   public void testSetLastName() {
      person.setLastName("Smith");
      assertEquals("Smith", person.getLastName());
   }

   @Test
   public void testSetTitle() {
      person.setTitle("Ms.");
      assertEquals("Ms.", person.getTitle());
   }

   @Test
   public void testSetYOB() {
      person.setYOB(1985);
      assertEquals(1985, person.getYOB());
   }
   @Test
   public void testFullName() {
      assertEquals("John Doe", person.fullName());
   }

   @Test
   public void testFormalName() {
      assertEquals("Mr. John Doe", person.formalName());
   }

   @Test
   public void testGetAge() {
      assertEquals("33", person.getAge(2023));
   }

   @Test
   public void testGetAgeForCurrentYear() {
      assertEquals("33", person.getAge());
   }

   @Test
   public void testToCSVDataRecord() {
      assertEquals("000005,John,Doe,Mr.,1990", person.toCSVDataRecord());
   }

}
