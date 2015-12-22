package me.devcode.SurvivalGames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.devcode.SurvivalGames.SG;

public class SetSpawn2 implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(SG.nospieler);
			return true;
		}
		Player p = (Player) sender;
		if(!p.hasPermission("sg.setspawn")) {
			p.sendMessage(SG.perm);
			return true;
		}
		
		if(args.length != 1) {
			p.sendMessage(SG.prefix + "§cFehler! §7Benutze: /setspawn2");
			return true;
		}
		
		try{
			int zahl = Integer.parseInt(args[0]);
			SG.plugin.getConfig().set("Spawn" + 2 + "."+ zahl + ".World", p.getWorld().getName());
			SG.plugin.getConfig().set("Spawn" + 2 + "."+ zahl + ".X", p.getLocation().getX());
			SG.plugin.getConfig().set("Spawn" + 2 + "."+ zahl + ".Y", p.getLocation().getY());
			SG.plugin.getConfig().set("Spawn" + 2 + "."+ zahl + ".Z", p.getLocation().getZ());
			SG.plugin.getConfig().set("Spawn.MName" + 2, "2MAP");
			SG.plugin.saveConfig();
			p.sendMessage(SG.prefix + "§7Du hast den " + zahl + " §3Spawn §7erfolgreich gesetzt.");
		}catch(NumberFormatException e) {
			p.sendMessage(SG.prefix + "§cBitte Zahl eingeben");
		}
		
		
		return true;
	}

}
