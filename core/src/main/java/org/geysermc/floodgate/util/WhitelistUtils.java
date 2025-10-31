package org.geysermc.floodgate.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class WhitelistUtils {

    public static boolean isWhitelisted(String address, List<String> whitelist) {
        if (whitelist == null || whitelist.isEmpty()) {
            return false;
        }

        try {
            InetAddress addr = InetAddress.getByName(address);
            for (String whitelistedAddress : whitelist) {
                if (whitelistedAddress.equals(addr.getHostAddress())) {
                    return true;
                }
            }
        } catch (UnknownHostException e) {
            // ignore
        }

        return false;
    }
}
