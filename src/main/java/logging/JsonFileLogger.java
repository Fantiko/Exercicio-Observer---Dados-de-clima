package logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonFileLogger implements Logger {
    private String filePath;
    private ObjectMapper objectMapper;

    public JsonFileLogger(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void logOperacao(String operacao) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDate = agora.format(formatter);

            LogEntry logEntry = new LogEntry(formattedDate, operacao);
            String jsonLog = objectMapper.writeValueAsString(logEntry);

            writer.write(jsonLog + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class LogEntry {
        public String timestamp;
        public String operacao;

        public LogEntry(String timestamp, String operacao) {
            this.timestamp = timestamp;
            this.operacao = operacao;
        }
    }
}
