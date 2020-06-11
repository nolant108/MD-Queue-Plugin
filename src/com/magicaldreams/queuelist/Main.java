package com.magicaldreams.queuelist;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{
	
	int players1 = 0;
	int players2 = 0;

	
	@Override
	public void onEnable() {
		
		System.out.println("QueueList ENABLED");
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
	}
	
	@EventHandler
	public void onSignChange1(SignChangeEvent e) {
		
		String RideONE = this.getConfig().getString("RideONE");
		
		Player player = e.getPlayer();
		
		if(e.getLine(0).equals("[Queue]") || e.getLine(1).equals("[" + RideONE + "]")) {
			player.sendMessage(ChatColor.AQUA 
			+ "To set up the Queue Sign do /QueueList [Signname] [ridename]" +
					" [tp to location] [riders per tarin]");
			e.setLine(0, ChatColor.AQUA + "[Queue]");
			e.setLine(1, ChatColor.GOLD + RideONE);
			e.setLine(2, players1 + " Players");
			
		}
	}
	
	@EventHandler
	public void onSignChange2(SignChangeEvent e) {
		
		String RideTWO = this.getConfig().getString("RideTWO");
		
		Player player = e.getPlayer();
		
		if(e.getLine(0).equals("[Queue]") || e.getLine(1).equals("[" + RideTWO + "]")) {
			player.sendMessage(ChatColor.AQUA 
			+ "To set up the Queue Sign do /QueueList [Signname] [ridename]" +
					" [tp to location] [riders per tarin]");
			e.setLine(0, ChatColor.AQUA + "[Queue]");
			e.setLine(1, ChatColor.GOLD + RideTWO);
			e.setLine(2, players2 + " Players");

		}
	}
	
	@Override
	public void onDisable() {

		System.out.println("QueueList Disabled");
		
	}

}
