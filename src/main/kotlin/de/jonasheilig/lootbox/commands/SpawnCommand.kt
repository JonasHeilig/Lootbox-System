package de.jonasheilig.lootbox.commands

import de.jonasheilig.lootbox.utils.NPCUtils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class SpawnCommand(private val plugin: JavaPlugin) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            val player: Player = sender
            NPCUtils.spawnLootboxNPC(player.location)
            player.sendMessage("Lootbox NPC spawned!")
        } else {
            sender.sendMessage("This command can only be executed by a player.")
        }
        return true
    }
}
