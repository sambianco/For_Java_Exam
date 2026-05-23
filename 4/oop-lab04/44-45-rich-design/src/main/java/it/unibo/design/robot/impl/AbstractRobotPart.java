package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.Robot;
import it.unibo.design.robot.api.RobotPart;

public abstract class AbstractRobotPart implements RobotPart {

    private final double consumption;
    private boolean isOn;
    private Robot robot; // Sarà null se non connesso

    /**
     * Il costruttore richiede il consumo, che varia da componente a componente.
     */
    public AbstractRobotPart(final double consumption) {
        this.consumption = consumption;
        this.isOn = false; // Di base il componente nasce spento
        this.robot = null; // e non connesso
    }

    @Override
    public boolean turnOn() {
        this.isOn = true;
        return true; 
    }

    @Override
    public boolean turnOff() {
        this.isOn = false;
        return true;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public double getConsumption() {
        return this.consumption;
    }

    @Override
    public void connect(final Robot robot) {
        this.robot = robot;
    }

    /**
     * Un metodo di utility (protected) per consentire alle classi figlie 
     * di accedere al robot su cui devono compiere l'azione.
     */
    protected Robot getRobot() {
        return this.robot;
    }

    // Nota: doAction() NON viene implementato qui. 
    // Essendo astratta la classe, deleghiamo l'implementazione alle classi concrete!
}
