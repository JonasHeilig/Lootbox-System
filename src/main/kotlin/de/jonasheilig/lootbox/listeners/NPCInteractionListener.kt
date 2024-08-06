package de.jonasheilig.lootbox.listeners

import de.jonasheilig.lootbox.managers.LootboxManager
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.bukkit.plugin.java.JavaPlugin

class NPCInteractionListener(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onPlayerInteractAtEntity(event: PlayerInteractAtEntityEvent) {
        val player: Player = event.player
        val entity = event.rightClicked

        if (entity.hasMetadata("lootbox_v")) {
            if (player.level >= 500) {
                player.level = player.level - 500

                val loot = LootboxManager.getLoot(plugin)
                val inventory = player.inventory

                if (inventory.firstEmpty() == -1) {
                    player.world.dropItem(player.location, loot)
                } else {
                    inventory.addItem(loot)
                }
                player.sendMessage("You received a lootbox item!")
            } else {
                player.sendMessage("You do not have enough XP to buy a lootbox.")
            }
        }
    }
}
