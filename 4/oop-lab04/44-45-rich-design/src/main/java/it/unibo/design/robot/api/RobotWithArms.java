package it.unibo.design.robot.api;

public interface RobotWithArms extends Robot{

    /**
     * picks an object
     * 
     * @return true if the action is sussessful
     */
    boolean pickUp();

    /**
     * drops an object
     * 
     * @return true if the action is sussessful
     */
    boolean dropDown();

    /**
     * @return the number of objects this robot is currently carrying
     */
    int getCarriedItemsCount();
    
}
