/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.sets.api;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author PanRyba.pl
 */
public class ItemSetPart {

    private Material material;
    private int qty;
    private ItemSetEnchantment[] enchants;

    private boolean damageSet;
    private short damage;

    public ItemSetPart() {}

    public ItemSetPart(Material material, int qty) {
        this(material, qty, null);
    }
    
    public ItemSetPart(Material material, int qty, short damage) {
        this(material, qty, null);
        this.damageSet = true;
        this.damage = damage;
    }
    
    public ItemSetPart(Material material, int qty, ItemSetEnchantment[] enchants) {
        this.material = material;
        this.qty = qty;
        this.enchants = enchants;
    }

    public int getQty() {
        return this.qty;
    }

    public Material getMaterial() {
        return this.material;
    }

    public ItemStack produceStack() {
        ItemStack stack;
        if(this.damageSet)
            stack = new ItemStack(material, qty, damage);
        else
            stack = new ItemStack(material, qty);

        if (this.enchants != null) {
            for (ItemSetEnchantment enchant : this.enchants) {
                enchant.apply(stack);
            }
        }

        return stack;
    }
}