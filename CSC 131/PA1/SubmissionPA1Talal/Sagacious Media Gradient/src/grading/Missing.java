package grading;

public class Missing{
	
	private double DEFAULT_MISSING_VALUE = 0;
	
	public double doubleValue(Double number)
	{
		if(number != null)
			return number;
		else
			return DEFAULT_MISSING_VALUE;
	}
	
	public double doubleValue(Double number, double missingValue)
	{
		if(number != null)
			return number;
		else
			return missingValue;
	}
}
