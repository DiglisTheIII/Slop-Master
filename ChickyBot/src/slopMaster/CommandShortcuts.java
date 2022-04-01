package slopMaster;

import java.io.File;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandShortcuts extends ListenerAdapter {

	public void sendMessage(GuildMessageReceivedEvent event, String message, boolean isReply) {
		if(!isReply) {
			event.getChannel().sendMessage(message).queue();
		} else {
			event.getMessage().reply(message).queue();
		}
	}
	
	//Overloaded method for files
	public void sendMessage(GuildMessageReceivedEvent event, File f) {
		event.getChannel().sendFile(f).queue();
	}
	
	public void deleteMessage(GuildMessageReceivedEvent event) {
		event.getMessage().delete().queue();
	}
	
	public void react(GuildMessageReceivedEvent event, String emote) {
		event.getMessage().addReaction(emote).queue();
	}
	
	public void sendDM(GuildMessageReceivedEvent event, String message) {
		event.getAuthor().openPrivateChannel().flatMap(channel -> channel.sendMessage(message)).queue();
	}
	
	
}
