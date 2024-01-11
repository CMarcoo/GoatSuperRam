package top.cmarco.goatsuperram.configuration;

import lombok.RequiredArgsConstructor;
import org.bukkit.configuration.file.FileConfiguration;
import top.cmarco.goatsuperram.GoatSuperRam;

@RequiredArgsConstructor
public final class GoatConfig {

    private final GoatSuperRam plugin;
    private FileConfiguration config = null;

    /**
     * Save the config.yml file and store it into field.
     */
    public void saveAndLoad() {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }

    /**
     * Should other entities be affected by ram boost.
     * @return True if affected, false otherwise.
     */
    public boolean getBoostPlayerOnly() {
        return config.getBoolean("boost-player-only" , false);
    }
}
