package management;

import data.AmplitudeEvent;
import data.AmplitudeException;
import management.AmplitudeClient;

public class Amplitude {

    private final String API_KEY;
    private final AmplitudeClient client;

    public Amplitude(String API_KEY) {
        this.API_KEY = API_KEY;
        client = new AmplitudeClient(API_KEY);
    }

    public void event(AmplitudeEvent event) throws AmplitudeException {
        client.addEvent(event);
    }

}
