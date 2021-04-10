package org.ekondrashova.application.sensor.impl;

import org.ekondrashova.application.sensor.base.TrendSensor;

public class TemperatureSensor extends TrendSensor {

    public String currentTemperature() {
        return format(getCurrentValue());
    }

    public String highTemperature() {
        return format(getHighValue());
    }

    public String lowTemperature() {
        return format(getLowValue());
    }

    private String format(Double value) {
        return String.format("%.1f", value) + " °C";
    }

}
