package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) throws Exception{
		if(text.contains("-")){
			throw new Exception(text);
		}
		if(text.equals("")){
			return 0;
		}
		if(text.contains("[")){

			return sum(splitByManyD(text));
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.contains("/")){
			String deLimiter = "" + text.charAt(2); 
			return sum(splitbyDelim(text, deLimiter));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    numbers = numbers.replaceAll("\n", "");
	    return numbers.split("\\W+");
	}
      
    private static int sum(String[] numbers){   
 	    int total = 0;
        for(String number : numbers){
        	if(isbelowThousand(number)){
		    	total += toInt(number);
			}
		}
		return total;
    }
    private static String[] splitbyDelim(String numbers, String deLimiter){
    	String newstring = numbers.substring(4, 7);
    	return newstring.split(deLimiter);
    }
    private static boolean isbelowThousand(String number){
    	if(toInt(number) <= 1000){
    		return true;
    	}
   		return false;
    }
    private static String[] splitByManyD(String numbers){
    	String [] first = numbers.split("\\n");
    	String work = first[0].replace("*", "\\*");
    	String work2 = first[1];
    	String delimiter = work.substring(work.indexOf("[") + 1, work.indexOf("]"));
		String [] arr = work2.split(delimiter);
    	return work2.split(delimiter);
    }


}