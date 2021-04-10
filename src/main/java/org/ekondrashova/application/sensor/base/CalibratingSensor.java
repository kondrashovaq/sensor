package org.ekondrashova.application.sensor.base;

import java.util.Objects;

public abstract class CalibratingSensor extends Sensor {
    private Double currentValue;
    protected Double highValue;
    protected Double lowValue;

    public CalibratingSensor() {
    }

    public CalibratingSensor(Double currentValue, Double highValue, Double lowValue) {
        this.currentValue = currentValue;
        this.highValue = highValue;
        this.lowValue = lowValue;
    }

    public void setCurrentValue(Double currentValue) {
        if (Objects.isNull(highValue) || currentValue > highValue) {
            setHighValue(currentValue);
        }
        if (Objects.isNull(lowValue) || currentValue < lowValue) {
            setLowValue(currentValue);
        }
        this.currentValue = currentValue;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setHighValue(Double highValue) {
        this.highValue = highValue;
    }

    public void setLowValue(Double lowValue) {
        this.lowValue = lowValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalibratingSensor)) return false;
        CalibratingSensor that = (CalibratingSensor) o;
        return Objects.equals(getCurrentValue(), that.getCurrentValue()) &&
                Objects.equals(highValue, that.highValue) &&
                Objects.equals(lowValue, that.lowValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrentValue(), highValue, lowValue);
    }
}
