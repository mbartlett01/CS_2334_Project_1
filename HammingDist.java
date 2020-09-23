/**
 * This class finds the Hamming Distance between different city codes as well
 * as how many other city codes share that same distance
 * @author Michael Bartlett
 * @version 0.1
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HammingDist
{
	//Class variables
	private static ArrayList<String> cityCodes = new ArrayList<String>();
	private static final String NORMAN_CODE = "NRMN";
	private static final String FILENAME = "Mesonet.txt";
	
	//Instance variables
	private String city1;
	private String city2;
	private int city1Dist;
	private int city2Dist;
	private int numCities1;
	private int numCities2;
	
	/**
	 * @param city1 The first city to compare to NRMN
	 * @param city2 The second city to compare to NRMN
	 * @throws FileNotFoundException
	 */
	public HammingDist(String city1, String city2) throws FileNotFoundException
	{
		this.city1 = city1;
		this.city2 = city2;
		
		//Read in the city codes if they aren't already initialized
		if(cityCodes.size() == 0)
		{
			readInCodes(FILENAME);
		}
		
		//Set the other variables
		city1Dist = findHammingDist(NORMAN_CODE, city1);
		city2Dist = findHammingDist(NORMAN_CODE, city2);
		numCities1 = findNumCities(city1, city1Dist);
		numCities2 = findNumCities(city2, city2Dist);
	}
	
	private void readInCodes(String filename) throws FileNotFoundException
	{
		//Create the Scanner
		Scanner data = new Scanner(new File(filename));
		
		//Skip over the first few lines to get to the actual city codes
		for(int i = 0; i < 5; i++)
		{
			if(data.hasNextLine())
			{
				data.nextLine();
			}
		}
		
		//Read all the codes into the ArrayList
		while(data.hasNextLine())
		{
			cityCodes.add(data.next());
			data.nextLine();
		}
	}
	
	private int findHammingDist(String string1, String string2)
	{
		int hammingDist = 0;
		
		//Make sure the strings are the same length
		if(string1.length() != string2.length())
		{
			return -1;
		}
		
		//Loop over the two strings to make sure they are equal
		for(int i = 0; i < string1.length(); i++)
		{
			if(string1.charAt(i) != string2.charAt(i))
			{
				hammingDist += 1;
			}
		}
		return hammingDist;
	}
	
	private int findNumCities(String city, int hammingDist)
	{
		//Loop through the cities and see if their Hamming distance is equal to the input amount
		int numCities = 0;
		
		for(int i = 0; i < cityCodes.size(); i++)
		{
			if(findHammingDist(city, cityCodes.get(i)) == hammingDist)
			{
				numCities += 1;
			}
		}
		
		return numCities;
		
	}
	
	/**
	 * @return returns the distance between Norman and the cities as well as how many other cities share that distance
	 */
	public String toString()
	{
		return "The Hamming distance between Norman and " + city1 + " is " + city1Dist
				+ "; between Norman and " + city2 + " is " + city2Dist + ".\n"
				+ "For " + city1 + ": Number of stations with Hamming Distance " + city1Dist + ": " + numCities1 + ".\n"
				+ "For " + city2 + ": Number of stations with Hamming Distance " + city2Dist + ": " + numCities2 + ".";
	}
}