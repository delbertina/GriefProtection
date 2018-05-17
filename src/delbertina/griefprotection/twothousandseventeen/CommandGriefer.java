package delbertina.greifprotection.twothousandseventeen;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Started by Taylor on 6/3/2017.
 */
public class CommandGriefer implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // -----
        //check for exceptions
        // -----
        //make sure of something ... uh
        if (!(cmd.getName().equalsIgnoreCase("griefer"))) {
            //send error message
            sender.sendMessage("Error! #1");
            return false;
        }
        //make sure a player sent the command
        if (!(sender instanceof Player))  {
            //send error message
            sender.sendMessage("Error! #2");
            return false;
        }
        //make sure the argument list is not empty
        if (args[0] == null) {
            //send error message
            sender.sendMessage("Error! #3");
            return false;
        }
        //make sure the target player is online
        String testPlayer = args[0];
        if (Bukkit.getPlayerExact(testPlayer) == null) {
            // send error message
            sender.sendMessage("Error! #4");
            return false;
        }

        //do the command things
        Player player = (Player) sender;

        Player badGuy = Bukkit.getServer().getPlayer(testPlayer);
                // -----
                //send messages
                // -----
                //send message to griefer
        String griefMessage = "You are greifing!";

        //if there is an arg 1, match with message
        if (args[1] != null) {
            Integer greiferChoice = Integer.parseInt (args[1]);

            switch (greiferChoice) {
                case 1:  griefMessage = "You are griefing! Greasing is bannable!";
                    break;
                case 2:  griefMessage = "You are griefing! Fix or face punishment!";
                    break;
                case 3:  griefMessage = "You are griefing! Fix or face banishment!";
                    break;
                case 4:  griefMessage = "Grief abandoned! Fix or face punishment!";
                    break;
                case 5:  griefMessage = "Grief abandoned for 60s! Fix or face ban!";
                    break;
                case 6:  griefMessage = "Grief abandoned for 300s! Fix or face ban! ";
                    break;
                case 7:  griefMessage = "Grief abandoned for 600s! Preparing jail cell ...";
                    break;
                case 8:  griefMessage = "Grief abandoned! Fix or get banned sukkah!";
                    break;
                case 9:  griefMessage = "You are griefing! Stop or face punishment!";
                    break;
                case 10: griefMessage = "You are griefing! Last warning before ban!";
                    break;
                case 11: griefMessage = "You think we're blind? I'm a plugin, and I can tell you're griefing!";
                    break;
                case 12: griefMessage = "Yo ding dong! What? Are you trying to get banned for griefing?";
                    break;
                case 13: griefMessage = "Legend has it, if you grief hard enough they'll sick Toygrubin on you!";
                    break;
                case 14: griefMessage = "This is funny and all, but you're seriously gonna get banned if you keep griefing.";
                    break;
                case 15: griefMessage = "Do you grief your mother with those lips? Get it ... cuz you're griefing! xD";
                    break;
                case 16: griefMessage = "Why did the griefer cross the road? I don't know, they got banned before they could!";
                    break;
                case 17: griefMessage = "Are you from Tennessee? Cuz you're the only ban I see! (So stop griefing)";
                    break;
                case 18: griefMessage = "Hey you! Yea you! No, you playing Minecraft! STOP GRIEFING!";
                    break;
                case 19: griefMessage = "It's fun to stay at the Y.R.U.Griefing!";
                    break;
                case 20:griefMessage = "Who lives in a pineapple and griefs like a noob? SpongeBo- No, it's you! You are griefing! ";
                    break;
                default: player.sendMessage ("Invalid choice, sending default!");
                    break;
            }
        }
        //else default message

        badGuy.sendMessage("[Grief Protection] > " + griefMessage);

                //send message to sender
        player.sendMessage(player.getDisplayName() + " -> " + badGuy.getDisplayName() + "[Grief Protection] > " + griefMessage);

        return true;
    }
}
