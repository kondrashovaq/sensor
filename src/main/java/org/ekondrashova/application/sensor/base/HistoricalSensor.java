package org.ekondrashova.application.sensor.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class HistoricalSensor extends CalibratingSensor {
    private LocalDateTime timeOfHighValue;
    private LocalDateTime timeOfLowValue;
    private final Map<LocalDateTime, Double> history = new HashMap<>();

    public HistoricalSensor() {
    }

    public HistoricalSensor(Double currentValue, Double highValue, Double lowValue,
                            LocalDateTime timeOfHighValue, LocalDateTime timeOfLowValue) {
        super(currentValue, highValue, lowValue);
        this.timeOfHighValue = timeOfHighValue;
        this.timeOfLowValue = timeOfLowValue;
    }

    @Override
    public void setCurrentValue(Double currentValue) {
        super.setCurrentValue(currentValue);
        history.put(LocalDateTime.now(), currentValue);
    }

    protected Map<LocalDateTime, Double> getHistory() {
        return history;
    }

    public Double getHighValue() {
        return highValue;
    }

    public Double getLowValue() {
        return lowValue;
    }

    public LocalDateTime getTimeOfHighValue() {
        return timeOfHighValue;
    }

    public LocalDateTime getTimeOfLowValue() {
        return timeOfLowValue;
    }

    @Override
    public void setHighValue(Double highValue) {
        super.setHighValue(highValue);
        this.timeOfHighValue = LocalDateTime.now();
    }

    @Override
    public void setLowValue(Double lowValue) {
        super.setLowValue(lowValue);
        this.timeOfLowValue = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HistoricalSensor)) return false;
        if (!super.equals(o)) return false;
        HistoricalSensor that = (HistoricalSensor) o;
        return Objects.equals(getTimeOfHighValue(), that.getTimeOfHighValue()) &&
                Objects.equals(getTimeOfLowValue(), that.getTimeOfLowValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTimeOfHighValue(), getTimeOfLowValue());
    }
}


