package me.devcode.SurvivalGames;



import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import me.devcode.SurvivalGames.Listeners.ChestListener;
import me.devcode.SurvivalGames.Listeners.JoinListener;

public class CountdownHandler {
	
	public static int lobbytimer = 61;
	public static BukkitTask task1;
	
	
	public static void firstCountdown() {
		task1 = new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(lobbytimer <= lobbytimer) {
					lobbytimer--;
					for(Player all : Bukkit.getOnlinePlayers()) {
						if(lobbytimer != 0) {
						all.setLevel(lobbytimer);
						}
					}
					if(Bukkit.getOnlinePlayers().size() < 1) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(SG.prefix + "§7Es sind zu wenige §3Spieler §7online!");
						JoinListener.gestartet = false;
						}
						lobbytimer = 61;
						cancel();
					}
				}
				if(lobbytimer == 60) {
					
				}
				if(lobbytimer == 60 || lobbytimer == 30 || lobbytimer == 15 || lobbytimer == 10 || lobbytimer == 5) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage(SG.prefix + "§7Das Spiel startet in §3" + lobbytimer + " §7Sekunden");
					}
				}
				if(lobbytimer == 5) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.getInventory().clear();
						all.sendMessage(SG.prefix + "§7Das §3Voting §7ist beendet");
					}
					MVote.getMap();
				}
				if(lobbytimer == 1) {
					
					setLocations();
				}
				if(lobbytimer == 0) {
				
					int intega = 0;
					int inet = intega;
					try{
					for(intega = inet; intega < Bukkit.getOnlinePlayers().size(); intega++) {
						Player player =SG.ingame.get(intega);
						
						player.setLevel(0);
						
						player.teleport(SG.spawnlocation.get(intega));
					}
					}catch(IndexOutOfBoundsException e) {
						for(intega = inet; intega < Bukkit.getOnlinePlayers().size(); intega++) {
							Player player =SG.ingame.get(intega);
							player.teleport(SG.spawnlocation.get(intega));
						}
					}
					SG.status = GameStatus.NOMOVE;
					noMoveCountdown();
					cancel();
				}
			}
		}.runTaskTimer(SG.plugin, 0, 20);
	}
	
	public static void noMoveCountdown() {
		new BukkitRunnable() {
			int schutz= 21;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(schutz<= schutz) {
					schutz--;
				}
				if(schutz== 20 || schutz== 10 || schutz<= 5 && schutz> 0) {
				for(Player all : SG.ingame) {
					
					all.setLevel(0);
					all.sendMessage(SG.prefix + "§7Die Schutzzeit beginnt in §3" + schutz+ " §7Sekunde(n)");
				}
				}
				if(schutz== 0) {
					SG.status = GameStatus.SCHUTZ;
					schutzCountdown();
					cancel();
							}
			}
		}.runTaskTimer(SG.plugin, 0, 20);
	}
	
	public static void schutzCountdown() {
		new BukkitRunnable() {
			int schutz = 21;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(schutz<= schutz) {
					schutz--;
				}
				if(schutz== 20 || schutz== 10 || schutz<= 5 && schutz> 0) {
				for(Player all : SG.ingame) {
					all.sendMessage(SG.prefix + "§7Die Schutzzeit endet in §3" + schutz+ " §7Sekunde(n)");
				}
				if(schutz == 6) {
					for(Player all : SG.ingame) {
						all.sendMessage(SG.prefix + "§7Die Kisten werden in §35 §7Sekunden neu aufgefüllt.");
					}
				}
				if(schutz == 1) {
					
				}
				}
				if(schutz== 0) {
					SG.status = GameStatus.INGAME;
					cancel();
							}
			}
		}.runTaskTimer(SG.plugin, 0, 20);
	}
	
	public static void ingameCountdown() {
		new BukkitRunnable() {
			int countdown = 601;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(countdown <= countdown) {
					countdown--;
					for(Player all : Bukkit.getOnlinePlayers()) {
						if(SG.spec.contains(all)) {
							if(all.getGameMode() != GameMode.SPECTATOR) {
								all.setGameMode(GameMode.SPECTATOR);
								}
						}
					}
				}
				if(countdown == 600 || countdown == 300 || countdown ==240 ||countdown ==60) {
					for(Player all : SG.ingame) {
						all.sendMessage(SG.prefix + "§7Das Deathmatch startet in §3" + countdown/60 + " §7Minute(n)");
					}
				}
				if(countdown == 185) {
					for(Player all : SG.ingame) {
						all.sendMessage(SG.prefix + "§7Die Kisten werden in §35 §7Sekunden neu aufgefüllt.");
					}
				}
				
				if(countdown == 180) {
					setLocations2();
					for(Player all : SG.ingame) {
						ChestListener.chest.clear();
						all.sendMessage(SG.prefix + "§7Die §3Kisten §7wurden aufgefüllt.");
					}
				}
				if(countdown == 30 || countdown == 10) {
					for(Player all : SG.ingame) {
						all.sendMessage(SG.prefix + "§7Das Deathmatch startet in §3" + countdown + " §7Sekunden");
					}
				}
				if(countdown == 0) {
					for(Player all : SG.ingame) {
						all.sendMessage(SG.prefix + "§7Das Deathmatch startet!");
						
						if(SG.plugin.getConfig().getString("DMSpecLobby.World")!= null) {
							World w = Bukkit.getWorld(SG.plugin.getConfig().getString("DMSpecLobby.World"));
							double x = SG.plugin.getConfig().getDouble("DMSpecLobby.X");
							double y = SG.plugin.getConfig().getDouble("DMSpecLobby.Y");
							double z = SG.plugin.getConfig().getDouble("DMSpecLobby.Z");
							Location loc = new Location(w, x, y, z);
							for(Player spectator: SG.spec) {
								spectator.teleport(loc);
							}
					}
						int intega = 0;
						int inet = intega;
						try{
						for(intega = inet; intega < Bukkit.getOnlinePlayers().size(); intega++) {
							Player player = SG.ingame.get(intega);
							player.teleport(SG.deathmatchlocation.get(intega));
						}
						}catch(IndexOutOfBoundsException e) {
							for(intega = inet; intega < Bukkit.getOnlinePlayers().size(); intega++) {
								Player player = SG.ingame.get(intega);
								player.teleport(SG.deathmatchlocation.get(intega));
							}
						}
					}
					onDMCountdown();
					cancel();
				}
			}
			
		}.runTaskTimer(SG.plugin, 0, 20);
	}
	
	public static void onDMCountdown() {
		
		new BukkitRunnable() {
			int dmcountdown = 301;
			@Override
			public void run() {
				if(dmcountdown <= dmcountdown) {
					dmcountdown--;
					for(Player all : Bukkit.getOnlinePlayers()) {
						if(SG.spec.contains(all)) {
							if(all.getGameMode() != GameMode.SPECTATOR) {
								all.setGameMode(GameMode.SPECTATOR);
								}
						}
					}
				}
				if(dmcountdown == 60 || dmcountdown == 30 || dmcountdown == 15 || dmcountdown == 10 || dmcountdown == 5) {
					for(Player all : SG.ingame) {
						all.sendMessage(SG.prefix + "§7Das Spiel endet in §3" + dmcountdown + " §7Sekunden");
					}
				}
				if(dmcountdown == 0) {
					onEnd();
					cancel();
				}
				
			}
			
		}.runTaskTimer(SG.plugin, 0, 20);
	}
	
	public static void onEnd() {
		new BukkitRunnable() {
			int countdown = 11;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(countdown <= countdown) {
					countdown--;
					for(Player all : Bukkit.getOnlinePlayers()) {
						if(SG.spec.contains(all)) {
							if(all.getGameMode() != GameMode.SPECTATOR) {
							all.setGameMode(GameMode.SPECTATOR);
							}
						}
					}
				}
				if(countdown == 10 || countdown <= 5 && countdown > 0) {
					for(Player all : SG.ingame) {
						all.sendMessage(SG.prefix + "§7Der Server restartet in §3" + countdown + " §7Sekunden");
					
					}
				}
				if(countdown == 0) {
					Bukkit.shutdown();
				}
			}
		}.runTaskTimer(SG.plugin, 0, 20);
		
	}
	
	
	public static void setLocations() {
		for(String s : SG.plugin.getConfig().getConfigurationSection("Spawn"  + MVote.cmap + ".").getKeys(false)) {
			if(SG.plugin.getConfig().getString("Spawn" + MVote.cmap + "."  + s + ".World") != null) {
			World w = Bukkit.getWorld(SG.plugin.getConfig().getString("Spawn" + MVote.cmap + "."+ s + ".World"));
			double x = SG.plugin.getConfig().getDouble("Spawn" + MVote.cmap + "." + "."  + s + ".X");
			double y = SG.plugin.getConfig().getDouble("Spawn" + MVote.cmap + "."+ s + ".Y");
			double z = SG.plugin.getConfig().getDouble("Spawn" + MVote.cmap + "."+ s + ".Z");
			Location loc = new Location(w, x, y, z);
			SG.spawnlocation.add(loc);
			System.out.println(SG.spawnlocation.size());
			}
		}
	}
	
	public static void setLocations2() {
		for(String s : SG.plugin.getConfig().getConfigurationSection("DMSpawn.").getKeys(false)) {
			if(SG.plugin.getConfig().getString("DMSpawn." + s + ".World") != null) {
			World w = Bukkit.getWorld(SG.plugin.getConfig().getString("DMSpawn." + s + ".World"));
			double x = SG.plugin.getConfig().getDouble("DMSpawn." + s + ".X");
			double y = SG.plugin.getConfig().getDouble("DMSpawn." + s + ".Y");
			double z = SG.plugin.getConfig().getDouble("DMSpawn." + s + ".Z");
			Location loc = new Location(w, x, y, z);
			SG.spawnlocation.add(loc);
			}
		}
	}

}
