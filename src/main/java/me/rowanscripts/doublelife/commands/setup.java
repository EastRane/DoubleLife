package me.rowanscripts.doublelife.commands;

import me.rowanscripts.doublelife.DoubleLife;
import me.rowanscripts.doublelife.data.ConfigHandler;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class setup {

    public static boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender)
            return true;

        if ((args.length != 2) || !args[1].equalsIgnoreCase("confirm")){
            sender.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "Are you sure? " + ChatColor.RESET + ChatColor.GRAY + "This command should only be ran once, while setting up the server! Please run '/dl setup confirm' to execute the command!");
            return true;
        }

        Player player = (Player) sender;
        World world = player.getWorld();
        String gameruleSettingsPath = "settings.gamerules.";
        player.sendMessage("Устанавливаем игровые правила...");
        world.setGameRule(GameRule.RANDOM_TICK_SPEED, DoubleLife.plugin.getConfig().getInt("gamerules.random-tick-speed"));
        player.sendMessage("Установлен RANDOM_TICK_SPEED в значении " + DoubleLife.plugin.getConfig().getInt("gamerules.random-tick-speed"));
        world.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, DoubleLife.plugin.getConfig().getBoolean("gamerules.spectators-generate-chunks"));
        player.sendMessage("Установлен SPECTATORS_GENERATE_CHUNKS в значении " + DoubleLife.plugin.getConfig().getBoolean("gamerules.spectators-generate-chunks"));
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, DoubleLife.plugin.getConfig().getBoolean("gamerules.do-weather-cycle"));
        player.sendMessage("Установлен DO_WEATHER_CYCLE в значении " + DoubleLife.plugin.getConfig().getBoolean("gamerules.do-weather-cycle"));
        world.setGameRule(GameRule.DO_INSOMNIA, DoubleLife.plugin.getConfig().getBoolean("gamerules.do-insomnia"));
        player.sendMessage("Установлен DO_INSOMNIA в значении " + DoubleLife.plugin.getConfig().getBoolean("gamerules.do-insomnia"));
        world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, DoubleLife.plugin.getConfig().getBoolean("gamerules.announce-advancements"));
        player.sendMessage("Установлен ANNOUNCE_ADVANCEMENTS в значении " + DoubleLife.plugin.getConfig().getBoolean("gamerules.announce-advancements"));
        world.setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, DoubleLife.plugin.getConfig().getInt("gamerules.players-sleeping-percentage"));
        player.sendMessage("Установлен PLAYERS_SLEEPING_PERCENTAGE в значении " + DoubleLife.plugin.getConfig().getInt("gamerules.players-sleeping-percentage"));
        world.setGameRule(GameRule.SPAWN_RADIUS, DoubleLife.plugin.getConfig().getInt("gamerules.spawn-radius"));
        player.sendMessage("Установлен SPAWN_RADIUS в значении " + DoubleLife.plugin.getConfig().getInt("gamerules.spawn-radius"));

        world.setSpawnLocation(player.getLocation());
        player.sendMessage("Установлена точка спавна на Х: " + world.getSpawnLocation().getX() + ", Y: " + world.getSpawnLocation().getY() + ", Z:" + world.getSpawnLocation().getZ());
        world.getWorldBorder().setCenter(0,0);
        world.getWorldBorder().setSize(DoubleLife.plugin.getConfig().getDouble("misc.border-size"));
        player.sendMessage("Установлена граница мира диаметром " + world.getWorldBorder().getSize() + " с центром X: " + world.getWorldBorder().getCenter().getX() + ", Z: " + world.getWorldBorder().getCenter().getZ());

        player.sendMessage("Настройка мира завершена.");
        return true;
    }

}
