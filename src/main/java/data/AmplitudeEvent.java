package data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AmplitudeEvent {

    private Long time = System.currentTimeMillis() / 1000L;
    private String insert_id = UUID.randomUUID().toString();

    private String user_id;
    private String device_id;
    private String event_type;
    private String app_version;
    private String country;
    private String region;
    private String city;
    private String dma;
    private String language;
    private String ip;
    private String os_name;
    private String os_version;
    private String device_brand;
    private String device_model;
    private String carrier;
    private String device_manufacturer;
    private Float price;
    private Float revenue;
    private Float location_lat;
    private Float location_lng;
    private Integer quantity;
    private String productId;
    private String revenueType;

    private AmplitudePlatform platform;

    private Map<String, Object> user_properties;
    private Map<String, Object> event_properties;
    private Map<String, Object> groups;


    public void addUserProperty(String name, Object val) {
        if (user_properties == null) {
            user_properties = new HashMap<>();
        }
        user_properties.put(name, val);
    }

    public void addEventProperty(String name, Object val) {
        if (event_properties == null) {
            event_properties = new HashMap<>();
        }
        event_properties.put(name, val);
    }

    public void addGroup(String name, Object val) {
        if (groups == null) {
            groups = new HashMap<>();
        }
        groups.put(name, val);
    }

    public AmplitudeEvent withUserId(String userId) {
        this.user_id = userId;
        return this;
    }

    public AmplitudeEvent withDeviceId(String device_id) {
        this.device_id = device_id;
        return this;
    }

    public AmplitudeEvent withOsName(String os_name) {
        this.os_name = os_name;
        return this;
    }

    public AmplitudeEvent withOsVersion(String os_version) {
        this.os_version = os_version;
        return this;
    }

    public AmplitudeEvent withDeviceBrand(String device_brand) {
        this.device_brand = device_brand;
        return this;
    }

    public AmplitudeEvent withDeviceManufacturer(String device_manufacturer) {
        this.device_manufacturer = device_manufacturer;
        return this;
    }

    public AmplitudeEvent withDeviceModel(String device_model) {
        this.device_model = device_model;
        return this;
    }

    public AmplitudeEvent withCarrier(String carrier) {
        this.carrier = carrier;
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

    public AmplitudeEvent withDMA(String dma) {
        this.dma = dma;
        return this;
    }

    public AmplitudeEvent withLanguage(String language) {
        this.language = language;
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

    public AmplitudeEvent withPrice(Float price) {
        this.price = price;
        return this;
    }

    public AmplitudeEvent withRevenue(Float revenue) {
        this.revenue = revenue;
        return this;
    }

    public AmplitudeEvent withLocationLat(Float location_lat) {
        this.location_lat = location_lat;
        return this;
    }

    public AmplitudeEvent withLocationLng(Float location_lng) {
        this.location_lng = location_lng;
        return this;
    }

    public AmplitudeEvent withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public AmplitudeEvent withRevenueType(String revenueType) {
        this.revenueType = revenueType;
        return this;
    }

    public AmplitudeEvent withProductId(String productId) {
        this.productId = productId;
        return this;
    }


}
