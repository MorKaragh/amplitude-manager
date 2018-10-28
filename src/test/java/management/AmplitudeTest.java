package management;

import data.AmplitudeEvent;
import data.AmplitudeException;
import data.AmplitudePlatform;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmplitudeTest {

    @Test
    public void test(){
        Amplitude amplitude = new Amplitude(new AmplitudeSettings() {
            @Override
            public String getApiKey() {
                return "*****";
            }

            @Override
            public int getPeriodInSeconds() {
                return 2;
            }

            @Override
            public int getMaxBatchSize() {
                return 2;
            }
        });
        amplitude.startSendingBySchedule();
        try {
            amplitude.event(getAmplitudeEvent());
            Thread.sleep(3000);
            amplitude.event(getAmplitudeEvent());
            Thread.sleep(3000);
            amplitude.event(getAmplitudeEvent());
            amplitude.event(getAmplitudeEvent());
            amplitude.event(getAmplitudeEvent());
            Thread.sleep(10000);
        } catch (AmplitudeException | InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    private AmplitudeEvent getAmplitudeEvent() {
        AmplitudeEvent e = new AmplitudeEvent()
                .withEventType("joke")
                .withApp_version("1.0.0")
                .withCity("Moscow")
                .withCountry("Russia")
                .withIp("127.0.0.1")
                .withPlatform(AmplitudePlatform.Web)
                .withEventType("test event")
                .withRegion("Moscow")
                .withUserId("Ololoev");
        e.addEventProperty("firstEventProperty","first");
        e.addEventProperty("secondEventProperty",1.5);
        return e;
    }

}