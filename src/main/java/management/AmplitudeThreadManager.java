package management;

import data.AmplitudeBatch;
import data.AmplitudeException;
import logging.AmplitudeLogger;

import java.util.concurrent.*;

public class AmplitudeThreadManager {

    private final AmplitudeClient client;
    private final AmplitudeLogger logger;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public AmplitudeThreadManager(AmplitudeClient client, AmplitudeLogger logger) {
        this.logger = logger;
        this.client = client;
    }

    public void start(int periodInSeconds) {
        executor.submit(new SheduleThread(client, periodInSeconds));
    }

    class SheduleThread implements Runnable{
        private final AmplitudeClient client;
        private final int period;
        private boolean stopped = false;

        public SheduleThread(AmplitudeClient client, int periodInSeconds) {
            this.client = client;
            this.period = periodInSeconds*1000;
        }

        @Override
        public void run() {
            System.out.println("schedule started with " + period/1000 + " seconds period");
            while (!stopped) {
                try {
                    client.send();
                    Thread.sleep(period);
                } catch (AmplitudeException | InterruptedException e) {
                    logger.error("error :" + e.getMessage());
                }
            }
        }
    }

}
