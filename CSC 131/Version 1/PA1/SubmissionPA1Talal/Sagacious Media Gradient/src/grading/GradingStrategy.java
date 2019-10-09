package grading;
import java.util.*;

public interface GradingStrategy
{
	
	public grading.Grade calculate(String key, List<grading.Grade> grades) throws SizeException;
	
}




