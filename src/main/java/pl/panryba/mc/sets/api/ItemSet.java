/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.sets.api;

import org.bukkit.inventory.ItemStack;

/**
 *
 * @author PanRyba.pl
 */
public class ItemSet {
    private ItemSetPart[] parts;
    
    public ItemStack[] produceStacks() {
        ItemStack[] stacks = new ItemStack[this.parts.length];
        
        int i = 0;
        for(ItemSetPart part : this.parts) {
            stacks[i++] = part.produceStack();
        }
        
        return stacks;
    }
        
    public ItemSet(ItemSetPart[] parts) {
        this.parts = parts;
    }
}