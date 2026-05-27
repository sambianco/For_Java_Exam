package it.unibo.design.robot.impl;

import java.util.ArrayList;
import java.util.List;
import it.unibo.design.robot.api.ComposableRobot;
import it.unibo.design.robot.api.RobotPart;

public class SimpleComposableRobot extends BaseRobot implements ComposableRobot {

    // 1. La lista dei componenti, dichiarata come interfaccia per il polimorfismo
    private final List<RobotPart> components;

    public SimpleComposableRobot(final String robotName) {
        // Passiamo il nome del robot alla classe madre BaseRobot
        super(robotName);
        // SOLUZIONE BUG: Inizializziamo l'ArrayList per evitare il NullPointerException
        this.components = new ArrayList<>();
    }

    @Override
    public void attachComponent(final RobotPart part) {
        // Protezione contro i valori nulli
        if (part != null) {
            this.components.add(part);
            // VINCOLO DI DOMINIO: Comunichiamo al componente che ora è connesso a QUESTO robot
            part.connect(this);
        }
    }

    @Override
    public void detachComponent(final RobotPart part) {
        if (part != null) {
            this.components.remove(part);
            // VINCOLO DI DOMINIO: Scolleghiamo il componente impostando il suo robot a null
            part.connect(null);
        }
    }

    @Override
    public void doCycle() {
        // Scorriamo tutti i componenti attualmente agganciati al robot
        for (final RobotPart part : this.components) {
            
            // VINCOLO DI DOMINIO: Il componente esegue l'azione solo se è ACCESO
            if (part.isOn()) {
                
                // SICUREZZA: Verifichiamo se il robot ha abbastanza batteria per sostenere il componente
                if (this.isBatteryEnough(part.getConsumption())) {
                    
                    // Il componente compie la sua azione specifica sul robot
                    part.doAction();
                    
                    // VINCOLO DI DOMINIO: Scaliamo dalla batteria il costo energetico del componente
                    this.consumeBattery(part.getConsumption());
                    
                } else {
                    // Logghiamo un messaggio se la batteria non basta per questo pezzo
                    this.log("Batteria insufficiente per attivare il componente: " + part.getClass().getSimpleName());
                }
            }
        }
    }
}
