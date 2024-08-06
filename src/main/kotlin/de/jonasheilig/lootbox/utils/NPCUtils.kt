package de.jonasheilig.lootbox.utils

import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.Villager
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.plugin.java.JavaPlugin

object NPCUtils {

    fun spawnLootboxNPC(location: Location) {
        val npc = location.world?.spawnEntity(location, EntityType.VILLAGER) as? Villager
        npc?.customName = "Lootbox Vendor"
        npc?.isCustomNameVisible = true
        npc?.setMetadata("lootbox_v", FixedMetadataValue(JavaPlugin.getProvidingPlugin(NPCUtils::class.java), true))
    }
}
