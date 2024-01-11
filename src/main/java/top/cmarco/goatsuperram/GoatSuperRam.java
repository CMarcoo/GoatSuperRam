package top.cmarco.goatsuperram;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import top.cmarco.goatsuperram.configuration.GoatConfig;
import top.cmarco.goatsuperram.listeners.RamListener;

@Getter
public final class GoatSuperRam extends JavaPlugin {

    private GoatConfig goatConfig = null;
    private RamListener ramListener = null;

    private void loadConfig() {
        goatConfig = new GoatConfig(this);
        goatConfig.saveAndLoad();
    }

    private void loadListeners() {
        ramListener = new RamListener(this);
        getServer().getPluginManager().registerEvents(ramListener, this);
    }

    @Override
    public void onEnable() {
        loadConfig();
        loadListeners();
    }
}
