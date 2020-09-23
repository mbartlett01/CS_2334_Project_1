import java.util.ArrayList;

public class HammingDist
{
	//Class variables
	private static ArrayList<String> cityCodes = new ArrayList<String>();
	private static final String normanCode = "NRMN";
	private static final String fileName = "Mesonet.txt";
	
	//Instance variables
	private String city1;
	private String city2;
	private int city1Dist;
	private int city2Dist;
	
	
	public HammingDist(String city1, String city2)
	{
		this.city1 = city1;
		this.city2 = city2;
		
		//Read in the city codes
		readInCodes();
	}
}