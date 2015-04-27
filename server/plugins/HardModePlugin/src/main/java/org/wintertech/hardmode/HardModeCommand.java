package org.wintertech.hardmode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import net.canarymod.Canary;
import net.canarymod.api.entity.EntityType;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.Command;
import net.canarymod.commandsys.CommandListener;

public class HardModeCommand implements CommandListener
{

    private ScheduledExecutorService executor = Executors
            .newScheduledThreadPool(1);

    private boolean isHardModeEnabled = false;
    private boolean addedTask = false;

    @Command(aliases = { "hardmode" }, 
            description = "Makes Minecraft difficult", 
            permissions = { "" }, 
            toolTip = "/hardmode")
    public void hardModeCommand(MessageReceiver caller, String[] parameters)
    {
        if (!isHardModeEnabled)
        {
            caller.asPlayer().message("Good luck...");
            
            if (!addedTask)
            {
                executor.scheduleWithFixedDelay(new SpawnCreeper(caller), 5, 5,
                        TimeUnit.SECONDS);
                addedTask = true;
            }
            isHardModeEnabled = true;
        } 
        else
        {
            caller.asPlayer().message("Ending hard mode...");
            isHardModeEnabled = false;
        }
    }

    private class SpawnCreeper implements Runnable
    {
        private MessageReceiver caller;

        public SpawnCreeper(MessageReceiver caller)
        {
            this.caller = caller;
        }

        @Override
        public void run()
        {
            if (isHardModeEnabled)
            {
                Player me = caller.asPlayer();
                for (Player player : me.getWorld().getPlayerList())
                {
                    Location location = player.getLocation();
                    Canary.factory().getEntityFactory()
                        .newEntity(EntityType.CREEPER, location)
                        .spawn();
                }
            }
        }
    }
}
