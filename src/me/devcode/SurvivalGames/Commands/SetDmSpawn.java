package me.devcode.SurvivalGames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.devcode.SurvivalGames.SG;

public class SetDmSpawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(SG.nospieler);
			return true;
		}
		Player p = (Player) sender;
		if(!p.hasPermission("sg.setdmspawn")) {
			p.sendMessage(SG.perm);
			return true;
		}
		
		if(args.length != 1) {
			p.sendMessage(SG.prefix + "§cFehler! §7Benutze: /setdmspawn");
			return true;
		}
		
		try{
			int zahl = Integer.parseInt(args[0]);
			SG.plugin.getConfig().set("DMSpawn." + zahl + ".World", p.getWorld().getName());
			SG.plugin.getConfig().set("DMSpawn." + zahl + ".X", p.getLocation().getX());
			SG.plugin.getConfig().set("DMSpawn." + zahl + ".Y", p.getLocation().getY());
			SG.plugin.getConfig().set("DMSpawn." + zahl + ".Z", p.getLocation().getZ());
			SG.plugin.saveConfig();
			p.sendMessage(SG.prefix + "§7Du hast den " + zahl + " §3Deathmatch§7-§3Spawn §7erfolgreich gesetzt.");
		}catch(NumberFormatException e) {
			p.sendMessage(SG.prefix + "§cBitte Zahl eingeben");
		}
		
		
		return true;
	}

}
