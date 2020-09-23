import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.print.DocFlavor.STRING;

public class DateTimeOne
{
	public void dateTimeNow() 
	{
		//Date/time object for date/time
		DateTimeFormatter formattedDateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
		LocalDateTime showDateTime = LocalDateTime.now();
		String formattedDateTimeFinal = showDateTime.format(formattedDateTime);
	    System.out.println("Current Date/Time: " + formattedDateTimeFinal);	    
	}
	
	public int getValueOfSecond()
	{
		System.out.println("getValueOfSeconds just ran");
		return 2;
	}
	
	public void sleepForThreeSec()
	{
		System.out.println("sleepForThreeSec just ran");
	}
	
	
}