package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotPart;

public abstract class AbstractRobotPart implements RobotPart{

    boolean isTurnedOn;
    private final double BATTERY_CONSUME;

    protected AbstractRobotPart(double batteryConsume) {
        this.BATTERY_CONSUME = batteryConsume;
        this.isTurnedOn = false;
    }

    public void turnOn(){
        if(isTurnedOn) {
            return;
        } else {
            isTurnedOn = true;
            return;
        }
    }
    public void turnOff(){
        if(!isTurnedOn) {
            return;
        } else {
            isTurnedOn = false;
            return;
        }
    }

    public double getConsumption() {
        return BATTERY_CONSUME;
    }

    public abstract void doCycle();
    
}
