package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.*;
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
			
		}

	}
	@Test
	public void testOneNumber() {
		try{
			assertEquals(1, Calculator.add("1"));
		}
		catch(Exception exc) {
	
		}
	}

	@Test
	public void testTwoNumbers() {
		try{
			assertEquals(3, Calculator.add("1,2"));
	    }
		catch(Exception exc) {
	
		}
	}
	@Test
	public void testNewline() {
		try{
			assertEquals(3, Calculator.add("1\n,2"));
		}
		catch(Exception exc) {

		}
	}
	@Test
	public void testDelimiter() {
		try{
			assertEquals(3, Calculator.add("//;\n1;2"));
		}
		catch(Exception exc) {
		}
	}
	@Test 
	public void testMinus() {
		try{
			assertEquals(13, Calculator.add("5,-2,-6"));
		}
		catch(Exception exc) {
			String error = "" + exc.getMessage();
			List <Integer> results = new ArrayList();
			String thetext = "Negatives not allowed: ";
			for(int i = 0; i < error.length(); i++){
				if(error.charAt(i) == '-'){
					thetext = thetext + "-" + error.charAt(i+1);
					if((error.length() - 2) != i ){
						thetext = thetext + ",";
					}
				}

			}
			fail(thetext);
		}
	}
	@Test 
	public void testThousand() {
		try{
			assertEquals(1, Calculator.add("1001,1"));
		}
		catch(Exception exc) {
		
		}
	}
	@Test 
	public void anyLengthDelim() {
		try{
			assertEquals(20000, Calculator.add("//[!!!]\n1!!!2!!!3"));
		}
		catch(Exception exc) {
		
		}
	}
}

	
	