package org.ekondrashova.application;

import org.ekondrashova.application.display.Display;
import org.ekondrashova.application.display.DisplayOfCurrent;
import org.ekondrashova.application.display.DisplayManager;
import org.ekondrashova.application.display.DisplayOfHighLow;
import org.ekondrashova.application.event.SensorEventService;
import org.ekondrashova.application.model.Event;
import org.ekondrashova.application.model.EventType;
import org.ekondrashova.application.sensor.impl.HumiditySensor;
import org.ekondrashova.application.sensor.impl.PressureSensor;
import org.ekondrashova.application.sensor.impl.TemperatureSensor;
import org.ekondrashova.application.sensor.impl.WindDirectionSensor;
import org.ekondrashova.application.sensor.impl.WindSpeedSensor;

public class Application {
    private static final DisplayManager displayManager = new DisplayManager();
    private static final SensorEventService sensorEventService = new SensorEventService();

    public static void main(String[] args) {

        HumiditySensor humiditySensor = new HumiditySensor();
        PressureSensor pressureSensor = new PressureSensor();
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        WindDirectionSensor windDirectionSensor = new WindDirectionSensor();
        WindSpeedSensor windSpeedSensor = new WindSpeedSensor();

        Display displayOfCurrent = new DisplayOfCurrent(
                humiditySensor, pressureSensor, temperatureSensor,
                windDirectionSensor, windSpeedSensor
        );

        Display displayOfHighLow = new DisplayOfHighLow(
                humiditySensor, pressureSensor, temperatureSensor,
                windDirectionSensor, windSpeedSensor
        );

        displayManager.addDisplay(displayOfCurrent);
        displayManager.addDisplay(displayOfHighLow);

        sensorEventService.subscribeSensor(humiditySensor);
        sensorEventService.subscribeSensor(pressureSensor);
        sensorEventService.subscribeSensor(temperatureSensor);
        sensorEventService.subscribeSensor(windSpeedSensor);

        sensorEventService.onIndicationsRead(new Event(EventType.HUMIDITY_READ, 35.38));
        sensorEventService.onIndicationsRead(new Event(EventType.HUMIDITY_READ, 45.38));
        sensorEventService.onIndicationsRead(new Event(EventType.HUMIDITY_READ, 67.38));
        sensorEventService.onIndicationsRead(new Event(EventType.WIND_SPEED_READ, 7.58));
        sensorEventService.onIndicationsRead(new Event(EventType.WIND_SPEED_READ, 8.68));
        sensorEventService.onIndicationsRead(new Event(EventType.WIND_SPEED_READ, 10.885));
        sensorEventService.onIndicationsRead(new Event(EventType.TEMPERATURE_READ, 23.86));
        sensorEventService.onIndicationsRead(new Event(EventType.TEMPERATURE_READ, 33.83));
        sensorEventService.onIndicationsRead(new Event(EventType.TEMPERATURE_READ, 30.58));
        sensorEventService.onIndicationsRead(new Event(EventType.PRESSURE_READ, 25.45));
        sensorEventService.onIndicationsRead(new Event(EventType.PRESSURE_READ, 22.15));
        sensorEventService.onIndicationsRead(new Event(EventType.PRESSURE_READ, 27.98));

        displayManager.showAll();
    }
}
