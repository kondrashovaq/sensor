package org.ekondrashova.application.sensor.base;

import java.time.LocalDateTime;
import java.util.Map;

public abstract class TrendSensor extends HistoricalSensor {

    public Map<LocalDateTime, Double> trend() {
        return getHistory();
    }

}
