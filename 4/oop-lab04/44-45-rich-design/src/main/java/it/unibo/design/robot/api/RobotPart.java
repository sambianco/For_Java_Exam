package it.unibo.design.robot.api;

public interface RobotPart {
    void turnOn();
    void turnOff();
    double getConsumption();
    void doCycle();
}
