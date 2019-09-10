package grading;
import java.util.*;
public interface Filter {
	
	public List<Grade> apply(List<Grade> grades) throws SizeException;
	

}
