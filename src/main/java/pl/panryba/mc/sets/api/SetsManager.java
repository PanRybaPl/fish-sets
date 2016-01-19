/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.sets.api;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/**
 *
 * @author PanRyba.pl
 */
public class SetsManager {
    private Map<String, ItemSet> sets;
    
    public SetsManager() {
        this.sets = new HashMap<>();
    }
    
    public void add(String key, ItemSet set) {
        sets.put(key, set);
    }
    
    public GiveSetResult give(String key, Player player, SetCreatedListener listener) {
        ItemSet set = getSet(key);
        
        if(set == null) {
            return new GiveSetResult(false, GiveSetReason.UNKNOWN_SET);
        }
        
        return give(set, player, listener);
    }
    
    public GiveSetResult give(String key, Player player) {
        return give(key, player, null);
    }
    
    public static boolean hasEnoughSlots(ItemSet set, Player player) {
        ItemStack[] stacks = set.produceStacks();
        PlayerInventory inv = player.getInventory();

        int totalSlots = stacks.length;
        int missingSlots = calculateMissingSlots(totalSlots, inv);
        
        return missingSlots <= 0;
    }
    
    public static GiveSetResult give(ItemSet set, Player player, SetCreatedListener listener)
    {        
        ItemStack[] stacks = set.produceStacks();
        PlayerInventory inv = player.getInventory();

        int totalSlots = stacks.length;
        int missingSlots = calculateMissingSlots(totalSlots, inv);

        if (missingSlots > 0) {
            return new GiveSetResult(false, GiveSetReason.NOT_ENOUGH_INVENTORY, missingSlots, totalSlots);
        }
        
        if(listener != null) {
            listener.onSetPrepared(stacks);
        }
        
        inv.addItem(stacks);
        
        return new GiveSetResult(true, GiveSetReason.GIVEN, missingSlots, totalSlots);
    }
    
    public static GiveSetResult give(ItemSet set, Player player)
    {
        return give(set, player, null);
    }

    private ItemSet getSet(String key) {
        return this.sets.get(key);
    }

    private static int calculateMissingSlots(int slotsRequired, PlayerInventory inv) {
        int missingSlots = slotsRequired;

        for (ItemStack invSlot : inv.getContents()) {
            if (invSlot == null || invSlot.getType() == Material.AIR) {
                if (--missingSlots <= 0) {
                    break;
                }
            }
        }
        
        return missingSlots;
    }
}
