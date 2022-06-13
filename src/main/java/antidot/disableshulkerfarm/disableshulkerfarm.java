package antidot.disableshulkerfarm;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Shulker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class disableshulkerfarm extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    private void removeLootFromShulkerFarm(CreatureSpawnEvent event) {
        Entity entity = event.getEntity();
        if(entity instanceof Shulker && event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.BREEDING)) {
            ((Shulker) entity).setLootTable(null);
        }
    }
}
