package org.ekondrashova.application.event;

import org.ekondrashova.application.sensor.base.CalibratingSensor;
import org.ekondrashova.application.model.Event;

import java.util.ArrayList;
import java.util.List;

public class SensorEventService {

    private final List<CalibratingSensor> subscribedSensors = new ArrayList<>();

    public void onIndicationsRead(Event event) {
        subscribedSensors.forEach(sensor -> {
            if (event.getEventType().supports(sensor.getClass())) {
                sensor.setCurrentValue(event.getValue());
            }
        });
    }

    public void subscribeSensor(CalibratingSensor calibratingSensor) {
        subscribedSensors.add(calibratingSensor);
    }

}
