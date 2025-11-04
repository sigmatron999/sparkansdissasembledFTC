package org.firstinspires.ftc.teamcode;

import java.util.HashMap;

public class CommandSystem {

    // Essentially a checklist; stores a state corresponding to a subsystem (like initialization)
    HashMap<Character, Boolean> completedMap = new HashMap<Character, Boolean>();

    // checks if every subsystem is completed
    public boolean isBoolsCompleted(){

        for (boolean value: this.completedMap.values()){
            if (!value) {return false;}
        }
        return true;
    }

    /* --------------------------------------------------------------
    Manipulate hashmap, i.e., add bools, read bools, reset map
    -----------------------------------------------------------------
    */
    public void resetMap(){ completedMap.clear();}

    public void setElementFalse(char element) { completedMap.put(element, false); }

    public void setElementTrue(char element) { completedMap.put(element, true); }

    public boolean getElementState(char element) { return completedMap.get(element); }

    public HashMap<Character, Boolean> getMap() { return completedMap; }


}
