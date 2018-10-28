package management;

import data.AmplitudeBatch;
import data.AmplitudeEvent;
import data.AmplitudeException;
import data.AmplitudePlatform;
import http.AmplitudeResponse;
import org.junit.jupiter.api.Test;

class AmplitudeClientTest {

    @Test
    public void sendTestEvent() throws AmplitudeException {
        AmplitudeClient amplitude = new AmplitudeClient("*****");
        AmplitudeResponse response = amplitude.sendBatch(createBatch());
        System.out.println(response.getStatus());
        System.out.println(response.getBody());
    }


    private AmplitudeBatch createBatch(){
        AmplitudeBatch batch = new AmplitudeBatch("*****");

        AmplitudeEvent stepanov = new AmplitudeEvent()
                .withEventType("joke")
                .withApp_version("1.0.0")
                .withCity("Moscow")
                .withCountry("Russia")
                .withIp("127.0.0.1")
                .withPlatform(AmplitudePlatform.Web)
                .withEventType("test event")
                .withRegion("Moscow")
                .withUserId("Ololoev");
        stepanov.addEventProperty("firstEventProperty","first");
        stepanov.addEventProperty("secondEventProperty",1.5);
        batch.addEvent(stepanov);

        AmplitudeEvent chervotkina = new AmplitudeEvent()
                .withEventType("laugh")
                .withApp_version("1.0.0")
                .withCity("Moscow")
                .withCountry("Russia")
                .withIp("127.0.0.1")
                .withPlatform(AmplitudePlatform.Web)
                .withEventType("test event")
                .withRegion("Moscow")
                .withUserId("Eotovna");
        chervotkina.addEventProperty("thirdEventProperty","first");
        chervotkina.addEventProperty("fourthEventProperty",200);
        batch.addEvent(chervotkina);
        return batch;
    }


}