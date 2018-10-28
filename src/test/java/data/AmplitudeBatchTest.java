package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AmplitudeBatchTest {

    @Test
    public void test() {
        AmplitudeBatch batch = new AmplitudeBatch("testapikey");

        AmplitudeEvent stepanov = new AmplitudeEvent()
                .withEventType("joke")
                .withApp_version("1.0.0")
                .withCity("Moscow")
                .withCountry("Russia")
                .withIp("127.0.0.1")
                .withPlatform(AmplitudePlatform.Web)
                .withEventType("test event")
                .withRegion("Moscow")
                .withUserId("StepanovSA");
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
                .withUserId("ChervotkinaA");
        chervotkina.addEventProperty("thirdEventProperty","first");
        chervotkina.addEventProperty("fourthEventProperty",200);
        batch.addEvent(chervotkina);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(batch));

    }
}