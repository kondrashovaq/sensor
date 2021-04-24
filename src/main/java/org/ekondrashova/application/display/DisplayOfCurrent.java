package org.ekondrashova.application.display;

import org.ekondrashova.application.logger.LogManager;
import org.ekondrashova.application.sensor.impl.HumiditySensor;
import org.ekondrashova.application.sensor.impl.PressureSensor;
import org.ekondrashova.application.sensor.impl.TemperatureSensor;
import org.ekondrashova.application.sensor.impl.WindDirectionSensor;
import org.ekondrashova.application.sensor.impl.WindSpeedSensor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DisplayOfCurrent extends Display {
    private HumiditySensor humiditySensor;
    private PressureSensor pressureSensor;
    private TemperatureSensor temperatureSensor;
    private WindDirectionSensor windDirectionSensor;
    private WindSpeedSensor windSpeedSensor;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

    public DisplayOfCurrent(HumiditySensor humiditySensor, PressureSensor pressureSensor,
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
        LogManager.getLogger().info("Текущее: ");
        LogManager.getLogger().info("Дата: {}", dateFormatter.format(LocalDate.now()));
        LogManager.getLogger().info("Время: {}", timeFormatter.format(LocalTime.now()));
        LogManager.getLogger().info("Влажность: {}", humiditySensor.currentHumidity());
        LogManager.getLogger().info("Давление: {}", pressureSensor.currentPressure());
        LogManager.getLogger().info("Температура: {}", temperatureSensor.currentTemperature());
        LogManager.getLogger().info("Влажность: {}", windSpeedSensor.currentSpeed());
        LogManager.getLogger().info("Направление ветра: {}", windDirectionSensor.getDirection().toString());
    }
}
