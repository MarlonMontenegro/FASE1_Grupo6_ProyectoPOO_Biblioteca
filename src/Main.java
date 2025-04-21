package src;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Esto es un mensaje de INFO");
        logger.warn("Esto es un mensaje de WARNING");
        logger.error("Esto es un mensaje de ERROR simulado");
    }
}