package org.ekondrashova.application.display;

import org.ekondrashova.application.logger.LogManager;
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
        LogManager.getLogger().info("--------------------------------------------------");
        LogManager.getLogger().info("Максимальное: ");
        LogManager.getLogger().info("Влажность: {}", humiditySensor.highHumidity());
        LogManager.getLogger().info("Давление: {}", pressureSensor.highPressure());
        LogManager.getLogger().info("Температура: {}", temperatureSensor.highTemperature());
        LogManager.getLogger().info("Влажность: {}", windSpeedSensor.highSpeed());
        LogManager.getLogger().info("--------------------------------------------------");
        LogManager.getLogger().info("Минимальное: ");
        LogManager.getLogger().info("Влажность: {}", humiditySensor.lowHumidity());
        LogManager.getLogger().info("Давление: {}", pressureSensor.lowPressure());
        LogManager.getLogger().info("Температура: {}", temperatureSensor.lowTemperature());
        LogManager.getLogger().info("Влажность: {}", windSpeedSensor.lowSpeed());
    }
}
