package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.CommandableRobotPart;
import it.unibo.design.robot.api.Robot;

public class RobotArm extends AbstractRobotPart implements CommandableRobotPart{

    boolean isGrabbing;
    private Robot robot;
    private String pendingAction;
    static private final double PICK_CONSUME = 0.5;
    static private final double RELEASE_CONSUME = 0.3;

    protected RobotArm(double batteryConsume) {
        super(batteryConsume);
        this.isGrabbing = false;
        this.pendingAction = null;
    }
    
    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public boolean sendCommand(String cmd) {
        if (cmd.equals("pick")) {
            pendingAction = "pick";
            return true;
        } else if (cmd.equals("release")) {
            pendingAction = "release";
            return true;
        } else {
            return false;

        }
    }

    @Override
    public void doCycle() {
        if(this.pendingAction == "pick") {
            
        }
    }
    
}
