package org.duckdns.davbosca.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Class containing EventHandlers for Farmland interaction 
 * with  Players and other Entities.
 */
public class FarmlandHandlers implements Listener {

    /**
     * Intercept Player events.
     * Trampling is prevented only if player is jumping, 
     * not when destroying/placing seeds
     * @param event Player Interactive Event
     */
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event){
        if(event.getAction().equals(Action.PHYSICAL)){
            stopTrampling(event, event.getClickedBlock());
        }
    }

    /**
     * Intercept other Entities events.
     * Entities will never interact with Farmland
     * <p> TODO: check if this prevents Enderman to steal Farmland blocks </p>
     * @param event Entity Interactive Event
     */
    @EventHandler
    public void onEntityInteractEvent(EntityInteractEvent event){
        stopTrampling(event, event.getBlock());
    }

    /**
     * Core of the functionality. Disable event if block is Farmland
     * @param event The interaction event
     * @param block The block interacted
     * @return true if event is cancelled, false otherwise
     */
    private boolean stopTrampling(Cancellable event, Block block){
        if(block.getType().equals(Material.SOIL)){
            event.setCancelled(true);
        }
        return event.isCancelled();
    }
    
}
