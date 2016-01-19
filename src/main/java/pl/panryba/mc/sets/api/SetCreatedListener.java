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
public interface SetCreatedListener {
    void onSetPrepared(ItemStack[] stacks);
}
