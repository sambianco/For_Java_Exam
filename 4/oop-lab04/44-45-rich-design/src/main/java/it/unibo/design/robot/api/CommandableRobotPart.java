package it.unibo.design.robot.api;

public interface CommandableRobotPart extends RobotPart{
    boolean sendCommand(String cmd);
}
