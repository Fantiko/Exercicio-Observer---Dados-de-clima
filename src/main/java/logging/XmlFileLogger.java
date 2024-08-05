package logging;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class XmlFileLogger implements Logger {
    private String filePath;
    private JAXBContext jaxbContext;

    public XmlFileLogger(String filePath) {
        this.filePath = filePath;
        try {
            this.jaxbContext = JAXBContext.newInstance(LogEntry.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logOperacao(String operacao) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDate = agora.format(formatter);

            LogEntry logEntry = new LogEntry(formattedDate, operacao);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(logEntry, writer);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    @XmlRootElement
    static class LogEntry {
        private String timestamp;
        private String operacao;

        public LogEntry() {
        }

        public LogEntry(String timestamp, String operacao) {
            this.timestamp = timestamp;
            this.operacao = operacao;
        }

        @XmlElement
        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        @XmlElement
        public String getOperacao() {
            return operacao;
        }

        public void setOperacao(String operacao) {
            this.operacao = operacao;
        }
    }
}
