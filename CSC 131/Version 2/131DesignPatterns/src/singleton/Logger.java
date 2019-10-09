package singleton;

public class Logger {

	private static Logger instance = new Logger();

	private Logger() {
	}

	public static Logger getInstance() {
		return instance;
	}

}