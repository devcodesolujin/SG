package me.devcode.SurvivalGames.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.devcode.SurvivalGames.GameStatus;
import me.devcode.SurvivalGames.SG;

public class PingListener implements Listener{
	
	@EventHandler
	public void onPing(ServerListPingEvent e) {
		if(SG.status == GameStatus.LOBBY) {
		e.setMotd("§7Lobby");
		}else if(SG.status == GameStatus.NOMOVE  || SG.status == GameStatus.SCHUTZ || SG.status == GameStatus.INGAME) {
			e.setMotd("§7Ingame");
		}else if(SG.status == GameStatus.DM) {
			e.setMotd("§7Deathmatch");
		}else if(SG.status == GameStatus.END) {
			e.setMotd("§cRestarting..");
		}else{
			e.setMotd("§4Offline");
		}
	}

}
