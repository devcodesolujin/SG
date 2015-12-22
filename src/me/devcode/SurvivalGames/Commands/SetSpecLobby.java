package me.devcode.SurvivalGames.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.devcode.SurvivalGames.SG;

public class SetSpecLobby implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(SG.nospieler);
			return true;
		}
		Player p = (Player) sender;
		if(!p.hasPermission("sg.setspeclobby")) {
			p.sendMessage(SG.perm);
			return true;
		}
		
		if(args.length != 0) {
			p.sendMessage(SG.prefix + "§cFehler! §7Benutze: /setspeclobby");
			return true;
		}
		SG.plugin.getConfig().set("SpecLobby.World", p.getWorld().getName());
		SG.plugin.getConfig().set("SpecLobby.X", p.getLocation().getX());
		SG.plugin.getConfig().set("SpecLobby.Y", p.getLocation().getY());
		SG.plugin.getConfig().set("SpecLobby.Z", p.getLocation().getZ());
		SG.plugin.saveConfig();
		p.sendMessage(SG.prefix + "§7Du hast die §3Spec§7-§3Lobby §7erfolgreich gesetzt");
		return true;
	}
	

}
