package data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AmplitudeEvent {

    private String user_id;
    private String event_type;
    private Long time = System.currentTimeMillis() / 1000L;
    private String app_version;
    private String country;
    private String region;
    private String city;
    private String ip;
    private String insert_id = UUID.randomUUID().toString();
    private AmplitudePlatform platform;

    private Map<String, Object> user_properties = new HashMap<>();
    private Map<String, Object> event_properties = new HashMap<>();


    public void addUserProperty(String name, Object val) {
        user_properties.put(name, val);
    }

    public void addEventProperty(String name, Object val) {
        event_properties.put(name, val);
    }

    public AmplitudeEvent withUserId(String userId) {
        this.user_id = userId;
        return this;
    }

    public AmplitudeEvent withEventType(String eventType) {
        this.event_type = eventType;
        return this;
    }

    public AmplitudeEvent withTime(Long time) {
        this.time = time;
        return this;
    }

    public AmplitudeEvent withApp_version(String app_version) {
        this.app_version = app_version;
        return this;
    }

    public AmplitudeEvent withCountry(String country) {
        this.country = country;
        return this;
    }

    public AmplitudeEvent withRegion(String region) {
        this.region = region;
        return this;
    }

    public AmplitudeEvent withCity(String city) {
        this.city = city;
        return this;
    }

    public AmplitudeEvent withIp(String ip) {
        this.ip = ip;
        return this;
    }

    public AmplitudeEvent withPlatform(AmplitudePlatform platform) {
        this.platform = platform;
        return this;
    }

}
