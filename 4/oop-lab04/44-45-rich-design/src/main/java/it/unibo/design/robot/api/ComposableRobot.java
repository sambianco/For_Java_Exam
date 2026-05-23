package it.unibo.design.robot.api;

public interface ComposableRobot extends Robot {
    boolean attachComponent(RobotPart part);
    boolean detachComponent(RobotPart part);
    void consumeBattery(double consume);
}
