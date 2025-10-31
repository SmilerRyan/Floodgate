package org.geysermc.floodgate.config;

import java.util.Collections;
import java.util.List;
import lombok.Getter;

@Getter
public class IpWhitelistConfig {
    private boolean enabled = true;
    private List<String> ips = Collections.singletonList("127.0.0.1");
}
