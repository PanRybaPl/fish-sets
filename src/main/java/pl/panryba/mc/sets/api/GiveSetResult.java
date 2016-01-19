/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.sets.api;

/**
 *
 * @author PanRyba.pl
 */
public class GiveSetResult {
    private GiveSetReason reason;
    private boolean result;
    private int missingSlots;
    private int totalSlots;
    
    public GiveSetResult(boolean result, GiveSetReason reason) {
        this.reason = reason;
        this.result = result;
    }

    public GiveSetResult(boolean result, GiveSetReason reason, int missingSlots, int totalSlots) {
        this(result, reason);
        this.missingSlots = missingSlots;
        this.totalSlots = totalSlots;
    }
    
    public GiveSetReason getReason() {
        return this.reason;
    }
    
    public boolean getResult() {
        return this.result;
    }
    
    public int getMissingSlots() {
        return this.missingSlots;
    }
    
    public int getTotalSlots() {
        return this.totalSlots;
    }
}
