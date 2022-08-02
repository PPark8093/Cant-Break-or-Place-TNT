package apl.aplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("블록이벤트플러그인_활성화");
        System.out.println("Made By PPark8093");
        System.out.println("https://github.com/PPark8093");
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("블록이벤트플러그인_비활성화");
        System.out.println("Made By PPark8093");
        System.out.println("https://github.com/PPark8093");
    }

    @EventHandler
    public void bk(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (!p.isOp()){
            if (b.getType() == Material.TNT){
                e.setCancelled(true);
                p.sendMessage(ChatColor.RED + "Can't Break!");
            }
        }
    }

    @EventHandler
    public void bp(BlockPlaceEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (!p.isOp()){
            if (b.getType() == Material.TNT){
                e.setCancelled(true);
                p.sendMessage(ChatColor.RED + "Can't Place!");
            }
        }
    }
}
