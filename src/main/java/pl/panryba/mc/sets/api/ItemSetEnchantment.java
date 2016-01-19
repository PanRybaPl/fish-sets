/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.sets.api;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author PanRyba.pl
 */
public class ItemSetEnchantment {
    private Enchantment type;
    private int level;
    
    public ItemSetEnchantment(Enchantment type, int level) {
        this.type = type;
        this.level = level;
    }
    
    public void apply(ItemStack stack) {
        stack.addEnchantment(this.type, this.level);
    }
}