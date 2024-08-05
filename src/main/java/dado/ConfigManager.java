package dado;


public class ConfigManager {
    private static ConfigManager instance;
    private static String logFormat = "XML";


    private ConfigManager() {
        // Valores padrão

    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public static String getLogFormat() {
        return logFormat;
    }

    public static void setLogFormat(String logFormatt) {
        logFormat = logFormatt;
    }

}

