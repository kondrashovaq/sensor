package org.ekondrashova.application.sensor.impl;

import org.ekondrashova.application.sensor.base.HistoricalSensor;

public class WindSpeedSensor extends HistoricalSensor {

    public String currentSpeed() {
        return format(getCurrentValue());
    }

    public String highSpeed() {
        return format(getHighValue());
    }

    public String lowSpeed() {
        return format(getLowValue());
    }

    private String format(Double value) {
        return String.format("%.0f", value) + " км/ч";
    }

}
