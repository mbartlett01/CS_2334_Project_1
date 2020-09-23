import java.sql.Date;

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
}