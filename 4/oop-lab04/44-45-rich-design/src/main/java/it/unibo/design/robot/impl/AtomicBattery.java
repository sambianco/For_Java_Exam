package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.Robot;

public class AtomicBattery extends AbstractRobotPart {

    private Robot robot;

    public AtomicBattery(double batteryConsume) {
        super(batteryConsume);
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doCycle() {
        if (this.robot != null && this.robot.getBatteryLevel() < 50.0) {
            this.robot.recharge();
        }
    }
    
}
