package app;
import grading.*;
import java.util.*;

/**
 * An application for calculating the numeric grade for
 * a course from the grades on individual assignments.
 * 
 * This version assumes that the course is structured as follows:
 * 
 *   6 programming assignments (PAs) accounting for 40% of the course grade
 *   after the lowest grade is dropped.
 *   
 *   5 homework assignments (HWs) accounting for 10% of the course grade.
 *   
 *   1 mid-term exam (Midterm) accounting for 20% of the course grade.
 *   
 *   1 final exam (Final) accounting for 30% of the course grade.
 * 
 * @version 1.0
 * @author  Sagacious Media
 *
 */
public class Gradient
{
	/**
	 * The entry point for the application.
	 * 
	 * @param args The 13 grades (ordered as above). Missing grades can be entered as "NA".
	 */
	public static void main(String[] args)
	{
		Filter                   paFilter;        
		Grade                    courseGrade, hwGrade, paGrade;
		GradingStrategy          courseStrategy, hwStrategy, paStrategy;
		List<Grade>              grades, hws, pas;
		Map<String, Double>      courseWeights;

		// Early exit
		if ((args == null) || (args.length != 13))
		{
			System.err.println("You must enter all 13 grades. (Use NA for missing.)");
			System.exit(1);
		}

		// Create the filter and strategy for PAs
		paFilter   = new DropFilter(true, false);
		paStrategy = new TotalStrategy();

		// Create the strategy for HWs
		hwStrategy = new TotalStrategy();

		// Create the weights and strategy for the course grade
		courseWeights = new HashMap<String, Double>();
		courseWeights.put("PAs",     0.4);
		courseWeights.put("HWs",     0.1);
		courseWeights.put("Midterm", 0.2);
		courseWeights.put("Final",   0.3);
		courseStrategy = new WeightedTotalStrategy(courseWeights);

		try
		{
			// Put the PA grades in a List
			pas = new ArrayList<Grade>();
			for (int i=0; i<6; i++) 
			{
				pas.add(parseGrade("PA"+(i+1), args[i]));
			}

			// Calculate the PA grade (after filtering)
			paGrade = paStrategy.calculate("PAs", paFilter.apply(pas));

			// Put the HW grades in a List
			hws = new ArrayList<Grade>();
			for (int i=0; i<5; i++)
			{
				hws.add(parseGrade("HW"+(i+1), args[i+6]));
			}

			// Calculate the HW grade
			hwGrade = hwStrategy.calculate("HWs", hws);

			// Put all of the grades in a List
			grades = new ArrayList<Grade>();
			grades.add(paGrade);
			grades.add(hwGrade);
			grades.add(parseGrade("Midterm", args[11]));
			grades.add(parseGrade("Final",   args[12]));

			// Calculate the final grade
			courseGrade = courseStrategy.calculate("Course Grade", grades);

			// Display the final grade
			System.out.println(courseGrade.toString());        
		}
		catch (SizeException se)
		{
			System.out.println("You entered too few valid grades.");
		}
		catch (IllegalArgumentException iae)
		{
			// Should never get here since all keys should be valid
		}
	}
	
	/**
	 * Construct a Grade object from a key and a String representation of
	 * its value. If the String representation of the value is null or not a valid
	 * double then the resulting Grade will have a missing value.
	 * 
	 * @param key   The key for the Grade
	 * @param value The String representation of the value
	 * @return      The corresponding Grade object
	 * @throws IllegalArgumentException if the key is invalid
	 */
	private static Grade parseGrade(String key, String value) throws IllegalArgumentException
	{
		Grade  result;
		
		try
		{
			Double v;
			if (value == null) v = null;
			else v = new Double(Double.parseDouble(value));
			
			result = new Grade(key, v);
		}
		catch (NumberFormatException nfe)
		{
			result = new Grade(key, null);
		}
		
		return result;
	}
}