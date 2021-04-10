package org.ekondrashova.application.sensor.impl;

import org.ekondrashova.application.sensor.base.HistoricalSensor;

public class HumiditySensor extends HistoricalSensor {

    public String currentHumidity() {
        return format(getCurrentValue());
    }

    public String highHumidity() {
        return format(getHighValue());
    }

    public String lowHumidity() {
        return format(getLowValue());
    }

    private String format(Double value) {
        return String.format("%.0f", value) + " %";
    }

}
