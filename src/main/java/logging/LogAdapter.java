package logging;

public class LogAdapter {
    private Logger logger;

    public LogAdapter(Logger logger) {
        this.logger = logger;
    }

    public void logOperacao(String operacao) {
        logger.logOperacao(operacao);
    }
}
