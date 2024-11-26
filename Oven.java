import java.io.FileWriter;

public class Oven {
    private final int batchNumber;
    private final FileWriter logFile;

    public Oven(int batchNumber, FileWriter logFile) {
        this.batchNumber = batchNumber;
        this.logFile = logFile;
    }

    public void bake() {
        try {
            Logger.log("Preparazione e cottura di 400 mattoni (batch " + batchNumber + ").", logFile);
            Thread.sleep(1000);
            Logger.log("Batch " + batchNumber + " cotto e pronto per l'imballaggio.", logFile);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
