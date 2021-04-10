package org.ekondrashova.application.display;

import org.ekondrashova.application.sensor.impl.HumiditySensor;
import org.ekondrashova.application.sensor.impl.PressureSensor;
import org.ekondrashova.application.sensor.impl.TemperatureSensor;
import org.ekondrashova.application.sensor.impl.WindDirectionSensor;
import org.ekondrashova.application.sensor.impl.WindSpeedSensor;

public class DisplayOfHighLow extends Display {
    private HumiditySensor humiditySensor;
    private PressureSensor pressureSensor;
    private TemperatureSensor temperatureSensor;
    private WindDirectionSensor windDirectionSensor;
    private WindSpeedSensor windSpeedSensor;


    public DisplayOfHighLow(HumiditySensor humiditySensor, PressureSensor pressureSensor,
                            TemperatureSensor temperatureSensor, WindDirectionSensor windDirectionSensor,
                            WindSpeedSensor windSpeedSensor) {
        this.humiditySensor = humiditySensor;
        this.pressureSensor = pressureSensor;
        this.temperatureSensor = temperatureSensor;
        this.windDirectionSensor = windDirectionSensor;
        this.windSpeedSensor = windSpeedSensor;
    }

    @Override
    public void show() {
        System.out.println("--------------------------------------------------");
        System.out.println("Максимальное: ");
        System.out.println("Влажность: " + humiditySensor.highHumidity());
        System.out.println("Давление: " + pressureSensor.highPressure());
        System.out.println("Температура: " + temperatureSensor.highTemperature());
        System.out.println("Влажность: " + windSpeedSensor.highSpeed());
        System.out.println("--------------------------------------------------");
        System.out.println("Минимальное: ");
        System.out.println("Влажность: " + humiditySensor.lowHumidity());
        System.out.println("Давление: " + pressureSensor.lowPressure());
        System.out.println("Температура: " + temperatureSensor.lowTemperature());
        System.out.println("Влажность: " + windSpeedSensor.lowSpeed());
    }
}
