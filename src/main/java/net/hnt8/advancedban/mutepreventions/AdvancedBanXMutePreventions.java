package net.hnt8.advancedban.mutepreventions;

import net.hnt8.advancedban.Universal;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class AdvancedBanXMutePreventions extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        new BukkitMetrics(this, 22192);
        
        if (getServer().getPluginManager().getPlugin("AdvancedBanX") == null) {
            getLogger().severe("AdvancedBanX is not installed!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        
        Logger logger = Universal.get().getLogger();
        
        logger.info("Enabling addon MutePreventions");
        
        logger.info("Hooking events...");
        getServer().getPluginManager().registerEvents(this, this);
        logger.info("Successfully hooked events.");
        
        logger.info("Successfully enabled addon MutePreventions");
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onSignChange(SignChangeEvent event) {
        if (Universal.get().getMethods().callChat(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerEditBook(PlayerEditBookEvent event) {
        if (Universal.get().getMethods().callChat(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
}
