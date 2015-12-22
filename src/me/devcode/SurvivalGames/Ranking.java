package me.devcode.SurvivalGames;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;

public class Ranking {
	
	
	public static HashMap<Integer, String> rang = new HashMap<Integer, String>();
	public static HashMap<Integer, String> rang2 = new HashMap<Integer, String>();
	//This does not work.
	public static void setRanking(Player p) {
		
		
		ResultSet rs = SG.mysql.query("SELECT UUID FROM Stats ORDER BY KILLS DESC LIMIT 10");
		int in = 0;
		try{
			while(rs.next()) {
				in++;
				rang.put(in, rs.getString("UUID"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < rang.size(); i++) {
			int id = i+1;
		String name = Bukkit.getOfflinePlayer(UUID.fromString(rang.get(id))).getName();
		p.sendMessage("§cPlatz §e#" + id);
		p.sendMessage("§cName: §e" + name);
		OfflinePlayer p1 = Bukkit.getOfflinePlayer(name);
		int kills = MySQLStats.getKills(p1.getUniqueId().toString());
		p.sendMessage("§cKills: §e" + kills);
		}
	}
	
	public static void setRankingSigns() {
		ResultSet rs = SG.mysql.query("SELECT UUID FROM Stats ORDER BY KILLS DESC LIMIT 10");
		int in = 0;
		try{
			while(rs.next()) {
				in++;
				rang2.put(in, rs.getString("UUID"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(SG.plugin.getConfig().getString("TopSign1." + ".World") != null) {
		Location loc = new Location(Bukkit.getWorld(SG.plugin.getConfig().getString("TopSign1." + ".World")), SG.plugin.getConfig().getDouble("TopSign1." + ".X"), SG.plugin.getConfig().getDouble("TopSign1." + ".Y") + 1, SG.plugin.getConfig().getDouble("TopSign1." + ".Z"));
		Location loc2 = new Location(Bukkit.getWorld(SG.plugin.getConfig().getString("TopSign2." + ".World")), SG.plugin.getConfig().getDouble("TopSign2." + ".X"), SG.plugin.getConfig().getDouble("TopSign2." + ".Y") + 1, SG.plugin.getConfig().getDouble("TopSign2." + ".Z"));
		Location loc3 = new Location(Bukkit.getWorld(SG.plugin.getConfig().getString("TopSign3." + ".World")), SG.plugin.getConfig().getDouble("TopSign3." + ".X"), SG.plugin.getConfig().getDouble("TopSign3." + ".Y") + 1, SG.plugin.getConfig().getDouble("TopSign3." + ".Z"));
		Location loc4 = new Location(Bukkit.getWorld(SG.plugin.getConfig().getString("TopSign4." + ".World")), SG.plugin.getConfig().getDouble("TopSign4." + ".X"), SG.plugin.getConfig().getDouble("TopSign4." + ".Y") + 1, SG.plugin.getConfig().getDouble("TopSign4." + ".Z"));
		Location loc5 = new Location(Bukkit.getWorld(SG.plugin.getConfig().getString("TopSign5." + ".World")), SG.plugin.getConfig().getDouble("TopSign5." + ".X"), SG.plugin.getConfig().getDouble("TopSign5." + ".Y") + 1, SG.plugin.getConfig().getDouble("TopSign5." + ".Z"));
		Location loc6 = new Location(Bukkit.getWorld(SG.plugin.getConfig().getString("TopSign6." + ".World")), SG.plugin.getConfig().getDouble("TopSign6." + ".X"), SG.plugin.getConfig().getDouble("TopSign6." + ".Y") + 1, SG.plugin.getConfig().getDouble("TopSign6." + ".Z"));
		Location loc7 = new Location(Bukkit.getWorld(SG.plugin.getConfig().getString("TopSign7." + ".World")), SG.plugin.getConfig().getDouble("TopSign7." + ".X"), SG.plugin.getConfig().getDouble("TopSign7." + ".Y") + 1, SG.plugin.getConfig().getDouble("TopSign7." + ".Z"));
		Location loc8 = new Location(Bukkit.getWorld(SG.plugin.getConfig().getString("TopSign8." + ".World")), SG.plugin.getConfig().getDouble("TopSign8." + ".X"), SG.plugin.getConfig().getDouble("TopSign8." + ".Y") + 1, SG.plugin.getConfig().getDouble("TopSign8." + ".Z"));
		Location loc9 = new Location(Bukkit.getWorld(SG.plugin.getConfig().getString("TopSign9." + ".World")), SG.plugin.getConfig().getDouble("TopSign9." + ".X"), SG.plugin.getConfig().getDouble("TopSign9." + ".Y") + 1, SG.plugin.getConfig().getDouble("TopSign9." + ".Z"));
		Location loc10 = new Location(Bukkit.getWorld(SG.plugin.getConfig().getString("TopSign10." + ".World")), SG.plugin.getConfig().getDouble("TopSign10." + ".X"), SG.plugin.getConfig().getDouble("TopSign10." + ".Y") + 1, SG.plugin.getConfig().getDouble("TopSign10." + ".Z"));
		
		List<Location> LOC = new ArrayList<Location>();
		LOC.add(loc);
		LOC.add(loc2);
		LOC.add(loc3);
		LOC.add(loc4);
		LOC.add(loc5);
		LOC.add(loc6);
		LOC.add(loc7);
		LOC.add(loc8);
		LOC.add(loc9);
		LOC.add(loc10);
		
		
		for(int i =0; i < LOC.size(); i++) {
			int id =i+1;
			LOC.get(i).getBlock().setType(Material.SKULL);
			Skull s = (Skull) LOC.get(i).getBlock().getState();
			s.setSkullType(SkullType.PLAYER);
			
			String name = "";
			if(UUID.fromString(rang2.get(id)) == null) {
				name = "test";
			}else{
			  name = Bukkit.getOfflinePlayer(UUID.fromString(rang2.get(id))).getName();
			s.setOwner(name);
			}
			s.update();
			Location newloc = new Location(LOC.get(i).getWorld(), LOC.get(i).getX(), LOC.get(i).getY()-1, LOC.get(i).getZ());
			if(newloc.getBlock().getState() instanceof Sign) {
				BlockState b = newloc.getBlock().getState();
				Sign S = (Sign) b;
				S.setLine(0, "Platz #" + id);
				
				S.setLine(1, name);
				
				S.setLine(2, "Klick für Stats");
				S.setLine(3, MySQLStats.getKills(rang.get(id)) + " §4Kills");
				
				S.update();
				System.out.print("[Signs] Gesetzt.");
			
			}
		}
		}else{
			System.out.println("[Signs] Bitte setzen sie die Location's der Schilder");
		}
	}

}
