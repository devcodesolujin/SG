package me.devcode.SurvivalGames.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.devcode.SurvivalGames.CountdownHandler;
import me.devcode.SurvivalGames.GameStatus;
import me.devcode.SurvivalGames.MySQLStats;
import me.devcode.SurvivalGames.SG;

public class DeathListener implements Listener {
	
	
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();
		Player killer = p.getKiller();
		p.spigot().respawn();
		MySQLStats.addDeaths(p.getUniqueId().toString(), 1);
		if(killer != null) {
			e.setDeathMessage(SG.prefix + "§7Der Spieler §3" + p.getName() + " §7wurde von §3" + killer.getName() + " §7getötet.");
			
			p.sendMessage(SG.prefix + "§7Dein Gegner hatte noch §a" + killer.getHealth()/10 + " §7Herzen");
			
			MySQLStats.addKills(killer.getUniqueId().toString(), 1);
			SG.ingame.remove(p);
			SG.spec.add(p);
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
			}else{
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.sendMessage(SG.prefix + "§7Es leben noch §3" + SG.ingame.size() + " §7Spieler");
				}
			}
			
		}else{
			
			e.setDeathMessage(SG.prefix + "§7Der Spieler §3" + p.getName() + " §7ist gestorben.");
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage(SG.prefix + "§7Es leben noch §3" + SG.ingame.size() + " §7Spieler");
			}
		}
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		if(SG.plugin.getConfig().getString("SpecLobby.World")!= null) {
			World w = Bukkit.getWorld(SG.plugin.getConfig().getString("SpecLobby.World"));
			double x = SG.plugin.getConfig().getDouble("SpecLobby.X");
			double y = SG.plugin.getConfig().getDouble("SpecLobby.Y");
			double z = SG.plugin.getConfig().getDouble("SpecLobby.Z");
			Location loc = new Location(w, x, y, z);
		e.setRespawnLocation(loc);
	}
		
	}
	
	
	

}
