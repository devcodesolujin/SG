package me.devcode.SurvivalGames.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.devcode.SurvivalGames.GameStatus;
import me.devcode.SurvivalGames.SG;

public class NoMove implements Listener {
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(SG.status == GameStatus.NOMOVE) {
			if(!SG.spec.contains(e.getPlayer())) {
			if(e.getFrom().getBlockX() != e.getTo().getBlockX() ||e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
				e.setTo(e.getFrom());
			}
			}
		}
	}

}
