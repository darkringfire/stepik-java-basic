package kao.stepik.basic.logger;

import java.util.logging.Logger;

public class LoggerDemo {
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.config.file", "conf/logging.properties");
        log = Logger.getLogger(LoggerDemo.class.getName());
    }

    public static void main(String[] args) {
        log.severe("SERVE");
        log.warning("WARNING");
        log.info("INFO");
        log.config("CONFIG");
        log.fine("FINE");
        log.finer("FINER");
        log.finest("FINEST");
    }

}
