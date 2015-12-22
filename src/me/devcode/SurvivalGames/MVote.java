package me.devcode.SurvivalGames;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MVote {
	
	
	public static Integer vote1 = 0;
	public static Integer vote2 = 0;
	public static Integer vote3 = 0;	
	public static Integer cmap = 1;
	
	
	public static void addVote1(Integer v) {
		vote1 = v + getVote1();		
	}
	
	public static void addVote2(Integer v) {
		vote2 = v + getVote2();
	}
	
	public static void addVote3(Integer v) {
		vote3 = v +getVote3();
	}
	
	public static Integer getVote1() {	
		return vote1;
	}
	
	public static Integer getVote2() {	
		return vote2;
	}
	
	public static Integer getVote3() {	
		return vote3;
	}
	
	
	public static void getMap() {
		 if(getVote1() > Math.max(getVote2(),getVote3())){
			 
             cmap = 1;
         } else if(getVote2() > Math.max(getVote1(),getVote3())) {
        	 
             cmap = 2;
         } else if( getVote3() > Math.max(getVote2(),getVote1())) {
        	 
             cmap = 3;
         } else {
            cmap = 1;
             
             
         }
		 for(Player all : Bukkit.getOnlinePlayers()) {
			 String map = SG.plugin.getConfig().getString("Spawn.MName" + cmap);
			 all.sendMessage(SG.prefix + "§7Es wird die Map §3" + map + " §7gespielt!");
		 }
	}
	

}
