package top.cmarco.goatsuperram.listeners;

import lombok.RequiredArgsConstructor;
import org.bukkit.EntityEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Goat;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.purpurmc.purpur.event.entity.GoatRamEntityEvent;
import top.cmarco.goatsuperram.GoatSuperRam;
import top.cmarco.goatsuperram.configuration.GoatConfig;

@RequiredArgsConstructor
public final class RamListener implements Listener {

    private final GoatSuperRam plugin;

    @EventHandler
    public void onRam(@NotNull GoatRamEntityEvent event) {
        GoatConfig conf = plugin.getGoatConfig();
        LivingEntity rammedEntity = event.getRammedEntity();

        plugin.getServer().getConsoleSender().sendMessage("Event fired!"); // not see :(

        if (conf.getBoostPlayerOnly() && (rammedEntity.getType() != EntityType.PLAYER)) {
            return;
        }

        Goat goat = event.getEntity();
        Vector goatDirection = goat.getEyeLocation().getDirection();
        rammedEntity.setVelocity(goatDirection.add(new Vector(0,12,0)).multiply(5.0));
        rammedEntity.playEffect(EntityEffect.FIREWORK_EXPLODE);
        rammedEntity.sendMessage("You got super rammed!");
    }

}
