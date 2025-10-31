package org.geysermc.floodgate.listener;

import com.destroystokyo.paper.event.profile.PreFillProfileEvent;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.geysermc.floodgate.config.FloodgateConfig;

public final class PaperListener implements Listener {
    private final Set<String> whitelistedUsernames = Collections.synchronizedSet(new HashSet<>());

    @Inject private FloodgateConfig config;

    @EventHandler(priority = EventPriority.LOW)
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        if (config.getIpWhitelist().isEnabled() && config.getIpWhitelist().getIps().contains(event.getAddress().getHostAddress())) {
            whitelistedUsernames.add(event.getName());
        }
    }

    @EventHandler
    public void onProfileFill(PreFillProfileEvent event) {
        if (whitelistedUsernames.remove(event.getPlayerProfile().getName())) {
            UUID offlineUuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + event.getPlayerProfile().getName()).getBytes());
            event.getPlayerProfile().setId(offlineUuid);
        }
    }
}
