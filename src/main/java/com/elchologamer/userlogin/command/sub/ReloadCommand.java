package com.elchologamer.userlogin.command.sub;

import com.elchologamer.userlogin.ULPlayer;
import com.elchologamer.userlogin.UserLogin;
import com.elchologamer.userlogin.command.base.SubCommand;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends SubCommand {

    private final UserLogin plugin = UserLogin.getPlugin();

    public ReloadCommand() {
        super("reload", "ul.reload");
    }

    @Override
    public boolean run(CommandSender sender, String[] args) {
        for (ULPlayer ulPlayer : plugin.getPlayers().values()) {
            if (!ulPlayer.isLoggedIn()) {
                ulPlayer.cancelPreLoginTasks();
            }
        }

        plugin.load();

        sender.sendMessage(plugin.getLang().getMessage("commands.reload"));
        return true;
    }
}
