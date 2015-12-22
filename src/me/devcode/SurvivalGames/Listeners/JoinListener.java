package me.devcode.SurvivalGames.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import me.devcode.SurvivalGames.CountdownHandler;
import me.devcode.SurvivalGames.GameStatus;
import me.devcode.SurvivalGames.MySQLStats;
import me.devcode.SurvivalGames.SG;




public class JoinListener implements Listener {
	
	
	
	
	
	
	
	 public static boolean gestartet = false;


	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.setGameMode(GameMode.SURVIVAL);
		p.setFoodLevel(20);
		p.setHealth(20D);
		p.getInventory().setArmorContents(null);
		p.getInventory().clear();
		p.setFireTicks(0);
		for(PotionEffect effect : p.getActivePotionEffects()) {
			p.removePotionEffect(effect.getType());
		}
		p.getInventory().setItem(0, SG.ItemStackName1(Material.PAPER, 0, 1, "§aVote", "§7Vote für eine Map", null, null));
		MySQLStats.createPlayer(p.getUniqueId().toString());
		
		p.setAllowFlight(false);
		
		
		
		if(SG.status == GameStatus.LOBBY) {
			e.setJoinMessage(SG.prefix + "§7Der Spieler §3" + p.getDisplayName() + " §7hat die Lobby betreten");
			p.sendMessage(SG.prefix + "§7Du spielst nun §3SurvivalGames");
			SG.ingame.add(p);
			if(SG.plugin.getConfig().getString("Lobby.World")!= null) {
				World w = Bukkit.getWorld(SG.plugin.getConfig().getString("Lobby.World"));
				double x = SG.plugin.getConfig().getDouble("Lobby.X");
				double y = SG.plugin.getConfig().getDouble("Lobby.Y");
				double z = SG.plugin.getConfig().getDouble("Lobby.Z");
				Location loc = new Location(w, x, y, z);
				p.teleport(loc);
			}
				if(SG.ingame.size() >= 2) {
					if(gestartet == false) {
					CountdownHandler.firstCountdown();
					gestartet = true;
					}
				}
			
		}else{
			e.setJoinMessage(null);
			p.sendMessage(SG.prefix + "§7Du spectatest nun §3SurvivalGames");
			SG.spec.add(p);
			p.setGameMode(GameMode.SPECTATOR);
			if(SG.plugin.getConfig().getString("SpecLobby.World")!= null) {
				World w = Bukkit.getWorld(SG.plugin.getConfig().getString("SpecLobby.World"));
				double x = SG.plugin.getConfig().getDouble("SpecLobby.X");
				double y = SG.plugin.getConfig().getDouble("SpecLobby.Y");
				double z = SG.plugin.getConfig().getDouble("SpecLobby.Z");
				Location loc = new Location(w, x, y, z);
				p.teleport(loc);
		}
	}
		
		updateScoreboard(p);
		
	}
	
	
	public static void updateScoreboard(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("aaa", "bbb");
		obj.setDisplayName("§7SurvivalGames");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score score1 = obj.getScore(Bukkit.getOfflinePlayer("§e" + SG.ingame.size()));
		Score score2 = obj.getScore(Bukkit.getOfflinePlayer("§3Spieler"));
		Score score3 = obj.getScore(Bukkit.getOfflinePlayer("§f"));
		int kisten;
		if(ChestListener.kistenanzahl.containsKey(p)) {
		 kisten = ChestListener.kistenanzahl.get(p);
		}else{
			kisten = 0;
		}
		int kills;
		if(SG.kills.containsKey(p)) {
			 kills = SG.kills.get(p);
			}else{
				kills = 0;
			}
		Score score4 = obj.getScore(Bukkit.getOfflinePlayer("§b" + kisten));
		Score score5 = obj.getScore(Bukkit.getOfflinePlayer("§3Kisten"));
		Score score6 = obj.getScore(Bukkit.getOfflinePlayer("§8"));
		Score score7 = obj.getScore(Bukkit.getOfflinePlayer("§a" + kills));
		Score score8 = obj.getScore(Bukkit.getOfflinePlayer("§3Kills"));
		Score score9 = obj.getScore(Bukkit.getOfflinePlayer("§7"));
		String erlaubtodernicht = "";
		if(SG.plugin.getConfig().getBoolean("Team") == false) {
			erlaubtodernicht = "§cverboten";
		}else if(SG.plugin.getConfig().getBoolean("Team") == true) {
			erlaubtodernicht = "§2erlaubt";
		}
		
		Score score10 = obj.getScore(Bukkit.getOfflinePlayer(erlaubtodernicht));
		Score score11 = obj.getScore(Bukkit.getOfflinePlayer("§3Teams"));
		score1.setScore(1);
		score2.setScore(2);
		score3.setScore(3);
		score4.setScore(4);
		score5.setScore(5);
		score6.setScore(6);
		score7.setScore(7);
		score8.setScore(8);
		score9.setScore(9);
		score10.setScore(10);
		score11.setScore(11);
		for(Player all : Bukkit.getOnlinePlayers()) {
			if(SG.status == GameStatus.LOBBY) {
				all.setScoreboard(board);
			}else{
		p.setScoreboard(board);
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
