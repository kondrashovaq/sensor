package org.ekondrashova.application.model;

import java.util.Objects;

public class Event {
    private EventType eventType;
    private Double value;

    public Event(EventType eventType, Double value) {
        this.eventType = eventType;
        this.value = value;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getEventType() == event.getEventType() &&
                Objects.equals(getValue(), event.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventType(), getValue());
    }
}
