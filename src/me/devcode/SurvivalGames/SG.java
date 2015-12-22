package me.devcode.SurvivalGames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.devcode.SurvivalGames.Commands.Build;
import me.devcode.SurvivalGames.Commands.SetDMSpecLobby;
import me.devcode.SurvivalGames.Commands.SetDmSpawn;
import me.devcode.SurvivalGames.Commands.SetLobby;
import me.devcode.SurvivalGames.Commands.SetSpawn1;
import me.devcode.SurvivalGames.Commands.SetSpawn2;
import me.devcode.SurvivalGames.Commands.SetSpawn3;
import me.devcode.SurvivalGames.Commands.SetSpecLobby;
import me.devcode.SurvivalGames.Commands.SetTop;
import me.devcode.SurvivalGames.Commands.Start;
import me.devcode.SurvivalGames.Commands.Stats;
import me.devcode.SurvivalGames.Listeners.BlockBP;
import me.devcode.SurvivalGames.Listeners.ChestListener;
import me.devcode.SurvivalGames.Listeners.Compass;
import me.devcode.SurvivalGames.Listeners.DeathListener;
import me.devcode.SurvivalGames.Listeners.ItemVote;
import me.devcode.SurvivalGames.Listeners.JoinListener;
import me.devcode.SurvivalGames.Listeners.Listeners;
import me.devcode.SurvivalGames.Listeners.NoMove;
import me.devcode.SurvivalGames.Listeners.PingListener;
import me.devcode.SurvivalGames.Listeners.QuitListener;
import me.devcode.SurvivalGames.Listeners.SetSignTop;
import me.devcode.SurvivalGames.Listeners.TnT;






public class SG extends JavaPlugin{
	
	//Logger
	Logger logger = Logger.getLogger("");
	
	//Strings
	public static String prefix = "§8[§3SurvivalGames§8] ";
	public static String perm = prefix + "§cDafür hast du keine Permissions";
	public static String nospieler = prefix + "§cDu bist kein Spieler";

	
	
	//Plugin
	public static SG plugin;
	
	//GameStatus
	public static GameStatus status;
	
	//HashMap
	public static HashMap<Player, Integer> kills = new HashMap<Player, Integer>();
	
	//ArrayLists
	public static ArrayList<Player> ingame = new ArrayList<Player>();
	public static ArrayList<Player> spec = new ArrayList<Player>();
	public static ArrayList<Location> spawnlocation = new ArrayList<Location>();
	public static ArrayList<Location> deathmatchlocation = new ArrayList<Location>();
	public static HashMap<Player, Player> compass = new HashMap<Player, Player>();
	
	//MySQL
	public static MySQL mysql;
	
	
	public void onEnable() {
		loadMySQL();
		plugin = this;
		logger.info("[SG] Gestartet");
		registerCommands();
		registerEvents();
		status = GameStatus.LOBBY;
		
		getConfig().addDefault("Team", Boolean.valueOf(true));
		getConfig().options().copyDefaults(true);
		saveConfig();
		logger.info("[Signs] Die Schilder werden in 1,5 Sekunden geladen...");
		Bukkit.getScheduler().runTaskLater(this, new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Ranking.setRankingSigns();
			}
		}, 30L);
		
		
	}
	
	private void registerCommands() {
		// TODO Auto-generated method stub
		this.getCommand("setlobby").setExecutor(new SetLobby());
		this.getCommand("setspeclobby").setExecutor(new SetSpecLobby());
		this.getCommand("setspawn1").setExecutor(new SetSpawn1());
		this.getCommand("setspawn2").setExecutor(new SetSpawn2());
		this.getCommand("setspawn3").setExecutor(new SetSpawn3());
		this.getCommand("stats").setExecutor(new Stats());
		this.getCommand("start").setExecutor(new Start());
		this.getCommand("setdmspawn").setExecutor(new SetDmSpawn());	
		this.getCommand("setdmspeclobby").setExecutor(new SetDMSpecLobby());
		this.getCommand("build").setExecutor(new Build());
		this.getCommand("settop").setExecutor(new SetTop());
	}

	private void registerEvents() {
		// TODO Auto-generated method stub
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new Listeners(), this);
		pm.registerEvents(new NoMove(), this);
		pm.registerEvents(new ChestListener(this), this);
		pm.registerEvents(new QuitListener(), this);
		pm.registerEvents(new TnT(), this);
		pm.registerEvents(new DeathListener(), this);
		pm.registerEvents(new ItemVote(), this);
		pm.registerEvents(new Compass(), this);
		pm.registerEvents(new BlockBP(), this);
		pm.registerEvents(new PingListener(), this);
		pm.registerEvents(new SetSignTop(), this);
		
	}

	public void onDisable() {
		logger.info("[SG] Gestoppt");
		BlockBP.reset();
		BlockBP.reset1();
		if(SG.plugin.getConfig().getString("Spawn" + 1 + "."  + 1 + ".World") != null) {
			World w = Bukkit.getWorld(SG.plugin.getConfig().getString("Spawn" + 1 + "."+ 1 + ".World"));
		for(Entity e : w.getEntities()) {
			if(!(e instanceof Player)) {
			
			e.remove();	
			}
			}
		}
		
	}
	
	public void loadMySQL() {
		
		mysql = new MySQL("localhost", "db_19926", "db_19926", "7610cd0267");
		mysql.update("CREATE TABLE IF NOT EXISTS Stats(UUID varchar(64), KILLS int, DEATHS int, VERBOT varchar(64), VERBOTUUID varchar(64));");
	}

	public static ItemStack ItemStackName1(Material m, int s, int i,
			String display, String lorename, String lorename1, String lorename2) {
		ItemStack Item = new ItemStack(m, i, (short) s);
		ItemMeta ItemMeta = Item.getItemMeta();
		ArrayList<String> lore = new ArrayList<>();
		if (display == null) {
		} else {
			ItemMeta.setDisplayName(display);
		}
		if (lorename == null) {
		} else {

			lore.add(lorename);
			ItemMeta.setLore(lore);
		}

		if (lorename1 == null) {
		} else {

			lore.add(lorename1);
			ItemMeta.setLore(lore);
		}
		if (lorename2 == null) {
		} else {

			lore.add(lorename2);
			ItemMeta.setLore(lore);
		}
		Item.setItemMeta(ItemMeta);
		return Item;
	}
	
}
