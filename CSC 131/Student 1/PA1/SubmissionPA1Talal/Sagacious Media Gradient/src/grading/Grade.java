package grading;

public class Grade implements Comparable<Grade>{
	
	private java.lang.String key;
	private java.lang.Double value;
	
	public Grade(java.lang.String key) throws IllegalArgumentException
	{
		if(key == null)
			throw new IllegalArgumentException("Key is null");
		this.value = 0.0;
		
	}
	
	public Grade(java.lang.String key, double value) throws IllegalArgumentException
	{
		if(key == null)
			throw new IllegalArgumentException("Key is null");
		
	}

	public Grade(java.lang.String key, java.lang.Double value) throws IllegalArgumentException
	{
		if(key == null)
			throw new IllegalArgumentException("Key is null");
	}
	
	public java.lang.String getKey() // returns java.lang.String : key
	{
		return key;
	}
	
	public java.lang.Double getValue() 
	{
		return value;
	}

	public java.lang.String toString()
	{
		if(value != null)
			return (key+": "+value);
		else
			return (key+":  NA");
		
	}
	
	public int compareTo(Grade other)
	{
		if(this.value == null && other.value != null)
			return -1;
		if(this.value == null && other.value == null)
			return 0;
		if(this.value != null && other.value == null)
			return 1;
		if(this.value != null && other.value != null)
			return this.value.compareTo(other.value);
		return 2; // If conditions not satisfied, return 2 to signify error
			
	}
}
