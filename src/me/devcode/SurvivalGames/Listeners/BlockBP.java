package me.devcode.SurvivalGames.Listeners;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import me.devcode.SurvivalGames.GameStatus;
import me.devcode.SurvivalGames.SG;
import me.devcode.SurvivalGames.Commands.Build;



public class BlockBP implements Listener {
	
	
	public static List<String> blockreset = new LinkedList<String>();
	public static List<String> blockreset1 = new LinkedList<String>();
	
	public static void reset() {
		for(String b : blockreset) {
			String[] blockdata = b.split(":");
			int id = Integer.parseInt(blockdata[0]);
			byte data = Byte.parseByte(blockdata[1]);
			World world = Bukkit.getWorld(blockdata[2]);
			int x = Integer.parseInt(blockdata[3]);
			int y = Integer.parseInt(blockdata[4]);
			int z = Integer.parseInt(blockdata[5]);
			world.getBlockAt(x, y, z).setTypeId(id);
			world.getBlockAt(x, y, z).setData(data);	
			
			}
	}
	
	public static void reset1() {
		for(String b : blockreset1) {
			String[] blockdata = b.split(":");
			int id = Integer.parseInt(blockdata[0]);
			byte data = Byte.parseByte(blockdata[1]);
			World world = Bukkit.getWorld(blockdata[2]);
			int x = Integer.parseInt(blockdata[3]);
			int y = Integer.parseInt(blockdata[4]);
			int z = Integer.parseInt(blockdata[5]);
			world.getBlockAt(x, y, z).setTypeId(id);
			world.getBlockAt(x, y, z).setData(data);	
			}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		if(!Build.bauen.contains(p.getName())) {
	
			if(((e.getBlock().getType() == Material.FIRE)) || (e.getBlock().getTypeId() == 31)|| (e.getBlock().getType() == Material.WEB) || (e.getBlock().getType() == Material.LEAVES) || (e.getBlock().getType() == Material.LEAVES_2)){
				String block = b.getTypeId() + ":" + b.getData() + ":" + b.getWorld().getName() + ":" + b.getX() + ":" + b.getY() + ":" + b.getZ();
				blockreset.add(block);
				System.out.println("" + blockreset.size());
			e.setCancelled(false);
			
			
			
			}else{
				e.setCancelled(true);
			}
		
		
		
			
			if(SG.status == GameStatus.LOBBY || SG.status == GameStatus.NOMOVE) {
				p.sendMessage(SG.prefix + "§7Du darfst immoment nichts abbauen");
				e.setCancelled(true);
			
		
		
			}
		
		}else{
			e.setCancelled(false);
		}
		
	
	

	}
	
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();
		if(!Build.bauen.contains(p.getName())) {
		
		if((((e.getBlock().getType() == Material.FIRE))) || (e.getBlock().getType() == Material.WEB) || (e.getBlock().getType() == Material.GRASS) || (e.getBlock().getType() == Material.CAKE)){
			@SuppressWarnings("deprecation")
			String block = b.getTypeId() + ":" + b.getData() + ":" + b.getWorld().getName() + ":" + b.getX() + ":" + b.getY() + ":" + b.getZ();
		blockreset1.add(block);
			e.setCancelled(false);
			
		}else {
			e.setCancelled(true);
		}
	
		
		
		
		if(SG.status == GameStatus.LOBBY || SG.status == GameStatus.NOMOVE) {
			p.sendMessage(SG.prefix + "§7Du darfst immoment nichts platzieren");
			e.setCancelled(true);
		}
		}else {
			e.setCancelled(false);
		}
	}
	
	
	}
	
	


