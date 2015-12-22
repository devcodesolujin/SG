package me.devcode.SurvivalGames.Listeners;

import java.sql.Time;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;

import me.devcode.SurvivalGames.CountdownHandler;
import me.devcode.SurvivalGames.GameStatus;
import me.devcode.SurvivalGames.MySQLStats;
import me.devcode.SurvivalGames.SG;

public class QuitListener implements Listener {
	
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(SG.status == GameStatus.LOBBY) {
			e.setQuitMessage(SG.prefix + "§7Der Spieler §3" + p.getDisplayName() + " §7hat die Lobby verlassen");
		}else if(SG.status == GameStatus.END){
			e.setQuitMessage(SG.prefix + "§7Der Spieler §3" + p.getDisplayName() + " §7hat die Lobby verlassen");
		}else{
			if(SG.spec.contains(p)) {
			e.setQuitMessage(null);
			SG.spec.remove(p);
			}else{
				SG.ingame.remove(p);
				if(!p.hasPermission("sg.leave")) {
				long verbot = 5 * 60 * 1000;
				long current = System.currentTimeMillis();
				long zusammen = current + verbot;
				MySQLStats.setVerbot(p.getUniqueId().toString(), zusammen);
				}
				Bukkit.broadcastMessage("" + MySQLStats.getVerbot(p.getUniqueId().toString()));
				e.setQuitMessage(SG.prefix + "§7Der Spieler §3" + p.getDisplayName() + " §7hat das Spiel verlassen.");
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.sendMessage(SG.prefix + "§7Es leben noch §3" + SG.ingame.size() + " §7Spieler");
				}
				
			
			
		
			if(SG.ingame.size() == 1) {
				
					for(Player player : SG.ingame) {
						Bukkit.getScheduler().cancelAllTasks();
						SG.status = GameStatus.END;
						player.sendMessage(SG.prefix + "§7Glückwunsch du hast gewonnen!");
						for(Player all : Bukkit.getOnlinePlayers()) {
					all.sendMessage(SG.prefix + "§7Der Spieler §3" + player.getName() + " §7hat gewonnen!");
						}
					CountdownHandler.onEnd();
					
				}
			}
			
			}
			
		}
	}
	
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		
		//Verbot
		Player p = e.getPlayer();
		Bukkit.broadcastMessage("TEST");
		Bukkit.broadcastMessage("" + MySQLStats.getVerbot(p.getUniqueId().toString()));
		if(MySQLStats.playerVerbot(p.getUniqueId().toString())) {
			long verbot = MySQLStats.getVerbot(p.getUniqueId().toString());
			long current = System.currentTimeMillis();
			long zusammen = verbot - current;
			if(zusammen > 0) {
				Time time = new Time(verbot);
				e.disallow(Result.KICK_BANNED, "§7Du hast das letzte Spiel vorzeitig verlassen!" + "\n" + "§7Du kannst wieder am: " + "\n" + "§2" + time.toLocaleString() + " §7Uhr spielen.");
			}
		}
	}

}
