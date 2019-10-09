package factory2;

public class DatabaseLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println("Logging to database: " + message);
	}

}
