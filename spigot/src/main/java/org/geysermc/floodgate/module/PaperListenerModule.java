package org.geysermc.floodgate.module;

import com.google.inject.AbstractModule;
import org.geysermc.floodgate.listener.PaperListener;

public class PaperListenerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PaperListener.class).asEagerSingleton();
    }
}
