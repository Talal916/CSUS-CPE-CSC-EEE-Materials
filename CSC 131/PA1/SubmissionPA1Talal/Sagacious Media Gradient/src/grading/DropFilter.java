package grading;
import java.util.*;

public class DropFilter {
	
	private boolean shouldDropLowest;
	private boolean shouldDropHighest;
	
	public DropFilter()
	{
		
	}
	
	public DropFilter(boolean shouldDropLowest, boolean shouldDropHighest)
	{
		
	}
	
	public List<Grade> apply(List<Grade> grades) throws SizeException 
	{
		return grades;
		
	}

}
