package me.devcode.SurvivalGames.Listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.devcode.SurvivalGames.GameStatus;
import me.devcode.SurvivalGames.SG;

public class ChestListener implements Listener {
	
	private List<ItemStack> chestitems;
	public static HashMap<Location, Inventory> chest = new HashMap<Location, Inventory>();
	public static HashMap<Player, Integer> kistenanzahl = new HashMap<Player, Integer>();
	
	private SG plugin;
	public ChestListener(SG plugin) {
		this.plugin = plugin;
		chestitems = new ArrayList<ItemStack>();
		setChestItems();
	}
	
	@EventHandler
	public void onChestOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Block block = e.getClickedBlock();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(block.getTypeId() == 33) {
				
				if(SG.spec.contains(p)) {
					e.setCancelled(true);
					return;
				}
				if(SG.status == GameStatus.INGAME || SG.status == GameStatus.SCHUTZ) {
					
					if(!chest.containsKey(block.getLocation())) {
						if(kistenanzahl.containsKey(p)) {
							kistenanzahl.put(p, kistenanzahl.get(p) + 1);
						}else{
							kistenanzahl.put(p, 1);
						}
						JoinListener.updateScoreboard(p);
						
						
						Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST);
						Random random = new Random();
						int chestint = random.nextInt(3) + 2;
						while(chestint > 0) {
							chestint--;
							ItemStack itemstack = chestitems.get(random.nextInt(chestitems.size()));
							int slot = random.nextInt(27);
							inv.setItem(slot, itemstack);
							
						}
						chest.put(block.getLocation(), inv);
						p.openInventory(inv);
						return;
					}else{
						if(kistenanzahl.containsKey(p)) {
							kistenanzahl.put(p, kistenanzahl.get(p) + 1);
						}else{
							kistenanzahl.put(p, 1);
						}
						JoinListener.updateScoreboard(p);
						p.openInventory(chest.get(block.getLocation()));
						return;
					}
					
				}else{
					e.setCancelled(true);
					return;
				}
				
			
			}
		
		}
	}
	
	private void setChestItems() {
		//essen
		 chestitems.add(new ItemStack(Material.APPLE, 3));
	     chestitems.add(new ItemStack(Material.COOKED_BEEF));
	     chestitems.add(new ItemStack(Material.COOKED_CHICKEN));
	     chestitems.add(new ItemStack(Material.COOKED_FISH));
	     chestitems.add(new ItemStack(Material.POTATO,2));
	     chestitems.add(new ItemStack(Material.BAKED_POTATO));
	     chestitems.add(new ItemStack(Material.APPLE, 3));
	     chestitems.add(new ItemStack(Material.COOKED_BEEF));
	     chestitems.add(new ItemStack(Material.COOKED_CHICKEN));
	     chestitems.add(new ItemStack(Material.COOKED_FISH));
	     chestitems.add(new ItemStack(Material.POTATO,2));
	     chestitems.add(new ItemStack(Material.BAKED_POTATO));
	     chestitems.add(new ItemStack(Material.APPLE, 3));
	     chestitems.add(new ItemStack(Material.COOKED_BEEF));
	     chestitems.add(new ItemStack(Material.COOKED_CHICKEN));
	     chestitems.add(new ItemStack(Material.COOKED_FISH));
	     chestitems.add(new ItemStack(Material.POTATO,2));
	     chestitems.add(new ItemStack(Material.BAKED_POTATO));
	     chestitems.add(new ItemStack(Material.APPLE, 3));
	     chestitems.add(new ItemStack(Material.COOKED_BEEF));
	     chestitems.add(new ItemStack(Material.COOKED_CHICKEN));
	     chestitems.add(new ItemStack(Material.COOKED_FISH));
	     chestitems.add(new ItemStack(Material.POTATO,2));
	     chestitems.add(new ItemStack(Material.BAKED_POTATO));
	     chestitems.add(new ItemStack(Material.CAKE));
	     chestitems.add(new ItemStack(Material.CAKE));
		


	     //Sonstiges
	     chestitems.add(new ItemStack(Material.IRON_INGOT));
	     chestitems.add(new ItemStack(Material.DIAMOND));
	     chestitems.add(new ItemStack(Material.STICK));
	     chestitems.add(new ItemStack(Material.STICK,2));
	     chestitems.add(new ItemStack(Material.FLINT));
	     chestitems.add(new ItemStack(Material.FLINT));
	     chestitems.add(new ItemStack(Material.FISHING_ROD));
	     chestitems.add(new ItemStack(Material.FISHING_ROD));
	     chestitems.add(new ItemStack(Material.WHEAT));
	     chestitems.add(new ItemStack(Material.ARROW,5));
	     chestitems.add(new ItemStack(Material.ARROW,4));
	     chestitems.add(new ItemStack(Material.ARROW,8));
	     chestitems.add(new ItemStack(Material.ARROW,10));
	     chestitems.add(new ItemStack(Material.ARROW,8));
	     chestitems.add(new ItemStack(Material.ARROW,5));
	     chestitems.add(new ItemStack(Material.ARROW,10));
	     chestitems.add(new ItemStack(Material.ARROW,5));
	     chestitems.add(new ItemStack(Material.ARROW,4));
	     chestitems.add(new ItemStack(Material.ARROW,8));
	     chestitems.add(new ItemStack(Material.ARROW,10));
	     chestitems.add(new ItemStack(Material.GOLDEN_APPLE));
	     chestitems.add(new ItemStack(Material.COMPASS));
	     chestitems.add(new ItemStack(Material.COMPASS));
	     chestitems.add(new ItemStack(Material.WEB));
	     chestitems.add(new ItemStack(Material.WEB));

	     

	     //Leder-Dings
	     chestitems.add(new ItemStack(Material.LEATHER_BOOTS));
	     chestitems.add(new ItemStack(Material.LEATHER_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.LEATHER_HELMET));
	     chestitems.add(new ItemStack(Material.LEATHER_LEGGINGS));
	     chestitems.add(new ItemStack(Material.LEATHER_BOOTS));
	     chestitems.add(new ItemStack(Material.LEATHER_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.LEATHER_HELMET));
	     chestitems.add(new ItemStack(Material.LEATHER_LEGGINGS));
	     chestitems.add(new ItemStack(Material.LEATHER_BOOTS));
	     chestitems.add(new ItemStack(Material.LEATHER_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.LEATHER_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.LEATHER_HELMET));
	     chestitems.add(new ItemStack(Material.LEATHER_LEGGINGS));
	     chestitems.add(new ItemStack(Material.LEATHER_BOOTS));
	     chestitems.add(new ItemStack(Material.LEATHER_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.LEATHER_HELMET));
	     chestitems.add(new ItemStack(Material.LEATHER_LEGGINGS));
	     chestitems.add(new ItemStack(Material.LEATHER_BOOTS));
	     chestitems.add(new ItemStack(Material.LEATHER_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.LEATHER_HELMET));
	     chestitems.add(new ItemStack(Material.LEATHER_LEGGINGS));

	     //Eisen-Dings
	     chestitems.add(new ItemStack(Material.IRON_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.IRON_LEGGINGS));
	     chestitems.add(new ItemStack(Material.IRON_BOOTS));
	     chestitems.add(new ItemStack(Material.IRON_HELMET));
	     chestitems.add(new ItemStack(Material.IRON_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.IRON_LEGGINGS));
	     chestitems.add(new ItemStack(Material.IRON_BOOTS));
	     chestitems.add(new ItemStack(Material.IRON_HELMET));

	     //Gold-Dings
	     chestitems.add(new ItemStack(Material.GOLD_BOOTS));
	     chestitems.add(new ItemStack(Material.GOLD_HELMET));
	     chestitems.add(new ItemStack(Material.GOLD_LEGGINGS));
	     chestitems.add(new ItemStack(Material.GOLD_BOOTS));
	     chestitems.add(new ItemStack(Material.GOLD_HELMET));
	     chestitems.add(new ItemStack(Material.GOLD_LEGGINGS));
	     chestitems.add(new ItemStack(Material.GOLD_BOOTS));
	     chestitems.add(new ItemStack(Material.GOLD_HELMET));
	     chestitems.add(new ItemStack(Material.GOLD_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.GOLD_LEGGINGS));
	     chestitems.add(new ItemStack(Material.GOLD_BOOTS));
	     chestitems.add(new ItemStack(Material.GOLD_HELMET));
	     chestitems.add(new ItemStack(Material.GOLD_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.GOLD_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.GOLD_CHESTPLATE));
	     chestitems.add(new ItemStack(Material.GOLD_LEGGINGS));



	  

	     //Diamanten-Dings
	     chestitems.add(new ItemStack(Material.DIAMOND_BOOTS));
	     

	     //Anderes-Fressen
	     chestitems.add(new ItemStack(Material.BOWL));
	     chestitems.add(new ItemStack(Material.RED_MUSHROOM));
	     chestitems.add(new ItemStack(Material.BROWN_MUSHROOM));
	     chestitems.add(new ItemStack(Material.MUSHROOM_SOUP));
	     chestitems.add(new ItemStack(Material.MUSHROOM_SOUP));
	     chestitems.add(new ItemStack(Material.MUSHROOM_SOUP));

	     //Waffen
	     chestitems.add(new ItemStack(Material.WOOD_SWORD));
	     chestitems.add(new ItemStack(Material.WOOD_SWORD));
	     chestitems.add(new ItemStack(Material.WOOD_SWORD));
	     chestitems.add(new ItemStack(Material.WOOD_SWORD));
	     chestitems.add(new ItemStack(Material.STONE_SWORD));
	     chestitems.add(new ItemStack(Material.FISHING_ROD));
	     chestitems.add(new ItemStack(Material.BOW));
	     chestitems.add(new ItemStack(Material.STONE_SWORD));
	     chestitems.add(new ItemStack(Material.STONE_SWORD));
	     chestitems.add(new ItemStack(Material.IRON_AXE));
	     chestitems.add(new ItemStack(Material.IRON_AXE));
	     chestitems.add(new ItemStack(Material.DIAMOND_AXE));
	     chestitems.add(new ItemStack(Material.FIREWORK_CHARGE, 8));
	     chestitems.add(new ItemStack(Material.FIREWORK_CHARGE, 8));
	     chestitems.add(new ItemStack(Material.WOOD_AXE));
	     chestitems.add(new ItemStack(Material.WOOD_AXE));
	     chestitems.add(new ItemStack(Material.WOOD_AXE));
	     chestitems.add(new ItemStack(Material.WOOD_AXE));
	     chestitems.add(new ItemStack(Material.DIAMOND_PICKAXE));
	     chestitems.add(new ItemStack(Material.BOW));
	     chestitems.add(new ItemStack(Material.BOW));
	     chestitems.add(new ItemStack(Material.BOW));
	     
	     //Potions
	     chestitems.add(new ItemStack(Material.POTION, 1, (short) 8197));
	     chestitems.add(new ItemStack(Material.POTION, 2, (short) 8197));
	     chestitems.add(new ItemStack(Material.POTION, 2, (short) 16389));
	     chestitems.add(new ItemStack(Material.POTION, 1, (short) 16386));
	     chestitems.add(new ItemStack(Material.POTION, 1, (short) 16388));
	     chestitems.add(new ItemStack(Material.POTION, 1, (short) 8193));
	     chestitems.add(new ItemStack(Material.POTION, 1, (short) 16392));
	}

}
