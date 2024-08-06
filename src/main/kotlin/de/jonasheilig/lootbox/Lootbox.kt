package de.jonasheilig.lootbox

import org.bukkit.plugin.java.JavaPlugin
import de.jonasheilig.lootbox.commands.*
import de.jonasheilig.lootbox.listeners.*
import de.jonasheilig.lootbox.managers.*

class Lootbox : JavaPlugin() {

    override fun onEnable() {
        this.getCommand("spawnLootboxNPC")?.setExecutor(SpawnCommand(this))
        server.pluginManager.registerEvents(NPCInteractionListener(this), this)
        LootboxManager.initialize(this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
