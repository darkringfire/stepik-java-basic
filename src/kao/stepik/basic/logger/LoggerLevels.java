package kao.stepik.basic.logger;

import java.util.logging.*;

public class LoggerLevels {
    public static void main(String[] args) {
        configureLogging();
    }

    private static void configureLogging() {
        Logger logger = Logger.getLogger("org.stepic.java");
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");

        Formatter formatter = new XMLFormatter();

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(formatter);

        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
        loggerA.setLevel(Level.ALL);
        loggerB.setLevel(Level.WARNING);
    }
}
