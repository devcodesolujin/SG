package me.devcode.SurvivalGames.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import me.devcode.SurvivalGames.GameStatus;
import me.devcode.SurvivalGames.SG;

public class Listeners implements Listener {
	
	
	@EventHandler
	public void onDamageinLobby(EntityDamageEvent e) {
		if(SG.status != GameStatus.INGAME) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDamageinLobby(EntityDamageByBlockEvent e) {
		if(SG.status != GameStatus.INGAME) {
			e.setCancelled(true);
		}
	}
	
	
	@EventHandler
	public void onDamageinLobby(EntityDamageByEntityEvent e) {
		if(SG.status != GameStatus.INGAME) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		if(SG.status == GameStatus.INGAME || SG.status == GameStatus.SCHUTZ) {
			e.setCancelled(false);
		}else {
			e.setCancelled(true);
		}
	}

}
