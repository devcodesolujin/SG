package me.devcode.SurvivalGames.Commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.devcode.SurvivalGames.SG;

public class SetTop implements CommandExecutor{
	
	public static ArrayList<String> top = new ArrayList<String>();
	public static ArrayList<String> top2 = new ArrayList<String>();
	public static ArrayList<String> top3= new ArrayList<String>();
	public static ArrayList<String> top4 = new ArrayList<String>();
	public static ArrayList<String> top5 = new ArrayList<String>();
	public static ArrayList<String> top6 = new ArrayList<String>();
	public static ArrayList<String> top7 = new ArrayList<String>();
	public static ArrayList<String> top8 = new ArrayList<String>();
	public static ArrayList<String> top9 = new ArrayList<String>();
	public static ArrayList<String> top10 = new ArrayList<String>();
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(!(s instanceof Player)) {
			s.sendMessage(SG.nospieler);
			return true;
		}
		Player p = (Player) s;
		if(!p.hasPermission("sg.settop")) {
			p.sendMessage(SG.perm);
			return true;
		}
		if(args[0].equalsIgnoreCase("1")) {
			p.sendMessage(SG.prefix + "§eDu kannst nun das 1 Top10 Schild erstellen.");
			top.add(p.getName());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("2")) {
			p.sendMessage(SG.prefix + "§eDu kannst nun das 2 Top10 Schild erstellen.");
			top2.add(p.getName());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("3")) {
			p.sendMessage(SG.prefix + "§eDu kannst nun das 3 Top10 Schild erstellen.");
			top3.add(p.getName());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("4")) {
			p.sendMessage(SG.prefix + "§eDu kannst nun das 4 Top10 Schild erstellen.");
			top4.add(p.getName());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("5")) {
			p.sendMessage(SG.prefix + "§eDu kannst nun das 5 Top10 Schild erstellen.");
			top5.add(p.getName());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("6")) {
			p.sendMessage(SG.prefix + "§eDu kannst nun das 6 Top10 Schild erstellen.");
			top6.add(p.getName());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("7")) {
			p.sendMessage(SG.prefix + "§eDu kannst nun das 7 Top10 Schild erstellen.");
			top7.add(p.getName());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("8")) {
			p.sendMessage(SG.prefix + "§eDu kannst nun das 8 Top10 Schild erstellen.");
			top8.add(p.getName());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("9")) {
			p.sendMessage(SG.prefix + "§eDu kannst nun das 9 Top10 Schild erstellen.");
			top9.add(p.getName());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("10")) {
			p.sendMessage(SG.prefix + "§eDu kannst nun das 10 Top10 Schild erstellen.");
			top10.add(p.getName());
			return true;
		}
		
		return true;
	}

}
