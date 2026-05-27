package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotPart;

public class AtomicBattery extends AbstractRobotPart implements RobotPart {

    private static final double BATTERY_CONSUMPTION = 0.0;

    public AtomicBattery() {
        super(BATTERY_CONSUMPTION);
    }

    @Override
    public void doAction() {
        if (this.isOn() && this.getRobot() != null) {
            if (this.getRobot().getBatteryLevel() < 50) {
                this.getRobot().recharge();
            }
        }
        
    }
}
