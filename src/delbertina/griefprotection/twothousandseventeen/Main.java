package delbertina.griefprotection.twothousandseventeen;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Started by Taylor on 5/27/2017.
 *
 * 6/3/2017 - 1.12-pre6 switch
 *
 * 6/10/2017 - 1.12 switch
 *
 * 7/8/2017 - Change greif to grief ... *psy*
 */
public final class Main extends JavaPlugin implements Listener {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        getLogger().info("-------------------");
        getLogger().info(" Grief Protection");
        getLogger().info("  By: delbertina");
        getLogger().info("  Ver: 0.1 - 1.12");
        getLogger().info("-------------------");

        config.addDefault("youAreAwesome", true);
        config.options().copyDefaults(true);
        saveConfig();

        // Enable our class to check for new players using onPlayerJoin()
        getServer().getPluginManager().registerEvents(this, this);

        this.getCommand("griefer").setExecutor(new CommandGriefer());

    }

    // This method checks for incoming players and sends them a message
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (config.getBoolean("youAreAwesome")) {
            player.sendMessage("You are awesome!");
        } else {
            player.sendMessage("You are not awesome...");
        }
    }

    @Override
    public void onDisable(){
        getLogger().info("Disabling Grief Protection ...");
    }

}
