package data;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AmplitudeBatch {

    private final String api_key;
    private List<AmplitudeEvent> events = new LinkedList<>();

    public AmplitudeBatch(String api_key) {
        this.api_key = api_key;
    }

    public void addEvent(AmplitudeEvent event) {
        events.add(event);
    }

    public void clear() {
        events.clear();
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    public int size() {
        return events.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
