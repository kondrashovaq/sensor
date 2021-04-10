package org.ekondrashova.application.model;

import org.ekondrashova.application.sensor.impl.HumiditySensor;
import org.ekondrashova.application.sensor.impl.PressureSensor;
import org.ekondrashova.application.sensor.impl.TemperatureSensor;
import org.ekondrashova.application.sensor.impl.WindDirectionSensor;
import org.ekondrashova.application.sensor.impl.WindSpeedSensor;

public enum EventType {

    HUMIDITY_READ(HumiditySensor.class),
    TEMPERATURE_READ(TemperatureSensor.class),
    WIND_SPEED_READ(WindSpeedSensor.class),
    PRESSURE_READ(PressureSensor.class),
    WIND_DIRECTION_CHANGED(WindDirectionSensor.class);

    EventType(Class<?> supportedClass) {
        this.supportedClass = supportedClass;
    }

    private final Class<?> supportedClass;

    public boolean supports(Class<?> another) {
        return supportedClass.equals(another);
    }

}
