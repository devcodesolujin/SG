package me.devcode.SurvivalGames;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;



public class MySQLStats {
	
	public static boolean playerExists(String uuid) {
		try{
			ResultSet rs = SG.mysql.query("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
			if(rs.next()) {
				return rs.getString("UUID")!= null;
			}
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean playerVerbot(String uuid) {
		try{
			ResultSet rs = SG.mysql.query("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
			if(rs.next()) {
				return rs.getString("VERBOTUUID")!=null;
			}
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void setVerbot(String uuid, Long zeit) {
		if(playerExists(uuid)) {
		SG.mysql.update("UPDATE Stats Set UUID='" + uuid + "', VERBOT='" + zeit + "', VERBOTUUID='" + uuid + "'");
	}else{
		createPlayer(uuid);
		setVerbot(uuid, zeit);
	}
	}
	
	public static Long getVerbot(String uuid) {
		if(playerExists(uuid)) {
		ResultSet rs = SG.mysql.query("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
		try{
		if(rs.next()) {
			return rs.getLong("VERBOT");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}else{
			createPlayer(uuid);
			getVerbot(uuid);
		}
		return null;
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public static void createPlayer(final String uuid) {
		if(SG.mysql.isConnected() == false) {
			SG.mysql = new MySQL("mysql.mc-host24.de", "db_19926", "db_19926", "7610cd0267");
			Bukkit.getScheduler().runTaskAsynchronously(SG.plugin, new BukkitRunnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					createPlayer(uuid);
				}
			});
			
		}else{
			if(!playerExists(uuid)) {
			SG.mysql.update("INSERT INTO Stats(UUID, KILLS, DEATHS, VERBOT, VERBOTUUID) VALUES ('" + uuid + "', '0', '0', '0', " + null + ");");
		}
		}
		
	}
	
	public static Integer getKills(String uuid) {
		Integer i = 0;
		try{
			if(playerExists(uuid)) {
			ResultSet rs = SG.mysql.query("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
			if(!rs.next() || Integer.valueOf(rs.getInt("KILLS"))== null) {
				
			}
			i = rs.getInt("KILLS");
			}else{
				createPlayer(uuid);
				getKills(uuid);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static void setKills(String uuid, Integer kills) {
		if(playerExists(uuid)) {
			SG.mysql.update("UPDATE Stats SET KILLS= '" + kills + "' WHERE UUID= '" + uuid + "';");
		}else{
			createPlayer(uuid);
			setKills(uuid, kills);
		}
	}
	
	public static void addKills(String uuid, Integer kills) {
		if(playerExists(uuid)) {
			setKills(uuid, Integer.valueOf(getKills(uuid)).intValue() + kills.intValue());
		}else{
			createPlayer(uuid);
			addKills(uuid, kills);
		}
	}
	
	public static Integer getDeaths(String uuid) {
		Integer i = 0;
		try{
			if(playerExists(uuid)) {
			ResultSet rs = SG.mysql.query("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
			if(!rs.next() || Integer.valueOf(rs.getInt("DEATHS"))== null) {
				
			}
			i = rs.getInt("DEATHS");
			}else{
				createPlayer(uuid);
				getDeaths(uuid);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static void setDeaths(String uuid, Integer deaths) {
		if(playerExists(uuid)) {
			SG.mysql.update("UPDATE Stats SET DEATHS= '" + deaths + "' WHERE UUID= '" + uuid + "';");
		}else{
			createPlayer(uuid);
			setDeaths(uuid, deaths);
		}
	}
	
	public static void addDeaths(String uuid, Integer deaths) {
		if(playerExists(uuid)) {
			setDeaths(uuid, Integer.valueOf(getDeaths(uuid)).intValue() + deaths.intValue());
		}else{
			createPlayer(uuid);
			addDeaths(uuid, deaths);
		}
	}
	
	
	
	
	

}
