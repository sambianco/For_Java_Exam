package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotWithArms;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms{

    private BaseArm leftArm;
    private BaseArm rightArm;
    private static final double PICK_UP_CONSUMPTION = 0.5;
    private static final double DROP_DOWN_CONSUMPTION = 0.2;

    public RobotWithTwoArms(String robotName) {
        super(robotName);
        this.leftArm = new BaseArm();
        this.rightArm = new BaseArm();
    }

    @Override
    public boolean pickUp() {
        BaseArm pick = serachFreeArm();
        if (pick == null) { return false;
        } else {
            pick.pickUp();
            super.consumeBattery(RobotWithTwoArms.PICK_UP_CONSUMPTION);
            return true;
        }
    }

    @Override
    public boolean dropDown() {
        BaseArm pick = searchBusyArm();
        if (pick == null) { return false;
        } else {
            pick.dropDown();
            super.consumeBattery(RobotWithTwoArms.DROP_DOWN_CONSUMPTION);
            return true;
        }
    }

    @Override
    public int getCarriedItemsCount() {
        return (this.leftArm.isGrabbing() ? 1 : 0) + (this.rightArm.isGrabbing() ? 1 : 0);
    }

    private BaseArm serachFreeArm() {
        if (!this.leftArm.isGrabbing()) {
            return this.leftArm;
        } else if (!this.rightArm.isGrabbing()) {
            return this.rightArm;
        } else {
            return null;
        }
    }

    private BaseArm searchBusyArm() {
        if (this.leftArm.isGrabbing()) {
            return this.leftArm;
        } else if (this.rightArm.isGrabbing()) {
            return this.rightArm;
        } else {
            return null;
        }
    }

    @Override
    protected double getBatteryRequirementForMovement() {
        // Riprendiamo il consumo base e aggiungiamo un extra per ogni oggetto
        // Esempio: 0.1 di consumo extra per ogni oggetto trasportato
        return super.getBatteryRequirementForMovement() + (this.getCarriedItemsCount() * 0.1);
    }
}
