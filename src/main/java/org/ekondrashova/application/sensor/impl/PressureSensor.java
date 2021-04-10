package org.ekondrashova.application.sensor.impl;

import org.ekondrashova.application.sensor.base.TrendSensor;

public class PressureSensor extends TrendSensor {

    public String currentPressure() {
        return format(getCurrentValue());
    }

    public String highPressure() {
        return format(getHighValue());
    }

    public String lowPressure() {
        return format(getLowValue());
    }

    private String format(Double value) {
        return String.format("%.2f", value) ;
    }

}
