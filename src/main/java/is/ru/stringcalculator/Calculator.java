package is.ru.stringcalculator;

import java.util.*;

public class Calculator {

	public static int add(String text) throws Exception{
		if(text.contains("-")){
			throw new Exception(text);
		}
		if(text.equals("")){
			return 0;
		}
		else{
			return sum(splitByManyD(text));
		}
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
    	work = work.replace("//", "");
 
    	String work2 = first[1];
    	String [] splitdel = work.split("]");
    	String deLim = "";
   
    	for(int i = 0; i < splitdel.length; i++){
    		deLim = deLim + splitdel[i].substring(splitdel[i].indexOf("[") + 1, splitdel[i].length()) + "|";
    	}
    	deLim = deLim.substring(0, deLim.length() - 1);
    	return work2.split(deLim);
    }


}