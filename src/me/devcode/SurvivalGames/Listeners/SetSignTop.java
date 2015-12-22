package me.devcode.SurvivalGames.Listeners;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.devcode.SurvivalGames.SG;
import me.devcode.SurvivalGames.Commands.SetTop;

public class SetSignTop implements Listener{
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getClickedBlock().getState() instanceof Sign) {
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				Player p = e.getPlayer();
				if(SetTop.top.contains(p.getName())) {
					e.setCancelled(true);
				Block b = e.getClickedBlock();
				String w = b.getWorld().getName();
				double x = b.getLocation().getX();
				double y = b.getLocation().getY();
				double z = b.getLocation().getZ();
				SG.plugin.getConfig().set("TopSign1." + ".World", w);
				SG.plugin.getConfig().set("TopSign1." + ".X", x);
				SG.plugin.getConfig().set("TopSign1." + ".Y", y);
				SG.plugin.getConfig().set("TopSign1." + ".Z", z);
				SG.plugin.saveConfig();
				p.sendMessage(SG.prefix + "§e1Top Sign gesetzt");
				SetTop.top.remove(p.getName());
				}else if(SetTop.top2.contains(p.getName())) {
					e.setCancelled(true);
					Block b = e.getClickedBlock();
					String w = b.getWorld().getName();
					double x = b.getLocation().getX();
					double y = b.getLocation().getY();
					double z = b.getLocation().getZ();
					SG.plugin.getConfig().set("TopSign2." + ".World", w);
					SG.plugin.getConfig().set("TopSign2." + ".X", x);
					SG.plugin.getConfig().set("TopSign2." + ".Y", y);
					SG.plugin.getConfig().set("TopSign2." + ".Z", z);
					SG.plugin.saveConfig();
					p.sendMessage(SG.prefix + "§e2Top Sign gesetzt");
					SetTop.top2.remove(p.getName());
					}else if(SetTop.top3.contains(p.getName())) {
						e.setCancelled(true);
						Block b = e.getClickedBlock();
						String w = b.getWorld().getName();
						double x = b.getLocation().getX();
						double y = b.getLocation().getY();
						double z = b.getLocation().getZ();
						SG.plugin.getConfig().set("TopSign3." + ".World", w);
						SG.plugin.getConfig().set("TopSign3." + ".X", x);
						SG.plugin.getConfig().set("TopSign3." + ".Y", y);
						SG.plugin.getConfig().set("TopSign3." + ".Z", z);
						SG.plugin.saveConfig();
						p.sendMessage(SG.prefix + "§e3Top Sign gesetzt");
						SetTop.top3.remove(p.getName());
					} if(SetTop.top4.contains(p.getName())) {
						e.setCancelled(true);
						Block b = e.getClickedBlock();
						String w = b.getWorld().getName();
						double x = b.getLocation().getX();
						double y = b.getLocation().getY();
						double z = b.getLocation().getZ();
						SG.plugin.getConfig().set("TopSign4." + ".World", w);
						SG.plugin.getConfig().set("TopSign4." + ".X", x);
						SG.plugin.getConfig().set("TopSign4." + ".Y", y);
						SG.plugin.getConfig().set("TopSign4." + ".Z", z);
						SG.plugin.saveConfig();
						p.sendMessage(SG.prefix + "§e4Top Sign gesetzt");
						SetTop.top4.remove(p.getName());
						}else if(SetTop.top5.contains(p.getName())) {
							e.setCancelled(true);
							Block b = e.getClickedBlock();
							String w = b.getWorld().getName();
							double x = b.getLocation().getX();
							double y = b.getLocation().getY();
							double z = b.getLocation().getZ();
							SG.plugin.getConfig().set("TopSign5." + ".World", w);
							SG.plugin.getConfig().set("TopSign5." + ".X", x);
							SG.plugin.getConfig().set("TopSign5." + ".Y", y);
							SG.plugin.getConfig().set("TopSign5." + ".Z", z);
							SG.plugin.saveConfig();
							p.sendMessage(SG.prefix + "§e5Top Sign gesetzt");
							SetTop.top5.remove(p.getName());
						}else if(SetTop.top6.contains(p.getName())) {
							e.setCancelled(true);
							Block b = e.getClickedBlock();
							String w = b.getWorld().getName();
							double x = b.getLocation().getX();
							double y = b.getLocation().getY();
							double z = b.getLocation().getZ();
							SG.plugin.getConfig().set("TopSign6." + ".World", w);
							SG.plugin.getConfig().set("TopSign6." + ".X", x);
							SG.plugin.getConfig().set("TopSign6." + ".Y", y);
							SG.plugin.getConfig().set("TopSign6." + ".Z", z);
							SG.plugin.saveConfig();
							p.sendMessage(SG.prefix + "§e6Top Sign gesetzt");
							SetTop.top6.remove(p.getName());
						}else if(SetTop.top7.contains(p.getName())) {
							e.setCancelled(true);
							Block b = e.getClickedBlock();
							String w = b.getWorld().getName();
							double x = b.getLocation().getX();
							double y = b.getLocation().getY();
							double z = b.getLocation().getZ();
							SG.plugin.getConfig().set("TopSign7." + ".World", w);
							SG.plugin.getConfig().set("TopSign7." + ".X", x);
							SG.plugin.getConfig().set("TopSign7." + ".Y", y);
							SG.plugin.getConfig().set("TopSign7." + ".Z", z);
							SG.plugin.saveConfig();
							p.sendMessage(SG.prefix + "§eTop Sign gesetzt");
							SetTop.top7.remove(p.getName());
						}else if(SetTop.top8.contains(p.getName())) {
							e.setCancelled(true);
							Block b = e.getClickedBlock();
							String w = b.getWorld().getName();
							double x = b.getLocation().getX();
							double y = b.getLocation().getY();
							double z = b.getLocation().getZ();
							SG.plugin.getConfig().set("TopSign8." + ".World", w);
							SG.plugin.getConfig().set("TopSign8." + ".X", x);
							SG.plugin.getConfig().set("TopSign8." + ".Y", y);
							SG.plugin.getConfig().set("TopSign8." + ".Z", z);
							SG.plugin.saveConfig();
							p.sendMessage(SG.prefix + "§e8Top Sign gesetzt");
							SetTop.top8.remove(p.getName());
							}else if(SetTop.top9.contains(p.getName())) {
								e.setCancelled(true);
								Block b = e.getClickedBlock();
								String w = b.getWorld().getName();
								double x = b.getLocation().getX();
								double y = b.getLocation().getY();
								double z = b.getLocation().getZ();
								SG.plugin.getConfig().set("TopSign9." + ".World", w);
								SG.plugin.getConfig().set("TopSign9." + ".X", x);
								SG.plugin.getConfig().set("TopSign9." + ".Y", y);
								SG.plugin.getConfig().set("TopSign9." + ".Z", z);
								SG.plugin.saveConfig();
								p.sendMessage(SG.prefix + "§e9Top Sign gesetzt");
								SetTop.top9.remove(p.getName());
								}else if(SetTop.top10.contains(p.getName())) {
									e.setCancelled(true);
									Block b = e.getClickedBlock();
									String w = b.getWorld().getName();
									double x = b.getLocation().getX();
									double y = b.getLocation().getY();
									double z = b.getLocation().getZ();
									SG.plugin.getConfig().set("TopSign10." + ".World", w);
									SG.plugin.getConfig().set("TopSign10." + ".X", x);
									SG.plugin.getConfig().set("TopSign10." + ".Y", y);
									SG.plugin.getConfig().set("TopSign10." + ".Z", z);
									SG.plugin.saveConfig();
									p.sendMessage(SG.prefix + "§e10Top Sign gesetzt");
									SetTop.top10.remove(p.getName());
									}else {
										
										
									}
								
							
			}
		}else{
			e.setCancelled(false);
		}
	}
		

}
