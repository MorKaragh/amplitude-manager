package management;

import data.AmplitudeBatch;
import data.AmplitudeEvent;
import data.AmplitudeException;
import http.AmplitudeHttpClient;
import http.AmplitudeResponse;
import org.apache.http.HttpEntity;

public class AmplitudeClient {

    private final String API_KEY;
    private AmplitudeHttpClient httpClient = new AmplitudeHttpClient();
    private AmplitudeBatch batch;
    private int maxSize = 1;

    public AmplitudeClient(String API_KEY) {
        this.API_KEY = API_KEY;
        batch = new AmplitudeBatch(API_KEY);
    }

    public void addEvent(AmplitudeEvent event) throws AmplitudeException {
        batch.addEvent(event);
        if (batch.size() >= maxSize){
            sendBatch(batch);
        }
    }

    AmplitudeResponse sendBatch(AmplitudeBatch batch) throws AmplitudeException {
        AmplitudeResponse response = httpClient.sendBatch(batch);
        this.batch.clear();
        return response;
    }

}
