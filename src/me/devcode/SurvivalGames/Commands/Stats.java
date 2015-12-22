package me.devcode.SurvivalGames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.devcode.SurvivalGames.MySQLStats;
import me.devcode.SurvivalGames.Ranking;

public class Stats implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label,
			String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage("§cPLAYER");
			return true;
		}
		Player p = (Player) cs;
		
		int kills = MySQLStats.getKills(p.getUniqueId().toString());
		int deaths = MySQLStats.getDeaths(p.getUniqueId().toString());
		double kd = Double.valueOf(kills) / Double.valueOf(deaths);
		if(deaths == 0) {
			kd = kills;
		}
		String kD = Double.valueOf(kd).toString();
		cs.sendMessage("§7-----§8[§aStats§8]§7-----");
		cs.sendMessage("");
		Ranking.setRanking(p);
		cs.sendMessage("§7Deine Kills: §a" + kills);
		cs.sendMessage("§7Deine Deaths: §a" + deaths);
		cs.sendMessage("§7Deine KD: §a" + kD.replace("NaN", "0").replace("Infinity", "0"));
		cs.sendMessage("");
		cs.sendMessage("§7-----§8[§aStats§8]§7-----");
		
		return true;
	}

}
