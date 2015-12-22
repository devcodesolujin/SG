package me.devcode.SurvivalGames.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import me.devcode.SurvivalGames.GameStatus;
import me.devcode.SurvivalGames.MVote;
import me.devcode.SurvivalGames.SG;

public class ItemVote implements Listener {
	
	
	@EventHandler
	public void onVote(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getMaterial() == Material.PAPER) {
				Inventory inv = Bukkit.createInventory(null, 9, "§aVoting");
				 String map = SG.plugin.getConfig().getString("Spawn.MName" + 1);
				 String map2 = SG.plugin.getConfig().getString("Spawn.MName" + 2);
				 String map3 = SG.plugin.getConfig().getString("Spawn.MName" + 3);
				inv.setItem(0, SG.ItemStackName1(Material.DIAMOND, 0, 1, "§6" + map, null, null, null));
				inv.setItem(4, SG.ItemStackName1(Material.EMERALD, 0, 1, "§6" + map2, null, null, null));
				inv.setItem(8, SG.ItemStackName1(Material.GOLD_INGOT, 0, 1, "§6" + map3, null, null, null));
			p.openInventory(inv);
			}
		}
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(e.getCurrentItem().getType() == Material.DIAMOND) {
			String map = SG.plugin.getConfig().getString("Spawn.MName" + 1);
			p.sendMessage(SG.prefix + "§7Du hast für die Map §3" + map + " §7gevotet");
			MVote.addVote1(1);
			p.getInventory().clear();
			e.getView().close();
		}
		if(e.getCurrentItem().getType() == Material.EMERALD) {
			String map = SG.plugin.getConfig().getString("Spawn.MName" + 2);
			p.sendMessage(SG.prefix + "§7Du hast für die Map §3" + map + " §7gevotet");
			MVote.addVote2(1);
			p.getInventory().clear();
			e.getView().close();
		}
		
		if(e.getCurrentItem().getType() == Material.GOLD_INGOT) {
			String map = SG.plugin.getConfig().getString("Spawn.MName" + 3);
			p.sendMessage(SG.prefix + "§7Du hast für die Map §3" + map + " §7gevotet");
			MVote.addVote3(1);
			p.getInventory().clear();
			e.getView().close();
		}else if(e.getInventory().getTitle().contains("§aVoting")){
			
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onID(PlayerDropItemEvent e) {
		if(SG.status == GameStatus.LOBBY ) {
			e.setCancelled(true);
		}
	}
	

}
