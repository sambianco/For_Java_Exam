package it.unibo.design.robot.impl;

public class BaseArm {

    boolean isGrabbing;

    public BaseArm() {
        this.isGrabbing = false;
    }
    
    public boolean isGrabbing(){
        return isGrabbing;
    }

    public boolean pickUp(){
        if (!isGrabbing) {
            isGrabbing = true;
            return true;
        }
        return false;
    }

    public boolean dropDown(){
        if (isGrabbing) {
            isGrabbing = false;
            return true;
        }
        return false;
    }

    public double getConsumptionForPickUp(){
        return 0.5;
    }

    public double getConsumptionForDropDown(){
        return 0.2;
    }
}
