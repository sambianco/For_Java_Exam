package it.unibo.design.robot.impl;

public class BorderNavigator extends AbstractRobotPart {

    private static final double BATTERY_CONSUMPTION = 1.2;
    
    // Rappresentazione della direzione: 0=Su, 1=Destra, 2=Giù, 3=Sinistra
    private int currentDirection;

    public BorderNavigator() {
        super(BATTERY_CONSUMPTION);
        this.currentDirection = 0; // Di base parte muovendosi verso l'alto (Su)
    }

    @Override
    public void doAction() {
        if (this.isOn() && this.getRobot() != null) {
            // 1. Prova a fare un passo nella direzione attuale
            boolean success = moveInCurrentDirection();
            
            // 2. Se il movimento fallisce (success è false), significa che hai urtato il bordo!
            if (!success) {
                // Ruota di 90 gradi in senso orario (0->1->2->3->0)
                // L'operatore % 4 serve a far tornare a 0 il valore quando superiamo il 3
                this.currentDirection = (this.currentDirection + 1) % 4;
                
                // Riprova subito a muoverti nella nuova direzione costeggiando il bordo
                moveInCurrentDirection();
            }
        }
    }

    /**
     * Metodo di supporto per mappare l'intero ai reali comandi di movimento del robot.
     * @return true se il movimento ha successo, false se tocca il bordo.
     */
    private boolean moveInCurrentDirection() {
        switch (this.currentDirection) {
            case 0: return this.getRobot().moveUp();
            case 1: return this.getRobot().moveRight();
            case 2: return this.getRobot().moveDown();
            case 3: return this.getRobot().moveLeft();
            default: return false;
        }
    }
}