package factory2;

public class LoggerFactory {

	private LoggerFactory() {
	}

	public static Logger getLogger(LoggerType loggerType) {
		Logger logger;

		switch (loggerType) {
		case DATABASE:
			logger = new DatabaseLogger();
			break;
		default:
			logger = new FileLogger();
		}
		return logger;
	}

	public enum LoggerType {
		DATABASE, FILE;
	}
}
