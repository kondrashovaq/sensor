package org.ekondrashova.application.sensor.impl;

import org.ekondrashova.application.model.Direction;
import org.ekondrashova.application.sensor.base.Sensor;

import java.util.Random;

public class WindDirectionSensor extends Sensor {
    private Direction direction;

    public WindDirectionSensor() {
        int number = new Random().nextInt(8);
        for (Direction direction : Direction.values()) {
            if (direction.ordinal() == number) {
                this.direction = direction;
            }
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
