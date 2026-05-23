package it.unibo.design.robot.api;

public interface ComposableRobot extends Robot {

    /**
     * Connette un componente al robot.
     * @param part il componente da aggiungere.
     */
    void attachComponent(RobotPart part);

    /**
     * Rimuove un componente dal robot.
     * @param part il componente da rimuovere.
     */
    void detachComponent(RobotPart part);

    /**
     * Esegue un ciclo di funzionamento: invoca l'azione di tutti i componenti 
     * connessi ed accesi, consumando la relativa energia dalla batteria del robot.
     */
    void doCycle();
}