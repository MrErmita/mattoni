import java.io.FileWriter;

public class Mixer implements Runnable {
    private final int mixerId;
    private final FileWriter logFile;

    public Mixer(int mixerId, FileWriter logFile) {
        this.mixerId = mixerId;
        this.logFile = logFile;
    }

    @Override
    public void run() {
        try {
            Logger.log("Mescolatrice " + mixerId + " avviata.", logFile);
            Thread.sleep(1000);
            Logger.log("Mescolatrice " + mixerId + " completata.", logFile);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
