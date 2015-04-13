package org.wintertech.hello;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.Colors;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.plugin.PluginListener;

/**
 *
 */
public class HelloWorldListener implements PluginListener{

    @HookHandler
    public void onLogin(ConnectionHook hook){
        Player player = hook.getPlayer();
        player.message(Colors.YELLOW+"Say hello to the world, "+player.getName());
    }

}
