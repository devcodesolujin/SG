package me.devcode.SurvivalGames.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class TnT implements Listener{
	
	
	
	@EventHandler
	public void onTnt(BlockPlaceEvent e) {
		if(e.getBlock().getType() == Material.TNT) {
			e.getBlock().setTypeId(0);
			e.getPlayer().getWorld().spawn(e.getBlock().getLocation(), TNTPrimed.class).setFuseTicks(30);
		}
	}
	
	
	@EventHandler
	public void onExplodeCancel(EntityExplodeEvent e) {
		e.setCancelled(true);
	}

}
