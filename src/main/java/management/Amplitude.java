package management;

import data.AmplitudeEvent;
import data.AmplitudeException;
import data.EventFilter;
import logging.AmplitudeLogger;
import logging.DefaultLogger;

import java.util.HashSet;
import java.util.Set;

public class Amplitude {

    private final AmplitudeClient client;
    private final AmplitudeLogger logger;
    private Set<EventFilter> filters = new HashSet<>();
    private AmplitudeThreadManager threadManager;
    private AmplitudeSettings settings;


    public Amplitude(AmplitudeSettings settings) {
        this(null, settings);
    }

    public Amplitude(AmplitudeLogger logger, AmplitudeSettings settings) {
        this.logger = logger != null ? logger : new DefaultLogger();
        this.settings = settings;
        client = new AmplitudeClient(settings.getApiKey(), settings.getMaxBatchSize(), this.logger);
        threadManager = new AmplitudeThreadManager(client,logger);
    }

    public void event(AmplitudeEvent event) throws AmplitudeException {
        for (EventFilter f : filters) {
            if (!f.filter(event)) {
                return;
            }
        }
        client.addEvent(event);
    }

    public void startSendingBySchedule() {
        threadManager.start(settings.getPeriodInSeconds());
    }

    public void addFilter(EventFilter filter) {
        filters.add(filter);
    }

    public void removeFilter(EventFilter filter) {
        filters.remove(filter);
    }

}
