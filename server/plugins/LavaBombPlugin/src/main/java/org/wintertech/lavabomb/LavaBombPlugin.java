package org.wintertech.lavabomb;

import net.canarymod.BlockIterator;
import net.canarymod.Canary;
import net.canarymod.LineTracer;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.world.effects.Particle;
import net.canarymod.api.world.effects.SoundEffect;
import net.canarymod.api.world.position.Location;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.Command;
import net.canarymod.commandsys.CommandDependencyException;
import net.canarymod.commandsys.CommandListener;
import net.canarymod.plugin.Plugin;

/**
 *
 */
public class LavaBombPlugin extends Plugin implements CommandListener {

    @Override
    public boolean enable() {
        getLogman().info("Enabling "+getName()+", version "+getVersion());
        try {
            Canary.commands().registerCommands(this, this, false);
            return true;
        } catch (CommandDependencyException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void disable() {

    }

    @Command(aliases = { "lavabomb" },
            description = "Shoot lava at your target",
            permissions = { "" },
            toolTip = "/lavabomb")
    public void fireLavaBomb(MessageReceiver caller, String[] args) {
        if (caller instanceof Player) {
            Player player = (Player) caller;

            BlockIterator lineOfSightObjects = getLineOfSightItems(player);

            while(lineOfSightObjects.hasNext()){
                Block block = lineOfSightObjects.next();
                if(BlockType.Air.equals(block.getType())){
                    fireParticle(block.getLocation(), Particle.Type.LAVA);
                } else{
                    createBlock(block.getLocation(), BlockType.Lava);
                    break;
                }
            }

        }
    }

    private void createBlock(Location location, BlockType blockType) {
        location.getWorld().setBlockAt(location, blockType);
    }

    private BlockIterator getLineOfSightItems(Player player) {
        return new BlockIterator(new LineTracer(player), true);
    }

    private void fireParticle(Location location, Particle.Type particleType) {

        Particle particle = new Particle(location.getX(), location.getY(), location.getZ(), particleType);
        location.getWorld().spawnParticle(particle);
    }

}
