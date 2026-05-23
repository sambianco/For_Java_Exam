package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.Robot;

public class NavigationComponent extends AbstractRobotPart{

    private Robot robot;
    
    protected NavigationComponent(double batteryConsume) {
        super(batteryConsume);
    }

    //naviga verso il bordo poi appena ci arriva si gira di 90 gradi e continua la navigazione
    @Override
    public void doCycle() {
        if (this.robot != null) {
            this.robot.moveForward();
            if (this.robot.isAtBorder()) {
                this.robot.turnRight();
            }
        }
    }
    
}
