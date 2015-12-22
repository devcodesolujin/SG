package me.devcode.SurvivalGames.Commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.devcode.SurvivalGames.SG;

public class Build implements CommandExecutor {
	
	public static ArrayList<String> bauen = new ArrayList<String>();
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(!(s instanceof Player)) {
			s.sendMessage(SG.nospieler);
			return true;
			
		}
		Player p = (Player) s;
		if(!p.hasPermission("sg.build")) {
			p.sendMessage(SG.perm);
			return true;
			
		}
		if(bauen.contains(p.getName())) {
			p.sendMessage(SG.prefix + "§eDu jannst nun nicht mehr bauen!");
			bauen.remove(p.getName());
			return true;
		}
		p.sendMessage(SG.prefix + "§eDu kannst nun bauen!");
		bauen.add(p.getName());
		return true;
	}

}
