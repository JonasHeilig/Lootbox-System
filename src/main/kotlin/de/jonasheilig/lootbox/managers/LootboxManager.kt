package de.jonasheilig.lootbox.managers

import de.jonasheilig.abilitiesSystem.items.HeartApple
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import kotlin.random.Random

object LootboxManager {

    private lateinit var lootTable: Map<String, Pair<ItemStack, Double>>

    fun initialize(plugin: JavaPlugin) {
        lootTable = mapOf(
            "diamond" to Pair(ItemStack(Material.DIAMOND), 0.1),
            "gold_ingot" to Pair(ItemStack(Material.GOLD_INGOT), 0.3),
            "iron_ingot" to Pair(ItemStack(Material.IRON_INGOT), 0.5),
            "heart_apple" to Pair(HeartApple.create(), 0.1)
        )
    }

    fun getLoot(plugin: JavaPlugin): ItemStack {
        val rand = Random.nextDouble()
        var cumulativeProbability = 0.0

        for ((_, pair) in lootTable) {
            val (item, probability) = pair
            cumulativeProbability += probability
            if (rand <= cumulativeProbability) {
                return item
            }
        }

        return ItemStack(Material.EMERALD)
    }
}
