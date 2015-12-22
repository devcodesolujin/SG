package me.devcode.SurvivalGames.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.devcode.SurvivalGames.SG;

public class Compass implements Listener {
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
		if(e.getMaterial() == Material.COMPASS) {
			Player target = getCompassTarget(p);
			if(target == null) {
				p.sendMessage(SG.prefix + "§7Es ist kein §3Spieler §7in deiner nähe");
				return;
			}
			
			int blocks = (int) p.getLocation().distance(getCompassTarget(p).getLocation());
			p.sendMessage(SG.prefix + "§7Der Spieler §3" + getCompassTarget(p).getName() + " §7ist §3" + blocks + " §7Blöcke von dir entfernt");
		}
	}
	}
	
	
	
	
	
	
	
	public Player getCompassTarget(Player p) {
		double distance = Double.MAX_VALUE;
		Player target = null;
		for(Entity entity : p.getNearbyEntities(500, 500, 500)) {
			if(entity instanceof Player) {
				
					
					
				double dis = p.getLocation().distance(entity.getLocation());
				if(dis < distance ) {
					distance = dis;
					target = (Player) entity;
					p.setCompassTarget(target.getLocation());
				
				}
				
				}
			}
		
		return target;
	}

}
