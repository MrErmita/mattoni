import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    public static synchronized void log(String message, FileWriter logFile) {
        try {
            String logMessage = "[" + LocalDateTime.now() + "] " + message;
            logFile.write(logMessage + "\n");
            logFile.flush();
            System.out.println(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
