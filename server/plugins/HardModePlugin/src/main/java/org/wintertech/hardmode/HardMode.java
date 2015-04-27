package org.wintertech.hardmode;

import net.canarymod.Canary;
import net.canarymod.commandsys.CommandDependencyException;
import net.canarymod.plugin.Plugin;

public class HardMode extends Plugin
{

    @Override
    public boolean enable()
    {
        try
        {
            Canary.commands().registerCommands(new HardModeCommand(), this,
                    false);
        } 
        catch (CommandDependencyException e)
        {
            getLogman().info("Command registration error");
        }
        getLogman().info("Enabling " + getName() + " Version " + getVersion());
        getLogman().info("Authored by " + getAuthor());
        return true;
    }
}