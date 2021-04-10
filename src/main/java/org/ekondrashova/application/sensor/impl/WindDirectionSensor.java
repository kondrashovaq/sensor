package org.ekondrashova.application.sensor.impl;

import org.ekondrashova.application.model.Direction;
import org.ekondrashova.application.sensor.base.Sensor;

public class WindDirectionSensor extends Sensor {
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
