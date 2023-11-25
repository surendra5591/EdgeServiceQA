package POC_TestCases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Datevalidate {
	
	public static String GetTodaysDateandTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmm");  
		LocalDateTime now = LocalDateTime.now();    
		return dtf.format(now); 
		}
	
	public static String GetRandomnumber()
	{
        int size = 10000;
        Random rand = new Random();
        int number = rand.nextInt(size) + 1;
        return String.valueOf(number);
	}
	
	public static void main(String args[]) {
		System.out.println(GetTodaysDateandTime());
		System.out.println(GetRandomnumber());
	}

}
