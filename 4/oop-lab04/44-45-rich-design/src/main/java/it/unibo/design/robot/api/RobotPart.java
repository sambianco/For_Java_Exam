package it.unibo.design.robot.api;

public interface RobotPart {
    
    boolean turnOn();
    
    boolean turnOff();
    
    boolean isOn();
    
    /**
     * Esegue l'azione specifica del componente sul robot a cui è connesso.
     */
    void doAction();
    
    /**
     * @return il consumo energetico associato all'azione del componente.
     */
    double getConsumption();
    
    /**
     * Connette il componente a un robot.
     * @param robot il robot a cui connettere il componente.
     */
    void connect(Robot robot); // Oppure ComposableRobot, a seconda di cosa preferisci
}