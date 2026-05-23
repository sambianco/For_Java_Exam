package it.unibo.design.robot.api;

public interface CommandableRobotPart extends RobotPart {
    
    /**
     * @return un array contenente i comandi supportati da questo componente.
     */
    String[] availableCommands();

    /**
     * Invia un comando al componente.
     * @param command il comando da eseguire.
     */
    void sendCommand(String command);
}