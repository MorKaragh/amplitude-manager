package management;

import data.AmplitudeBatch;
import data.AmplitudeEvent;
import data.AmplitudeException;
import http.AmplitudeHttpClient;
import http.AmplitudeResponse;
import logging.AmplitudeLogger;

public class AmplitudeClient {

    private final String API_KEY;
    private final AmplitudeLogger logger;
    private AmplitudeHttpClient httpClient = new AmplitudeHttpClient();
    private AmplitudeBatch batch;
    private int maxSize;

    public AmplitudeClient(String API_KEY, int maxBatchSize, AmplitudeLogger logger) {
        this.API_KEY = API_KEY;
        batch = new AmplitudeBatch(API_KEY);
        this.logger = logger;
        this.maxSize = maxBatchSize;
    }

    public void addEvent(AmplitudeEvent event) throws AmplitudeException {
        logger.info("adding event");
        batch.addEvent(event);
        if (batch.size() >= maxSize) {
            logger.info("sending batch because of size limitation reached");
            sendBatch(batch);
        }
    }

    public void send() throws AmplitudeException {
        if (!batch.isEmpty()){
            sendBatch(batch);
        } else {
            System.out.println("no events to send");
        }
    }

    private AmplitudeResponse sendBatch(AmplitudeBatch batch) throws AmplitudeException {
        logger.info("sending batch of " + batch.size() + " events");
        AmplitudeResponse response = httpClient.sendBatch(batch);
        logger.info(response.toString());
        batch.clear();
        return response;
    }

}
