package factory2;

import factory2.LoggerFactory.LoggerType;

public class Application {

	// Get logger of type DATABASE from logger factory
	private final Logger logger = LoggerFactory.getLogger(LoggerType.DATABASE);

	private void doSomething() {
		logger.log("Executing method doSomething()");
		// do something
	}

	public static void main(String[] args) {
		Application application = new Application();
		application.doSomething();
	}

}
