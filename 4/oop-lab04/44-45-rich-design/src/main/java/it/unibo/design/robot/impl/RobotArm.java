package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.CommandableRobotPart;

public class RobotArm extends AbstractRobotPart implements CommandableRobotPart {

    // Nomi corretti in camelCase ed evitando refusi
    private final String[] availableCommands = {"pick", "drop"};
    private String pendingAction; // Inizialmente null
    private final BaseArm arm = new BaseArm(); // Composizione del braccio meccanico reale
    private double currentConsumption = 0;

    public RobotArm() {
        // Passiamo 0 alla classe astratta, perché il consumo viene calcolato 
        // dinamicamente ciclo per ciclo in base all'azione svolta
        super(0);
    }

    @Override
    public void doAction() {
        // 1. IMPORTANTE: Resettiamo il consumo all'inizio di OGNI ciclo.
        // Se in questo turno il braccio è fermo o spento, consumerà giustamente 0.
        this.currentConsumption = 0;

        if (this.isOn() && this.getRobot() != null) {
            
            // 2. SICUREZZA: Controlliamo che ci sia un'azione da fare.
            // Se pendingAction è null, saltiamo lo switch evitando il NullPointerException!
            if (this.pendingAction != null) {
                
                switch (this.pendingAction) {
                    case "pick":
                        // Impostiamo il consumo specifico recuperandolo da BaseArm
                        this.currentConsumption = this.arm.getConsumptionForPickUp();
                        // Attiviamo il braccio meccanico per raccogliere l'oggetto
                        this.arm.pickUp();
                        break;
                        
                    case "drop":
                        // Impostiamo il consumo specifico recuperandolo da BaseArm
                        this.currentConsumption = this.arm.getConsumptionForDropDown();
                        // Attiviamo il braccio meccanico per rilasciare l'oggetto
                        this.arm.dropDown();
                        break;
                        
                    default:
                        break;
                }
                
                // 3. PULIZIA: Abbiamo eseguito il comando, quindi svuotiamo la variabile.
                // In questo modo il braccio non ripeterà l'azione nei turni successivi.
                this.pendingAction = null;
            }
        }
    }

    @Override
    public String[] availableCommands() {
        return this.availableCommands;
    }

    @Override
    public void sendCommand(final String command) {
        if (command.equals("pick") || command.equals("drop")) {
            this.pendingAction = command;
        }
    }

    @Override
    public double getConsumption() {
        return this.currentConsumption;
    }
}
