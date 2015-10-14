package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		try{
			assertEquals(0, Calculator.add(""));
		}

		catch(Exception exc) {
			System.out.println("WTF");
		}

	}
	@Test
	public void testOneNumber() {
		try{
			assertEquals(1, Calculator.add("1"));
		}
		catch(Exception exc) {
			System.out.println("WTF");
		}
	}

	@Test
	public void testTwoNumbers() {
		try{
		assertEquals(3, Calculator.add("1,2"));
	    }
		catch(Exception exc) {
			System.out.println("WTF");
		}
	}
	@Test
	public void testNewline() {
		try{
		assertEquals(3, Calculator.add("1\n,2"));
		}
		catch(Exception exc) {
			System.out.println("WTF");
		}
	}
	@Test
	public void testDelimiter() {
		try{
		assertEquals(3, Calculator.add("//;\n1;2"));
		}
		catch(Exception exc) {
			System.out.println("WTF");
		}
	}
	@Test 
	public void testMinus() {
		try{
			assertEquals(3, Calculator.add("5,-2"));
		}
		catch(Exception exc) {
			System.out.println(exc.getMessage());
			fail("An exception was caught");
		}
	}
}

	
	