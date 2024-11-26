import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final int TOTAL_BRICKS = 1600;
    private static final int OVEN_CAPACITY = 400;

    public static void main(String[] args) {
        try (FileWriter logFile = new FileWriter("brick_production_log.txt")) {
            Logger.log("Inizio processo di produzione mattoni.", logFile);

            // Fase 1: Mescolatrici
            Logger.log("Fase 1: Preparazione della malta con 8 mescolatrici.", logFile);
            Thread[] mixers = new Thread[8];
            for (int i = 0; i < mixers.length; i++) {
                int mixerId = i + 1;
                mixers[i] = new Thread(new Mixer(mixerId, logFile));
                mixers[i].start();
            }

            for (Thread mixer : mixers) {
                mixer.join();
            }
            Logger.log("Fase 1 completata: Malta pronta per gli stampi.", logFile);

            Logger.log("Fase 2: Stampo e cottura dei mattoni.", logFile);
            for (int i = 0; i < TOTAL_BRICKS / OVEN_CAPACITY; i++) {
                new Oven(i + 1, logFile).bake();
            }
            Logger.log("Fase 2 completata: Tutti i mattoni sono stati cotti.", logFile);

            Logger.log("Fase 3: Imballaggio di 1600 mattoni.", logFile);
            Thread.sleep(1000);
            Logger.log("Fase 3 completata: Mattoni imballati e pronti per il magazzino.", logFile);

            Logger.log("Processo di produzione completato con successo.", logFile);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
