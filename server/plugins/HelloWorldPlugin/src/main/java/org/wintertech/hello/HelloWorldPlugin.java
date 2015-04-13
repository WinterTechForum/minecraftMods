package org.wintertech.hello;

import net.canarymod.Canary;
import net.canarymod.plugin.Plugin;

/**
 *
 */
public class HelloWorldPlugin extends Plugin {
    @Override
    public boolean enable() {

        getLogman().info("Enabling "+getName()+", version "+getVersion());
        Canary.hooks().registerListener(new HelloWorldListener(), this);

        return true;
    }

    @Override
    public void disable() {

    }
}
